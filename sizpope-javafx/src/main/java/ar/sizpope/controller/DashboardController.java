package ar.sizpope.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {
    @FXML private Label statusLabel;
    @FXML public void initialize(){
        statusLabel.setText("Bienvenido a SIZPOPE — PFZ Viewer");
    }
}

