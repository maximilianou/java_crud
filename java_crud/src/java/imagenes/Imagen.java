package imagenes;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Imagen", urlPatterns = {"/Imagen"})
public class Imagen extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setHeader("expires", "0");
        //response.setContentType("image/jpg");

        Connection conn = null;
        //TODO: Ejemplo de crud de imagenes basico.
        //TODO: Ejemplo de crud de imagenes basico.
        //TODO: Ejemplo de crud de imagenes basico.
        //TODO: Ejemplo de crud de imagenes basico.
//        try {
//            conn = ConexionDB.getInstance().getConnection();
//            String consulta = "select pro_img from productos where pro_id = ?;";
//            PreparedStatement statement = conn.prepareStatement(consulta);
//
//            statement.setString(1, request.getParameter("id"));
//            System.out.println("!!!" + request.getParameter("id") + "!!!");
//
//            ResultSet resultado = statement.executeQuery();
//            System.out.println("!!!" + request.getParameter("id") + "!!!");
//
//            if (resultado.next()) {
//                //extrae datos byte del resulset
//                byte[] datosImagen = resultado.getBytes("pro_img");
//
//                OutputStream os = response.getOutputStream();
//                os.write(datosImagen);
//                os.flush();
//                os.close();
////                
//            } else {
//                response.getWriter().print("UUUUUU");
//
//            }
//        }
    }
}
