package guc.supermarket.products;


public abstract class GroceryProduct {
    private String name;
    private double price, discount;

    public GroceryProduct(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public final double getActualPrice() {
        double discount_price = price * discount / 100;
        return price - discount_price;
    }

    public String toString() {
        return "name: " + name + "\n" +
                "Price: " + price + "\n" +
                "Discount: " + discount + "\n";
    }


    public final String getName() {
        return name;
    }

    public final double getDiscount() {
        return discount;
    }

    public final double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public boolean equals(Object o) {
        if (o instanceof GroceryProduct) {
            GroceryProduct p = (GroceryProduct) o;
            return this.name.equals(p.name) &&
                    this.price == p.price &&
                    this.discount == p.discount;
        } else {
            return false;
        }
    }

    public abstract boolean refrigerate();

}
