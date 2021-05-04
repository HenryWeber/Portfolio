package SortingMethods;

import java.util.Comparator;

public class Student implements Comparable<Student> {
    int studentId;
    int studentGeneration;

    public Student(int studentId, int studentGeneration) {
        this.studentId = studentId;
        this.studentGeneration = studentGeneration;
    }

    @Override
    public String toString() {
        return studentId + "/" + studentGeneration % 100;
    }

    @Override
    public int compareTo(Student student) {
        int result = this.studentGeneration - student.studentGeneration;
        if (result != 0)
            return result;
        else
            return this.studentId - student.studentId;
    }
}

