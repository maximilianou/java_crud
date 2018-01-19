package ejemploRest;

import com.google.gson.Gson;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Rest Explained
 * https://en.wikipedia.org/wiki/Representational_state_transfer
 */
@WebServlet(name = "PersonaServer", urlPatterns = {"/PersonaServer"})
public class PersonaServer extends HttpServlet {

    final static Gson CONVERTIR = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String texto = request.getReader().readLine();
            ArrayList<Persona> listado = PersonaDao.getInstance().obtener();
            String resultado = CONVERTIR.toJson(listado);
            out.println("" + resultado);

        } catch (ClassNotFoundException ex) {
            out.println("Verificar:" + ex.getMessage());
        } catch (SQLException ex) {
            out.println("Verificar:" + ex.getMessage());
        } catch (Exception ex) {
            out.println("Verificar:" + ex.getMessage());
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

            String texto = request.getReader().readLine();

            Persona personaParametro = CONVERTIR.fromJson(texto, Persona.class);
            personaParametro.validar();

            PersonaDao.insertar(personaParametro);
            out.println(CONVERTIR.toJson("OK"));

        } catch (ClassNotFoundException ex) {
            out.println("Verificar: " + ex.getMessage());
        } catch (SQLException ex) {
            out.println("Verificar:" + ex.getMessage());
        } catch (Exception ex) {
            out.println("Verificar:" + ex.getMessage());
        } finally {
            out.close();
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Persona personaParametro = CONVERTIR.fromJson(request.getReader(), Persona.class);
            PersonaDao.actualizar(personaParametro);
            out.println(CONVERTIR.toJson("OK"));
        } catch (ClassNotFoundException ex) {
            out.println("Verificar:" + ex.getMessage());
        } catch (SQLException ex) {
            out.println("Verificar:" + ex.getMessage());
        } catch (Exception ex) {
            out.println("Verificar:" + ex.getMessage());
        } finally {
            out.close();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            Persona personaParametro = CONVERTIR.fromJson(request.getParameter("q"), Persona.class);

            PersonaDao.borrar(personaParametro);
            out.println(CONVERTIR.toJson("OK"));

        } catch (ClassNotFoundException ex) {
            out.println("Verificar:" + ex.getMessage());
        } catch (SQLException ex) {
            out.println("Verificar:" + ex.getMessage());
        } catch (Exception ex) {
            out.println("Verificar:" + ex.getMessage());
        } finally {
            out.close();
        }
    }

}
