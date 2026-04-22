package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class BrailleLessonList {
    private BrailleNode head, tail, current;
    private Grade2 grade2Data = new Grade2();

    public BrailleLessonList() {
        // Initialization happens via the initialize() method
    }

    public void initialize(String type) {
        head = null;
        tail = null;
        current = null;

        if ("grade1Alphabets".equalsIgnoreCase(type)) {
            Grade1.loadAlphabets(this);
        } else if ("grade1Numbers".equalsIgnoreCase(type)) {
            Grade1.loadNumbers(this);
        } else if ("learnWords".equalsIgnoreCase(type)) {
            buildVocabularyLessons();
        } else if ("contractions".equalsIgnoreCase(type)) {
            buildContractionLessons();
        }
        
        current = head;
    }

    public void addLetter(char letter, int pattern, String type) {
        addNode(letter, String.valueOf(letter), List.of(pattern), type);
    }

    private void buildVocabularyLessons() {
        for (char c = 'A'; c <= 'Z'; c++) {
            String word = grade2Data.wordMap.get(c);
            if (word == null) continue;
            
            List<Integer> patterns = new ArrayList<>();
            for (char letter : word.toCharArray()) {
                patterns.add(grade2Data.brailleMap.getOrDefault(Character.toUpperCase(letter), 0));
            }
            addNode(c, word, patterns, "word");
        }
    }

    private void buildContractionLessons() {
        List<String> sortedWords = new ArrayList<>(grade2Data.contractionMap.keySet());
        Collections.sort(sortedWords);

        for (String word : sortedWords) {
            int pattern = grade2Data.contractionMap.get(word);
            addNode(word.charAt(0), word, List.of(pattern), "contraction");
        }
    }

    private void addNode(char letter, String word, List<Integer> patterns, String type) {
        BrailleNode newNode = new BrailleNode(letter, word, patterns, type);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // --- NEW METHOD ADDED FOR QUEUE TRACKER ---
    /**
     * Iterates through the Linked List and collects all words/letters.
     * This List is passed to the LessonTracker (Queue) to calculate progress.
     */
    public List<String> getAllItemsInCurrentLesson() {
    List<String> items = new ArrayList<>();
    BrailleNode temp = head;
    while (temp != null) {
        // Change temp.getword() to temp.word
        items.add(temp.word); 
        temp = temp.next;
    }
    return items;
}
    // --- Navigation Methods ---

    public BrailleNode getCurrent() { 
        return current; 
    }

    public BrailleNode getNext() { 
        if (current != null && current.next != null) {
            current = current.next;
        }
        return current; 
    }

    public BrailleNode getPrev() { 
        if (current != null && current.prev != null) {
            current = current.prev;
        }
        return current; 
    }
}