package steps;

import io.cucumber.java.bg.И;
import utils.Sleep;
import utils.WebActions;

public class SupportSteps extends BaseSteps {

    @И("шаг №{int}")
    public void step(int step) {
        logger.info("Шаг № {}", step);
    }

    @И("подождать {int} сек")
    public void waitSeconds(int timeout) {
        Sleep.pauseSec(timeout);
        logger.info("Ожидание {} сек", timeout);
    }

    @И("переключиться на следующую вкладку")
    public void switchNextTab() {
        WebActions.switchToNextTab(null);
        logger.info("Переключение на следующую вкладку");
    }

    @И("закрыть текущую вкладку и перейти на предыдущую")
    public void closeTabAndSwitchTab() {
        WebActions.closeCurrentTabAndSwitchToPrevious();
        logger.info("Вкладка закрыта");
    }
}
