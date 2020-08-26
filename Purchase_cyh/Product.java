package Purchase_cyh;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public class Product {
    private String serialNum;
    private int price;
    private ProductSpec spec;

    public Product(String serialNum,int price,ProductSpec spec)
    {
        this.serialNum=serialNum;
        this.price=price;
        this.spec=spec;
    }

    public String getSerialNum()
    {
        return serialNum;
    }

    public void setPrice(int price)
    {
        this.price=price;
    }

    public int getPrice()
    {
        return price;
    }

    public ProductSpec getSpec()
    {
        return spec;
    }
}
