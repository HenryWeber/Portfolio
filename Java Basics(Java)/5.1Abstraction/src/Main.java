import java.util.Stack;
import java.util.HashMap;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        
    	//Concrete
    	Rectangle r = new Rectangle("purple", 5, 2);
        Circle c = new Circle("blue", 4);
        
        //Abstract cannot create unless specific shape
        Shape s = new Rectangle("red", 9, 8);//WRONG Shape s = new Shape("red");
        
        System.out.println("\nSHAPE");
        System.out.println("Shape Area " + s.getArea());
        System.out.println("Shape Draw: " +s.draw());

        System.out.println("\nAREA");
        System.out.println("Rectangle Area: " + r.getArea());
        System.out.println("Circle Area: " + c.getArea());
        
        System.out.println("\nDRAW");
        System.out.println("Rectangle Draw: " +r.draw());
        System.out.println("Circle Draw: " +c.draw());
    }
}