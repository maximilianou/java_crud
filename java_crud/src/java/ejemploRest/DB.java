package ejemploRest;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.*;
import org.hsqldb.server.Server;
import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.ServerAcl;

public class DB {

    private static DB INSTANCE = null;
    private static String LABASE = "file:"+System.getProperty("user.home")+"/personas.hsqldb";
    public static DB getInstance() throws ClassNotFoundException, IOException, SQLException {
        if (INSTANCE == null) {
            INSTANCE = new DB();
        }
        return INSTANCE;
    }

    private DB() throws ClassNotFoundException,
            IOException, SQLException {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            HsqlProperties p = new HsqlProperties();
            p.setProperty("server.database.0", LABASE);
            p.setProperty("server.dbname.0", "personas");
            PrintWriter salidaINFO = new PrintWriter(
                    new OutputStreamWriter(System.out));
            PrintWriter salidaERR = new PrintWriter(
                    new OutputStreamWriter(System.err));
            Server server = new Server();
            server.setProperties(p);
            server.setLogWriter(salidaINFO);
            server.setErrWriter(salidaERR);
            server.start();
        } catch (ServerAcl.AclFormatException e) {
            throw new SQLException("Acceso denegado:" + e.getMessage());
        }
    }

    public Connection getConnection() throws ClassNotFoundException,
            IOException, SQLException {
        DB.getInstance();
        return DriverManager.getConnection("jdbc:hsqldb:"+LABASE, "SA", "");
    }

    public void shutdown() throws ClassNotFoundException,
            IOException, SQLException {
        Connection c = null;
        PreparedStatement pstmt = null;
        try {
            c = getConnection();
            pstmt = c.prepareStatement("SHUTDOWN;");
            pstmt.execute();
            pstmt.close();
        } finally {
            try {
                pstmt.close();
            } finally {
                c.close();
            }
        }
    }
}
