package _4_maps.before;

import java.util.HashMap;

public class AdvancedOperations
{
    public static void main(String[] args)
    {
        var defaultProduct = new Product(-1, "Whatever the customer wants", 100);

        var idToProduct = new HashMap<Integer, Product>();
        idToProduct.put(1, ProductFixtures.door);
        idToProduct.put(2, ProductFixtures.floorPanel);
        idToProduct.put(3, ProductFixtures.window);


        System.out.println(idToProduct.getOrDefault(10, defaultProduct));
        System.out.println(idToProduct.get(10)); //will give null since nothing exist at 10

        idToProduct.replaceAll((key, oldProduct) ->
                new Product(
                        oldProduct.getId(),
                        oldProduct.getName(),
                        oldProduct.getWeight() + 10));


        var result = idToProduct.computeIfAbsent(1 , key ->

            new Product(key, "Unknown Product", 100));


    }
}
