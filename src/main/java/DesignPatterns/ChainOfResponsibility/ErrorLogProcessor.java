package DesignPatterns.ChainOfResponsibility;

public class ErrorLogProcessor extends LogProcessor {
    ErrorLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }
    public void log(int logLevel, String message) {
        if (logLevel == LogProcessor.ERROR) {
            System.out.println(message);
        }
        else {
            super.log(logLevel, message);
        }
    }
}
