import java.util.Stack;
import java.util.HashMap;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Elizabeth Blackburn",
                29, 183762);

        System.out.println(employee.getName());
        System.out.println(employee.getAge());
        System.out.println(employee.getId());

        //Can only retrieve attributes because only get methods are created
        //Cannot retrieve data directly because attributes are private
        //employee.age;
        //employee.name;
        //employee.id;

    }
}