package _7_sets.before;

import common.Product;
import common.Supplier;

import java.util.*;

public class ProductCatalogue implements Iterable<Product>
{

    private final Set<Product> products = new HashSet<>();

    public void addSupplier(final Supplier supplier)
    {
        products.addAll(supplier.getProducts());
    }

    @Override
    public Iterator<Product> iterator()
    {
        return null;
    }
}
