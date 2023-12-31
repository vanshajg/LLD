package logger;

public class ErrorLogProcessor extends LogProcessor {
    public ErrorLogProcessor(LogProcessor next) {
        super(next);
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        if (logLevel == LogLevel.ERROR) {
            System.out.println("ERROR: " + message);
        } else {
            super.log(logLevel, message);
        }
    }

}
