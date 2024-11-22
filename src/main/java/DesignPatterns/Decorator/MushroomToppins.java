package DesignPatterns.Decorator;

public class MushroomToppins extends ToppingDecorator{
    BasePizza basePizza;
    MushroomToppins(BasePizza basePizza) {
        this.basePizza = basePizza;
    }
    @Override
    public int cost() {
        return basePizza.cost() + 10;
    }
}
