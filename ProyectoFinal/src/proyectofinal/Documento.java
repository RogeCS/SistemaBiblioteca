package proyectofinal;

/**
 *
 * @author Víctor y Rosherrr
 */
public abstract class Documento {
    protected String titulo, autorNombre, autorApellido;
    protected int anioPublicacion, numPaginas;
    protected String idioma;
    protected int identificador;
    

    public Documento(int identificador, String titulo, String autorNombre, String autorApellido, 
            int anioPublicacion, int numPaginas, String idioma) {
        this.titulo = titulo;
        this.autorNombre = autorNombre;
        this.autorApellido = autorApellido;
        this.anioPublicacion = anioPublicacion;
        this.numPaginas = numPaginas;
        this.idioma = idioma;
        this.identificador = identificador;
    }

    @Override
    public String toString() {
        return identificador + ", " + titulo + ", "+ autorNombre + ", " + autorApellido + ", " +  anioPublicacion + ", " +  numPaginas + ", " + idioma;
    }
    
    public int getIdentificador(){
        return identificador;
    }
    
}
