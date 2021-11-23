package wallpapersapp;

import java.sql.*;
import java.util.HashMap;

public class DataBaseManager { //класс для работы с базой данных
    
    private final String URL = "jdbc:mysql://localhost:3306/wallpapersappdb";
    private final String USER = "root";
    private final String PASS = "123456";
    private Connection connection;
    
    public DataBaseManager() { //установка соединения
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean addUser(String login, String password) { //добавление нового пользователя
        try {
            String query = "INSERT INTO users(user_login, user_password) VALUES(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public HashMap<String, String> getUsers() { //получение списка всех пользователей
        HashMap<String, String> usersInfo = new HashMap<>();
        try {
            String query = "SELECT * FROM users";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                usersInfo.put(resultSet.getString(1), resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersInfo;
    }
}
