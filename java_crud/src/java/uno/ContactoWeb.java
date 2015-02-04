package uno;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ContactoWeb", urlPatterns = {"/uno/Contacto"})
public class ContactoWeb extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HashMap diccionario = new HashMap();

            String valor = request.getHeader("User-Agent");
            diccionario.put("User-Agent", valor);
            diccionario.put("Referer", request.getHeader("Referer"));
            
            

            Gson gson = new Gson();

            String textoRespuesta = gson.toJson( diccionario );
            
            out.println( textoRespuesta );
            
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("NADA POR METODO HTTP POST");
        }

    }

}
