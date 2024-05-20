package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Persona;

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

    private Persona persona;

    private ObservableList<Persona> personas;

    public void initialize(){}

    public void setPersonas(ObservableList<Persona> personas) {
        this.personas = personas;
    }

    @FXML
    private void guardar(ActionEvent event) {
        String nombre = this.txtNombre.getText();
        String apellidos = this.txtApellidos.getText();
        int edad = Integer.parseInt(this.txtEdad.getText());

        Persona p = new Persona(nombre, apellidos, edad);

        if (!personas.contains(p)) {
            this.persona = p;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText("Persona añadida");
            alert.setContentText("La persona ha sido añadida correctamente");
            alert.showAndWait();

            Stage stage = (Stage) btnGuardar.getScene().getWindow();
            stage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Persona duplicada");
            alert.setContentText("La persona ya existe en la lista");
            alert.showAndWait();
        }
    }

    @FXML
    private void salir() {
        this.persona = null;
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();
    }

    public Persona getPersona() {
        return persona;
    }
}
