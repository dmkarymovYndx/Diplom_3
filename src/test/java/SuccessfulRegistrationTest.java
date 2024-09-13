import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.praktikum.pageobject.*;
import api.ApiActions;

import static ru.yandex.praktikum.constants.TestsData.*;

public class SuccessfulRegistrationTest extends BaseTest {

    @Test
    @DisplayName("Check if User's correct name is shown in the Profile Page after registration")
    public void profilePageShowsCorrectNameAfterRegistration() {

        HeaderFragment objHeaderFragment = new HeaderFragment(driver);
        RegisterPage objRegisterPage = new RegisterPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        ProfilePage objProfilePage = new ProfilePage(driver);

        objHeaderFragment.clickProfileButton();
        objLoginPage.clickRegisterButton();
        objRegisterPage.fillRegisterFormAndEnter(EMAIL, PASSWORD, NAME);
        objHeaderFragment.clickProfileButton();
        objLoginPage.fillLoginFormAndEnter(EMAIL, PASSWORD);
        objHeaderFragment.clickProfileButton();
        String name = objProfilePage.getName();
        Assert.assertEquals("Ошибка: имя пользователя не совпадает с введённым", NAME, name);

    }

    @After
    public void cleanUp() {
        ApiActions.userDelete(EMAIL, PASSWORD);
    }

}
