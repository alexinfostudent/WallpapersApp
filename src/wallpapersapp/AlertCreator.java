package wallpapersapp;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AlertCreator { //класс для создания Alert окна

    public Alert createAlert(ButtonType... buttonType) { //метод создания, принимает на вход кнопки (типы кнопок) как параметр переменной длины
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(WallpapersApp.class.getResourceAsStream("images/logo.png")));
        alert.setTitle("");
        alert.setTitle("Действие с изображением");
        alert.setHeaderText("Выберите действие");
        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(buttonType);
        return alert;
    }

    // генерация алерта об успешном окончании экспорта
    public Alert createInformationAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(WallpapersApp.class.getResourceAsStream("images/logo.png")));
        alert.setTitle("Сохранение в файл");
        alert.setHeaderText("Успешно");
        alert.setContentText("Данные экспортированы и сохранены в файл!");
        return alert;
    }

    // генерация алерта об ошибке в процессе экспорта
    public Alert createErrorAlert(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(WallpapersApp.class.getResourceAsStream("images/logo.png")));
        alert.setTitle("Ошибка");
        alert.setHeaderText("В процессе экспорта произошла ошибка");
        alert.setContentText("Код ошибки: " + errorMessage);
        return alert;
    }
}
