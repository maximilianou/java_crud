package ejemploRest;

import java.io.IOException;
import java.sql.*;

/**
 * Design Patterns Explained
 * https://en.wikipedia.org/wiki/Software_design_pattern
 * 
 * Singleton Design Patterns Explained
 * https://en.wikipedia.org/wiki/Singleton_pattern
 */
public class DB {

    private static DB INSTANCE = null;
    private static String LABASE = "jdbc:mysql://localhost/dbrest";
    private static String LABASEUSUARIO = "educacion";  // "root";
    private static String LABASECLAVE = "educacion";    //"root";
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
