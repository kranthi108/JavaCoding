package DesignPatterns.Strategy.Without;

public class Main {
    public static void main(String[] args) {
        Vehicle bike = new SportsVehicle();
        Vehicle goods = new GoodsVehicle();
        Vehicle pass = new PassengerVehicle();
        Vehicle thar = new OffRoadVehicle();
        bike.drive();
        goods.drive();
        pass.drive();
        thar.drive();
    }
}
