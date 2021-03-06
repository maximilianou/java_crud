##  Javascript, minimal CRUD.
-----

* Javascript OOP, class, fetch, JSON
* css selectors to connect elements and utilities

>        
        
----- 
>      class Persona {
>          static inicializar() {
>              let elemInsertar = document.querySelector('#btnInsertar');
>              elemInsertar.setAttribute('onclick', "Persona.insertar();");
>              let elemConsultar = document.querySelector('#btnConsultar');
>              elemConsultar.setAttribute('onclick', "Persona.consultar();");
>          }
>          static insertar() {
>              const traer = async() => {
>                  let persona = {};
>                  persona.nombre = document.querySelector("#persona_nombre").value;
>                  persona.email = document.querySelector("#persona_email").value;
>                  let personaStringJSON = JSON.stringify(persona);
>                  let respuesta = await fetch("../PersonaServer",
>                          {method: 'POST', body: personaStringJSON});
>                  let datotexto = JSON.parse(await respuesta.text());
>                  document.querySelector('#panelResultados').innerHTML = datotexto;
>              };
>              traer()
>                      .catch(ex => {
>                          document.querySelector("#panelMensajes").innerHTML = 'ERROR: ' + ex.message;
>                      });
>      
>          }
>          static actualizar(paramId) {
>              const traer = async() => {
>                  let persona = {};
>                  persona.id = paramId;
>                  persona.nombre = document.querySelector("#persona_nombre_" + paramId).value;
>                  persona.email = document.querySelector("#persona_email_" + paramId).value;
>                  let personaStringJSON = JSON.stringify(persona);
>                  let respuesta = await fetch("../PersonaServer",
>                          {method: 'PUT', body: personaStringJSON});
>                  let datotexto = JSON.parse(await respuesta.text());
>                  document.querySelector('#panelResultados').innerHTML = datotexto;
>              };
>              traer()
>                      .catch(ex => {
>                          document.querySelector("#panelMensajes").innerHTML = 'ERROR: ' + ex.message;
>                      });
>          }
>          static eliminar(paramId) {
>              const traer = async() => {
>                  let persona = {};
>                  persona.id = paramId;
>                  persona.nombre = document.querySelector("#persona_nombre_" + paramId).value;
>                  persona.email = document.querySelector("#persona_email_" + paramId).value;
>                  let personaStringJSON = JSON.stringify(persona);
>                  let respuesta = await fetch("../PersonaServer?&q=" + personaStringJSON,
>                          {method: 'DELETE'});
>                  let datotexto = JSON.parse(await respuesta.text());
>                  document.querySelector('#panelResultados').innerHTML = datotexto;
>              };
>              traer()
>                      .catch(ex => {
>                          document.querySelector("#panelMensajes").innerHTML = 'ERROR: ' + ex.message;
>                      });
>          }
>          static consultar() {
>              const traer = async() => {
>                  let respuesta = await fetch("../PersonaServer", {method: 'GET'});
>                  let personas = JSON.parse(await respuesta.text());
>                  let templatePersonas = await document.querySelector("#templatePersonasES6").innerHTML;
>                  document.querySelector('#panelResultados').innerHTML = await eval(templatePersonas);
>              };
>              traer()
>                      .catch(ex => {
>                          document.querySelector("#panelMensajes").innerHTML = 'ERROR: ' + ex.message;
>                      });
>          }
>      }
>      ///////////////////////////////////////// main() // Ejecucion Inicial Default
>      Persona.inicializar();
>      /////////////////////////////////////////
----- 
##  HTML.
-----

* HTML, structural html.
* FORM Input Button
* LINK css
* SCRIPT javascript

>        
        
