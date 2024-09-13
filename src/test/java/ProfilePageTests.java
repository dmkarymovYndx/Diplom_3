import api.ApiActions;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.pageobject.*;
import java.time.Duration;

import static ru.yandex.praktikum.constants.TestsData.*;

public class ProfilePageTests extends BaseTest {

    @Before
    public void apiCreateUserAndLogin() {
        Response response = ApiActions.userRegister(EMAIL, PASSWORD, NAME);
        String accessToken = response.jsonPath().getString("accessToken");
        String refreshToken = response.jsonPath().getString("refreshToken");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("localStorage.setItem('accessToken', '" + accessToken + "');");
        js.executeScript("localStorage.setItem('refreshToken', '" + refreshToken + "');");
    }

    @Test
    @DisplayName("Check if click on Profile button opens Profile page")
    public void clickProfileButtonOpensProfilePage() {

        HeaderFragment objHeaderFragment = new HeaderFragment(driver);
        ProfilePage objProfilePage = new ProfilePage(driver);

        objHeaderFragment.clickProfileButton();
        Assert.assertTrue("Ошибка: отсутствует описание страницы, либо нужная страница не загружена", objProfilePage.isDescriptionPresent());

    }

    @Test
    @DisplayName("Check if clicking the Constructor button from the Profile page opens the Constructor page")
    public void clickConstructorButtonOpensConstructorPage() {

        HeaderFragment objHeaderFragment = new HeaderFragment(driver);
        ConstructorPage objConstructorPage = new ConstructorPage(driver);

        objHeaderFragment.clickProfileButton();
        objHeaderFragment.clickConstructorButton();
        Assert.assertTrue("Ошибка: отсутствует описание страницы, либо нужная страница не загружена", objConstructorPage.isPageTitlePresent());

    }

    @Test
    @DisplayName("Check if clicking the Header logo from the Profile page opens the Constructor page")
    public void clickHeaderLogoOpensConstructorPage() {

        HeaderFragment objHeaderFragment = new HeaderFragment(driver);
        ConstructorPage objConstructorPage = new ConstructorPage(driver);

        objHeaderFragment.clickProfileButton();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.className("AppHeader_header__logo__2D0X2")));
        objHeaderFragment.clickLogo();
        Assert.assertTrue("Ошибка: отсутствует описание страницы, либо нужная страница не загружена", objConstructorPage.isPageTitlePresent());

    }

    @Test
    @DisplayName("Check if the Logout button logs User out")
    public void clickLogoutButtonLogsUserOut() {

        HeaderFragment objHeaderFragment = new HeaderFragment(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        ProfilePage objProfilePage = new ProfilePage(driver);

        objHeaderFragment.clickProfileButton();
        objProfilePage.clickLogoutButton();
        objHeaderFragment.clickProfileButton();
        Assert.assertTrue("Ошибка: отсутствует описание страницы, либо нужная страница не загружена", objLoginPage.isPageTitlePresent());

    }

    @After
    public void cleanUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("localStorage.removeItem('accessToken');");
        js.executeScript("localStorage.removeItem('refreshToken');");
        ApiActions.userDelete(EMAIL, PASSWORD);
    }

}
