package DesignPatterns.Strategy.With;

import DesignPatterns.Strategy.With.Strategy.NormalDriveStrategy;
public class GoodsVehicle extends Vehicle{
    GoodsVehicle() {
        super(new NormalDriveStrategy());
    }
}
