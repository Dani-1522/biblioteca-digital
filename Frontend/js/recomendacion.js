const usuarioId = 1; // Simulación de usuario

document.addEventListener("DOMContentLoaded", () => {
    cargarLibrosPopulares();
    cargarReseñas();
});

function cargarLibrosPopulares() {
    fetch("http://localhost:8080/api/recomendaciones/populares")
    .then(response => response.json())
    .then(libros => {
        const lista = document.getElementById("librosPopulares");
        lista.innerHTML = "";
        libros.forEach(libroId => {
            const item = document.createElement("li");
            item.textContent = `Libro ID: ${libroId}`;
            lista.appendChild(item);
        });
    });
}

function cargarReseñas() {
    fetch("http://localhost:8080/api/recomendaciones/libro/101") // Simulación de un libro
    .then(response => response.json())
    .then(resenas => {
        const lista = document.getElementById("listaReseñas");
        lista.innerHTML = "";
        resenas.forEach(resena => {
            const item = document.createElement("li");
            item.textContent = `${resena.reseña} - Calificación: ${resena.calificacion}`;
            lista.appendChild(item);
        });
    });
}

function guardarReseña() {
    const libroId = document.getElementById("libroSelect").value;
    const reseña = document.getElementById("resena").value;
    const calificacion = document.getElementById("calificacion").value;

    const data = {
        usuario: { id: usuarioId },
        libro: { id: libroId },
        calificacion: parseFloat(calificacion),
        reseña: reseña
    };

    fetch("http://localhost:8080/api/recomendaciones", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(() => {
        alert("Reseña guardada");
        cargarReseñas();
    });
}