package steps;

import io.cucumber.java.bg.И;

public class SupportSteps extends BaseSteps {

    @И("шаг №{int}")
    public void step(int step)  {
        logger.info("Шаг № {}",step);
    }
}
