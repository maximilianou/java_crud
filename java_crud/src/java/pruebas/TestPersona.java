package pruebas;

import ejemploRest.Persona;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestPersona {
    
    public static void main(String [] args){
        System.out.println("Test::Persona:: [  ]");
        Persona mik = null;
        System.out.println("Test::Persona:: "+mik);
        mik = new Persona();
        System.out.println("Test::Persona:: "+mik);
        Persona juancito = new Persona();
        System.out.println("Test::Persona:: "+juancito);
        try {
            mik.setEmail("miguelito@gg");
            System.out.println("Caso @ OK: [OK] ");
        } catch (Exception ex) {
            System.out.println("Caso @ OK: [ERROR]");
        }
        System.out.println("Test::Persona:: "+mik);
        try {
            mik.setEmail("javier");
            System.out.println("Caso @ ERROR: [ERROR]");
        } catch (Exception ex) {
            System.out.println("Caso @ ERROR: [OK] : El mail debe tener un Arroba!! " + ex.getMessage());
            
        }
        System.out.println("Test::Persona:: "+mik);
        
        
        System.out.println("Test::Persona:: [OK]");
    }
    
}
