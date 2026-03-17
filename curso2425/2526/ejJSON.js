function serializar(obj) {
  return JSON.stringify(obj)  // Convierte a texto
}

function deserializar(objJson) {
  return JSON.parse(objJson)  // Convierte a objeto
}

function enviar(obj) {
  console.log("Serializado: " + obj.nombre);
  return serializar(obj);
}

function recibir(json_serializado) {
  console.log("Deserializado: " + json_serializado);
  return deserializar(json_serializado);
}

function insertaDatos(obj_recuperado) {
  $("#tr2").append(
    "<tr><td>" + obj_recuperado.nombre + "</td>" +
    "<td>" + obj_recuperado.apellidos + "</td>" +
    "<td>" + obj_recuperado.edad + "</td>" +
    "<td>" + obj_recuperado.ciudad + "</td></tr>"
  );
}

function inputDatos() {
  let nombre = $("#inputNombre").val();
  let apellidos = $("#inputApellidos").val();
  let edad = $("#inputEdad").val();
  let ciudad = $("#inputCiudad").val();

  let obj = {
    "nombre": nombre,
    "apellidos": apellidos,
    "edad": edad,
    "ciudad": ciudad
  }

  insertaDatos(obj);

}
