package DesignPatterns.ChainOfResponsibility;

public class InfoLogProcessor extends LogProcessor {
    public InfoLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }
    public void log(int logLevel, String message) {
        if (logLevel == LogProcessor.INFO) {
            System.out.println(message);
        }
        else {
            super.log(logLevel, message);
        }
    }
}
