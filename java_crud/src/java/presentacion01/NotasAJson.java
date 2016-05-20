package presentacion01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.*;
import com.google.gson.*;

@WebServlet(name = "NotasAJson", 
        urlPatterns = {"/presentacion01/NotasAJson"})
public class NotasAJson extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Gson convertir = new Gson();
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conexion = DriverManager
                    .getConnection("jdbc:mysql://localhost/db1", "root", "root");
            PreparedStatement sentencia = conexion.prepareStatement(" SELECT * FROM notas ");
            ResultSet resultado = sentencia.executeQuery();
            ArrayList<TreeMap> listado = new ArrayList();
            while (resultado.next()) {
                TreeMap<String, String> notaActual = new TreeMap();
                notaActual.put("not_id", resultado.getString("not_id"));
                notaActual.put("not_titulo", resultado.getString("not_titulo"));
                listado.add(notaActual);
            }
            out.print(convertir.toJson(listado));

        } catch (Exception e) {

            out.print(convertir.toJson(e.getMessage()));
            e.printStackTrace();
        }

    }

}
