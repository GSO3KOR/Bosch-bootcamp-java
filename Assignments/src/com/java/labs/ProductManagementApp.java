import java.util.*;
import java.util.stream.Collectors;

public class ProductManagementApp {
    private static List<Product> products = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Product Management App ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View Product");
            System.out.println("5. View All Products");
            System.out.println("6. Print Statistics");
            System.out.println("7. Import Product Details");
            System.out.println("8. Export Product Details");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> updateProduct();
                case 3 -> deleteProduct();
                case 4 -> viewProduct();
                case 5 -> viewAllProducts();
                case 6 -> printStatistics();
                case 7 -> importProducts();
                case 8 -> exportProducts();
                case 9 -> running = false;
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Product Category (Mobiles/Laptops/Furnitures/Stationary): ");
        ProductType category = ProductType.valueOf(scanner.nextLine());
        System.out.print("Enter Description: ");
        String description = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        System.out.print("Is Active (true/false): ");
        boolean active = scanner.nextBoolean();

        products.add(new Product(id, category, description, price, active));
        System.out.println("Product added successfully!");
    }

    private static void updateProduct() {
        System.out.print("Enter Product ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Optional<Product> productOptional = products.stream().filter(p -> p.id == id).findFirst();

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            System.out.print("Enter New Description: ");
            String description = scanner.nextLine();
            System.out.print("Enter New Price: ");
            double price = scanner.nextDouble();
            System.out.print("Is Active (true/false): ");
            boolean active = scanner.nextBoolean();

            product.description = description;
            product.price = price;
            product.active = active;
            System.out.println("Product updated successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    private static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int id = scanner.nextInt();
        products.removeIf(product -> product.id == id);
        System.out.println("Product deleted successfully!");
    }

    private static void viewProduct() {
        System.out.print("Enter Product ID to view: ");
        int id = scanner.nextInt();
        products.stream()
                .filter(product -> product.id == id)
                .forEach(System.out::println);
    }

    private static void viewAllProducts() {
        products.forEach(System.out::println);
    }

    private static void printStatistics() {
        System.out.println("a. No of products whose price is more than 10k:");
        long count = products.stream().filter(product -> product.price > 10000).count();
        System.out.println("Count: " + count);

        System.out.println("b. No of products by category (sorted):");
        Map<ProductType, Long> categoryCount = products.stream()
                .collect(Collectors.groupingBy(product -> product.category, TreeMap::new, Collectors.counting()));
        categoryCount.forEach((category, cnt) -> System.out.println(category + ": " + cnt));

        System.out.println("c. Average price by product category:");
        Map<ProductType, Double> avgPriceByCategory = products.stream()
                .collect(Collectors.groupingBy(product -> product.category,
                        Collectors.averagingDouble(product -> product.price)));
        avgPriceByCategory.forEach((category, avg) -> System.out.println(category + ": " + avg));

        System.out.println("d. List product IDs whose product name contains given name:");
        System.out.print("Enter keyword to search: ");
        String keyword = scanner.nextLine().toLowerCase();
        products.stream()
                .filter(product -> product.description.toLowerCase().contains(keyword))
                .map(product -> product.id)
                .forEach(System.out::println);
    }

    private static void importProducts() {
        System.out.println("Import functionality not implemented.");
    }

    private static void exportProducts() {
        System.out.println("Export functionality not implemented.");
    }
}

