class Persona{
  static insertar(){
    var xhr = new XMLHttpRequest();
    // Metodo INSERTAR, Accion PersonaServer
    xhr.open("POST","../PersonaServer");
    xhr.onreadystatechange = function(){
        if( xhr.readyState === 4 && xhr.status === 200){
            document.querySelector('#panelResultados').innerHTML += xhr.responseText + '<br/>';
        }
    };
    // objeto para enviar los parametros del formulario
    var persona = {};
    persona.nombre = document.querySelector("#persona_nombre").value;
    persona.email = document.querySelector("#persona_email").value;
    // formato del mensaje en JSON
    var personaStringJSON = JSON.stringify(persona);
    xhr.send(  personaStringJSON );
      
  }  
  static actualizar(){
    var xhr = new XMLHttpRequest();
    // Metodo ACTUALIZAR, Accion PersonaServer
    xhr.open("PUT","../PersonaServer");
    xhr.onreadystatechange = function(){
        if( xhr.readyState === 4 && xhr.status === 200){
            document.querySelector('#panelResultados').innerHTML += xhr.responseText + '<br/>';
        }
    };
    // objeto para enviar los parametros del formulario
    var persona = {};
    persona.id = paramId;
    persona.nombre = document.querySelector("#persona_nombre_"+paramId).value;
    persona.email = document.querySelector("#persona_email_"+paramId).value;
    // formato del mensaje en JSON
    var personaStringJSON = JSON.stringify(persona);
    xhr.send( personaStringJSON );
      
  }  
  static eliminar(){
    // objeto para enviar los parametros del formulario
    var persona = {};
    persona.id = paramId;
    persona.nombre = document.querySelector("#persona_nombre_"+paramId).value;
    persona.email = document.querySelector("#persona_email_"+paramId).value;
    // formato del mensaje en JSON
    var personaStringJSON = JSON.stringify(persona);

    var xhr = new XMLHttpRequest();
    // Metodo ELIMINAR, Accion PersonaServer
    xhr.open("DELETE","../PersonaServer?&q=" + personaStringJSON);
    xhr.onreadystatechange = function(){
        if( xhr.readyState === 4 && xhr.status === 200){
            document.querySelector('#panelResultados').innerHTML += xhr.responseText + '<br/>';
        }
    };
    //xhr.send( personaStringJSON );
    xhr.send(  );
      
  }  
  static consultar(){
    var xhr = new XMLHttpRequest();
    // Metodo CONSULTAR, Accion PersonaServer
    xhr.open("GET","../PersonaServer");
    xhr.onreadystatechange = function(){
        if( xhr.readyState === 4 && xhr.status === 200){
            //document.querySelector('#panelResultados').innerHTML += xhr.responseText + '<br/>';
            var personas = JSON.parse( xhr.responseText );
            var templatePersonas = document.querySelector("#templatePersonasES6").innerHTML;
            document.querySelector('#panelResultados').innerHTML = eval( templatePersonas );
        }
    };
    // objeto para enviar los parametros del formulario
    var persona = {};
    persona.nombre = document.querySelector("#persona_nombre").value;
    persona.email = document.querySelector("#persona_email").value;
    // formato del mensaje en JSON
    var personaStringJSON = JSON.stringify(persona);
    xhr.send( personaStringJSON );
      
  }  
}
/////////////////////////////////////////

Persona.inicializar = function(){
   var elemInsertar = document.querySelector('#btnInsertar');    
   elemInsertar.setAttribute('onclick',"Persona.insertar();");
   var elemActualizar = document.querySelector('#btnActualizar');    
   elemActualizar.setAttribute('onclick',"Persona.actualizar();");
   var elemEliminar = document.querySelector('#btnEliminar');    
   elemEliminar.setAttribute('onclick',"Persona.eliminar();");
   var elemConsultar = document.querySelector('#btnConsultar');    
   elemConsultar.setAttribute('onclick',"Persona.consultar();");
   
};
Persona.inicializar();
