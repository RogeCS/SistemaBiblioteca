package proyectofinal;

/**
 *
 * @author User
 */
public class Tesis extends Documento{
    public String lugarDePublicacion, grado, universidad, campo;
    public boolean disponible;

    public Tesis(int identificador, String titulo, String autorNombre, String autorApellido, int 
            anioPublicacion, int numPaginas, String idioma, String 
            lugarDePublicacion, String grado, String universidad, String campo){
        super(identificador, titulo, autorNombre, autorApellido, anioPublicacion, numPaginas, 
            idioma);
        this.lugarDePublicacion = lugarDePublicacion;
        this.grado = grado;
        this.universidad = universidad;
        this.campo = campo;
        disponible = true;
    }


    @Override
    public String toString() {
        return super.toString() + ", " + lugarDePublicacion + ", " + 
               universidad + ", "+ grado 
                + ", " + campo;
    }       
    
}
