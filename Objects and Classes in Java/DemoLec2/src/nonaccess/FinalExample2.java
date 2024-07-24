
package nonaccess;

public class FinalExample2 {
	  final  int x = 10;
	  final double PI = 3.14;

	  public static void main(String[] args) {
		FinalExample2 myObj = new FinalExample2();
//	    myObj.x = 50; // will generate an error
//	    myObj.PI = 25; // will generate an error
	    System.out.println(myObj.x); 
	    System.out.println(myObj.PI);
	  }
}

