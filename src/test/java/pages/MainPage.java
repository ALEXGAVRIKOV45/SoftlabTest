package pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;


public class MainPage {

    /*******Images*******/
    public static String imgLogoSoftLab = "//*[@class='header__logotype']",

    /*******Butttons*******/
    buttons = "//a[text()='%1$s']" +
            "|//span[text()='%1$s']" +
            "|//div[text()='%1$s']/ancestor::li",
buttonLogoType = "//a[@class='header__logotype']",
    buttonMenuSearch = "//div[contains(@class,'header__menu')]/div[contains(@class,'menu__search')]",

    /*******Blocks*******/

    blocks = "//*[contains(text(),'%1$s')]/ancestor::div[@class='container']",
            blockHeader = "//header",
            blockFooter = "//footer",

    /******* Cards ********/

    cards = "//a[@class='import-item js-item']" +
            "|//h3[contains(text(),'%1$s')]/ancestor::a[@class='card']" +
            "|//a[@class = 'products-documentation__card' and div[normalize-space(translate(string(text()), '\t\n\r ', '    '))= '%1$s']]",

    /******* Text ********/
    texts = "//*[contains(text(),'%1$s')]";

    @Step("Открыть страницу сервиса")
    public void openBrowser(String url) {
        Selenide.open(url);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }


    public SelenideElement getImageElement(String name) {
        if (name.equalsIgnoreCase("Логотип компании"))
            return $x(imgLogoSoftLab).shouldBe(visible);
        else if (name.equalsIgnoreCase("Иконка поиска по сайту"))
            return $x(buttonMenuSearch).shouldBe(Condition.visible);

        return null;
    }

    public SelenideElement getFirstButtonName(String name) {
        if (name.equalsIgnoreCase("Иконка поиска по сайту"))
            return $x(buttonMenuSearch).shouldBe(visible);
        else if (name.equalsIgnoreCase("Логотип компании"))
            return $x(imgLogoSoftLab).shouldBe(visible);
        else
            return $$x(format(buttons, name)).first().shouldBe(visible);
    }

    public SelenideElement getFirstBlockName(String name) {
        if (name.equalsIgnoreCase("Шапка"))
            return $x(blockHeader).shouldBe(visible);
        else if (name.equalsIgnoreCase("Подвал"))
            return $x(blockFooter).shouldBe(visible);
        else
            return $$x(format(blocks, name)).first().shouldBe(visible);
    }

    public ElementsCollection getAllCards() {
        return $$x(cards);
    }

    public SelenideElement getFirstText(String text) {
        return $$x(format(texts, text)).first().shouldBe(visible);
    }

    public SelenideElement getFirstCardName(String name) {
        return $$x(format(cards, name)).first().shouldBe(visible);
    }
}

