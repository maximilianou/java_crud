class Persona {

    static inicializar() {
        let elemInsertar = document.querySelector('#btnInsertar');
        elemInsertar.setAttribute('onclick', "Persona.insertar();");
        let elemConsultar = document.querySelector('#btnConsultar');
        elemConsultar.setAttribute('onclick', "Persona.consultar();");
    }
    
    static insertar() {
        // objeto para enviar los parametros del formulario
        let persona = {};
        persona.nombre = document.querySelector("#persona_nombre").value;
        persona.email = document.querySelector("#persona_email").value;
        // formato del mensaje en JSON
        let personaStringJSON = JSON.stringify(persona);
        // Reemplazo de Ajax a Fetch
        fetch("../PersonaServer",
                {method: 'POST', body: personaStringJSON})
                .then(function (response) {
                    return response.text();
                })
                .then(function (datotexto) {
                    document.querySelector('#panelResultados').innerHTML = datotexto;
                });
    }
    
    static actualizar(paramId) {
        // objeto para enviar los parametros del formulario
        let persona = {};
        persona.id = paramId;
        persona.nombre = document.querySelector("#persona_nombre_" + paramId).value;
        persona.email = document.querySelector("#persona_email_" + paramId).value;
        // formato del mensaje en JSON
        let personaStringJSON = JSON.stringify(persona);
        // Reemplazo de Ajax a Fetch
        fetch("../PersonaServer",
                {method: 'PUT', body: personaStringJSON})
                .then(function (response) {
                    return response.text();
                })
                .then(function (datotexto) {
                    document.querySelector('#panelResultados').innerHTML = datotexto;
                });
    }
    
    static eliminar(paramId) {
        // objeto para enviar los parametros del formulario
        let persona = {};
        persona.id = paramId;
        persona.nombre = document.querySelector("#persona_nombre_" + paramId).value;
        persona.email = document.querySelector("#persona_email_" + paramId).value;
        // formato del mensaje en JSON
        let personaStringJSON = JSON.stringify(persona);
        // Reemplazo de Ajax a Fetch
        fetch("../PersonaServer?&q=" + personaStringJSON,
                {method: 'DELETE'})
                .then(function (response) {
                    return response.text();
                })
                .then(function (datotexto) {
                    document.querySelector('#panelResultados').innerHTML = datotexto;
                });
    }
    
    static consultar() {
        // Reemplazo de Ajax a Fetch
        fetch("../PersonaServer",
                {method: 'GET'})
                .then(function (response) {
                    return response.text();
                })
                .then(function (datotexto) {
                    let personas = JSON.parse(datotexto);
                    let templatePersonas = document.querySelector("#templatePersonasES6").innerHTML;
                    document.querySelector('#panelResultados').innerHTML = eval(templatePersonas);
                });
    }
}
///////////////////////////////////////// main() // Ejecucion Inicial Default
Persona.inicializar();
/////////////////////////////////////////
