package _2_what_are_collections.before;

import common.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionConcepts
{
    public static void main(String[] args)
    {
        var door = new Product("Wooden Door", 35);
        var floorPanel = new Product("Floor Panel", 25);
        var window = new Product("Glass Window", 10);

        Collection<Product> products = new ArrayList<>();
        products.add(door);
        products.add(floorPanel);
        products.add(window);

        System.out.println(products);
        System.out.println(products.size());  //3 - how many objects are in the ArrayList
        System.out.println(products.isEmpty());  //false -not empty, size is 3
        System.out.println(products.contains(door)); //true - door exists in products now
        System.out.println(products.remove(door)); //true - operation was complete
        System.out.println(products.contains(door)); //false - door has been removed

        var toRemove = new ArrayList<Product>(); //create new arraylist object
        toRemove.add(door);
        toRemove.add(floorPanel);

        products.removeAll(toRemove); //removes all product objects in products arraylist that match with toRemove arraylist
        System.out.println(products);

//        Iterator<Product> it = products.iterator();
//        while(it.hasNext()){
//            var product = it.next();
//            if (product.weight() > 20){
//                it.remove();
//            }
//        }
//
//        System.out.println(products);
    }
}
