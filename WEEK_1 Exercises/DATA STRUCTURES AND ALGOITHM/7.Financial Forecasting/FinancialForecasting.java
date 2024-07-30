import java.util.Scanner;

public class FinancialForecasting {

    // Method to calculate future value using recursion
    public static double calculateFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    // Optimized method to calculate future value using memoization
    public static double calculateFutureValueMemo(double currentValue, double growthRate, int years, double[] memo) {
        if (years == 0) {
            return currentValue;
        }
        if (memo[years] != 0) {
            return memo[years];
        }
        memo[years] = calculateFutureValueMemo(currentValue * (1 + growthRate), growthRate, years - 1, memo);
        return memo[years];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input for current value, growth rate, and years
        System.out.print("Enter the current value: ");
        double currentValue = scanner.nextDouble();

        System.out.print("Enter the annual growth rate (e.g., 0.05 for 5%): ");
        double growthRate = scanner.nextDouble();

        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();

        // Calculating future value using recursion
        double futureValue = calculateFutureValue(currentValue, growthRate, years);
        System.out.printf("Future Value (Recursive): %.2f%n", futureValue);

        // Calculating future value using optimized recursion with memoization
        double[] memo = new double[years + 1];
        double futureValueMemo = calculateFutureValueMemo(currentValue, growthRate, years, memo);
        System.out.printf("Future Value (Memoization): %.2f%n", futureValueMemo);

        scanner.close();
    }
}
