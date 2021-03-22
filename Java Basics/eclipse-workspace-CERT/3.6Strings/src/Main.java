public class Main {

    public static void main(String[] args) {
    	//literal and otherLiteral access same place in memory
    	String literal ="hello";
    	String obj = new String("hello");
    	String otherLiteral = "hello";
    	String otherObj = new String("hello"); // now we have 3 "hello"s in memory
    	
    	// ==
    	//Compares references/pointers
    	System.out.println(literal == obj);//false
    	System.out.println(literal == otherLiteral);//true
    	
    	//.equals()
    	//Compares true values of Strings
    	System.out.println(literal.equals(obj));//true
    	System.out.println(literal.equals(otherLiteral));//true
    	
    	
    	//Comparing Objects
    	System.out.println(obj == otherObj);// false
    	System.out.println(obj.equals(otherObj));//true
    	
    }
}
