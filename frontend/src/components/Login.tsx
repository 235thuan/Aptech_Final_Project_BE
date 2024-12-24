import { authService } from '../services/api';

const Login = () => {
    const handleLogin = async (e: FormEvent) => {
        e.preventDefault();
        try {
            const response = await authService.login(username, password);
            localStorage.setItem('token', response.token);
            // Handle successful login
        } catch (error) {
            // Handle error
        }
    };

    return (
        <form onSubmit={handleLogin}>
            {/* Login form */}
        </form>
    );
}; 