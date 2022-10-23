import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackTest {
    public static final Logger logger = LoggerFactory.getLogger(LogbackTest.class);

    @Test
    public void test () {
        logger.info("info");
        logger.warn("warning");
        logger.error("error");
        logger.debug("debug");
//        logger.trace("trace");
    }
}
