import java.util.Random;

public class Dice {
	// class(static) variable needing no instance
    static int sidesOfDice = 6;
    // non-static variable
    int faceValue = 0;

    
    public int roll() {
        Random rand = new Random();
        //keyword 'this' shows specify faceValue is instance value 
        this.faceValue = rand.nextInt(sidesOfDice) + 1;
        return this.faceValue;
    }
    
    //STATIC method
    public static void changeNumSidesOfDice(int newNumberOfSides) {
        Dice.sidesOfDice = newNumberOfSides;
    }

    //PUBLIC method
    public int getFaceValue() {
        return this.faceValue;
    }

}
