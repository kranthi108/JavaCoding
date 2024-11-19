package DesignPatterns.Strategy.With;

import DesignPatterns.Strategy.With.Strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle{
    OffRoadVehicle() {
        super(new SportsDriveStrategy());
    }
}
