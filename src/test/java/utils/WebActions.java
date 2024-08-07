package utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WebActions {
    public static WebDriver getDriver() {
        return WebDriverRunner.getWebDriver();
    }
    public static void switchToNextTab(Integer tabNumber) {
        List<String> handles = new ArrayList<>(getDriver().getWindowHandles());
        tabNumber = tabNumber == null ? handles.size() - 1 : tabNumber - 1;
        Selenide.switchTo().window(handles.get(tabNumber));
        Selenide.sleep(1000);
    }

    public static void closeCurrentTabAndSwitchToPrevious() {
        Selenide.closeWindow();
        List<String> handles = new ArrayList<>(getDriver().getWindowHandles());
        Selenide.switchTo().window(handles.get(handles.size() - 1));
        Selenide.sleep(1000);
    }
}
