var CONTACTO = {};

// Mensajes de Log de la Aplicacion Cliente
CONTACTO.panelMsg = document.querySelector('#msg');
CONTACTO.log = function(txt) {
    CONTACTO.panelMsg.innerHTML += txt + '<br/>';
};
CONTACTO.logJSON = function(responseText) {
    var resp = JSON.parse(responseText);
    for (var clave in resp) {
        CONTACTO.log("[" + (new Date()) + "] " + clave + ": " + resp[clave]);
    }
};

CONTACTO.form = function(elid){
    // Obtiene el elemento HTML con los filtros parametros
    var elForm = document.querySelector(elid);
    var losInput = elForm.querySelectorAll("input[type='text'],input[type='email']");
    // Crea un Objeto JSON con los filtros parametros
    var losParametros = {};
    //losParametros del formulario;
    for(var i = 0; i < losInput.length; i++){
      losParametros[ losInput[i].name ] = losInput[i].value;
    }
    return losParametros;
};
// Metodos GET POST PUT DELETE Cliente
CONTACTO.get = function(elid) {
    var losParametros = CONTACTO.form(elid);
    // Configura la consulta Ajax, a la Accion Contacto
    promise.ajax('GET', 'srv/Contacto.php', JSON.stringify(losParametros)).then(function(error, text, xhr) {
        if (error) {
            CONTACTO.log("ERROR: " + error);
        } else { // OK
            CONTACTO.logJSON(JSON.parse(text));
        }
    });
};
CONTACTO.post = function(elid) {
    var losParametros = CONTACTO.form(elid);
    // Configura la consulta Ajax, a la Accion Contacto
    promise.ajax('POST', 'srv/Contacto.php', JSON.stringify(losParametros)).then(function(error, text, xhr) {
        if (error) {
            CONTACTO.log("ERROR: " + error);
        } else { // OK
            CONTACTO.logJSON(JSON.parse(text));
        }
    });
};
CONTACTO.put = function(elid) {
    var losParametros = CONTACTO.form(elid);
    // Configura la consulta Ajax, a la Accion Contacto
    promise.ajax('PUT', 'srv/Contacto.php', JSON.stringify(losParametros)).then(function(error, text, xhr) {
        if (error) {
            CONTACTO.log("ERROR: " + error);
        } else { // OK
            CONTACTO.logJSON(JSON.parse(text));
        }
    });

};
CONTACTO.delete = function(elid) {
    var losParametros = CONTACTO.form(elid);
    // Configura la consulta Ajax, a la Accion Contacto
    promise.ajax('DELETE', 'srv/Contacto.php', JSON.stringify(losParametros)).then(function(error, text, xhr) {
        if (error) {
            CONTACTO.log("ERROR: " + error);
        } else { // OK
            CONTACTO.logJSON(JSON.parse(text));
        }
    });

};
