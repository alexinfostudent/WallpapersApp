package wallpapersapptest;

import org.junit.Test;
import static org.junit.Assert.*;
import wallpapersapp.AuthorizationController;
import wallpapersapp.RegistrationController;

public class JUnitTest {

    @Test
    public void authNegative() {
        AuthorizationController controller = new AuthorizationController();
        assertEquals("Проверка негативного сценария при авторизации", controller.check("user", "888"), "Такого пользователя не существует!");
    }

    @Test
    public void registrationNegative() {
        RegistrationController controller = new RegistrationController();
        assertEquals("Проверка негативного сценария при регистрации", controller.addUser("alex", "456"), "Ошибка! Пользователь с таким логином уже существует");       
    }

}
