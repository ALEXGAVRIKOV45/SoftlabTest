package steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import config.ConfigManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.И;
import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static java.lang.String.format;

public class MainStepsTest extends BaseSteps {
    private MainPage mainPage;

    public MainStepsTest() {
        mainPage = new MainPage();
    }

    String baseUrl = ConfigManager.TEST_CONFIG.baseUrl();

    @И("открыть станицу сервиса")
    public void openBaseUrl() {
        mainPage.openBrowser(baseUrl);
        logger.info(format("Открыта страница сервиса"));
    }

    @И("проверить что {string} присутствует")
    public void checkElementVisible(String name) {
        SelenideElement element = mainPage.getImageElement(name);
        Assertions.assertTrue(element.isDisplayed());
        logger.info("Элемент {} присутствует", name);
    }
    @И("проверить что присутствуют кнопки:")
    public void checkButtonsIsDisplay(DataTable dataTable) {
        dataTable.asList().forEach(this::checkButtonVisible);
//        logger.info("Кнопки присутствуют");
    }

    @И("проверить что кнопка {string} присутствует")
    public void checkButtonVisible(String name) {
        SelenideElement firstButtonName = mainPage.getFirstButtonName(name);
        Assertions.assertTrue(firstButtonName.isDisplayed());
        logger.info("Кнопка {} присутствует", name);
    }

    @И("навести курсор на кнопку {string}")
    public void hoverMouseOnButton(String name) {
        SelenideElement firstButtonName = mainPage.getFirstButtonName(name);
        firstButtonName.hover();
        logger.info("Наведен курсор мыши на кнопку {}", name);
    }

    @И("нажать кнопку {string}")
    public void pressButton(String name) {
        SelenideElement firstButtonName = mainPage.getFirstButtonName(name);
        firstButtonName.click();
        logger.info("Нажата кнопка {}", name);
    }

    @И("проверить что блок {string} присутствует")
    public void checkBlockExist(String name) {
        SelenideElement firstBlockName = mainPage.getFirstBlockName(name);
        Assertions.assertTrue(firstBlockName.isDisplayed());
        logger.info("Блок {} присутствует", name);
    }

    @И("проверить что кнопка {string} нажата")
    public void checkButtonActive(String name) {
        SelenideElement firstButtonName = mainPage.getFirstButtonName(name);
        firstButtonName.shouldBe(attributeMatching("class", "current"));
        logger.info("Кнопка {} нажата", name);
    }

    @И("проверить что url содержит {string}")
    public void currentUrlContains(String url) {
        WebDriver driver = WebDriverRunner.getWebDriver();
        boolean result = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains(url));
        Assertions.assertTrue(result, String.format(driver.getCurrentUrl(), url));
        logger.info("Текущий url '{}' содержит текст '{}'", driver.getCurrentUrl(), url);
    }

    @И("проверить что в блоке присутствуют {int} плашек")
    public void checkAllCards(int count) {
        mainPage.getAllCards().filter(visible).should(CollectionCondition.size(count));
        logger.info("Блок содержит {} плашек", count);
    }

    @И("проверить что цвет {string} кнопки {string} {string}")
    public void checkBackColorButton(String element,String name, String color) {
        String propertyName = null;
        String propertyColor = null;
        SelenideElement firstButtonName = mainPage.getFirstButtonName(name);
        if (element.equalsIgnoreCase("фона"))
            propertyName = "background-color";
        else if (element.equalsIgnoreCase("текста"))
            propertyName = "color";
        if (color.equalsIgnoreCase("черный"))
            propertyColor = "rgba(43, 43, 43, 1)";
        else if (color.equalsIgnoreCase("белый"))
            propertyColor = "rgba(255, 255, 255, 1)";
        firstButtonName.shouldHave(cssValue(propertyName,propertyColor));
        logger.info("Цвет {} кнопки '{}' {}", element, name, color);
    }
}
