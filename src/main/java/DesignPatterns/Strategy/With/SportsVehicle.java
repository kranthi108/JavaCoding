package DesignPatterns.Strategy.With;

import DesignPatterns.Strategy.With.Strategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle{
    SportsVehicle() {
        super(new SportsDriveStrategy());
    }
}
