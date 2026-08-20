const formulario = document.getElementById("formLogin");

formulario.addEventListener("submit", function(evento) {

    evento.preventDefault();

    const correo = document.getElementById("correo").value.trim();
    const contrasena = document.getElementById("contrasena").value.trim();
    const tipoUsuario = document.getElementById("tipoUsuario").value;
    const mensaje = document.getElementById("mensaje");

    if (correo === "" || contrasena === "" || tipoUsuario === "") {

        mensaje.textContent = "Por favor, complete todos los campos.";

        return;
    }

    mensaje.textContent =
        "Bienvenido a COMFEY. Usuario: " + tipoUsuario;

});