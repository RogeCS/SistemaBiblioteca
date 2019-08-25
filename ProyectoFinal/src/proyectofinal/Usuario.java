package proyectofinal;

/**
 *
 * @author User
 */
public class Usuario{
    public String nombre, apellido;
    public int iD; //5 caracterres numéricos
    public int deuda;
    public boolean deudor;

    public Usuario(String nombre, String apellido, int iD) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.iD = iD;
        deuda = 0;
    }
    
    public void multar(){
        
    }
  
}
