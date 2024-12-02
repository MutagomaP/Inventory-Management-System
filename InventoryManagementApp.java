import java.util.Scanner;

public class InventoryManagementApp {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nInventory Management System:");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. View Product by ID");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add product
                    System.out.print("Enter product name: ");
                    String name = scanner.next();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    productDAO.addProduct(new Product(0, name, quantity, price));
                    break;
                case 2:
                    // View all products
                    productDAO.getAllProducts().forEach(System.out::println);
                    break;
                case 3:
                    // Update product
                    System.out.print("Enter product ID to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new name: ");
                    String newName = scanner.next();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    productDAO.updateProduct(new Product(updateId, newName, newQuantity, newPrice));
                    break;
                case 4:
                    // Delete product
                    System.out.print("Enter product ID to delete: ");
                    int deleteId = scanner.nextInt();
                    productDAO.deleteProduct(deleteId);
                    break;
                case 5:
                    // View product by ID
                    System.out.print("Enter product ID to view: ");
                    int productId = scanner.nextInt();
                    Product product = productDAO.getProductById(productId);
                    if (product != null) {
                        System.out.println("Product found: " + product);
                    } else {
                        System.out.println("Product not found with ID: " + productId);
                    }
                    break;
                case 6:
                    // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
