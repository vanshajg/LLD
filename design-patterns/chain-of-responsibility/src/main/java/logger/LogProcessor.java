package logger;

public abstract class LogProcessor {
    private final LogProcessor next;

    public LogProcessor(LogProcessor next) {
        this.next = next;
    }

    public void log(LogLevel logLevel, String message) {
        if (next != null) {
            next.log(logLevel, message);
        }
    }
}
