package ejemploRest;

public class Persona {

    private String id;
    private String nombre;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if ( email.contains("@") ) {
            this.email = email;
        } else {
            throw new Exception("Ponele Arroba al Email!!!!");
        }

    }

    @Override
    public String toString() {
        return "Persona: " + nombre + " : " + email;
    }
    
    public void validar() throws Exception{
        this.setEmail( this.getEmail() );
    }

}
