package util;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author maximilianou@gmail.com
 */
public class Readme {
    String salida = "README.md";
    String salidaFILE = "../README.md";
    String[] archivos = {
        "web/ejemploRest/README.md",
        "web/ejemploRest/persona03.html",
        "web/ejemploRest/css/README.md",
        "web/ejemploRest/css/estilo.css",
        "web/ejemploRest/js/README.md",
        "web/ejemploRest/js/persona03.js",
        "src/java/sql/README.md",
        "src/java/sql/dbrest.sql",
        "src/java/ejemploRest/README.md",
        "src/java/ejemploRest/Persona.java",
        "src/java/ejemploRest/DB.java",
        "src/java/ejemploRest/PersonaDao.java",
        "src/java/ejemploRest/PersonaServer.java",
        "src/java/util/README.md",
        "src/java/util/Readme.java",
        "src/java/license/README.md"
    };
    FileWriter arch = null;
    BufferedWriter barch = null;
    public void inicializar() throws IOException {
        File fs = new File(salidaFILE);
        fs.delete();
        arch = new FileWriter(salidaFILE, true);
        barch = new BufferedWriter(arch);
    }
    public void exportar() {
        for (String s : archivos) {
            String p = "";
            if (!s.endsWith(salida)) {
                p = ">      ";
            }
            try {
                exportar(s, p);
            } catch (Exception ex) {
                Logger.getLogger(Readme.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("[ERROR]Readme " + ex.getMessage() + s);

            }
        }
        try {
            barch.close();
        } catch (IOException ex) {
            Logger.getLogger(Readme.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            arch.close();
        } catch (IOException ex) {
            Logger.getLogger(Readme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void exportar(String archName, String pref) throws FileNotFoundException, IOException {
        FileReader in = new FileReader(archName);
        BufferedReader bin = new BufferedReader(in);
        while (bin.ready()) {
            barch.write(pref + bin.readLine());
            barch.newLine();
        }
        barch.write("----- ");
        barch.newLine();
    }
    public static void main(String[] args) {
        System.out.println("[..]Readme");
        Readme r = new Readme();
        try {
            r.inicializar();
            r.exportar();
        } catch (IOException ex) {
            Logger.getLogger(Readme.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("[ERROR]Readme");
        }
        System.out.println("[ok]Readme");
    }
}
