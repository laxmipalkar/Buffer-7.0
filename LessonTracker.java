package com.example.demo.model;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LessonTracker {
    private Queue<String> remainingLetters;
    private int totalLetters;

    public LessonTracker(List<String> allLetters) {
        // Enqueue all letters into the LinkedList (which implements Queue)
        this.remainingLetters = new LinkedList<>(allLetters);
        this.totalLetters = allLetters.size();
    }

    public double getProgressPercentage() {
    // Safety check: if total is 0, we can't divide.
    if (totalLetters == 0) return 100.0; 
    
    int completed = totalLetters - remainingLetters.size();
    return ((double) completed / totalLetters) * 100;
}

    public String getNextLetter() {
        // poll() removes the letter from the front of the queue
        return remainingLetters.poll(); 
    }
    
    public boolean isFinished() {
        return remainingLetters.isEmpty();
    }
}