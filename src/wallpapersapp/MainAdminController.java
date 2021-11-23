package wallpapersapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class MainAdminController {

    @FXML
    private ImageView image_1;
    @FXML
    private Button exitButton;

    public void initialize() {
        exitButton.setOnAction(event -> {
            try {
                ProgramNavigation.setRoot("authorization");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
