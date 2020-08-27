package Coffee_cyh.Cup;

import Coffee_cyh.Drink.Drink;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public abstract class Cup extends Drink{
    Drink drink;
    @Override
    public abstract String getDescription();
}
