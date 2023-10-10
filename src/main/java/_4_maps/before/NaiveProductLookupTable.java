package _4_maps.before;

import java.util.ArrayList;
import java.util.List;

public class NaiveProductLookupTable implements ProductLookupTable
{
    private final List<Product> products = new ArrayList<>();

    @Override
    public void addProduct(final Product productToAdd){

        //linear scan, will become slower as more items get added
        for(var product: products){
            if (product.getId() == productToAdd.getId()){
                throw new IllegalArgumentException(
                        "Unable to add product, " +
                                "duplicate id for " + product);
            }
        }

        products.add(productToAdd);
    }

    @Override
    public Product lookupById(final int id)
    {
        //linear scan, will become slower as more items get added
        for(var product : products){
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }

    @Override
    public void clear()
    {
    }
}
