package ejemploRest;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        try (PrintWriter out = response.getWriter()) {
            try {

                BufferedReader buff_entrada = new BufferedReader(
                        new InputStreamReader(request.getInputStream()));
                String texto = buff_entrada.readLine();
                ArrayList<Persona> listado = PersonaDao.getInstance().obtener();
                Gson convertir = new Gson();
                String resultado = convertir.toJson(listado);
                out.println("" + resultado);

            } catch (ClassNotFoundException ex) {
                out.println("" + ex.getMessage());
            } catch (SQLException ex) {
                out.println("" + ex.getMessage());
            } finally {
                out.close();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {

                Gson convertir = new Gson();
                BufferedReader buff_entrada = new BufferedReader(
                        new InputStreamReader(request.getInputStream()));
                String texto = buff_entrada.readLine();
                Persona personaParametro = convertir.fromJson(texto, Persona.class);
                PersonaDao.insertar(personaParametro);
                out.println( convertir.toJson("OK") );

            } catch (ClassNotFoundException ex) {
                out.println("" + ex.getMessage());
            } catch (SQLException ex) {
                out.println("" + ex.getMessage());
            } finally {
                out.close();
            }
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            BufferedReader buff_entrada = new BufferedReader(
                    new InputStreamReader(request.getInputStream()));
            String texto = buff_entrada.readLine();
            System.out.println(texto);
            System.err.println(texto);
            /* TODO: Falta hacer .. */

            out.println("" + texto);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            BufferedReader buff_entrada = new BufferedReader(
                    new InputStreamReader(request.getInputStream()));
            String texto = buff_entrada.readLine();
            System.out.println(texto);
            System.err.println(texto);

            /* TODO: Falta hacer .. */
            out.println("" + texto);
        }
    }

}
