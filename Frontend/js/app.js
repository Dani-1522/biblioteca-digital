function mostrarMensaje(id, mensaje, tipo) {
    const elemento = document.getElementById(id);
    if (elemento) {
        elemento.innerText = mensaje;
        elemento.style.color = tipo === "error" ? "red" : "green";
    }
}

// Registrar usuario con validación
document.getElementById("registerForm").addEventListener("submit", function (e) {
    e.preventDefault();
    
    const username = document.getElementById("registerUsername").value;
    const password = document.getElementById("registerPassword").value;

    if (username.length < 4 || password.length < 6) {
        mostrarMensaje("registerError", "Usuario o contraseña demasiado cortos", "error");
        return;
    }

    fetch("http://localhost:8080/api/auth/register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username, password })
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            mostrarMensaje("registerError", "Usuario registrado con éxito", "success");
        } else {
            mostrarMensaje("registerError", data.message || "Error al registrar", "error");
        }
    })
    .catch(() => mostrarMensaje("registerError", "Error al conectar con el servidor", "error"));
});

// Inicio de sesión con validación
document.getElementById("loginForm").addEventListener("submit", function (e) {
    e.preventDefault();

    const username = document.getElementById("loginUsername").value;
    const password = document.getElementById("loginPassword").value;

    fetch("http://localhost:8080/api/auth/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username, password })
    })
    .then(response => response.json())
    .then(data => {
        if (data.token) {
            localStorage.setItem("token", data.token);
            mostrarMensaje("loginError", "Inicio de sesión exitoso", "success");
        } else {
            mostrarMensaje("loginError", "Credenciales incorrectas", "error");
        }
    })
    .catch(() => mostrarMensaje("loginError", "Error al conectar con el servidor", "error"));
});
