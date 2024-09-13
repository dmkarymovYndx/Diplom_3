import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.pageobject.*;

@RunWith(Parameterized.class)
public class RegistrationPasswordErrorTests extends BaseTest {

    private final String password;
    private final boolean isErrorDisplayed;

    public RegistrationPasswordErrorTests(String password, boolean isErrorDisplayed) {
        this.password = password;
        this.isErrorDisplayed = isErrorDisplayed;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                {"qwert", true},
                {"qwerty", false},
                {"qwertyu", false}
        };
    }

    @Test
    @DisplayName("Check if an error message is shown when password is less than 6 symbols")
    public void shortPasswordShowsError() {

        HeaderFragment objHeaderFragment = new HeaderFragment(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        RegisterPage objRegisterPage = new RegisterPage(driver);

        objHeaderFragment.clickProfileButton();
        objLoginPage.clickRegisterButton();
        objRegisterPage.enterPassword(password);
        objRegisterPage.pressTabInPasswordField();

        boolean isErrorDisplayedActual = objRegisterPage.isIncorrectPasswordMessageDisplayed();
        Assert.assertEquals("Неверный статус видимости сообщения об ошибке", isErrorDisplayed, isErrorDisplayedActual);

    }

}
