package _4_maps.before;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ViewsOverMaps
{
    public static void main(String[] args)
    {
        var idToProduct = new HashMap<Integer, Product>();
        idToProduct.put(1, ProductFixtures.door);
        idToProduct.put(2, ProductFixtures.floorPanel);
        idToProduct.put(3, ProductFixtures.window);

//        var ids = idToProduct.keySet();
//        ids.remove(1);
//        idToProduct.remove(2);

//        System.out.println(ids);
//        System.out.println(idToProduct);

//        var products = idToProduct.values();
//        idToProduct.remove(2);
//
//        System.out.println(products);
//        System.out.println(idToProduct);

        var entries = idToProduct.entrySet();

//        for(var entry : entries){
//            System.out.println(entry);
//        }
        //iterate through map using forEach() method
//        idToProduct.forEach((k, v) -> {
//            System.out.println(k);
//            System.out.println(v);
//        });
//        var e = entries.iterator().next();
//        e.setValue(null);
//
//        System.out.println(idToProduct);

        var entry = Map.entry(1, ProductFixtures.door);
        entries.remove(entry);
        entries.add(entry);

        System.out.println(entries);
        System.out.println(idToProduct);

    }
}
