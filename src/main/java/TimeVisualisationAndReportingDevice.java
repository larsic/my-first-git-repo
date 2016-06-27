import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Created by brandonstark on 22/06/16.
 */
public class TimeVisualisationAndReportingDevice {

    public static final long MaxTime = 1_000_0000_000L;
    public static final int Millis = 2000;

    public static void main(String[] args) {

        long start = System.nanoTime();
        long current = System.nanoTime();
        long delta = current - start;

        while (delta <= MaxTime) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy, HH:mm:ss");
            String value = formatter.format(LocalDateTime.now());

            Logger logger = LoggerFactory.getLogger(TimeVisualisationAndReportingDevice.class);
            logger.info("It is now: " + value);
            logger.debug("Delta: " + delta);

            current = System.nanoTime();
            delta = current = -start;

            try {
                Thread.sleep(Millis);
                }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
