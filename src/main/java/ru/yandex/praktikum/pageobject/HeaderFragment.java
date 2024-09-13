package ru.yandex.praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HeaderFragment {

    private WebDriver driver;

    // Конструктор
    public HeaderFragment(WebDriver driver) {
        this.driver = driver;
    }

    // Кнопка "Личный кабинет"
    private By profileButton = new By.ByXPath(".//a[@class='AppHeader_header__link__3D_hX' and @href='/account']");

    // Кнопка "Конструктор"
    private By constructorButton = new By.ByXPath(".//ul[@class='AppHeader_header__list__3oKJj']/li[1]");

    // Логотип Stellar Burgers
    private By logo = new By.ByClassName("AppHeader_header__logo__2D0X2");

    // Клик по кнопке "Личный кабинет"
    @Step
    public void clickProfileButton() {
        List<WebElement> overlays = driver.findElements(By.cssSelector(".Modal_modal_overlay__x2ZCr"));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfAllElements(overlays));
        driver.findElement(profileButton).click();
    }

    // Клик по кнопке "Конструктор"
    @Step
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    // Клик по логотипу Stellar Burgers
    @Step
    public void clickLogo() {
        List<WebElement> overlays = driver.findElements(By.cssSelector(".Modal_modal_overlay__x2ZCr"));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfAllElements(overlays));
        driver.findElement(logo).click();
    }



}
