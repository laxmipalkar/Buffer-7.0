package com.example.demo.model;

public class Grade1 {

    public static void loadAlphabets(BrailleLessonList list) {
        // Row 1: A-J
        // Parameters: (char letter, String word, int pattern, String type)
        list.addLetter('A', 32, "alphabet");
        list.addLetter('B', 48, "alphabet");
        list.addLetter('C', 36, "alphabet");
        list.addLetter('D', 38, "alphabet");
        list.addLetter('E', 34, "alphabet");
        list.addLetter('F', 52, "alphabet");
        list.addLetter('G', 54, "alphabet");
        list.addLetter('H', 50, "alphabet");
        list.addLetter('I', 20, "alphabet");
        list.addLetter('J', 22, "alphabet");

        // Row 2: K-T
        list.addLetter('K', 40, "alphabet");
        list.addLetter('L', 56, "alphabet");
        list.addLetter('M', 44, "alphabet");
        list.addLetter('N', 46, "alphabet");
        list.addLetter('O', 42, "alphabet");
        list.addLetter('P', 60, "alphabet");
        list.addLetter('Q', 62, "alphabet");
        list.addLetter('R', 58, "alphabet");
        list.addLetter('S', 28, "alphabet");
        list.addLetter('T', 30, "alphabet");

        // Row 3: U-Z
        list.addLetter('U', 41, "alphabet");
        list.addLetter('V', 57, "alphabet");
        list.addLetter('W', 23, "alphabet");
        list.addLetter('X', 45, "alphabet");
        list.addLetter('Y', 47, "alphabet");
        list.addLetter('Z', 43, "alphabet");
    }

    public static void loadNumbers(BrailleLessonList list) {
        // Numbers 1-0 usually follow A-J patterns
        list.addLetter('1', 32, "number");
        list.addLetter('2', 48, "number");
        list.addLetter('3', 36, "number");
        list.addLetter('4', 38, "number");
        list.addLetter('5', 34, "number");
        list.addLetter('6', 52, "number");
        list.addLetter('7', 54, "number");
        list.addLetter('8', 50, "number");
        list.addLetter('9', 20, "number");
        list.addLetter('0', 22, "number");
    }
}