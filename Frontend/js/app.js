document.getElementById("formLibro").addEventListener("submit", async function(event) {
    event.preventDefault();

    const libro = {
        titulo: document.getElementById("titulo").value,
        autor: document.getElementById("autor").value,
        isbn: document.getElementById("isbn").value,
        fechaPublicacion: document.getElementById("fechaPublicacion").value,
        genero: document.getElementById("genero").value
    };

    console.log("Enviando libro:", libro); // Verifica en la consola

    try {
        const response = await fetch("http://localhost:3000/api/libros", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(libro)
        });

        const data = await response.json();
        console.log("Respuesta del servidor:", data);
        document.getElementById("mensaje").textContent = data.mensaje;
    } catch (error) {
        console.error("Error:", error);
        document.getElementById("mensaje").textContent = "Error al registrar el libro";
    }
});