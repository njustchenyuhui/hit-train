package Coffee_cyh.Drink;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public abstract class Drink {
    //描述
    String description = "Unknown Drink";

    public String getDescription(){
        return description;
    }

    //价格
    public abstract double cost();
}
