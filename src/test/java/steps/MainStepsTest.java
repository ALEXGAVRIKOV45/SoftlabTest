package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.ConfigManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.И;
import org.junit.jupiter.api.Assertions;

import pages.MainPage;

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
}
