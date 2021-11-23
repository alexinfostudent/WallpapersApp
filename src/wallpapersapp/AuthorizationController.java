package wallpapersapp;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AuthorizationController {

    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button authButton;
    @FXML
    private Button registrationButton;

    public void initialize() {
        authButton.setOnAction(event -> { //вход в систему и переход на страницу с обоями
            
        });
        registrationButton.setOnAction(event -> { //переход на страницу регистрации
            try {
                ProgramNavigation.setRoot("registration");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
