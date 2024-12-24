export const API_ENDPOINTS = {
    AUTH: {
        REGISTER_STUDENT: '/api/auth/dang-ky/sinh-vien',
        REGISTER_TEACHER: '/api/auth/dang-ky/giao-vien',
        LOGIN: '/api/auth/dang-nhap',
        LOGOUT: '/api/auth/dang-xuat'
    },
    STUDENT: {
        GET_PROFILE: '/api/sinhvien/thong-tin',
        UPDATE_PROFILE: '/api/sinhvien/cap-nhat',
        // other endpoints...
    },
    TEACHER: {
        GET_PROFILE: '/api/giaovien/thong-tin',
        UPDATE_PROFILE: '/api/giaovien/cap-nhat',
        // other endpoints...
    }
};

export interface LoginRequest {
    tenDangNhap: string;
    matKhau: string;
}

export interface LoginResponse {
    token: string;
    type: string;
    id: number;
    username: string;
    roles: string[];
}

export interface RegisterStudentRequest {
    tenDangNhap: string;
    matKhau: string;
    email: string;
    soDienThoai: string;
    tenSinhVien: string;
    lop: string;
    maChuyenNganh: number;
    namVaoHoc: number;
}

// ... other interfaces 