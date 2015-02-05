/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno02;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.buf.UDecoder;

/**
 *
 * @author maximilianou
 */
@WebServlet(name = "uno02.ContactoWeb", urlPatterns = {"/uno02/Contacto"})
public class ContactoWeb extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        try {

            String str = request.getParameter("msg_json");

            str = gson.fromJson(str, String.class);
            HashMap diccionario = gson.fromJson(str, HashMap.class);

            String textoRespuesta = gson.toJson(diccionario);

            textoRespuesta = gson.toJson(textoRespuesta);

            out.println(textoRespuesta);

        } catch (Exception e) {
            out.println(gson.toJson("Error: " + e.getMessage()));
        } finally {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        try {

            String str = request.getParameter("msg_json");

            str = gson.fromJson(str, String.class);
            HashMap diccionario = gson.fromJson(str, HashMap.class);

            String textoRespuesta = gson.toJson(diccionario);

            textoRespuesta = gson.toJson(textoRespuesta);

            out.println(textoRespuesta);

        } catch (Exception e) {
            out.println(gson.toJson("Error: " + e.getMessage()));
        } finally {
            out.close();
        }
    }

}
