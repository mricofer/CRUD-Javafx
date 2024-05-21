package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Persona;

import java.net.URL;
import java.util.ResourceBundle;

public class PersonController {

    @FXML
    private TableView tblPersonas;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colApellidos;
    @FXML
    private TableColumn colEdad;
    @FXML
    private Button btnAñadir;

    private ObservableList<Persona> personas;

    @FXML
    public void initialize() {
        personas = FXCollections.observableArrayList();
        this.tblPersonas.setItems(personas);

        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colApellidos.setCellValueFactory(new PropertyValueFactory("apellidos"));
        this.colEdad.setCellValueFactory(new PropertyValueFactory("edad"));
    }


    @FXML
    private void agregarPersona(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PersonCreateView.fxml"));

        try {
            Parent root = loader.load();

            PersonCreateController controller = loader.getController();
            controller.setPersonas(personas);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(javafx.stage.Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

            Persona p = controller.getPersona();
            if (p != null) {
                personas.add(p);
                this.tblPersonas.refresh();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}