----- 
>      <!DOCTYPE html>
>      <html>
>          <head>
>              <title>Contacto</title>
>              <meta charset="UTF-8">
>              <meta name="viewport" content="width=device-width, initial-scale=1.0">
>              <link href="css/estilo04.css" rel="stylesheet" id="elestilo"/>
>          </head>
>          <body>
>              <div>Contacto</div>
>              <section id="panelFiltro">
>                  <form action="" method="GET">
>                      <input type="text" name="persona_nombre" id="persona_nombre" maxlength="200" />
>                      <input type="email" name="persona_email" id="persona_email" maxlength="200" />
>                      <input type="button" id="btnInsertar" value="Insertar" />
>                      <input type="button" id="btnConsultar" value="Consultar" />
>                  </form>
>              </section>
>              <section id="panelResultados">
>      
>              </section>
>              <section id="panelMensajes">
>      
>              </section>
>      
>              <script type="text/template" id="templatePersonasES6">
>      `
>          <table>
>                  <tr><th>Nombre</th><th>Email</th><th>ID</th></tr>
>          ${ personas.map( persona => 
>          `
>                    <tr class='persona_item'>
>                        <td>${persona.id}</td>
>                        <td><input type='text' value='${persona.nombre}' id='persona_nombre_${persona.id}' /></td>
>                        <td><input type='email' value='${persona.email}' id='persona_email_${persona.id}' /></td>
>                        <td><input type='button' value='Modificar  ${persona.id}' onclick='Persona.actualizar(${persona.id});' /></td>
>                        <td><input type='button' value='Eliminar  ${persona.id}' onclick='Persona.eliminar(${persona.id});' /></td>
>                    </tr>
>          `
>              ).join('')
>            }
>          </table>
>      `            
>              </script>
>              <script src="js/persona04.js"></script>
>          </body>
>      </html>
----- 
##  CSS, minimal just to know where it fits.
-----

* CSS selectors to connect elements and style

>        

        
----- 
>      *{
>          margin:0px;
>          padding:0px;
>      }
>      body{
>          background-color: chocolate;
>      }
>      td{
>          background-color: salmon;
>          padding: 2px;
>      }
>      
>      .persona_item{
>          background-color: brown;
>          color: snow;
>          font-size: large;
>      }
>      #panelMensajes{
>          background-color: darkolivegreen;
>          color: white;
>          font-weight: bold;
>      }
----- 
##  Java. POJO ( Plain Old Java Object )
-----

* Simple base clase.
* Class Naming Conventions.
* attributes.
* methods.
* Encapsulation. ( getter and setters )
* Overriding. ( toString )

>        ejemploRest/Persona.java

##  Java. DB ( Database Connection Utility )
-----

* Utility to connect to database
* Encapsulating user, password, url

>        ejemploRest/DB.java

##  Java. DAO ( Data Access Object )
-----

* Here we translate Database Table to Java Objects

>        ejemploRest/PersonaDao.java

##  Java Rest ( Representational state transfer )
-----

* Java. Servlet, the simplest web HTTP  GET, POST, PUT, DELETE
* Over JSON as messages protocol
* HTTP method: GET    ( SQL alias SELECT )
* HTTP method: POST   ( SQL alias INSERT ) 
* HTTP method: PUT    ( SQL alias UPDATE )
* HTTP method: DELETE ( SQL alias DELETE )

