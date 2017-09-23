// Javascript: Inicializacion de Objeto PERSONA Instanciado con Llaves
Persona = {};
// Creacion de un Metodo insertar() en el Objeto PERSONA
Persona.insertar = function(){
    // Instanciar el Objeto AJAX que existe en todos los Navegadores Web
    var xhr = new XMLHttpRequest();
    // Metodo INSERTAR, Accion PersonaServer
    xhr.open("POST","../PersonaServer");
    //xhr.setRequestHeader('enctype', 'multipart/form-data');
    xhr.setRequestHeader('Content-Type', 'multipart/form-data');
    // Metodo Respuesta que se ejecuta en y muestra al finalizar el AJAX.
    xhr.onreadystatechange = function(){
        if( xhr.readyState === 4 && xhr.status === 200){ // Caso de OK 
            document.querySelector('#panelResultados').innerHTML += xhr.responseText + '<br/>';
        } // Lista de codigos de error https://tools.ietf.org/html/rfc7231
    };
    // objeto para enviar los parametros del formulario
    var persona = {}; // new Object();
    persona.nombre = document.querySelector("#persona_nombre").value;
    persona.email = document.querySelector("#persona_email").value;
    // formato del mensaje en JSON
    var personaStringJSON = JSON.stringify(persona);
    // Activa el Envio por Red del Ajax
    xhr.send(  personaStringJSON );
};
// Creacion de un Metodo consultar() en el Objeto PERSONA
Persona.consultar = function(){
    // Instanciar el Objeto AJAX que existe en todos los Navegadores Web
    var xhr = new XMLHttpRequest();
    // Metodo CONSULTAR, Accion PersonaServer
    xhr.open("GET","../PersonaServer");
    // Metodo Respuesta que se ejecuta en y muestra al finalizar el AJAX.
    xhr.onreadystatechange = function(){
        if( xhr.readyState === 4 && xhr.status === 200){ // Caso de OK 
            //document.querySelector('#panelResultados').innerHTML += xhr.responseText + '<br/>';
            var personas = JSON.parse( xhr.responseText );
            var templatePersonas = document.querySelector("#templatePersonasES6").innerHTML;
            document.querySelector('#panelResultados').innerHTML = eval( templatePersonas );
        } // Lista de codigos de error https://tools.ietf.org/html/rfc7231
    };
    // Activa el Envio por Red del Ajax
    xhr.send( );
};
/////////////////////////////////////////
// Inicializa en la pagina HTML los Eventos que ejecutan el Javascript
Persona.inicializar = function(){
    // Agregar en los botones visuales HTML, las acciones Javascript
    var elemInsertar = document.querySelector('#btnInsertar');    
    elemInsertar.setAttribute('onclick',"Persona.insertar();");
    var elemConsultar = document.querySelector('#btnConsultar');    
    elemConsultar.setAttribute('onclick',"Persona.consultar();");
   
};
// Se llama a la inicializacion de la pagina, 
// incorpora de forma NO Intrusiva el codigo javascript en el html
Persona.inicializar();

