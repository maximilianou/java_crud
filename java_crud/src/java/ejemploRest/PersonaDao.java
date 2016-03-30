package ejemploRest;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class PersonaDao {

    private PersonaDao() throws ClassNotFoundException,
            IOException, SQLException {
    }
    private static PersonaDao INSTANCE = null;

    public static PersonaDao getInstance() throws ClassNotFoundException,
            IOException, SQLException {
        if (INSTANCE == null) {
            INSTANCE = new PersonaDao();
        }
        return INSTANCE;
    }
    private final static String SQL_PERSONAS_SELECT = "SELECT * FROM personas;";

    public ArrayList<Persona> obtener() throws ClassNotFoundException,
            IOException, SQLException {
        ArrayList<Persona> lista = new ArrayList();
        Connection c = null;
        PreparedStatement ptsmt = null;
        ResultSet rs = null;
        try {
            c = DB.getInstance().getConnection();
            ptsmt = c.prepareStatement(SQL_PERSONAS_SELECT);
            rs = ptsmt.executeQuery();
            Persona a = null;
            while (rs.next()) {
                try {
                    a = new Persona();
                    a.setId(rs.getString("per_id"));
                    a.setNombre(rs.getString("per_nombre"));
                    a.setEmail(rs.getString("per_email"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                lista.add(a);
            }
        } finally {
            try {
                rs.close();
            } finally {
                try {
                    ptsmt.close();
                } finally {
                    c.close();
                }
            }
        }
        return lista;
    }
    private final static String SQL_PERSONAS_INSERT = "INSERT INTO personas (per_nombre,"
            + " per_email)values(?,?);";

    public static void insertar(Persona a)
            throws ClassNotFoundException,
            IOException, SQLException {
        Connection c = null;
        PreparedStatement ptsmt = null;
        try {
            c = DB.getInstance().getConnection();
            ptsmt = c.prepareStatement(SQL_PERSONAS_INSERT);
            ptsmt.setString(1, a.getNombre());
            ptsmt.setString(2, a.getEmail());
            ptsmt.execute();
        } finally {
            try {
                ptsmt.close();
            } finally {
                c.close();
            }
        }
    }
    private final static String SQL_PERSONAS_UPDATE = "UPDATE personas "
            + " set per_nombre = ?, per_email = ? "
            + " WHERE per_id = ?;";

    public static void actualizar(Persona a) throws ClassNotFoundException,
            IOException, SQLException {
        Connection c = null;
        PreparedStatement ptsmt = null;
        try {
            c = DB.getInstance().getConnection();
            ptsmt = c.prepareStatement(SQL_PERSONAS_UPDATE);
            ptsmt.setString(1, a.getNombre());
            ptsmt.setString(2, a.getEmail());
            ptsmt.setInt(3, Integer.parseInt(a.getId()));
            ptsmt.execute();
        } finally {
            try {
                ptsmt.close();
            } finally {
                c.close();
            }
        }
    }
    private final static String SQL_PERSONAS_DELETE = "DELETE FROM personas "
            + " WHERE per_id = ?;";

    public static void borrar(Persona a) throws ClassNotFoundException,
            IOException, SQLException {
        Connection c = null;
        PreparedStatement ptsmt = null;
        try {
            c = DB.getInstance().getConnection();
            ptsmt = c.prepareStatement(SQL_PERSONAS_DELETE);
            ptsmt.setInt(1, Integer.parseInt(a.getId()));
            ptsmt.execute();
        } finally {
            try {
                ptsmt.close();
            } finally {
                c.close();
            }
        }
    }
    
    
    
//////////////////////////////////////
        public static void main(String[] args) {
        System.out.println("[ .. ]TestPersonaDao");
        try {
            ArrayList<Persona> personas = PersonaDao.getInstance().obtener();
            for (Persona a : personas) {
                System.out.println(a);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            Persona a = new Persona();
            a.setNombre("Enzo");
            a.setEmail("Enzo@gmail.com");
            PersonaDao.insertar(a);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("[ OK ]TestPersonaDao");
    }
    
    
}
