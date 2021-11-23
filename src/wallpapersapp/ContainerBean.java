package wallpapersapp;

public class ContainerBean { //класс хранилище объекта менеджера базы данных
    
    private static DataBaseManager dbManager = new DataBaseManager();

    public static DataBaseManager getDbManager() {
        return dbManager;
    }

    public static void setDbManager(DataBaseManager dbManager) {
        ContainerBean.dbManager = dbManager;
    }
}
