package DesignPatterns.ChainOfResponsibility;

public class Main {
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
//        logProcessor.log(LogProcessor.DEBUG, "Debug message");
//        logProcessor.log(LogProcessor.INFO, "Info message");
//        logProcessor.log(LogProcessor.ERROR, "Error message");
        LogProcessor logProcessor1 = new DebugLogProcessor(new InfoLogProcessor(null));
        logProcessor1.log(LogProcessor.INFO, "error");
    }
}
