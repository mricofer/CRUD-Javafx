package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PersonCreateController {

    @FXML
    private Button btnSalir;
    @FXML
    private Button btnGuardar;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtEdad;

    public void initialize(URL url, ResourceBundle resources) {

    }

    private void agregarPersona(ActionEvent event) {
    }
}
