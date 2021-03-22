import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        // Create a Linked List
        LinkedList<String> students = new LinkedList<>();

        // Add students to Linked List
        students.add("Charlie");
        students.add("Sally");
        students.add("Morgan");
        students.add("Taylor");
        students.add("Jamie");

        //Add
        students.addFirst("Sarah");//FIRST
        students.addLast("Hailey");//LAST
        students.add(2, "Tara");//INDEx

        //Get
        String firstStudent = students.getFirst();//FIRST
        System.out.println("First " + firstStudent);
        String lastStudent = students.getLast();//LAST
        System.out.println("Last " + lastStudent);
        System.out.println(students.size());//SIZE
        System.out.println(students);
        String secondStudent = students.get(1);//INDEX
        System.out.println("Second " + secondStudent);
        int i = students.indexOf("Morgan");//BY VALUE
        System.out.println("Index of Morgan is " + i);

        //Remove
        students.removeFirst();
        students.removeLast();
        students.remove("Jamie");
        students.remove(1);
        System.out.println(students);

        //Contains
        boolean hasTaylor = students.contains("Taylor");
        System.out.println(hasTaylor);

        //Remove All
        students.clear();
        System.out.println(students);
    }
}
