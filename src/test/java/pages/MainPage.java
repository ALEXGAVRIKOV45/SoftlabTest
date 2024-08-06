package pages;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static com.codeborne.selenide.Condition.attributeMatching;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;


public class MainPage {

    /*******Images*******/
    public static String imgLogoSoftLab = "//span[@class='header__logotype']",

    /*******Butttons*******/
    buttons = "//a[text()='%1$s']" +
            "|//span[text()='%1$s']" +
            "|//div[text()='%1$s']/ancestor::li",

    buttonMenuSearch = "//div[contains(@class,'header__menu')]/div[contains(@class,'menu__search')]",

    /*******Blocks*******/

    blocks = "//*[contains(text(),'%1$s')]/ancestor::div[@class='container']",
            blockHeader = "//header",
            blockFooter = "//footer",

            /******* Cards ********/

            cardVendor = "//a[@class='import-item js-item']";
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
        return $$x(cardVendor);
    }
}

