document.getElementById("usuarioForm").addEventListener("submit", function(event) {
    event.preventDefault();

    let usuario = {
        nombre: document.getElementById("nombre").value,
        correo: document.getElementById("correo").value,
        contraseña: document.getElementById("contraseña").value,
        rol: document.getElementById("rol").value
    };

    fetch("http://localhost:8080/usuarios", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(usuario)
    })
    .then(response => response.json())
    .then(data => {
        alert("Usuario registrado");
        obtenerUsuarios();
    });
});

function obtenerUsuarios() {
    fetch("http://localhost:8080/usuarios")
    .then(response => response.json())
    .then(data => {
        let lista = document.getElementById("listaUsuarios");
        lista.innerHTML = "";
        data.forEach(usuario => {
            let item = document.createElement("li");
            item.textContent = `${usuario.nombre} - ${usuario.correo}`;
            lista.appendChild(item);
        });
    });
}

function buscarUsuarios() {
    let nombre = document.getElementById("buscarNombre").value;
    fetch(`http://localhost:8080/api/usuarios/buscar/nombre/${nombre}`)
    .then(response => response.json())
    .then(data => {
        let lista = document.getElementById("listaUsuarios");
        lista.innerHTML = "";
        data.forEach(usuario => {
            let item = document.createElement("li");
            item.textContent = `${usuario.nombre} - ${usuario.correo}`;
            lista.appendChild(item);
        });
    });
}

obtenerUsuarios();