import axios from 'axios';
import { API_ENDPOINTS } from './api-docs';

const api = axios.create({
    baseURL: 'http://localhost:8080'
});

// Add JWT token to requests
api.interceptors.request.use(config => {
    const token = localStorage.getItem('token');
    if (token) {
        config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
});

// Add response interceptor
api.interceptors.response.use(
    response => response,
    error => {
        if (error.response) {
            switch (error.response.status) {
                case 401:
                    // Handle unauthorized
                    localStorage.removeItem('token');
                    window.location.href = '/login';
                    break;
                case 403:
                    // Handle forbidden
                    break;
                case 400:
                    // Handle validation errors
                    break;
                default:
                    // Handle other errors
            }
        }
        return Promise.reject(error);
    }
);

export const authService = {
    login: async (username: string, password: string) => {
        const response = await api.post(API_ENDPOINTS.AUTH.LOGIN, {
            tenDangNhap: username,
            matKhau: password
        });
        return response.data;
    },

    registerStudent: async (data: RegisterStudentRequest) => {
        const response = await api.post(API_ENDPOINTS.AUTH.REGISTER_STUDENT, data);
        return response.data;
    },

    logout: async () => {
        await api.post(API_ENDPOINTS.AUTH.LOGOUT);
        localStorage.removeItem('token');
    }
};

export const studentService = {
    getProfile: async () => {
        const response = await api.get(API_ENDPOINTS.STUDENT.GET_PROFILE);
        return response.data;
    },
    // other methods...
}; 