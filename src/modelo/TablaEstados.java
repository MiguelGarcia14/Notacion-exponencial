/**
 * La clase TablaEstados contiene la tabla de transicion del automata que usa el programa
 * Contiene un metodo.
 */
package modelo;

public class TablaEstados 
{
    
    /**
     * Variable constante de tipo String, es una arreglo bidimimensional.
     */
    private static final String TABLA_TRANSICION[][] = {
        //D    +     -   .    e   Fdc
        {"2", "1", "1", "E", "E", "E"}, //q0
        {"2", "E", "E", "E", "E", "E"}, //q1
        {"2", "E", "E", "3", "E", "A"}, //q2
        {"4", "E", "E", "E", "E", "E"}, //q3
        {"4", "E", "E", "E", "5", "A"}, //q4
        {"7", "6", "6", "E", "E", "E"}, //q5
        {"7", "E", "E", "E", "E", "E"}, //q6
        {"7", "E", "E", "E", "E", "A"}  //q7
    };
    
    /**
     * Metodo que devuelve un nuevo Estado para seguir analizando la cadena.
     * @param Estado recibe el estado anterior 
     * @param columna corresponde al alfabeto que se el asigno en la cadena
     * @return el nuevo estado 
     */
    public static String F(String Estado, int columna)
    {
        int aux = 0;
        if(Estado.equals("0") || Estado.equals("1") || Estado.equals("2") || Estado.equals("3")
                || Estado.equals("4") || Estado.equals("5") ||Estado.equals("6") || Estado.equals("7")
                || Estado.equals("8") || Estado.equals("9"))
            aux = Integer.parseInt(Estado);
            
        return TABLA_TRANSICION[aux][columna];
    }
}