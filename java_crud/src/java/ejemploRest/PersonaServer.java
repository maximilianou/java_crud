package ejemploRest;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;        

@WebServlet(name = "PersonaServer", urlPatterns = {"/PersonaServer"})
public class PersonaServer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            String texto = request.getReader().readLine();
            ArrayList<Persona> listado = PersonaDao.getInstance().obtener();
            Gson convertir = new Gson();
            String resultado = convertir.toJson(listado);
            out.println("" + resultado);

        } catch (ClassNotFoundException ex) {
            out.println("" + ex.getMessage());
        } catch (SQLException ex) {
            out.println("" + ex.getMessage());
        } catch (Exception ex) {
            out.println("" + ex.getMessage());
        } finally {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            Gson convertir = new Gson();
            String texto = request.getReader().readLine();
            
            Persona personaParametro = convertir.fromJson(texto, Persona.class);
            personaParametro.validar();
            
            PersonaDao.insertar(personaParametro);
            out.println(convertir.toJson("OK"));

        } catch (ClassNotFoundException ex) {
            out.println("" + ex.getMessage());
        } catch (SQLException ex) {
            out.println("" + ex.getMessage());
        } catch (Exception ex) {
            out.println("" + ex.getMessage());
        } finally {
            out.close();
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Gson convertir = new Gson();
            Persona personaParametro = convertir.fromJson(request.getReader(), Persona.class);
            PersonaDao.actualizar(personaParametro);
            out.println(convertir.toJson("OK"));
        } catch (ClassNotFoundException ex) {
            out.println("" + ex.getMessage());
        } catch (SQLException ex) {
            out.println("" + ex.getMessage());
        } catch (Exception ex) {
            out.println("" + ex.getMessage());
        } finally {
            out.close();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            Gson convertir = new Gson();
            
            Persona personaParametro = convertir.fromJson(request.getParameter("q"), Persona.class);
            
            PersonaDao.borrar(personaParametro);
            out.println(convertir.toJson("OK"));

        } catch (ClassNotFoundException ex) {
            out.println("" + ex.getMessage());
        } catch (SQLException ex) {
            out.println("" + ex.getMessage());
        } catch (Exception ex) {
            out.println("" + ex.getMessage());
        } finally {
            out.close();
        }
    }

}
