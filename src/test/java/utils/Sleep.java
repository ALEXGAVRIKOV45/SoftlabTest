package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Sleep {
    public static final Logger logger = LoggerFactory.getLogger(Sleep.class);

    public Sleep() {
    }

    public static void pauseSec(double sec) {
        logger.info("Ожидание {} секунд", sec);
        sleep(sec * 1000.0);
    }

    public static void sleep(double ms) {
        try {
            TimeUnit.MILLISECONDS.sleep((long) ms);
        } catch (InterruptedException var3) {
            var3.printStackTrace();
        }
    }
}
