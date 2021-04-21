package guc.supermarket.products;

public class Beverage extends GroceryProduct {
    private SugarLevel sugarLevel;

    public Beverage(String name, double price, double discount, SugarLevel level) {
        super(name, price, discount);
        this.sugarLevel = level;
    }


    public void setSugarLevel(SugarLevel sugarLevel) {
        this.sugarLevel = sugarLevel;
    }

    public SugarLevel getSugarLevel() {
        return sugarLevel;
    }

    public final double getActualPrice(double extra) {
        double price = this.getPrice();
        double discount = this.getDiscount();

        return price - price * ((discount + extra) / 100);
    }


    public String toString() {
        return super.toString() + "Sugar level: " + sugarLevel;
    }

    public boolean equals(Object o) {
        if (o instanceof Beverage) {
            Beverage b = (Beverage) o;
            return super.equals(o) && this.sugarLevel == b.sugarLevel;
        } else {
            return false;
        }
    }

    public boolean refrigerate() {
        return false;
    }
}
