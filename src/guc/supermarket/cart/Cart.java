package guc.supermarket.cart;

import java.util.ArrayList;

import guc.supermarket.products.GroceryProduct;


public class Cart {
    private final ArrayList<GroceryProduct> products;

    public Cart() {
        products = new ArrayList<>();
    }


    public double getTotal() {
        double sum = 0.0;
        for (GroceryProduct p : products)
            sum += p.getActualPrice();

        return sum;
    }

    public ArrayList<GroceryProduct> getProducts() {
        return products;
    }


    public void addProduct(GroceryProduct p) {
        products.add(p);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (GroceryProduct product : products) {
            s.append(product.toString()).append("\n--------------------\n");
        }

        return s.toString();
    }
}
