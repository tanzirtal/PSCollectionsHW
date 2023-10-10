package _3_lists.before;

import common.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Shipment implements Iterable<Product>
{
    //if something is not within the List<> index, console will return -1
    //Creating this constant as a check
    private static final int MISSING_PRODUCT = -1;

    private static final int LIGHT_VAN_MAX_WEIGHT = 20;

    private final List<Product> products = new ArrayList<>();
    private List<Product> lightVanProducts;
    private List<Product> heavyVanproducts;

    public void add(Product product)
    {
        products.add(product);
    }

    public boolean replace(Product oldProduct, Product newProduct)
    {
        //this implementation of replace only replaces the first index
//        //local variable gets assigned to index of oldProduct
//        int position = products.indexOf(oldProduct);
//        //this checks if the product is within the list because the interface returns -1 when something isn't in the list
//        if (position == MISSING_PRODUCT){
//            return false;
//        } else {
//            //sets position of newProduct to be that of oldProduct's (removes each index from oldProduct, replaces with newProduct index)
//            products.set(position, newProduct);
//        }
//            return true;

        //same thing as above, but if oldProduct is in the shipment more than once, this will remove all of them
//        boolean update = products.contains(oldProduct);
//        if (update){
//           products.replaceAll(product -> {
//                product == oldProduct ? newProduct : product)
//        }
//        products.replaceAll(product -> {
//                product == oldProduct ? newProduct : product); //ternary operator to replace if-statement
//            if (product == oldProduct){
//                return newProduct;
//            } else {
//                return product;
//            }
//        });

        return true;
    }

    public void prepare()
    {
        //sort the product list
        products.sort(Product.BY_WEIGHT);

        //find the split point - lightest product that can go into the heavy van
        int splitPoint = findSplitPoint();

        //create two subviews of the list
        lightVanProducts = products.subList(0, splitPoint);
        heavyVanproducts = products.subList(splitPoint, products.size());

    }

    private int findSplitPoint() {
        int size = products.size();
        for(int i = 0; i < size; i++){
            var product = products.get(i);
            if (product.weight() > LIGHT_VAN_MAX_WEIGHT){
                return i;
            }
        }
        return products.size();
    }

    public List<Product> getHeavyVanProducts()
    {
        return heavyVanproducts;
    }

    public List<Product> getLightVanProducts()
    {
        return lightVanProducts;
    }

    public Iterator<Product> iterator()
    {
        return products.iterator();
    }

    public boolean stripHeavyProducts()
    {
        return products.removeIf(
                product -> product.weight() > LIGHT_VAN_MAX_WEIGHT);
    }
}
