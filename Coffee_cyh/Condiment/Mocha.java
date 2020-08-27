package Coffee_cyh.Condiment;

import Coffee_cyh.Condiment.Condiment;
import Coffee_cyh.Drink.Drink;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public class Mocha extends Condiment {


    public Mocha(Drink drink){
        this.drink = drink;
    }

    @Override
    public String getDescription() {
        return drink.getDescription() + ",摩卡";
    }

    @Override
    public double cost() {
        return 5 + drink.cost();
    }

}
