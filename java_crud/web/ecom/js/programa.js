var NOTA = {};
NOTA.consultar = function ( comando ) {
    alert(comando.laurl);
    alert(comando.laplantilla);
    alert(comando.panelresultado);
    var xhr = new XMLHttpRequest();
    //xhr.open("GET", "../presentacion01/NotasAJson");
    xhr.open("GET", comando.laurl);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            //var lavista = document.querySelector("#laplantilla").innerHTML;
            var lavista = document.querySelector(comando.laplantilla).innerHTML;
            var eldato = {};
            eldato.listaNotas = JSON.parse(xhr.responseText);
            var resultado = Mustache.render(lavista, eldato);
            //document.querySelector("#panelResultados").innerHTML += resultado;
            document.querySelector(comando.panelresultado).innerHTML += resultado;
        } else {

        }
    };
    xhr.send();
};


NOTA.inicializar = function () {
    document.querySelector("#elboton").setAttribute("onclick", 
    "NOTA.consultar(\n\
      {'laurl':'../presentacion01/NotasAJson', \n\
      'laplantilla':'#laplantilla', \n\
      'panelresultado':'#panelResultados'}\n\
     );");
};
NOTA.inicializar();


