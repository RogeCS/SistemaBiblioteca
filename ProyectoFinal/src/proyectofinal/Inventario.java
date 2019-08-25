package proyectofinal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Inventario {
    static ArrayList<Documento>inventario;

    public Inventario() {
        inventario = new ArrayList<>();
    }

    public static ArrayList<Documento> getInventario() {
        return inventario;
    }
    
    public static void setInventario() throws IOException{
        BufferedReader libros = new BufferedReader(new FileReader("libros.txt"));
        BufferedReader tesis = new BufferedReader(new FileReader("tesis.txt"));
        BufferedReader revistas = new BufferedReader(new FileReader("revistas.txt"));
        
        int identificador = 0;
        int anio = 0;
        int numPaginas = 0;
    
        String titulo = "";
        String autorNombre= "";
        String autorApellido= "";
        String idioma= "";
        
        String lugarDePublicacion= "";
        String editorial= "";
        String genero= "";
        
        String grado= "";
        String universidad= "";
        String campo= "";
        
        String nombreRevista= "";
        int volumen= 0;
        int numeroRevista= 0;
       
        while ( libros.ready() ) {
            
            String a = libros.readLine();
            String b = a.replace(" ", "");
            String[] c = b.split(",");
            //System.out.println(Arrays.toString(c));
            
            identificador = Integer.parseInt(c[0]);
            titulo = c[1];
            autorNombre = c[2];
            autorApellido = c[3];
            anio = Integer.parseInt(c[4]);
            numPaginas = Integer.parseInt(c[5]);
            idioma = c[6];
            lugarDePublicacion = c[7];
            editorial = c[8];
            genero = c[9];
            
            
            Libro l = new Libro(identificador,titulo,autorNombre,autorApellido,anio,numPaginas,idioma, lugarDePublicacion, editorial, genero);
            Inventario.aniadirSilencioso(l);
        }
        libros.close();
        
        while ( tesis.ready() ) {
            
            
            String a = tesis.readLine();
            String b = a.replace(" ", "");
            String[] c = b.split(",");
            
            identificador = Integer.parseInt(c[0]);
            titulo = c[1];
            autorNombre = c[2];
            autorApellido = c[3];
            anio = Integer.parseInt(c[4]);
            numPaginas = Integer.parseInt(c[5]);
            idioma = c[6];
            lugarDePublicacion = c[7];
            grado = c[8];
            universidad = c[9];
            campo = c[10];
            
            Tesis t = new Tesis(identificador,titulo,autorNombre,autorApellido,anio,numPaginas,idioma, lugarDePublicacion, grado, universidad, campo);
            Inventario.aniadirSilencioso(t);
        }
        tesis.close();
        
        while ( revistas.ready() ) {
            
            
            String a = revistas.readLine();
            String b = a.replace(" ", "");
            String[] c = b.split(",");
            
            identificador = Integer.parseInt(c[0]);
            titulo = c[1];
            autorNombre = c[2];
            autorApellido = c[3];
            anio = Integer.parseInt(c[4]);
            numPaginas = Integer.parseInt(c[5]);
            idioma = c[6];
            nombreRevista = c[7];
            volumen = Integer.parseInt(c[8]);
            numeroRevista = Integer.parseInt(c[9]);
            
            ArticuloRevista r = new ArticuloRevista(identificador,titulo,autorNombre,autorApellido,anio,numPaginas,idioma, nombreRevista, volumen, numeroRevista);
            Inventario.aniadirSilencioso(r);
        }
        revistas.close();
                    
    }
    
    public static void aniadir(Documento doc){
        boolean exists = false;
        for(Documento d : inventario){
            if(d.getIdentificador()==doc.getIdentificador()){
                exists = true;
                JOptionPane.showMessageDialog(null, "¡Este número"
                        + "identificador ya existe!");
                break;
            }
        }
        if(exists == false){
            inventario.add(doc);
            JOptionPane.showMessageDialog(null, "Documento añadido"
                    + " correctamente");
        }
    }
    
    public static void aniadirSilencioso(Documento doc){
        boolean exists = false;
        for(Documento d : inventario){
            if(d.getIdentificador()==doc.getIdentificador()){
                exists = true;
                break;
            }
        }
        if(exists == false){
            inventario.add(doc);
        }
    }
    
    public static void eliminar(int identificador){
        boolean exists = false;
        for(Documento d : inventario){
            if(d.getIdentificador() == identificador){
                exists = true;
                int respuesta = JOptionPane.showConfirmDialog(null, "Estás a punto de eliminar un elemento. ¿Deseas continuar?");
                if(respuesta == 0){
                    inventario.remove(d);
                JOptionPane.showMessageDialog(null, "Documento eliminado "
                        + "correctamente");
                }
                break;
            }
        }
        if(exists == false){
            JOptionPane.showMessageDialog(null, "no existe un documento con el "
                    + " numero identificador ingresado");
        }
    }
    
    public static void accederInventario(){
        for(Documento d : inventario)
            System.out.println(d.toString());
    }
    
    
    public static void guardar(){
        vaciarArchivos();
        FileWriter escribir;
        PrintWriter linea;
        for (Documento d: Inventario.getInventario()){
            //System.out.println(d);
            if (d instanceof Libro){
                //System.out.println(d);
                File file = new File("libros.txt");
                if (!file.exists()){

                    try{
                        file.createNewFile();

                        System.out.println(file.getName() + " se creó éxitosamente");
                        escribir = new FileWriter(file,true);
                        linea = new PrintWriter(escribir);

                        linea.println(d);
                        


                        linea.close();
                        escribir.close();
                    } catch(IOException e){
                        e.printStackTrace();
                    }

                }else {
                    try {
                        System.out.println(file.getName() + " se abrió éxitosamente");
                        escribir = new FileWriter(file,true);
                        linea = new PrintWriter(escribir);

                        
                        linea.println(d);


                        linea.close();
                        escribir.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }
            }else if (d instanceof Tesis){
                File file = new File("tesis.txt");
                if (!file.exists()){

                    try{
                        file.createNewFile();

                        System.out.println(file.getName() + " se creó éxitosamente");
                        escribir = new FileWriter(file,true);
                        linea = new PrintWriter(escribir);

                        
                        linea.println(d);
                        //System.out.println(d);


                        linea.close();
                        escribir.close();
                    } catch(IOException e){
                        e.printStackTrace();
                    }

                }else {
                    try {
                        System.out.println(file.getName() + " se abrió éxitosamente");
                        escribir = new FileWriter(file,true);
                        linea = new PrintWriter(escribir);

                        
                        linea.println(d);


                        linea.close();
                        escribir.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                
                    }
                }    
            }else if (d instanceof ArticuloRevista){
                //System.out.println(d);
                File file = new File("revistas.txt");
                if (!file.exists()){

                    try{
                        file.createNewFile();

                        System.out.println(file.getName() + " se creó éxitosamente");
                        escribir = new FileWriter(file,true);
                        linea = new PrintWriter(escribir);

                        linea.println(d);
                        


                        linea.close();
                        escribir.close();
                    } catch(IOException e){
                        e.printStackTrace();
                    }

                }else {
                    try {
                        System.out.println(file.getName() + " se abrió éxitosamente");
                        escribir = new FileWriter(file,true);
                        linea = new PrintWriter(escribir);

                        
                        linea.println(d);


                        linea.close();
                        escribir.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }
            }
        }
        JOptionPane.showMessageDialog(null, "Guardado exitoso");
       
    }
    
    public static void vaciarArchivos() {
        try {
            BufferedWriter libro = new BufferedWriter(new FileWriter("libros.txt"));
            BufferedWriter tesis = new BufferedWriter(new FileWriter("tesis.txt"));
            BufferedWriter revistas = new BufferedWriter(new FileWriter("revistas.txt"));
            
            libro.write("");
            tesis.write("");
            revistas.write("");
            
            libro.close();
            tesis.close();
            revistas.close();
            
        } catch (IOException ex) {
            System.out.println("");
        }
        
        
        
    }
    
}
