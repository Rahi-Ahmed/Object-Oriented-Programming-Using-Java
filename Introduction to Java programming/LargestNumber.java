package JavaWorld;

public class LargestNumber {

	public static void main(String[] args) {
    	
    	System.out.println(largest(5, 10)); //printing the largest number between two integers
    	System.out.println(largest(9.14, 3.15)); //printing the largest number between two decimals for overloaded method
    	
    }
	//method for finding largest of two integers
    public static int largest(int x, int y) { 
    	if(x < y) { //checking whether x is less than y
    		return y; //will return y since x is less than y
    	}
    	return x; //otherwise, it will return x since x is not less than y
    }
    
    //overloaded method to find largest one of two doubles
    public static double largest(double x, double y) {
    	if(x < y) { //checking whether x is less than y
    		return y; //will return y since x is less than y
    	}
    	return x; //otherwise, it will return x since x is not less than y
    }
}
