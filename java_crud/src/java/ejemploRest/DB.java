package ejemploRest;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.*;

public class DB {

    private static DB INSTANCE = null;
    //private static String LABASE = "jdbc:hsqldb:file:"+System.getProperty("user.home")+"/personas.hsqldb";
    private static String LABASE = "jdbc:mysql://localhost/dbrest";
    private static String LABASEUSUARIO = "root";  // "root";
    private static String LABASECLAVE = "";    //"root";
    public static DB getInstance() throws ClassNotFoundException, IOException, SQLException {
        if (INSTANCE == null) {
            INSTANCE = new DB();
        }
        return INSTANCE;
    }
    private DB() throws ClassNotFoundException,
            IOException, SQLException {
    }

    public Connection getConnection() throws ClassNotFoundException,
            IOException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(LABASE, LABASEUSUARIO, LABASECLAVE);
    }

}
