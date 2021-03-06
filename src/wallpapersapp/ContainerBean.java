package wallpapersapp;

import javafx.scene.image.Image;

public class ContainerBean { //класс хранилище объектов (Dependency injection)

    private static String userName;
    
    private static DataBaseManager dbManager = new DataBaseManager();

    private static AlertCreator alertCreator = new AlertCreator();

    private static WallpapersActions wallpapersActions = new WallpapersActions();

    private static Image openedImage;

    private static WallpaperChanger wallpaperChanger = new WallpaperChanger();

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        ContainerBean.userName = userName;
    }

    public static DataBaseManager getDbManager() {
        return dbManager;
    }

    public static void setDbManager(DataBaseManager dbManager) {
        ContainerBean.dbManager = dbManager;
    }

    public static AlertCreator getAlertCreator() {
        return alertCreator;
    }

    public static void setAlertCreator(AlertCreator alertCreator) {
        ContainerBean.alertCreator = alertCreator;
    }

    public static WallpapersActions getWallpapersActions() {
        return wallpapersActions;
    }

    public static void setWallpapersActions(WallpapersActions wallpapersActions) {
        ContainerBean.wallpapersActions = wallpapersActions;
    }

    public static Image getOpenedImage() {
        return openedImage;
    }

    public static void setOpenedImage(Image openedImage) {
        ContainerBean.openedImage = openedImage;
    }

    public static WallpaperChanger getWallpaperChanger() {
        return wallpaperChanger;
    }

    public static void setWallpaperChanger(WallpaperChanger wallpaperChanger) {
        ContainerBean.wallpaperChanger = wallpaperChanger;
    }
}
