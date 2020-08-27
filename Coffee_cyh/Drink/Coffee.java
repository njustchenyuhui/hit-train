package Coffee_cyh.Drink;

import Coffee_cyh.Drink.Drink;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public class Coffee extends Drink {
    public Coffee(){
        description = "咖啡";
    }

    @Override
    public double cost() {
        return 10;
    }

}
