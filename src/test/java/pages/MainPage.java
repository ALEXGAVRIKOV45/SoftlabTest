package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebElement;


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
            "|//div[text()='%1$s']/ancestor::li" +
            "|//li[a[text()='%1$s']]",
    //            /parent::div[contains(@class,'menu__item')]
    buttonMenuSearch = "//div[contains(@class,'header__menu')]/div[contains(@class,'menu__search')]",

    /*******Blocks*******/

    blocks = "//div[contains(@class,'header__menu')]/div[contains(@class,'menu__search')]",
    blockHeader = "//header";


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
        else
            return $$x(format(blocks, name)).first().shouldBe(visible);
    }
}

