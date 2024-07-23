public class MethodOverloadingDemo {
    public static void main(String[] args) {
        MethodOverloadingDemo demo = new MethodOverloadingDemo();

        // Calling the overloaded methods
        System.out.println("The sum of two integers: " + demo.sum(10, 20));
        System.out.println("The sum of three integers: " + demo.sum(10, 20, 30));
        System.out.println("The sum of two doubles: " + demo.sum(10.5, 20.5));
    }

    // Method to sum two integers
    public int sum(int x, int y) {
        return x + y;
    }

    // Overloaded method to sum three integers
    public int sum(int x, int y, int z) {
        return x + y + z;
    }

    // Overloaded method to sum two doubles
    public double sum(double x, double y) {
        return x + y;
    }
}
