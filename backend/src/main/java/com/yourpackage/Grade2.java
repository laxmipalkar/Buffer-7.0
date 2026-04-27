package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;

public class Grade2 {
    // Stores the teaching word for each letter (e.g., 'A' -> "APPLE")
    public final Map<Character, String> wordMap = new HashMap<>();
    
    // Stores the pattern for a single character (e.g., 'A' -> 32)
    public final Map<Character, Integer> brailleMap = new HashMap<>();
    
    // Stores Grade 2 Contractions (e.g., "BUT" -> 48)
    public final Map<String, Integer> contractionMap = new HashMap<>();

    public Grade2() {
        // 1. Basic Alphabet Bitmasking: Dot 1=32, 2=16, 3=8, 4=4, 5=2, 6=1
        brailleMap.put('A', 32);  brailleMap.put('B', 48);  brailleMap.put('C', 36);
        brailleMap.put('D', 38);  brailleMap.put('E', 34);  brailleMap.put('F', 52);
        brailleMap.put('G', 54);  brailleMap.put('H', 50);  brailleMap.put('I', 20);
        brailleMap.put('J', 22);  brailleMap.put('K', 40);  brailleMap.put('L', 56);
        brailleMap.put('M', 44);  brailleMap.put('N', 46);  brailleMap.put('O', 42);
        brailleMap.put('P', 60);  brailleMap.put('Q', 62);  brailleMap.put('R', 58);
        brailleMap.put('S', 28);  brailleMap.put('T', 30);  brailleMap.put('U', 41);
        brailleMap.put('V', 57);  brailleMap.put('W', 23);  brailleMap.put('X', 45);
        brailleMap.put('Y', 47);  brailleMap.put('Z', 43);

        // 2. Vocabulary Words for Alphabet Teaching
        wordMap.put('A', "APPLE");  wordMap.put('B', "BALL");   wordMap.put('C', "CAT");
        wordMap.put('D', "DOG");    wordMap.put('E', "EGG");    wordMap.put('F', "FAN");
        wordMap.put('G', "GOAT");   wordMap.put('H', "HAT");    wordMap.put('I', "ICE");
        wordMap.put('J', "JAR");    wordMap.put('K', "KITE");   wordMap.put('L', "LAMP");
        wordMap.put('M', "MOON");   wordMap.put('N', "NET");    wordMap.put('O', "OWL");
        wordMap.put('P', "PEN");    wordMap.put('Q', "QUEEN");  wordMap.put('R', "RAT");
        wordMap.put('S', "SUN");    wordMap.put('T', "TIGER");  wordMap.put('U', "UMBRELLA");
        wordMap.put('V', "VAN");    wordMap.put('W', "WATCH");  wordMap.put('X', "XRAY");
        wordMap.put('Y', "YAK");    wordMap.put('Z', "ZEBRA");

        // 3. Grade 2 Contractions (Shortcuts)
        contractionMap.put("BUT", 48);       contractionMap.put("CAN", 36);
        contractionMap.put("DO", 38);        contractionMap.put("EVERY", 34);
        contractionMap.put("FROM", 52);      contractionMap.put("GO", 54);
        contractionMap.put("HAVE", 50);      contractionMap.put("JUST", 22);
        contractionMap.put("KNOWLEDGE", 40); contractionMap.put("LIKE", 56);
        contractionMap.put("MORE", 44);      contractionMap.put("NOT", 46);
        contractionMap.put("PEOPLE", 60);    contractionMap.put("QUITE", 62);
        contractionMap.put("RATHER", 58);    contractionMap.put("SO", 28);
        contractionMap.put("THAT", 30);      contractionMap.put("US", 41);
        contractionMap.put("VERY", 57);      contractionMap.put("IT", 20);
        contractionMap.put("YOU", 45);       contractionMap.put("AS", 32);
        contractionMap.put("AND", 61);       contractionMap.put("FOR", 63);
        contractionMap.put("OF", 59);        contractionMap.put("THE", 29);
        contractionMap.put("WITH", 31);
    }
}
