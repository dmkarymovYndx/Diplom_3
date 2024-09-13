package ru.yandex.praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProfilePage {

    private WebDriver driver;

    // Конструктор
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    // Кнопка "Выход"
    private By logoutButton = new By.ByXPath(".//button[contains(@class, 'Account_button__14Yp3')]");

    // Поле "Имя"
    private By nameField = new By.ByXPath(".//ul[@class='Profile_profileList__3vTor']/li[1]/div/div/input");

    // Описание раздела
    private By description = new By.ByXPath(".//p[contains(@class, 'Account_text__fZAIn')]");

    // Клик по кнопке "Выход"
    @Step
    public void clickLogoutButton() {
        List<WebElement> overlays = driver.findElements(By.cssSelector(".Modal_modal_overlay__x2ZCr"));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfAllElements(overlays));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(logoutButton)).click();
    }

    // Получить текст из поля "Имя"
    @Step
    public String getName() {
        return driver.findElement(nameField).getAttribute("value");
    }

    // Проверка, что на странице есть описание раздела
    public boolean isDescriptionPresent() {
        return !driver.findElements(description).isEmpty();
    }

}
