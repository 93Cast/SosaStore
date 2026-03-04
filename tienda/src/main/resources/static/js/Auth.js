document.addEventListener("DOMContentLoaded", () => {

    const loginForm = document.getElementById("loginForm");
    const registerForm = document.getElementById("registerForm");

    if (loginForm) {
        loginForm.addEventListener("submit", async (e) => {
            e.preventDefault();

            const response = await fetch("/api/auth/login", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({
                    email: email.value,
                    password: password.value
                })
            });

            const data = await response.json();

            if (response.ok) {
                localStorage.setItem("token", data.token);
                window.location.href = "/dashboard";
            } else {
                alert("Credenciales incorrectas");
            }
        });
    }

    if (registerForm) {
        registerForm.addEventListener("submit", async (e) => {
            e.preventDefault();

            await fetch("/api/auth/register", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({
                    nombre: nombre.value,
                    email: email.value,
                    password: password.value
                })
            });

            window.location.href = "/login";
        });
    }
});