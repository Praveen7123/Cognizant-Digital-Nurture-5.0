import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {

    // one logger for this class
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        // Exercise 1: error and warning messages
        logger.error("This is an error message");
        logger.warn("This is a warning message");

        logger.info("This is an info message");

        // logging with values inside the message
        String user = "Praveen";
        logger.warn("User {} did something wrong", user);
    }
}
