package proyectofinal;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Libro extends Documento implements LecturaEnLinea{
    
    public String lugarDePublicacion, editorial, genero;
    public boolean disponible;

    public Libro(int identificador,String titulo, String autorNombre, String autorApellido, 
            int anioPublicacion, int numPaginas, String idioma,
            String lugarDePublicacion, String editorial, String genero){
        super(identificador, titulo, autorNombre, autorApellido, anioPublicacion, numPaginas, 
            idioma);
        this.lugarDePublicacion = lugarDePublicacion;
        this.editorial = editorial;
        this.genero = genero;
        disponible = true;
    }    
    
    @Override
    public void descargar() {
        JOptionPane.showMessageDialog(null, "¡Libro, con identificador " + getIdentificador() + ", descargado exitosamente!");
    }


    @Override
    public String toString() {
        return super.toString() + ", " + lugarDePublicacion + ", " + editorial + ", " + genero + ", " + disponible;
    } 
    
}
