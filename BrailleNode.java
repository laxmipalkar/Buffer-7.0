package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

public class BrailleNode {
    public char letter;
    public String word;
    public List<Integer> patterns;
    public String type;
    public double progress = 0.0;  // ← make it PUBLIC, remove all annotations

    @JsonIgnore
    public BrailleNode next;

    @JsonIgnore
    public BrailleNode prev;

    public BrailleNode() {}

    public BrailleNode(char letter, String word, List<Integer> patterns, String type) {
        this.letter = letter;
        this.word = word;
        this.patterns = patterns;
        this.type = type;
    }

    public void setProgress(double progress) { this.progress = progress; }
    public double getProgress() { return progress; }
}