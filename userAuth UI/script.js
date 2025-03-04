document.addEventListener('DOMContentLoaded', () => {
    const loginForm = document.querySelector('.login-form');
    const signupForm = document.querySelector('.signup-form');
    const signupLink = document.getElementById('signupLink');
    const loginLink = document.getElementById('loginLink');
    const loginBtn = document.getElementById('loginBtn');
    const signupBtn = document.getElementById('signupBtn');

    signupLink.addEventListener('click', (e) => {
        e.preventDefault();
        loginForm.style.display = 'none';
        signupForm.style.display = 'block';
    });

    loginLink.addEventListener('click', (e) => {
        e.preventDefault();
        signupForm.style.display = 'none';
        loginForm.style.display = 'block';
    });

    loginBtn.addEventListener('click', async () => {
        const email = document.getElementById('loginEmail').value;
        const password = document.getElementById('loginPassword').value;
        const login_data={
            "email":email,
            "password":password
        }
        try {
            const response = await axios.post('http://localhost:8080/api/login',login_data);
            console.log('Login successful', response.data);
            alert('Login successful '+response.data);
            // Redirect or update UI as needed
        } catch (error) {
            console.error('Login failed', error);
            alert(error.response?.data );
        }
    }); 
    signupBtn.addEventListener('click', async () => {
        const name = document.getElementById('signupName').value;
        const email = document.getElementById('signupEmail').value;
        const password = document.getElementById('signupPassword').value;
        const sign_data={
            "name":name,
            "email":email,
            "password":password
        }
        
        try {
            const response = await axios.post('http://localhost:8080/api/signup',sign_data);
            console.log('Signup successful', response.data);
            alert('Signup successful! Please login.');
            // Switch to login form after successful signup
            signupForm.style.display = 'none';
            loginForm.style.display = 'block';
        } catch (error) {
            console.error('Signup failed', error);
            alert('Signup failed. Please try again.');
        }
    });
});

