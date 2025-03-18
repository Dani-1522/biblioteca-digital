document.getElementById("libroForm").addEventListener("submit", function(event) {
    event.preventDefault();

    let libro = {
        titulo: document.getElementById("titulo").value,
        autor: document.getElementById("autor").value,
        isbn: document.getElementById("isbn").value,
        categoria: document.getElementById("categoria").value,
        stock: document.getElementById("stock").value
    };

    fetch("http://localhost:8080/libros", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(libro)
    })
    .then(response => response.json())
    .then(data => {
        alert("Libro registrado");
        obtenerLibros();
    });
});

function obtenerLibros() {
    fetch("http://localhost:8080/libros")
    .then(response => response.json())
    .then(data => {
        let lista = document.getElementById("listaLibros");
        lista.innerHTML = "";
        data.forEach(libro => {
            let item = document.createElement("li");
            item.textContent = `${libro.titulo} - ${libro.autor}`;
            lista.appendChild(item);
        });
    });
}

function buscarLibros() {
    let titulo = document.getElementById("buscarTitulo").value;
    fetch(`http://localhost:8080/libros/buscar/titulo/${titulo}`)
    .then(response => response.json())
    .then(data => {
        let lista = document.getElementById("listaLibros");
        lista.innerHTML = "";
        data.forEach(libro => {
            let item = document.createElement("li");
            item.textContent = `${libro.titulo} - ${libro.autor}`;
            lista.appendChild(item);
        });
    });
}

obtenerLibros();