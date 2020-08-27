package Coffee_cyh.Cup;

import Coffee_cyh.Drink.Drink;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public class Small extends Cup {

    public Small(Drink drink)
    {
        this.drink=drink;
    }

    @Override
    public String getDescription() {
        return drink.getDescription() + ",小杯";
    }

    @Override
    public double cost() {
        return drink.cost() + 2;
    }

}
