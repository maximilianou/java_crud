package pruebas;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestErrores {

    public static void main(String[] args) {
        System.out.println("Testing Error ...");

        try {
            
            System.out.println("Previo");
            URL laurl = new URL("http://ifts16.com.ar");
            System.out.println("Luego");
            
        } catch (MalformedURLException ex) {
            System.out.println("Capture el Error, Sorry Gordoo!");
            //ex.printStackTrace();
        }

        System.out.println("Testing Error OK!");
    }
}
