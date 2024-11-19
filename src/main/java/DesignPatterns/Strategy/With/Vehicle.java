package DesignPatterns.Strategy.With;

import DesignPatterns.Strategy.With.Strategy.DriveStrategy;

public class Vehicle {
    DriveStrategy driveStrategy;

    Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }
    public void drive() {
        driveStrategy.drive();
    }
}
