// CHILD CLASS // SUBCLASS // DERIVED CLASS

public class MathTeacher extends Teacher {
    int favoriteNumber;

    public MathTeacher(int numberOfStudents, String school, int favoriteNumber) {
        
    	//using superclass constructor
        super(numberOfStudents, school);
        
        //using instance attribute
        this.favoriteNumber = favoriteNumber;
    }
}
