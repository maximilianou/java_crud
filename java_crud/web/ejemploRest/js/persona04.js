class Persona {

    static inicializar() {
        let elemInsertar = document.querySelector('#btnInsertar');
        elemInsertar.setAttribute('onclick', "Persona.insertar();");
        let elemConsultar = document.querySelector('#btnConsultar');
        elemConsultar.setAttribute('onclick', "Persona.consultar();");
    }

    static insertar() {
        let persona = {};
        persona.nombre = document.querySelector("#persona_nombre").value;
        persona.email = document.querySelector("#persona_email").value;
        let personaStringJSON = JSON.stringify(persona);
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
        let persona = {};
        persona.id = paramId;
        persona.nombre = document.querySelector("#persona_nombre_" + paramId).value;
        persona.email = document.querySelector("#persona_email_" + paramId).value;
        let personaStringJSON = JSON.stringify(persona);
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
        let persona = {};
        persona.id = paramId;
        persona.nombre = document.querySelector("#persona_nombre_" + paramId).value;
        persona.email = document.querySelector("#persona_email_" + paramId).value;
        let personaStringJSON = JSON.stringify(persona);
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
        const traer = async() => {
            let respuesta = await fetch("../PersonaServer", {method: 'GET'});
            let personas = JSON.parse(await respuesta.text());
            let templatePersonas = await document.querySelector("#templatePersonasES6").innerHTML;
            document.querySelector('#panelResultados').innerHTML = await eval(templatePersonas);
        }
        traer()
                .catch(ex => {
                    document.querySelector("#panelMensajes").innerHTML = 'ERROR: ' + ex.message;
                });
    }
}
///////////////////////////////////////// main() // Ejecucion Inicial Default
Persona.inicializar();
/////////////////////////////////////////