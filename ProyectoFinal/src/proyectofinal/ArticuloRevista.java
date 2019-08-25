package proyectofinal;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ArticuloRevista extends Documento implements LecturaEnLinea{
    public String nombreRevista;
    public int volumen, numeroRevista, numero;

    public ArticuloRevista(int identificador, String titulo, String autorNombre, String 
            autorApellido, int anioPublicacion, int numPaginas, String idioma, 
            String nombreRevista, int volumen, int numeroRevista) {
        super(identificador, titulo, autorNombre, autorApellido, anioPublicacion, 
            numPaginas, idioma);
        this.nombreRevista = nombreRevista;
        this.volumen = volumen;
        this.numeroRevista = numeroRevista;    }

    @Override
    public void descargar() {
        JOptionPane.showMessageDialog(null, "¡Revista, con identificador " + getIdentificador() +", descargada exitosamente!");
    }

    @Override
    public String toString() {
        return super.toString() + ", " + nombreRevista + ", " + volumen + ", " +
               numeroRevista;
    }
    
}
