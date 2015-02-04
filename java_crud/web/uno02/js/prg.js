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

//CONTACTO.logJSON(JSON.stringify(promise));
/*
promise.get('data/data.json').then(function(error, text, xhr) {
    if (error) {
        alert('Error ' + xhr.status);
        return;
    }
    alert('The page contains ' + text.length + ' character(s).' + text);
});
*/

// Metodos GET POST PUT DELETE Cliente
CONTACTO.get = function(elid) {
    // Obtiene el elemento HTML con los filtros parametros
    var elEmail = document.querySelector(elid);

    // Crea un Objeto JSON con los filtros parametros
    var losParametros = {};
    losParametros.email = elEmail.value;

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
    // Obtiene el elemento HTML con los filtros parametros
    var elEmail = document.querySelector(elid);

    // Crea un Objeto JSON con los filtros parametros
    var losParametros = {};
    losParametros.email = elEmail.value;

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
    // Obtiene el elemento HTML con los filtros parametros
    var elEmail = document.querySelector(elid);

    // Crea un Objeto JSON con los filtros parametros
    var losParametros = {};
    losParametros.email = elEmail.value;

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
    // Obtiene el elemento HTML con los filtros parametros
    var elEmail = document.querySelector(elid);

    // Crea un Objeto JSON con los filtros parametros
    var losParametros = {};
    losParametros.email = elEmail.value;

    // Configura la consulta Ajax, a la Accion Contacto
    promise.ajax('DELETE', 'srv/Contacto.php', JSON.stringify(losParametros)).then(function(error, text, xhr) {
        if (error) {
            CONTACTO.log("ERROR: " + error);
        } else { // OK
            CONTACTO.logJSON(JSON.parse(text));
        }
    });

};
