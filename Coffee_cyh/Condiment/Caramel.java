package Coffee_cyh.Condiment;

import Coffee_cyh.Drink.Drink;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public class Caramel extends Condiment{


    public Caramel(Drink drink){
        this.drink = drink;
    }

    @Override
    public String getDescription() {
        return drink.getDescription() + ",焦糖";
    }

    @Override
    public double cost() {
        return 6 + drink.cost();
    }
}
