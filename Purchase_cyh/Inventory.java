package Purchase_cyh;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class Inventory {
     List<Product> productList;

     public Inventory()
     {
         productList=new LinkedList<>();
     }

     public void addProduct(String serialNum,int price, ProductSpec spec)
     {
         Product product=new Product(serialNum, price, spec);
         productList.add(product);
     }

     public Product get(String serialNum)
     {
         for(Iterator i=productList.iterator();i.hasNext();)
         {
             Product product=(Product)i.next();
             if(product.getSerialNum().equals(serialNum))
             {
                 return product;
             }
         }
         return null;
     }

     public List search(ProductSpec spec)
     {
         List matchProduct=new LinkedList();
         for(Iterator i=productList.iterator();i.hasNext();)
         {
             Product product=(Product)i.next();
             if(product.getSpec().matches(spec))
             {
                 matchProduct.add(product);
             }
         }
         return matchProduct;
     }
}