>        ejemploRest/PersonaServer.java

        
----- 
>      package ejemploRest;
>      
>      import com.google.gson.Gson;
>      import java.io.*;
>      import java.sql.SQLException;
>      import java.util.ArrayList;
>      import javax.servlet.ServletException;
>      import javax.servlet.annotation.WebServlet;
>      import javax.servlet.http.*;
>      
>      /**
>       * Rest Explained
>       * https://en.wikipedia.org/wiki/Representational_state_transfer
>       */
>      @WebServlet(name = "PersonaServer", urlPatterns = {"/PersonaServer"})
>      public class PersonaServer extends HttpServlet {
>      
>          final static Gson CONVERTIR = new Gson();
>      
>          @Override
>          protected void doGet(HttpServletRequest request, HttpServletResponse response)
>                  throws ServletException, IOException {
>              response.setContentType("text/html;charset=UTF-8");
>              PrintWriter out = response.getWriter();
>              try {
>      
>                  String texto = request.getReader().readLine();
>                  ArrayList<Persona> listado = PersonaDao.getInstance().obtener();
>                  String resultado = CONVERTIR.toJson(listado);
>                  out.println("" + resultado);
>      
>              } catch (ClassNotFoundException ex) {
>                  out.println("Verificar:" + ex.getMessage());
>              } catch (SQLException ex) {
>                  out.println("Verificar:" + ex.getMessage());
>              } catch (Exception ex) {
>                  out.println("Verificar:" + ex.getMessage());
>              } finally {
>                  out.close();
>              }
>          }
>      
>          @Override
>          protected void doPost(HttpServletRequest request, HttpServletResponse response)
>                  throws ServletException, IOException {
>              response.setContentType("text/html;charset=UTF-8");
>              PrintWriter out = response.getWriter();
>              try {
>      
>                  String texto = request.getReader().readLine();
>      
>                  Persona personaParametro = CONVERTIR.fromJson(texto, Persona.class);
>                  personaParametro.validar();
>      
>                  PersonaDao.insertar(personaParametro);
>                  out.println(CONVERTIR.toJson("OK"));
>      
>              } catch (ClassNotFoundException ex) {
>                  out.println("Verificar: " + ex.getMessage());
>              } catch (SQLException ex) {
>                  out.println("Verificar:" + ex.getMessage());
>              } catch (Exception ex) {
>                  out.println("Verificar:" + ex.getMessage());
>              } finally {
>                  out.close();
>              }
>          }
>      
>          @Override
>          protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
>              response.setContentType("text/html;charset=UTF-8");
>              PrintWriter out = response.getWriter();
>              try {
>                  Persona personaParametro = CONVERTIR.fromJson(request.getReader(), Persona.class);
>                  PersonaDao.actualizar(personaParametro);
>                  out.println(CONVERTIR.toJson("OK"));
>              } catch (ClassNotFoundException ex) {
>                  out.println("Verificar:" + ex.getMessage());
>              } catch (SQLException ex) {
>                  out.println("Verificar:" + ex.getMessage());
>              } catch (Exception ex) {
>                  out.println("Verificar:" + ex.getMessage());
>              } finally {
>                  out.close();
>              }
>          }
>      
>          @Override
>          protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
>              response.setContentType("text/html;charset=UTF-8");
>              PrintWriter out = response.getWriter();
>              try {
>      
>                  Persona personaParametro = CONVERTIR.fromJson(request.getParameter("q"), Persona.class);
>      
>                  PersonaDao.borrar(personaParametro);
>                  out.println(CONVERTIR.toJson("OK"));
>      
>              } catch (ClassNotFoundException ex) {
>                  out.println("Verificar:" + ex.getMessage());
>              } catch (SQLException ex) {
>                  out.println("Verificar:" + ex.getMessage());
>              } catch (Exception ex) {
>                  out.println("Verificar:" + ex.getMessage());
>              } finally {
>                  out.close();
>              }
>          }
>      
>      }
----- 
>      package ejemploRest;
>      
>      import java.io.IOException;
>      import java.sql.*;
>      import java.util.ArrayList;
>      
>      /**
>       * Design Patterns Explained
>       * https://en.wikipedia.org/wiki/Software_design_pattern
>       */
>      public class PersonaDao {
>      
>          private PersonaDao() throws ClassNotFoundException,
>                  IOException, SQLException {
>          }
>          private static PersonaDao INSTANCE = null;
>      
>          public static PersonaDao getInstance() throws ClassNotFoundException,
>                  IOException, SQLException {
>              if (INSTANCE == null) {
>                  INSTANCE = new PersonaDao();
>              }
>              return INSTANCE;
>          }
>          private final static String SQL_PERSONAS_SELECT = "SELECT * FROM personas;";
>      
>          public ArrayList<Persona> obtener() throws ClassNotFoundException,
>                  IOException, SQLException {
>              ArrayList<Persona> lista = new ArrayList();
>              Connection c = null;
>              PreparedStatement ptsmt = null;
>              ResultSet rs = null;
>              try {
>                  c = DB.getInstance().getConnection();
>                  ptsmt = c.prepareStatement(SQL_PERSONAS_SELECT);
>                  rs = ptsmt.executeQuery();
>                  Persona a = null;
>                  while (rs.next()) {
>                      try {
>                          a = new Persona();
>                          a.setId(rs.getString("per_id"));
>                          a.setNombre(rs.getString("per_nombre"));
>                          a.setEmail(rs.getString("per_email"));
>                      } catch (Exception ex) {
>                          ex.printStackTrace();
>                      }
>                      lista.add(a);
>                  }
>              } finally {
>                  try {
>                      rs.close();
>                  } finally {
>                      try {
>                          ptsmt.close();
>                      } finally {
>                          c.close();
>                      }
>                  }
>              }
>              return lista;
>          }
>          private final static String SQL_PERSONAS_INSERT = "INSERT INTO personas (per_nombre,"
>                  + " per_email)values(?,?);";
>      
>          public static void insertar(Persona a)
>                  throws ClassNotFoundException,
>                  IOException, SQLException {
>              Connection c = null;
>              PreparedStatement ptsmt = null;
>              try {
>                  c = DB.getInstance().getConnection();
>                  ptsmt = c.prepareStatement(SQL_PERSONAS_INSERT);
>                  ptsmt.setString(1, a.getNombre());
>                  ptsmt.setString(2, a.getEmail());
>                  ptsmt.execute();
>              } finally {
>                  try {
>                      ptsmt.close();
>                  } finally {
>                      c.close();
>                  }
>              }
>          }
>          private final static String SQL_PERSONAS_UPDATE = "UPDATE personas "
>                  + " set per_nombre = ?, per_email = ? "
>                  + " WHERE per_id = ?;";
>      
>          public static void actualizar(Persona a) throws ClassNotFoundException,
>                  IOException, SQLException {
>              Connection c = null;
>              PreparedStatement ptsmt = null;
>              try {
>                  c = DB.getInstance().getConnection();
>                  ptsmt = c.prepareStatement(SQL_PERSONAS_UPDATE);
>                  ptsmt.setString(1, a.getNombre());
>                  ptsmt.setString(2, a.getEmail());
>                  ptsmt.setInt(3, Integer.parseInt(a.getId()));
>                  ptsmt.execute();
>              } finally {
>                  try {
>                      ptsmt.close();
>                  } finally {
>                      c.close();
>                  }
>              }
>          }
>          private final static String SQL_PERSONAS_DELETE = "DELETE FROM personas "
>                  + " WHERE per_id = ?;";
>      
>          public static void borrar(Persona a) throws ClassNotFoundException,
>                  IOException, SQLException {
>              Connection c = null;
>              PreparedStatement ptsmt = null;
>              try {
>                  c = DB.getInstance().getConnection();
>                  ptsmt = c.prepareStatement(SQL_PERSONAS_DELETE);
>                  ptsmt.setInt(1, Integer.parseInt(a.getId()));
>                  ptsmt.execute();
>              } finally {
>                  try {
>                      ptsmt.close();
>                  } finally {
>                      c.close();
>                  }
>              }
>          }
>          
>          
>          
>      //////////////////////////////////////
>              public static void main(String[] args) {
>              System.out.println("[ .. ]TestPersonaDao");
>              try {
>                  ArrayList<Persona> personas = PersonaDao.getInstance().obtener();
>                  for (Persona a : personas) {
>                      System.out.println(a);
>                  }
>              } catch (Exception ex) {
>                  ex.printStackTrace();
>              }
>              try {
>                  Persona a = new Persona();
>                  a.setNombre("Paturuzu");
>                  a.setEmail("paturuzu@gmail.com");
>                  PersonaDao.insertar(a);
>              } catch (Exception ex) {
>                  ex.printStackTrace();
>              }
>              System.out.println("[ OK ]TestPersonaDao");
>          }
>          
>          
>      }
----- 
>      package ejemploRest;
>      
>      /**
>      * Simple base class.
>      * Class Naming Conventions.
>      * attributes.
>      * methods.
>      * Encapsulation. ( getter and setters )
>      * Overriding. ( toString )
>      */
>      public class Persona {
>      
>          private String id;
>          private String nombre;
>          private String email;
>      
>          public String getId() {
>              return id;
>          }
>      
>          public void setId(String id) {
>              this.id = id;
>          }
>      
>          public String getNombre() {
>              return nombre;
>          }
>      
>          public void setNombre(String nombre) {
>              this.nombre = nombre;
>          }
>      
>          public String getEmail() {
>              return email;
>          }
>      
>          public void setEmail(String email) throws Exception {
>              if ( email.contains("@") ) {
>                  this.email = email;
>              } else {
>                  throw new Exception("Ponele Arroba al Email!!!!");
>              }
>      
>          }
>      
>          @Override
>          public String toString() {
>              return "Persona: " + nombre + " : " + email;
>          }
>          
>          public void validar() throws Exception{
>              this.setEmail( this.getEmail() );
>          }
>      
>      }
----- 
>      package ejemploRest;
>      
>      import java.io.IOException;
>      import java.sql.*;
>      
>      /**
>       * Design Patterns Explained
>       * https://en.wikipedia.org/wiki/Software_design_pattern
>       * 
>       * Singleton Design Patterns Explained
>       * https://en.wikipedia.org/wiki/Singleton_pattern
>       */
>      public class DB {
>      
>          private static DB INSTANCE = null;
>          private static String LABASE = "jdbc:mysql://localhost/dbrest";
>          private static String LABASEUSUARIO = "educacion";  // "root";
>          private static String LABASECLAVE = "educacion";    //"root";
>          public static DB getInstance() throws ClassNotFoundException, IOException, SQLException {
>              if (INSTANCE == null) {
>                  INSTANCE = new DB();
>              }
>              return INSTANCE;
>          }
>          private DB() throws ClassNotFoundException,
>                  IOException, SQLException {
>          }
>      
>          public Connection getConnection() throws ClassNotFoundException,
>                  IOException, SQLException {
>              Class.forName("com.mysql.jdbc.Driver");
>              return DriverManager.getConnection(LABASE, LABASEUSUARIO, LABASECLAVE);
>          }
>      
>      }
----- 
##  SQL CREATE INSERT.
-----

