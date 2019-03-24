/**
 * La clase Algoritmo implementa el seudocodigo usando la tabla de transicion del automata
 * Este algoritmo se ejecuta en otro proceso.
 */
package modelo;

import controlador.VistaPrincipalController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javax.swing.JOptionPane;

public class Algoritmo extends Thread {

    char[] cadena;                // cadena de caracteres para poder analizar la cadena introducida
    int contador;                 // contador para poder obtener el caracter del arreglo de caracteres

    public PruebaEscritorio objeto = new PruebaEscritorio();    // objeto de la clase PruebaEscritorio que contiene los metodos de aceeso
    
    VistaPrincipalController ctrl;     // objeto de la clase VistaPrincipalController, esto para poder 
                                       // escribir en la tabla
    
    // coleccion de tipo PruebaEscritorio
    private ObservableList<PruebaEscritorio> datos = FXCollections.observableArrayList(); 
    
    /**
     * Contructor con un parametro.
     * @param ctrl objeto de la clase VistaPrincipalController para poder escribir en la tabla
     */
    public Algoritmo(VistaPrincipalController ctrl) {
        this.ctrl = ctrl;
    }

    /**
     * Metodo que convierte una cadena String en un arreglo de caracteres.
     * @param cadenaExaminar variable de tipo de String que es la que se pretende analizar
     */
    public void convertirCadena(String cadenaExaminar) {
        cadenaExaminar = cadenaExaminar + "Fdc";
        cadena = cadenaExaminar.toCharArray();
    }

    /**
     * @return caracter del arreglo de caracteres indicado en la posicion de acuerdo al valor que tenga la
     * variable contador
     */
    public String leerSimbolo() {
        return ((contador < cadena.length) ? String.valueOf(cadena[contador]) : "");
    }

    /** 
     * Metodo que muestra el resultado una vez que se ejecuto el algoritmo 
     * dependiendo si es E(Error) o A(Aceptacion)
     */
    public void aceptacionCadena() throws IOException {
        // arreglo de url donde estan las imagenes de aceptacion y de error
        String urlImagenes[] = {"/imagenes/aceptacion.jpg", "/imagenes/icono cerrar.png"};
        Image res = null;     // objeto de la clase Image
        if (objeto.getEstado().equals("A")) {
            res = new Image(urlImagenes[0]);   // establecemos a la variable res la url de donde se 
                                               // se obtendra la imagen
            ctrl.imgVResultado.setImage(res);  // mostramos la imagen
        } 
        else 
        {
            res = new Image(urlImagenes[1]);
            ctrl.imgVResultado.setImage(res);
        }
    }

    @Override
    public void run() 
    {
        try {
            objeto.setEstado("0");                        // establecemos el Estado a 0
            objeto.setSimbolo(leerSimbolo());             // leemos el primer letra
            Alfabeto miAlfabeto = null;                   // puede ser DIGITO, OP_MAS, OP_MENOS, PUNTO, EXP
                                                          // FDC
            do {
                switch (objeto.getSimbolo()) {
                    // en caso de que sea digito el carácter
                    case "0":
                    case "1":
                    case "2":
                    case "3":
                    case "4":
                    case "5":
                    case "6":
                    case "7":
                    case "8":
                    case "9":
                        miAlfabeto = Alfabeto.DIGITO;
                        objeto.setEntrada(miAlfabeto.getIdentificador());
                        break;

                    // en caso de que sea el operador +
                    case "+":
                        miAlfabeto = Alfabeto.OP_MAS;
                        objeto.setEntrada(miAlfabeto.getIdentificador());
                        System.out.println("");
                        break;

                    // en caso de que sea el operador -
                    case "-":
                        miAlfabeto = Alfabeto.OP_MENOS;
                        objeto.setEntrada(miAlfabeto.getIdentificador());
                        break;

                    // en caso de que sea punto decimal
                    case ".":
                        miAlfabeto = Alfabeto.PUNTO;
                        objeto.setEntrada(miAlfabeto.getIdentificador());
                        break;

                    // en caso de que sea el exponente
                    case "e":
                        miAlfabeto = Alfabeto.EXPONENCIAL;
                        objeto.setEntrada(miAlfabeto.getIdentificador());
                        break;

                    // en caso de que sea el fin de cadena
                    case "F":
                        miAlfabeto = Alfabeto.FDC;
                        objeto.setEntrada(miAlfabeto.getIdentificador());
                        break;

                    // si no es ninguno de los simbolos anteriores, es un error
                    default:
                        error(objeto.getSimbolo());
                        objeto.setEstado("E");
                        objeto.setSimbolo(objeto.getSimbolo());
                        aceptacionCadena();
                        this.stop();
                }
                Thread.sleep(1000);    // hacemoa que el hilo se duerma por 1 segundo
                
                // agregamos a la variable lista, el objeto de la clase PruebaEscritorio
                datos.add(new PruebaEscritorio(objeto.getEstado(), objeto.getSimbolo(), objeto.getEntrada()));
                ctrl.tblPruebaEscritorio.setItems(datos);    // agregamos una nueva fila a la table
                objeto.setEstado(TablaEstados.F(objeto.getEstado(), miAlfabeto.ordinal()));   //obtenemos el nuevo Estado para seguir con el algoritmo
                contador++;     // incrementamos el contador
                objeto.setSimbolo(leerSimbolo());   // leemos el siguiente caracter que hay en al arreglo
            } 
            while (!objeto.getEstado().equals("E") && !objeto.getEstado().equals("A"));
            datos.add(new PruebaEscritorio(objeto.getEstado()));  
            ctrl.tblPruebaEscritorio.setItems(datos);
            aceptacionCadena();
        } 
        catch (InterruptedException e) 
        {
            System.err.print(e.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(Algoritmo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Método que muestra un mensaje de error
     * @param s corresponde al simbolo que no se puede analizar de acuerdo al algoritmo del automata
     */
    public void error(String s)
    {
        JOptionPane.showMessageDialog(null, "No se puede analizar el caracter que ingreso: " + s, "Error en la lectura", 
                JOptionPane.ERROR_MESSAGE);
    }
}