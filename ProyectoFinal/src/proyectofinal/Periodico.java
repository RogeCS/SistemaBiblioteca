package proyectofinal;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Periodico extends Documento{
    public String nombrePeriodico;
    public double ingreso;
    public static final double PRECIO = 25;
    public int ventaDePeriodicos;
    public int periodicosEnAlmacen = 20;

    public Periodico(int identificador, String titulo, String autorNombre, String autorApellido, 
            int anioPublicacion, int numPaginas, String idioma, String 
            nombrePeriodico) {
        super(identificador, titulo, autorNombre, autorApellido, anioPublicacion, numPaginas, 
            idioma);
        this.nombrePeriodico = nombrePeriodico;
    }

    public void vender(int numPeriodicos) {
        if(numPeriodicos <= periodicosEnAlmacen){
            JOptionPane.showMessageDialog(null, "¡Se vendió exitosamente!");
            ventaDePeriodicos += PRECIO * numPeriodicos;
            periodicosEnAlmacen -= numPeriodicos;
        }else{
            JOptionPane.showMessageDialog(null, "No hay suficientes periódicos"
                    + "en almacén. Sólo quedan " + periodicosEnAlmacen + ".");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", " + "periódico: " + nombrePeriodico;
    }   
    
}
