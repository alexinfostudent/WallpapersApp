package wallpapersapp;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

public class WallpapersActions { //класс для выполнения действий над обоями

    public void openMenu(Image image, int index) { //открывает меню Alert, назначает кнопки и действия по ним
        ButtonType saveButton = new ButtonType("Save");
        ButtonType openButton = new ButtonType("Open");
        ButtonType installButton = new ButtonType("Install");
        ButtonType closeButton = ButtonType.CLOSE; //создаем 4 типа кнопок, которые потом добавим на окно Alert
        Alert alert = ContainerBean.getAlertCreator().createAlert(saveButton, openButton, installButton, closeButton); //создание Alert
        Optional<ButtonType> optional = alert.showAndWait(); //ожидание действий
        if (optional.isPresent()) { //в зависимости от нажатой кнопки выполнение действий
            if (optional.get().equals(saveButton)) { //сохранение картинки
                try {
                    save(image);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (optional.get().equals(openButton)) { //открытие картинки
                try {
                    open(image);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (optional.get().equals(installButton)) { //установка на рабочий стол картинки
                install(index);
            }
        }
    }

    private void save(Image image) throws IOException { //сохраняет картинку
        FileChooser fileChooser = new FileChooser(); //открываем проводник для сохранения картинки, ставим ему свойства и сохраняем
        fileChooser.setTitle("Сохранение файла");
        FileChooser.ExtensionFilter newFilter = new FileChooser.ExtensionFilter("Фотография (*.jpg)", "*.jpg");
        fileChooser.getExtensionFilters().add(newFilter);
        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            fileChooser.setInitialDirectory(file);
            String savePath = fileChooser.getInitialDirectory().toString();
            FileOutputStream fileOutputStream = new FileOutputStream(savePath);
            BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
            ImageIO.write(bufferedImage, "jpg", fileOutputStream);
            fileOutputStream.close();
        }
    }

    private void open(Image image) throws IOException { //открывает картинку
        ContainerBean.setOpenedImage(image);
        FXMLLoader fxmlLoader = new FXMLLoader(WallpapersApp.class.getResource("openImage.fxml"));
        Parent root = fxmlLoader.load();
        Stage newStage = new Stage(); //создаем сцену для открытия картинки в новом окне
        newStage.setTitle("Просмотр изображения");
        newStage.getIcons().add(new Image(WallpapersApp.class.getResourceAsStream("images/logo.png")));
        newStage.setScene(new Scene(root, 950, 530));
        newStage.setResizable(false);
        newStage.show();
    }

    private void install(int index) { //устанавливает картинку на рабочий стол
        String path = "D:\\Users\\Алексей\\Documents\\Development\\NetBeansProjects5\\WallpapersApp\\src\\wallpapersapp\\images\\image" + index + ".jpg";
        ContainerBean.getWallpaperChanger().changeWallpaper(path);
    }
}
