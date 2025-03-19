let usuarioId = 1; // Simulación de usuario
let libroId = 101; // Simulación de libro

document.addEventListener("DOMContentLoaded", () => {
    cargarProgreso();
});

function cambiarFuente(tamaño) {
    document.getElementById("lector").style.fontSize = tamaño + "px";
}

function toggleModoOscuro() {
    document.body.classList.toggle("modo-oscuro");
}

function cargarProgreso() {
    fetch(`http://localhost:8080/lecturas/usuario/${usuarioId}`)
    .then(response => response.json())
    .then(data => {
        let lectura = data.find(l => l.libro.id === libroId);
        if (lectura) {
            document.getElementById("contenido").innerText = `Página ${lectura.paginaActual}`;
        }
    });
}

function guardarProgreso() {
    let progreso = {
        usuario: { id: usuarioId },
        libro: { id: libroId },
        paginaActual: Math.floor(Math.random() * 100) + 1 // Simulación de página
    };

    fetch("http://localhost:8080/lecturas", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(progreso)
    })
    .then(response => response.json())
    .then(data => {
        alert("Progreso guardado: Página " + data.paginaActual);
    });
}
function subirArchivo() {
    let archivo = document.getElementById("archivo").files[0];
    let formData = new FormData();
    formData.append("file", archivo);

    fetch("http://localhost:8080/archivos/subir", {
        method: "POST",
        body: formData
    })
    .then(response => response.text())
    .then(data => {
        alert("Archivo subido con éxito: " + data);
        document.getElementById("visorPDF").src = "uploads/" + archivo.name;
    })
    .catch(error => console.error("Error al subir el archivo", error));
}
function mostrarLibro(archivo) {
    let visorPDF = document.getElementById("visorPDF");
    let visorEPUB = document.getElementById("visorEPUB");

    if (archivo.endsWith(".pdf")) {
        visorPDF.src = "uploads/" + archivo;
        visorPDF.style.display = "block";
        visorEPUB.style.display = "none";
    } else if (archivo.endsWith(".epub")) {
        visorEPUB.innerHTML = "";
        let libro = ePub("uploads/" + archivo);
        let rendition = libro.renderTo("visorEPUB", { width: "100%", height: "600px" });
        rendition.display();
        visorPDF.style.display = "none";
        visorEPUB.style.display = "block";
    }
}


