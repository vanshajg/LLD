import logger.DebugLogProcessor;
import logger.ErrorLogProcessor;
import logger.InfoLogProcessor;
import logger.LogLevel;
import logger.LogProcessor;

public class LogProcessorApplication {
    public static void main(String[] args) {
        LogProcessor logProcessor = new ErrorLogProcessor(new InfoLogProcessor(new DebugLogProcessor(null)));
        logProcessor.log(LogLevel.DEBUG, "Debug message");
    }
}
