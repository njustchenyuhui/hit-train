package Purchase_cyh;

import Purchase_cyh.character.Brand;
import Purchase_cyh.character.Processor;
import Purchase_cyh.character.ProductType;
import Purchase_cyh.character.Size;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public class FindProduct {
    public static void initInventory(Inventory inventory)
    {
        Map properties1=new HashMap();
        properties1.put("Brand", Brand.HP);
        properties1.put("Processor", Processor.INTER_CORE);
        properties1.put("ProductType", ProductType.LAPTOP);
        properties1.put("Size", Size._11_INCH);
        inventory.addProduct("1",2100,new ProductSpec(properties1));

        Map properties2=new HashMap();
        properties2.put("Brand", Brand.LENOVO);
        properties2.put("Processor", Processor.INTER_CORE);
        properties2.put("ProductType", ProductType.DESKTOP);
        inventory.addProduct("2",2000,new ProductSpec(properties2));

        Map properties3=new HashMap();
        properties3.put("Brand", Brand.APPLE);
        properties3.put("Processor", Processor.INTER_I7);
        properties3.put("ProductType", ProductType.SERVER);
        properties3.put("Size", Size._14_INCH);
        inventory.addProduct("3",3000,new ProductSpec(properties3));
    }

    public static void main(String[] args) {

        Inventory inventory=new Inventory();
        initInventory(inventory);

        Map properties=new HashMap();
        properties.put("Brand", Brand.LENOVO);
        properties.put("Processor", Processor.INTER_CORE);
        properties.put("ProductType", ProductType.DESKTOP);

        ProductSpec spec=new ProductSpec(properties);
        List matchProduct=inventory.search(spec);
        if(!matchProduct.isEmpty())
        {
            System.out.println("You might like these product: ");
            for(Iterator i = matchProduct.iterator(); i.hasNext();)
            {
                Product product=(Product)i.next();
                ProductSpec productSpec=product.getSpec();
                System.out.println("we have a "+ productSpec.getProperty("ProductType")+"with the following properties");
                for(Iterator j=productSpec.getProperties().keySet().iterator();j.hasNext();)
                {
                    String propertyName=(String)j.next();
                    if(propertyName.equals("ProductType"))
                    {
                        continue;
                    }
                    System.out.println("You can have this " + productSpec.getProperty("ProductType")+"for $"+product.getPrice()+"\n----");
                }
            }
        }else{
            System.out.println("Sorry,we have nothing for you!");
        }
    }
}
