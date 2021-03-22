import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList();

        // Enqueue items
        queue.add("Sam");
        queue.add("Anna");
        queue.add("Heidi");
        queue.add("Susan");
        queue.add("Charlotte");
        System.out.println(queue);

        //Peek
        String nextInQueue = queue.peek();
        System.out.println("Peek "+ nextInQueue);
        
        //Remove
        String recentlyRemoved = queue.remove();
        System.out.println(recentlyRemoved);
        
        System.out.println(queue);
        
        //Remove until 2 left
        for(int i = 0; i < queue.size(); i++) {
        	queue.remove();
        	System.out.println(queue);
        }
    }
}
