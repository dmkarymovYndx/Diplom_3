import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.yandex.praktikum.pageobject.ConstructorPage;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    ChromeOptions chromeOptions = new ChromeOptions().addArguments(
            "--no-sandbox", "--headless", "--disable-dev-shm-usage");

    FirefoxOptions firefoxOptions = new FirefoxOptions().addArguments(
            "--headless", "--disable-dev-shm-usage");

    private WebDriver getDriver(String driverType) {
        switch (driverType) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(chromeOptions);
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(firefoxOptions);
            default:
                throw new IllegalArgumentException("Driver type is not supported");
        }
    }

    @Before
    public void start() {

        String driverType = System.getenv("WEB_DRIVER");
        driver = getDriver(driverType == null ? "chrome" : driverType);

        driver.get(ConstructorPage.URL);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
