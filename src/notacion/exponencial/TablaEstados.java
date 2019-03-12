/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notacion.exponencial;

/**
 *
 * @author campu
 */
public class TablaEstados {
    private static char[][] TABLA_TRANSICION={
                {'2','E','1','1','E','E'},  //Q0
                {'2','E','E','E','E','E'},  //Q1
                {'2','3','E','E','E','A'},  //Q2
                {'4','E','E','E','E','E'},//Q3
                {'4','E','E','E','5','A'},//Q4
                {'7','E','6','6','E','E'},//Q5
                {'7','E','E','E','E','E'},//Q6
                {'7','E','E','E','E','A'}};//Q7
    
}
