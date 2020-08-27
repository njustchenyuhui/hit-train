package Coffee_cyh.Drink;

import Coffee_cyh.Drink.Drink;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public class Milk_tea extends Drink {
    public Milk_tea()
    {
        description = "奶茶";
    }

    @Override
    public double cost() {
        return 20;
    }
}