* Ejemplo Creando la base de datos.
* Ejemplo Insertando en la base de datos

>        sql/dbrest.sql
>        
----- 
>      CREATE DATABASE dbrest;
>      USE dbrest;
>      
>      -- --------------------------------------------------------
>      
>      --
>      -- Table structure for table 'personas'
>      --
>      
>      DROP TABLE IF EXISTS personas;
>      CREATE TABLE IF NOT EXISTS personas (
>        per_id int(11) NOT NULL AUTO_INCREMENT,
>        per_nombre varchar(250) NOT NULL,
>        per_email varchar(250) NOT NULL,
>        PRIMARY KEY (per_id)
>      ) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;
>      
>      --
>      -- Dumping data for table 'personas'
>      --
>      
>      INSERT INTO personas (per_nombre, per_email) VALUES
>      ('Julieta', 'juli@gmail'),
>      ('Marcelo', 'marce@gmail'),
>      ('Victoria', 'vicky@gmail'),
>      ('Felix', 'felix@gmail'),
>      ('Pedro', 'peter@gmail'),
>      ('Carlos', 'carlitos@gmail'),
>      ('Simona', 'simo@gmail');
>      
----- 
##  Export, Utilitario, Herramienta.
-----

* Ejemplo java exportar los archivos README.md
* Ejemplo java exportar el codigo fuente.

