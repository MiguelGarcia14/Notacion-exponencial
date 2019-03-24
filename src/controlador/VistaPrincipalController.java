/**
 * Clase controlador de la vista VistaPrincipal.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;
import modelo.Algoritmo;

import modelo.*;

/**
 * FXML Controller class
 *
 * @author campu
 */
public class VistaPrincipalController implements Initializable {

    Algoritmo miAlgoritmo;

    @FXML
    public TextField txtCadena;
    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnSiete;
    @FXML
    private Button btnOcho;
    @FXML
    private Button btnNueve;
    @FXML
    private Button btnCuatro;
    @FXML
    private Button btnCinco;
    @FXML
    private Button btnSeis;
    @FXML
    private Button btnUno;
    @FXML
    private Button btnDos;
    @FXML
    private Button btnTres;
    @FXML
    private Button btnPunto;
    @FXML
    private Button btnMas;
    @FXML
    private Button btnMenos;
    @FXML
    private Button btnCero;
    @FXML
    private Button btnExp;
    @FXML
    private Button btnBorrar;
    @FXML
    public TableView<PruebaEscritorio> tblPruebaEscritorio;
    @FXML
    public ImageView imgVResultado;
    @FXML
    public TableColumn<PruebaEscritorio, String> EstadoColumn;
    @FXML
    public TableColumn<PruebaEscritorio, String> EntradaColumn;
    @FXML
    public TableColumn<PruebaEscritorio, String> SimboloColumn;
    @FXML
    private VBox contenedor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //iniciamos con tres columnas la TableView
        EstadoColumn.setCellValueFactory(cellData -> cellData.getValue().getEstadoPro());
        SimboloColumn.setCellValueFactory(cellData -> cellData.getValue().getSimboloPro());
        EntradaColumn.setCellValueFactory(cellData -> cellData.getValue().getEntradaPro());

        miAlgoritmo = new Algoritmo(this);
        this.txtCadena.setTooltip(new Tooltip("Ingrese cadena"));
        this.txtCadena.setPromptText("");

        // Establecemos que el cursor este en lado izquierdo
        this.txtCadena.setAlignment(Pos.CENTER_RIGHT);
        this.txtCadena.forward();
    }

    @FXML
    private void btnAceptar(ActionEvent event) {
        miAlgoritmo = new Algoritmo(this);    // inicializamos objeto de la clase Algoritmo
                                              // le mandamos el controlador en su constructor
        this.imgVResultado.setImage(null);    // en caso de que muestre la imagen de resultado
                                              // se borra
        miAlgoritmo.setName("Ejecucion algoritmo");   // le ponemos un nombre al hilo que hara el 
                                                      // desarrollo del algoritmo 
        miAlgoritmo.convertirCadena(txtCadena.getText()); // le mandamos la cadena que ingreso el usuario
        miAlgoritmo.start();                             // ejecutamos el hilo 
    }

    @FXML
    private void btnSiete(ActionEvent event) {
        String aux = txtCadena.getText();
        aux = aux + "7";
        txtCadena.setText(aux);
    }

    @FXML
    private void btnOcho(ActionEvent event) {
        String aux = txtCadena.getText();
        aux = aux + "8";
        txtCadena.setText(aux);
    }

    @FXML
    private void btnNueve(ActionEvent event) {
        String aux = txtCadena.getText();
        aux = aux + "9";
        txtCadena.setText(aux);
    }

    @FXML
    private void btnCuatro(ActionEvent event) {
        String aux = txtCadena.getText();
        aux = aux + "4";
        txtCadena.setText(aux);
    }

    @FXML
    private void btnCinco(ActionEvent event) {
        String aux = txtCadena.getText();
        aux = aux + "5";
        txtCadena.setText(aux);
    }

    @FXML
    private void btnSeis(ActionEvent event) {
        String aux = txtCadena.getText();
        aux = aux + "6";
        txtCadena.setText(aux);
    }

    @FXML
    private void btnUno(ActionEvent event) {
        String aux = txtCadena.getText();
        aux = aux + "1";
        txtCadena.setText(aux);
    }

    @FXML
    private void btnDos(ActionEvent event) {
        String aux = txtCadena.getText();
        aux = aux + "2";
        txtCadena.setText(aux);
    }

    @FXML
    private void btnTres(ActionEvent event) {
        String aux = txtCadena.getText();
        aux = aux + "3";
        txtCadena.setText(aux);
    }

    @FXML
    private void btnPunto(ActionEvent event) {
        String aux = txtCadena.getText();
        aux = aux + ".";
        txtCadena.setText(aux);
    }

    @FXML
    private void btnOpMas(ActionEvent event) {
        String aux = txtCadena.getText();
        aux = aux + "+";
        txtCadena.setText(aux);
    }

    @FXML
    private void btnOpMenos(ActionEvent event) {
        String aux = txtCadena.getText();
        aux = aux + "-";
        txtCadena.setText(aux);
    }

    @FXML
    private void btnCero(ActionEvent event) {
        String aux = txtCadena.getText();
        aux = aux + "0";
        txtCadena.setText(aux);
    }

    @FXML
    private void btnExponente(ActionEvent event) {
        String aux = txtCadena.getText();
        aux = aux + "e";
        txtCadena.setText(aux);
    }

    @FXML
    private void btnSup(ActionEvent event) {
        String aux = txtCadena.getText();
        int tamaño = aux.length() - 1;
        if (tamaño < 0) {
            txtCadena.setText("");
            //primeraVez = false;
        } else {
            aux = aux.substring(0, tamaño);
        }

        txtCadena.setText(aux);
    }
}