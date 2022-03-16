package wallpapersapp;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class RegistrationController { //контроллер регистрации в системе

    @FXML
    private Button backButton;
    @FXML
    private Button registrationButton;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label message;

    public void initialize() {
        registrationButton.setOnAction(event -> { //регистрация в системе
            message.setText(addUser(loginField.getText(), passwordField.getText()));
        });
        backButton.setOnAction(event -> {  //возврат на предыдущую страницу
            try {
                ProgramNavigation.setRoot("authorization");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public String addUser(String login, String password) {
        DataBaseManager dbManager = ContainerBean.getDbManager();
        boolean isAdded = dbManager.addUser(login, password);
        if (isAdded) { //проверка, существует ли пользователь с таким логином
            ContainerBean.setUserName(login);
            try {
                ProgramNavigation.setRoot("mainClient");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            return "Ошибка! Пользователь с таким логином уже существует";
        }
        return null;
    }
}
