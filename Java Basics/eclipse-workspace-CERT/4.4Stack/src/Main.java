import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<String> deckOfCards = new Stack();
        String card1 = "Jack : Diamonds";
        String card2 = "8 : Hearts";
        String card3 = "3 : Clubs";
        
        //Push (Insert)
        deckOfCards.push(card1);
        deckOfCards.push(card2);
        deckOfCards.push(card3);

        System.out.println(deckOfCards);

        //Peek
        String top = deckOfCards.peek();
        System.out.println("Peek = " + top);

        //Size
        System.out.println("Size: " + deckOfCards.size());

        //Pop All
        while(!deckOfCards.empty()) {
            String removedItem = deckOfCards.pop();
            System.out.println("Removed: " + removedItem);
        }
    }
}
