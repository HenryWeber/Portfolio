public class Main {

    public static void main(String[] args) {
    	// c instance only allowed within main method
        Counter c = new Counter();
        c.incrementCount(5);
        System.out.println(c.count);
    }
}
