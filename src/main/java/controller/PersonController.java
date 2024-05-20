package com.example.crudjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PersonController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}