package logger;

public class DebugLogProcessor extends LogProcessor {
    public DebugLogProcessor(LogProcessor next) {
        super(next);
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        if (logLevel == LogLevel.DEBUG) {
            System.out.println("DEBUG: " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}
