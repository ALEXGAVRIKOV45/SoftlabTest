package pages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class MainPage {

    /*******Images*******/
    static String imgLogoSoftLab = "//span[@class='header__logotype']",

    /*******Butttons*******/
    buttonHeaderMenuItem = "//a[text()='%1$s']/parent::div[contains(@class,'menu__item')]",
            buttonMenuSearch = "//div[contains(@class,'header__menu')]/div[contains(@class,'menu__search')]";


    public static void open(String page) {
        String baseUrl = page;
        Selenide.open(baseUrl);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

}

