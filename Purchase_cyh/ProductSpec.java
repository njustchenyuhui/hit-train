package Purchase_cyh;

import javax.swing.text.html.HTMLDocument;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 单一职责 商品属性 进行匹配
 */
public class ProductSpec {
    private Map properties;

    public ProductSpec(Map Properties)
    {
        if(Properties==null)
        {
            this.properties=new HashMap();
        }else {
            this.properties=new HashMap(Properties);
        }
    }

    public Object getProperty(String propertyName)
    {
        return properties.get(propertyName);
    }

    public Map getProperties()
    {
        return properties;
    }

    public boolean matches(ProductSpec otherSpec)
    {
        for(Iterator i=otherSpec.getProperties().keySet().iterator();i.hasNext();)
        {
            String propertyName=(String)i.next();
            if(!properties.get(propertyName).equals(otherSpec.getProperty(propertyName)))
            {
                return false;
            }
        }
        return true;
    }
}
