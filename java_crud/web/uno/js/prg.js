var CONTACTO = {};

// Mensajes de Log de la Aplicacion Cliente
CONTACTO.panelMsg = document.querySelector('#msg');

CONTACTO.log = function(txt){
    CONTACTO.panelMsg.innerHTML += txt + '<br/>';
};
CONTACTO.logJSON = function(responseText){
        var resp = JSON.parse(responseText);
        for(var clave in resp){
         CONTACTO.log( "["+(new Date())+"] " +clave+": "+resp[clave]);
        }
};

// Metodos GET POST PUT DELETE Cliente
CONTACTO.get = function(elid){
    var xhr = new XMLHttpRequest();
    xhr.open("GET","Contacto");
    xhr.onreadystatechange = function(){
        if( xhr.readyState === 4 ){
            if( xhr.status === 200 ){
               CONTACTO.log( xhr.responseText );
               CONTACTO.logJSON( xhr.responseText );
            }else{
               CONTACTO.log("ERROR: "+xhr.responseText);
            }
        }
    }
    xhr.send(elid);
};

CONTACTO.post = function(){
};

CONTACTO.put = function(){
};

CONTACTO.delete = function(){
};
