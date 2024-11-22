package DesignPatterns.Decorator;

public class Pizza {
    public static void main(String[] args) {
        BasePizza pizza = new ExtraCheese(new Margaritta());
        System.out.println("the price of margarita with extracheese is " + pizza.cost());
    }
}
