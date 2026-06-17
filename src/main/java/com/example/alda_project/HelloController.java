package com.example.alda_project;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("C is your character, \n try to reach Stairs S \n while avoiding Enemies G, M and Z \n Use WASD to move\n The game is shown in console, \n this window is only used for input!");
    }
}
