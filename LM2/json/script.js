function obtenerUsuarios() {
    var xhr = new XMLHttpRequest();

    // Configurar la solicitud
    let ts=Date.now();
    let apikey="9a0b85ba945f7c199f411cb4bccffc48";
    let apikey2="c1dd2a0483a6120b23bb79bba3eb486afde505f3";
    let hash=md5(ts+apikey+apikey2);
    let url="http://gateway.marvel.com/v1/public/comics";
    url+="?ts="+ts+"&apikey="+apikey+"&hash="+hash;
    xhr.open("GET", url, true);

    // Manejar la respuesta
    xhr.onload = function() {
        if (xhr.status == 200) {
            // Convertir la respuesta JSON a un objeto JavaScript
            var usuarios = JSON.parse(xhr.responseText);

            // Manejar los datos obtenidos
            mostrarUsuarios(usuarios);
        } else {
            console.error("Error al realizar la solicitud. Código de estado: " + xhr.status);
        }
    };

    // Manejar errores de red
    xhr.onerror = function() {
        console.error("Error de red al realizar la solicitud");
    };

    // Enviar la solicitud
    xhr.send();
}

function mostrarUsuarios(usuarios) {
    var resultado = document.getElementById("resultado");
    resultado.innerHTML = "<h2>Usuarios</h2>";

    // Crear una lista de usuarios
    var listaUsuarios = "<ul>";
    usuarios.forEach(function(usuario) {
        listaUsuarios += "<li><strong>ID:</strong> " + usuario.id + ", <strong>Nombre:</strong> " + usuario.name + ", <strong>Email:</strong> " + usuario.email + "</li>";
    });
    listaUsuarios += "</ul>";

    resultado.innerHTML += listaUsuarios;
}