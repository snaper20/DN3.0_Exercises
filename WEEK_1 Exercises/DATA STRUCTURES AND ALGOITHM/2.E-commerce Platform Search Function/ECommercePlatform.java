import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// Product class
class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    // Getters and setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

// Linear search class
class LinearSearch {
    public static Product linearSearch(Product[] products, String searchTerm) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(searchTerm) || 
                product.getProductId().equalsIgnoreCase(searchTerm) || 
                product.getCategory().equalsIgnoreCase(searchTerm)) {
                return product;
            }
        }
        return null;
    }
}

// Binary search class
class BinarySearch {
    public static void sortProducts(Product[] products) {
        Arrays.sort(products, Comparator.comparing(Product::getProductName));
    }

    public static Product binarySearch(Product[] products, String searchTerm) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Product midProduct = products[mid];
            int compareResult = midProduct.getProductName().compareToIgnoreCase(searchTerm);

            if (compareResult == 0) {
                return midProduct;
            } else if (compareResult < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}

// Main class
public class ECommercePlatform {
    public static void main(String[] args) {
        Product[] products = {
            new Product("1", "Laptop", "Electronics"),
            new Product("2", "Smartphone", "Electronics"),
            new Product("3", "Desk Chair", "Furniture"),
            new Product("4", "Keyboard", "Electronics"),
            new Product("5", "Book", "Books")
        };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter search term: ");
        String searchTerm = scanner.nextLine();

        // Linear search
        Product foundProductLinear = LinearSearch.linearSearch(products, searchTerm);
        if (foundProductLinear != null) {
            System.out.println("Product found using linear search: " + foundProductLinear);
        } else {
            System.out.println("Product not found using linear search.");
        }

        // Sort products for binary search
        BinarySearch.sortProducts(products);

        // Binary search
        Product foundProductBinary = BinarySearch.binarySearch(products, searchTerm);
        if (foundProductBinary != null) {
            System.out.println("Product found using binary search: " + foundProductBinary);
        } else {
            System.out.println("Product not found using binary search.");
        }

        scanner.close();
    }
}
