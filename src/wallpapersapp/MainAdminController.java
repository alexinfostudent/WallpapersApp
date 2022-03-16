package wallpapersapp;

import java.io.BufferedWriter;
import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

public class MainAdminController { //контроллер главной страницы для админа

    @FXML
    private Button exitButton;
    @FXML
    private Button exportButton;
    @FXML
    private ImageView image_1;
    @FXML
    private ImageView image_2;
    @FXML
    private ImageView image_3;
    @FXML
    private ImageView image_4;
    @FXML
    private ImageView image_5;
    @FXML
    private ImageView image_6;
    @FXML
    private ImageView image_7;
    @FXML
    private ImageView image_8;
    @FXML
    private ImageView image_9;
    @FXML
    private ImageView image_10;
    @FXML
    private ImageView image_11;
    @FXML
    private ImageView image_12;
    @FXML
    private ImageView image_13;
    @FXML
    private ImageView image_14;
    @FXML
    private ImageView image_15;

    public void initialize() {

        image_1.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> { //назначение обработчика на все картинки, чтобы по ним можно было нажимать
            ContainerBean.getWallpapersActions().openMenu(image_1.getImage(), 1);
        });

        image_2.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ContainerBean.getWallpapersActions().openMenu(image_2.getImage(), 2);
        });

        image_3.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ContainerBean.getWallpapersActions().openMenu(image_3.getImage(), 3);
        });

        image_4.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ContainerBean.getWallpapersActions().openMenu(image_4.getImage(), 4);
        });

        image_5.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ContainerBean.getWallpapersActions().openMenu(image_5.getImage(), 5);
        });

        image_6.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ContainerBean.getWallpapersActions().openMenu(image_6.getImage(), 6);
        });

        image_7.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ContainerBean.getWallpapersActions().openMenu(image_7.getImage(), 7);
        });

        image_8.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ContainerBean.getWallpapersActions().openMenu(image_8.getImage(), 8);
        });

        image_9.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ContainerBean.getWallpapersActions().openMenu(image_9.getImage(), 9);
        });

        image_10.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ContainerBean.getWallpapersActions().openMenu(image_10.getImage(), 10);
        });

        image_11.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ContainerBean.getWallpapersActions().openMenu(image_11.getImage(), 11);
        });

        image_12.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ContainerBean.getWallpapersActions().openMenu(image_12.getImage(), 12);
        });

        image_13.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ContainerBean.getWallpapersActions().openMenu(image_13.getImage(), 13);
        });

        image_14.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ContainerBean.getWallpapersActions().openMenu(image_14.getImage(), 14);
        });

        image_15.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            ContainerBean.getWallpapersActions().openMenu(image_15.getImage(), 15);
        });

        exitButton.setOnAction(event -> { //кнопка выхода на экран авторизации
            try {
                ProgramNavigation.setRoot("authorization");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        exportButton.setOnAction(event -> {
            try {
                // подключение к БД и выгрузка списка пользователей
                DataBaseManager dbManager = ContainerBean.getDbManager();
                ResultSet rs = dbManager.getUsers();

                // открытие окна выбора файла для сохранения
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Сохранить");
                fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text document", "*.txt"));
                File file = fileChooser.showSaveDialog(ProgramNavigation.getScene().getWindow());
                PrintWriter printWriter = new PrintWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(printWriter);
                // запись списка пользователей в выбранный файл
                bufferedWriter.write("id, user_login, user_password");
                bufferedWriter.newLine();
                while (rs.next()) {
                    bufferedWriter.write(rs.getString("id") + ", " + rs.getString("user_login") + ", " + rs.getString("user_password"));
                    if (!rs.isLast()) {
                        bufferedWriter.newLine();
                    }
                }
                rs.close();
                bufferedWriter.close();
                printWriter.close();

                // вывод алерта об успешном окончании экспорта
                Alert alert = ContainerBean.getAlertCreator().createInformationAlert();
                alert.show();
            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = ContainerBean.getAlertCreator().createErrorAlert(e.getLocalizedMessage());
                alert.show();
            }
        });
    }
}
