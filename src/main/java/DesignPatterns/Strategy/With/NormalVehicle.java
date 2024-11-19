package DesignPatterns.Strategy.With;

import DesignPatterns.Strategy.With.Strategy.NormalDriveStrategy;

public class NormalVehicle extends Vehicle{
    NormalVehicle() {
        super(new NormalDriveStrategy());
    }
}
