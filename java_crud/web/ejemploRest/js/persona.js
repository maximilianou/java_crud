// Javascript: Inicializacion de Objeto PERSONA Instanciado con Llaves
PERSONA = {};
//TODO: Recordar poner mas comentarios
// Creacion de un Metodo insertar() en el Objeto PERSONA
PERSONA.insertar = function(){
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
PERSONA.consultar = function(){
    // Instanciar el Objeto AJAX que existe en todos los Navegadores Web
    var xhr = new XMLHttpRequest();
    // Metodo CONSULTAR, Accion PersonaServer
    xhr.open("GET","../PersonaServer");
    // Metodo Respuesta que se ejecuta en y muestra al finalizar el AJAX.
    xhr.onreadystatechange = function(){
        if( xhr.readyState === 4 && xhr.status === 200){ // Caso de OK 
            //document.querySelector('#panelResultados').innerHTML += xhr.responseText + '<br/>';
            var templatePersonas = document.querySelector("#templatePersonas").innerHTML;
            var personas = {};
            personas.listaPersonas = JSON.parse( xhr.responseText );
            document.querySelector('#panelResultados').innerHTML = Mustache.render(  templatePersonas, personas);
        } // Lista de codigos de error https://tools.ietf.org/html/rfc7231
    };
    // objeto para enviar los parametros del formulario
    var persona = {};
     persona.nombre = document.querySelector("#persona_nombre").value;
    persona.email = document.querySelector("#persona_email").value;
    // formato del mensaje en JSON
    var personaStringJSON = JSON.stringify(persona);
    // Activa el Envio por Red del Ajax
    xhr.send( personaStringJSON );
};

/////////////////////////////////////////
// Inicializa en la pagina HTML los Eventos que ejecutan el Javascript
PERSONA.inicializar = function(){
    // Agregar en los botones visuales HTML, las acciones Javascript
    var elemInsertar = document.querySelector('#btnInsertar');    
    elemInsertar.setAttribute('onclick',"PERSONA.insertar();");
    var elemConsultar = document.querySelector('#btnConsultar');    
    elemConsultar.setAttribute('onclick',"PERSONA.consultar();");
   
};
// Se llama a la inicializacion de la pagina, 
// incorpora de forma NO Intrusiva el codigo javascript en el html
PERSONA.inicializar();

