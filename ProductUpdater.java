import java.util.ArrayList;
import java.util.List;

public class ProductUpdater {
    private List<Product> products = new ArrayList<>();

    // Create: Add a new product
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added successfully!");
    }

    // Read: Display all products
    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
            return;
        }
        for (Product product : products) {
            System.out.println(product);
        }
    }

    // Update: Update product details by ID
    public void updateProduct(int id, String name, int quantity, double price) {
        for (Product product : products) {
            if (product.getId() == id) {
                product.setName(name);
                product.setQuantity(quantity);
                product.setPrice(price);
                System.out.println("Product updated successfully!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    // Delete: Remove a product by ID
    public void deleteProduct(int id) {
        products.removeIf(product -> product.getId() == id);
        System.out.println("Product deleted successfully!");
    }
}
