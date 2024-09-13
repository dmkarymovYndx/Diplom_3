import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.praktikum.pageobject.*;

public class ConstructorPageTests extends BaseTest {

    // значение 243 высоты заголовка выбранного раздела получено опытным путём
    int ingredientTitleYPos = 243;

    @Test
    @DisplayName("Check if Sauces button click scrolls to Sauces section")
    public void clickSaucesButtonScrollsToSaucesSection() throws InterruptedException {

        ConstructorPage objConstructorPage = new ConstructorPage(driver);

        objConstructorPage.clickSauceSectionButton();
        Thread.sleep(4000);
        int actualIngredientTitleYPos = objConstructorPage.getSauceTitleYPos();
        Assert.assertEquals("Ошибка: не было перехода к разделу \"Соусы\"", ingredientTitleYPos, actualIngredientTitleYPos);

    }

    @Test
    @DisplayName("Check if Main button click scrolls to Main section")
    public void clickMainButtonScrollsToSaucesSection() throws InterruptedException {

        ConstructorPage objConstructorPage = new ConstructorPage(driver);

        objConstructorPage.clickMainSectionButton();
        Thread.sleep(4000);
        int actualIngredientTitleYPos = objConstructorPage.getMainTitleYPos();
        Assert.assertEquals("Ошибка: не было перехода к разделу \"Начинка\"", ingredientTitleYPos, actualIngredientTitleYPos);

    }

    @Test
    @DisplayName("Check if Buns button click scrolls to Buns section")
    public void clickBunsButtonScrollsToSaucesSection() throws InterruptedException {

        ConstructorPage objConstructorPage = new ConstructorPage(driver);

        objConstructorPage.clickSauceSectionButton();
        Thread.sleep(4000);
        objConstructorPage.clickBunsSectionButton();
        Thread.sleep(4000);
        int actualIngredientTitleYPos = objConstructorPage.getBunsTitleYPos();
        Assert.assertEquals("Ошибка: не было перехода к разделу \"Булки\"", ingredientTitleYPos, actualIngredientTitleYPos);

    }

}
