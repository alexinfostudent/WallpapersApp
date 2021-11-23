package wallpapersapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class MainClientController {

    @FXML
    private Button exitButton;
    @FXML
    private ImageView image_1;

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
