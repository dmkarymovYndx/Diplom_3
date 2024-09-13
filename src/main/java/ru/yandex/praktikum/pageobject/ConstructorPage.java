package ru.yandex.praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ConstructorPage {

    private WebDriver driver;

    // Конструктор
    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    // URL страницы
    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    // Заголовок "Соберите бургер"
    private By pageTitle = new By.ByXPath(".//h1[contains(@class, text_type_main-large)]");

    // Кнопка "Войти в аккаунт"
    private By loginButton = new By.ByClassName("button_button__33qZ0");

    // Кнопка "Булки" в разделе "Соберите бургер"
    private By bunSectionButton = new By.ByXPath("//main/section[@class='BurgerIngredients_ingredients__1N8v2']/div[@style='display: flex;']/div[1]");

    // Заголовок "Булки" в разделе "Соберите бургер"
    private By bunSectionTitle = new By.ByXPath(".//h2[text()='Булки']");

    // Кнопка "Соусы" в разделе "Соберите бургер"
    private By sauceSectionButton = new By.ByXPath("//main/section[@class='BurgerIngredients_ingredients__1N8v2']/div[@style='display: flex;']/div[2]");

    // Заголовок "Соусы" в разделе "Соберите бургер"
    private By sauceSectionTitle = new By.ByXPath(".//h2[text()='Соусы']");

    // Кнопка "Начинки" в разделе "Соберите бургер"
    private By mainSectionButton = new By.ByXPath("//main/section[@class='BurgerIngredients_ingredients__1N8v2']/div[@style='display: flex;']/div[3]");

    // Заголовок "Начинки" в разделе "Соберите бургер"
    private By mainSectionTitle = new By.ByXPath(".//h2[text()='Начинки']");

    // Клик по кнопке "Войти в аккаунт"
    @Step
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Клик по кнопке "Булки" в разделе "Соберите бургер"
    @Step
    public void clickBunsSectionButton() {
        List<WebElement> overlays = driver.findElements(By.cssSelector(".Modal_modal_overlay__x2ZCr"));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfAllElements(overlays));
        driver.findElement(bunSectionButton).click();
    }

    // Клик по кнопке "Соусы" в разделе "Соберите бургер"
    @Step
    public void clickSauceSectionButton() {
        List<WebElement> overlays = driver.findElements(By.cssSelector(".Modal_modal_overlay__x2ZCr"));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfAllElements(overlays));
        driver.findElement(sauceSectionButton).click();
    }

    // Клик по кнопке "Начинка" в разделе "Соберите бургер"
    @Step
    public void clickMainSectionButton() {
        List<WebElement> overlays = driver.findElements(By.cssSelector(".Modal_modal_overlay__x2ZCr"));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfAllElements(overlays));
        driver.findElement(mainSectionButton).click();
    }

    // Проверка того, что на странице есть заголовок "Соберите бургер"
    public boolean isPageTitlePresent() {
        return !driver.findElements(pageTitle).isEmpty();
    }

    // Получить Y координату заголовка "Булки"
    @Step
    public int getBunsTitleYPos() {
        return driver.findElement(bunSectionTitle).getLocation().getY();
    }

    // Получить Y координату заголовка "Соусы"
    @Step
    public int getSauceTitleYPos() {
        return driver.findElement(sauceSectionTitle).getLocation().getY();
    }

    // Получить Y координату заголовка "Начинка"
    @Step
    public int getMainTitleYPos() {
        return driver.findElement(mainSectionTitle).getLocation().getY();
    }

}
