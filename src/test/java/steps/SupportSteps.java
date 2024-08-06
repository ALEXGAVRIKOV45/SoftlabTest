package steps;

import io.cucumber.java.bg.И;
import utils.Sleep;

public class SupportSteps extends BaseSteps {

    @И("шаг №{int}")
    public void step(int step)  {
        logger.info("Шаг № {}",step);
    }

    @И("подождать {int} сек")
    public void waitSeconds(int timeout) {
        Sleep.pauseSec(timeout);
    }
}
