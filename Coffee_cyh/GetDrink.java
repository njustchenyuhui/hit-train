package Coffee_cyh;

import Coffee_cyh.Condiment.Caramel;
import Coffee_cyh.Condiment.Mocha;
import Coffee_cyh.Cup.Big;
import Coffee_cyh.Cup.Medium;
import Coffee_cyh.Cup.Small;
import Coffee_cyh.Drink.Coffee;
import Coffee_cyh.Drink.Drink;
import Coffee_cyh.Drink.Milk_tea;

import java.util.Scanner;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public class GetDrink {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("请选择饮料类型");
        System.out.println("1.咖啡    2.奶茶");
        Drink drink;
        switch (sc.nextInt()) {
            case 1:
                drink = new Coffee();
                break;
            case 2:
                drink = new Milk_tea();
                break;
            default:
                throw new Exception("错误");
        }

        System.out.println("请选择杯型");
        System.out.println("1. 小杯    2.中杯    3.大杯");
        switch (sc.nextInt()) {
            case 1:
                drink = new Small(drink);
                break;
            case 2:
                drink = new Medium(drink);
                break;
            case 3:
                drink = new Big(drink);
                break;
            default:
                throw new Exception("错误");
        }

        System.out.println("请选择调料");
        System.out.println("1. 焦糖    2.摩卡");
        switch (sc.nextInt()) {
                case 1:
                    drink = new Caramel(drink);
                    break;
                case 2:
                    drink = new Mocha(drink);
                    break;
                default:
        }

        double price = drink.cost();
        System.out.println("您选择的饮料：" + drink.getDescription()+ "价格为：" + price + "元！");

    }

}
