package wallpapersapp;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class OpenImageController { //контроллер страницы открытия окна

    @FXML
    private ImageView image;

    public void initialize() {
        image.setImage(ContainerBean.getOpenedImage());
    }
}
