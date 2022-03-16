package wallpapersapp;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class AuthorizationController { //контроллер входа в систему

    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button authButton;
    @FXML
    private Button registrationButton;
    @FXML
    private Label message;

    public void initialize() {
        authButton.setOnAction(event -> { //вход в систему
            message.setText("");
            message.setText(check(loginField.getText(), passwordField.getText()));
        });

        registrationButton.setOnAction(event -> { //переход на страницу регистрации
            try {
                ProgramNavigation.setRoot("registration");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public String check(String login, String password) {
        DataBaseManager dbManager = ContainerBean.getDbManager();
        ResultSet resultSet = dbManager.getUser(login, password);
        try {
            if (resultSet.next()) { //есть ли такой пользователь в системе
                int id = resultSet.getInt(1);
                try {
                    if (id == 1) { //проверка является ли пользователь админом
                        ProgramNavigation.setRoot("mainAdmin");
                        return "Роль = Админ!";
                    } else {
                        ContainerBean.setUserName(login);
                        ProgramNavigation.setRoot("mainClient");
                        return "Роль = Клиент!";
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            } else {                
                return "Такого пользователя не существует!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
