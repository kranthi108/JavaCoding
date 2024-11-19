package DesignPatterns.Strategy.With.Strategy;

public class SportsDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Sport drive capability");
    }
}
