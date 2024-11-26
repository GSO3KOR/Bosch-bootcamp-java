import java.util.function.Function;
import java.util.stream.Collectors;

enum ProductType {
    Mobiles, Laptops, Furnitures, Stationary
}

class Product {
    int id;
    ProductType category;
    String description;
    double price;
    boolean active;

    public Product(int id, ProductType category, String description, double price, boolean active) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.price = price;
        this.active = active;
    }

    @Override
    public String toString() {
        return "Product [ID=" + id + ", Category=" + category + ", Description=" + description
                + ", Price=" + price + ", Active=" + active + "]";
    }
}