>        util.Readme.java
>        
----- 
>      package util;
>      import java.io.*;
>      import java.util.logging.Level;
>      import java.util.logging.Logger;
>      /**
>       * @author maximilianou@gmail.com
>       */
>      public class Readme {
>          String salida = "README.md";
>          String salidaFILE = "../README.md";
>          String[] archivos = {
>              "web/ejemploRest/js/README.md",
>              "web/ejemploRest/js/persona04.js",
>              "web/ejemploRest/README.md",
>              "web/ejemploRest/persona04.html",
>              "web/ejemploRest/css/README.md",
>              "web/ejemploRest/css/estilo04.css",
>              "src/java/ejemploRest/README.md",
>              "src/java/ejemploRest/PersonaServer.java",
>              "src/java/ejemploRest/PersonaDao.java",
>              "src/java/ejemploRest/Persona.java",
>              "src/java/ejemploRest/DB.java",
>              "src/java/sql/README.md",
>              "src/java/sql/dbrest.sql",
>              "src/java/util/README.md",
>              "src/java/util/Readme.java",
>              "src/java/license/README.md"
>          };
>          FileWriter arch = null;
>          BufferedWriter barch = null;
>          public void inicializar() throws IOException {
>              File fs = new File(salidaFILE);
>              fs.delete();
>              arch = new FileWriter(salidaFILE, true);
>              barch = new BufferedWriter(arch);
>          }
>          public void exportar() {
>              for (String s : archivos) {
>                  String p = "";
>                  if (!s.endsWith(salida)) {
>                      p = ">      ";
>                  }
>                  try {
>                      exportar(s, p);
>                  } catch (Exception ex) {
>                      Logger.getLogger(Readme.class.getName()).log(Level.SEVERE, null, ex);
>                      System.out.println("[ERROR]Readme " + ex.getMessage() + s);
>      
>                  }
>              }
>              try {
>                  barch.close();
>              } catch (IOException ex) {
>                  Logger.getLogger(Readme.class.getName()).log(Level.SEVERE, null, ex);
>              }
>              try {
>                  arch.close();
>              } catch (IOException ex) {
>                  Logger.getLogger(Readme.class.getName()).log(Level.SEVERE, null, ex);
>              }
>          }
>          public void exportar(String archName, String pref) throws FileNotFoundException, IOException {
>              FileReader in = new FileReader(archName);
>              BufferedReader bin = new BufferedReader(in);
>              while (bin.ready()) {
>                  barch.write(pref + bin.readLine());
>                  barch.newLine();
>              }
>              barch.write("----- ");
>              barch.newLine();
>          }
>          public static void main(String[] args) {
>              System.out.println("[..]Readme");
>              Readme r = new Readme();
>              try {
>                  r.inicializar();
>                  r.exportar();
>              } catch (IOException ex) {
>                  Logger.getLogger(Readme.class.getName()).log(Level.SEVERE, null, ex);
>                  System.out.println("[ERROR]Readme");
>              }
>              System.out.println("[ok]Readme");
>          }
>      }
----- 
-----

## The MIT License

Copyright (c) 2009 - 2018 Maximiliano Usich maximilianou@gmail.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the 'Software'), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

----- 
