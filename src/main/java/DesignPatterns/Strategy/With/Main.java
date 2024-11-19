package DesignPatterns.Strategy.With;

public class Main {
    public static void main(String[] args) {
        Vehicle bike = new SportsVehicle();
        Vehicle goods = new GoodsVehicle();
        Vehicle cycle = new NormalVehicle();
        Vehicle thar = new OffRoadVehicle();
        bike.drive();
        goods.drive();
        cycle.drive();
        thar.drive();
    }
}
