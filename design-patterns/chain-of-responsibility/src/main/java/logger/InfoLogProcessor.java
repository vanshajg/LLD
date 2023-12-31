package logger;

public class InfoLogProcessor extends LogProcessor {
    public InfoLogProcessor(LogProcessor next) {
        super(next);
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        if (logLevel == LogLevel.INFO) {
            System.out.println("INFO: " + message);
        } else {
            super.log(logLevel, message);
        }
    }

}
