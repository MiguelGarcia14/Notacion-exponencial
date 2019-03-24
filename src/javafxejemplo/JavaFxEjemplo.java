/**
 * Clase donde se encuentra el main
 * Aqui se inicia el programa.
 */
package javafxejemplo;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class JavaFxEjemplo extends Application {

    /**
     * Este metodo se ejecuta una vez, esto es cuando se crea la GUI
     * @param stage
     */
    @Override
    public void start(Stage stage) throws Exception {
        // obtenemos una referencia del archivo VistaPrincipal.fxml para que podamos usar
        Parent root = FXMLLoader.load(getClass().getResource("/vista/VistaPrincipal.fxml"));

        // usamos los archivos CSS(hojas de estilo cascada) para el diseño de la vista
        root.getStylesheets().add(getClass().getResource("EstilosTabla.css").toExternalForm());
        root.getStylesheets().add(getClass().getResource("EstilosBotonesTextfield.css").toExternalForm());
        
        // establecemos un titulo, ancho y alto
        stage.setTitle("Notacion exponencial - Automata");
        stage.setWidth(930);
        stage.setHeight(380);
        
        // No se puede maximizar, es decir no se puede redimensionar
        stage.setResizable(false);
        
        // especificamos nuestra Escena, es decir la GUI que vamos a mostrar
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

        //establecemos un atajo de teclado para poder limpiar todo, es decir hacer un nueva entrada de cadena
        scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
           
            // declaramos la combinacion de teclas que se tiene que presionar (Ctrl + N)
            KeyCombination keyComb = new KeyCodeCombination(KeyCode.N,
                    KeyCombination.CONTROL_DOWN);

            @Override
            public void handle(KeyEvent ke) {
                if (keyComb.match(ke)) {
                    try {
                        Parent root = null;
                        root = FXMLLoader.load(getClass().getResource("/vista/VistaPrincipal.fxml"));
                        ke.consume();
                        root.getStylesheets().add(getClass().getResource("EstilosTabla.css").toExternalForm());
                        root.getStylesheets().add(getClass().getResource("EstilosBotonesTextfield.css").toExternalForm());
                        stage.setTitle("Notacion exponencial - Automata");
                        stage.setWidth(880);
                        stage.setHeight(400);
                        Scene scene = new Scene(root);
                        // a la nueva vista le volvemos a agregar el evento de teclas
                        // le agregamos el atajo de teclado
                        // CTRL + N
                        scene.addEventFilter(KeyEvent.KEY_PRESSED, this);
                        stage.setScene(scene);
                        stage.show();
                    } 
                    catch (Exception e) 
                    {
                    }
                }
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}