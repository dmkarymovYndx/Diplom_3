import api.ApiActions;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.pageobject.*;

import static ru.yandex.praktikum.constants.TestsData.*;

public class LoginTests extends BaseTest {

    @Before
    public void apiCreateUser() {
        ApiActions.userRegister(EMAIL, PASSWORD, NAME);
    }

    @Test
    @DisplayName("Check if login is successful when entering by 'Login' button on the Constructor page")
    public void isConstructorLoginButtonLoginSuccessful() {

        HeaderFragment objHeaderFragment = new HeaderFragment(driver);
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        ProfilePage objProfilePage = new ProfilePage(driver);

        objConstructorPage.clickLoginButton();
        objLoginPage.fillLoginFormAndEnter(EMAIL, PASSWORD);
        objHeaderFragment.clickProfileButton();
        String name = objProfilePage.getName();
        Assert.assertEquals("Ошибка: имя пользователя не совпадает с введённым", NAME, name);

    }

    @Test
    @DisplayName("Check if login is successful when entering by 'Profile' button on the Header")
    public void isHeaderProfileButtonLoginSuccessful() {

        HeaderFragment objHeaderFragment = new HeaderFragment(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        ProfilePage objProfilePage = new ProfilePage(driver);

        objHeaderFragment.clickProfileButton();
        objLoginPage.fillLoginFormAndEnter(EMAIL, PASSWORD);
        objHeaderFragment.clickProfileButton();
        String name = objProfilePage.getName();
        Assert.assertEquals("Ошибка: имя пользователя не совпадает с введённым", NAME, name);

    }

    @Test
    @DisplayName("Check if login is successful when entering by 'Login' button on the Register page")
    public void isRegisterLoginButtonLoginSuccessful() {

        HeaderFragment objHeaderFragment = new HeaderFragment(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        ProfilePage objProfilePage = new ProfilePage(driver);
        RegisterPage objRegisterPage = new RegisterPage(driver);

        objHeaderFragment.clickProfileButton();
        objLoginPage.clickRegisterButton();
        objRegisterPage.clickLoginButton();
        objLoginPage.fillLoginFormAndEnter(EMAIL, PASSWORD);
        objHeaderFragment.clickProfileButton();
        String name = objProfilePage.getName();
        Assert.assertEquals("Ошибка: имя пользователя не совпадает с введённым", NAME, name);

    }

    @Test
    @DisplayName("Check if login is successful when entering by 'Login' button on the Restore Password page")
    public void isRestorePasswordLoginButtonLoginSuccessful() {

        HeaderFragment objHeaderFragment = new HeaderFragment(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        ProfilePage objProfilePage = new ProfilePage(driver);
        RestorePasswordPage objRestorePasswordPage = new RestorePasswordPage(driver);

        objHeaderFragment.clickProfileButton();
        objLoginPage.clickForgotPasswordButton();
        objRestorePasswordPage.clickLoginButton();
        objLoginPage.fillLoginFormAndEnter(EMAIL, PASSWORD);
        objHeaderFragment.clickProfileButton();
        String name = objProfilePage.getName();
        Assert.assertEquals("Ошибка: имя пользователя не совпадает с введённым", NAME, name);

    }

    @After
    public void apiDeleteUser() {
        ApiActions.userDelete(EMAIL, PASSWORD);
    }

}
