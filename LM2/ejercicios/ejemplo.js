let persona = {
  nombre: "Juan",
  edad: 30,
  ciudad: "Madrid"
};

let personaJSON = JSON.stringify(persona);
console.log(personaJSON); // Salida: {"nombre":"Juan","edad":30,"ciudad":"Madrid"}