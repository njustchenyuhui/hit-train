package Coffee_cyh.Condiment;

import Coffee_cyh.Drink.Drink;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public abstract class Condiment extends Drink {
    Drink drink;
    //所有的调料装饰者都必须重新实现该方法
    public abstract String getDescription();
}
