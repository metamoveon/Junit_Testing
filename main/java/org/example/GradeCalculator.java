package org.example;

public class GradeCalculator {
    public char calculateGrade(int scores) {
        if (scores < 0 || scores > 100) {
            throw new IllegalArgumentException("Input score is invalid");
        }
        if (scores >= 80) {
            return 'A';
        }
        if (scores >= 70) {
            return 'B';
        }
        if (scores >= 60) {
            return 'C';
        }
        if (scores >= 50) {
            return 'D';
        }
        return 'F';
    }
}
