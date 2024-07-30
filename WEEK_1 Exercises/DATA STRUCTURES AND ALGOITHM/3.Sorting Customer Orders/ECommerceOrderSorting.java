import java.util.Arrays;
import java.util.Scanner;

// Order class
class Order {
    private String orderId;
    private String customerName;
    private double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    // Getters and setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

// Bubble Sort class
class BubbleSort {
    public static void sortOrders(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }
}

// Quick Sort class
class QuickSort {
    public static void sortOrders(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            sortOrders(orders, low, pi - 1);
            sortOrders(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }
}

// Main class
public class ECommerceOrderSorting {
    public static void main(String[] args) {
        Order[] orders = {
            new Order("1", "Alice", 250.75),
            new Order("2", "Bob", 150.30),
            new Order("3", "Charlie", 300.00),
            new Order("4", "David", 120.40),
            new Order("5", "Eve", 200.20)
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose sorting algorithm:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Quick Sort");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        switch (choice) {
            case 1:
                // Bubble Sort
                System.out.println("Sorting using Bubble Sort...");
                BubbleSort.sortOrders(orders);
                break;
            case 2:
                // Quick Sort
                System.out.println("Sorting using Quick Sort...");
                QuickSort.sortOrders(orders, 0, orders.length - 1);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("Sorted Orders:");
        for (Order order : orders) {
            System.out.println(order);
        }

        scanner.close();
    }
}
