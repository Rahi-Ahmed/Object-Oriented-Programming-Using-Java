public class DefaultDemo {
	/*
	 * The code is only accessible in the same package. This is used when you don't
	 * specify a modifier. You will learn more about packages in the Packages
	 * chapter
	 */
}
class Human {
	  String fname = "John";
	  String lname = "Doe";
	  String email = "john@doe.com";
	  int age = 24;
	  
	  public static void main(String[] args) {
	    Human myObj = new Human();
	    System.out.println("Name: " + myObj.fname + " " + myObj.lname);
	    System.out.println("Email: " + myObj.email);
	    System.out.println("Age: " + myObj.age);
	  }
	}
