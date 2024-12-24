package com.example.aptech_final_project_be.repository;

import org.springframework.stereotype.Repository;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

@Repository
public class BlacklistedTokenRepository {
    private final Map<String, Long> blacklistedTokens = new ConcurrentHashMap<>();

    public void blacklist(String token, Long expirationTime) {
        blacklistedTokens.put(token, expirationTime);
    }

    public boolean isBlacklisted(String token) {
        if (blacklistedTokens.containsKey(token)) {
            // Kiểm tra xem token đã hết hạn chưa
            if (System.currentTimeMillis() > blacklistedTokens.get(token)) {
                blacklistedTokens.remove(token);
                return false;
            }
            return true;
        }
        return false;
    }

    // Phương thức dọn dẹp token hết hạn (có thể chạy định kỳ)
    public void cleanupExpiredTokens() {
        long now = System.currentTimeMillis();
        blacklistedTokens.entrySet().removeIf(entry -> entry.getValue() < now);
    }
} 