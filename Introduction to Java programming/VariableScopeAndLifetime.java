public class VariableScopeAndLifetime {

    // Class-level variable (Global scope)
    static int globalVar = 10;

    public static void main(String[] args) {
        // Local variable in the main method
        int localVar = 20;

        System.out.println("Global Variable: " + globalVar);
        System.out.println("Local Variable: " + localVar);

        // Calling a method
        modifyVariables();

        // localVar is not accessible here; uncommenting the next line will cause a compilation error
        // System.out.println(localVar);

        System.out.println("Global Variable after modification: " + globalVar);

        // Calling block scope demonstration
        blockScopeExample();
    }

    public static void modifyVariables() {
        // This method can access the global variable but not the local variable of main
        globalVar = 30;
        // Uncommenting the next line would cause a compilation error because localVar is not accessible here
        // System.out.println(localVar);
    }

    public static void blockScopeExample() {
        // This variable only exists within the block
        if (true) {
            int blockVar = 40;
            System.out.println("Block Variable: " + blockVar);
        }
        // blockVar is not accessible here; uncommenting the next line will cause a compilation error
        // System.out.println(blockVar);
    }
}

