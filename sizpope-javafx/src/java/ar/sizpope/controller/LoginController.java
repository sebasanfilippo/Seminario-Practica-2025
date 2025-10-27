package ar.sizpope.controller;

import ar.sizpope.config.Db;
import ar.sizpope.config.Env;
import ar.sizpope.domain.User;
import ar.sizpope.repository.UserRepository;
import ar.sizpope.service.AuthService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;

    @FXML public void initialize(){
        Db.configure(Env.get("db.url"), Env.get("db.user"), Env.get("db.pass"));
    }

    @FXML public void onLogin(ActionEvent e){
        try {
            AuthService auth = new AuthService(new UserRepository());
            User user = auth.login(emailField.getText(), passwordField.getText());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Dashboard.fxml"));
            Scene scene = new Scene(loader.load());
            Stage st = (Stage) emailField.getScene().getWindow();
            st.setTitle("SIZPOPE - Dashboard (" + user.getDisplayName() + ")");
            st.setScene(scene);
        } catch (Exception ex){
            Alert a = new Alert(Alert.AlertType.ERROR, ex.getMessage());
            a.setHeaderText("Error de autenticación");
            a.showAndWait();
        }
    }
}

