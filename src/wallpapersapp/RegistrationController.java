package wallpapersapp;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationController {

    @FXML
    private Button backButton;
    @FXML
    private Button registrationButton;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    
    public void initialize() {
        registrationButton.setOnAction(event -> {
            DataBaseManager dbManager = ContainerBean.getDbManager();
            boolean isAdded = dbManager.addUser(loginField.getText(), passwordField.getText());
            if(isAdded) {
                //переход на страницу с обоями
            } else {
                //вывод ошибки, что такой пользователь уже есть
            }
        });
        backButton.setOnAction(event -> {  //возврат на предыдущую страницу
            try {
                ProgramNavigation.setRoot("authorization");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }    
    
}
