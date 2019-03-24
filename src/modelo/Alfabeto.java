/**
 * Declaracion de tipo enum con un constructor y campos de instancia explícitos,
 * junto con metodos de acceso a estos campos.
 */
package modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public enum Alfabeto 
{
    /**
     * Declaracion de constantes de tipo enum.
     */
    DIGITO("Digito", "D"),
    OP_MAS("Op mas", "+"),
    OP_MENOS("Op menos", "-"),
    PUNTO("Punto", "."),
    EXPONENCIAL("Exponencial", "e"),
    FDC ("Fin de cadena", "F");
    
    /**
     * Propiedades de instancia
     */
    private final StringProperty identificador;
    private final StringProperty Simbolo;

    /**
     * Constructor de enum
     * @param identificador corresponde a un titulo para la constante
     * @param S corresponde a la forma mas corta de identificarlo
     */
    Alfabeto(String identificador, String S)
    {
        this.identificador = new SimpleStringProperty(identificador);
        this.Simbolo = new SimpleStringProperty(S);
    }
    
    //Metodos de acceso de las propiedades
    
    /**
     * @return identificador
     */
    public String getIdentificador()
    {
        return identificador.get();
    }
    
    /**
     * @return Simbolo
     */
    public String getSimbolo()
    {
        return Simbolo.get();
    }
}