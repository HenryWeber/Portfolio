package SortingMethods;
import java.util.Arrays;

public class Driver {
	
	public static void main(String[] args) {
	    Student[] a = new SortingMethods.Student[5];
	    a[0] = new Student(75, 2016);
	    a[1] = new Student(52, 2019);
	    a[2] = new Student(57, 2016);
	    a[3] = new Student(220, 2014);
	    a[4] = new Student(16, 2018);
	    
	    //Sort by Generation inside Student class
	    Arrays.sort(a);
	    
	    //Sort by Student ID in SortByID Class
	    Arrays.sort(a, new SortByID());

	    
	    System.out.println(Arrays.toString(a));
	    
	    
	}
	
}
