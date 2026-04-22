package com.example.demo.controller;

import com.example.demo.model.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lesson")
@CrossOrigin(origins = "*")

public class LessonController {

    private final BrailleLessonList lessonList = new BrailleLessonList();
    private LessonTracker progressTracker;
    private String currentMode = "";

    // Store progress per lesson so switching lessons doesn't lose progress
    private double progressGrade1Alphabets = 0;
    private double progressGrade1Numbers = 0;
    private double progressLearnWords = 0;
    private double progressContractions = 0;

    public LessonController() {
        loadLesson("grade1Alphabets");
    }

    private void loadLesson(String action) {
        lessonList.initialize(action);
        progressTracker = new LessonTracker(lessonList.getAllItemsInCurrentLesson());
        currentMode = action;
    }
    @GetMapping("/completePractice")
public BrailleNode completePractice() {
    // Poll the queue = increase progress
    if (progressTracker != null && !progressTracker.isFinished()) {
        progressTracker.getNextLetter();
    }
    // Then advance to next node
    lessonList.getNext();
    return getCurrentNodeWithProgress();
}
    @GetMapping("/{action}")
    public BrailleNode handleAction(@PathVariable String action) {

        // 1. Lesson Switching Logic
        boolean isLessonSwitch = action.equals("grade1Alphabets") ||
                                 action.equals("grade1Numbers") ||
                                 action.equals("learnWords") ||
                                 action.equals("contractions");

        if (isLessonSwitch) {
            if (!action.equals(currentMode)) {
                // Save current progress before switching
                saveProgress(currentMode);
                // Load the new lesson but restore its saved progress
                loadLesson(action);
                // Restore saved progress for the new lesson
                restoreProgress(action);
            }
            return getCurrentNodeWithProgress();
        }

        // 2. "Next" logic — advances the linked list AND polls the queue
        if ("next".equalsIgnoreCase(action)) {
    lessonList.getNext(); // just navigate, no progress update
    return getCurrentNodeWithProgress();
}
        // 3. Prev navigation
        if ("prev".equalsIgnoreCase(action)) {
            lessonList.getPrev();
        }

        return getCurrentNodeWithProgress();
    }

    // Attaches the latest queue percentage to the node before returning it
    private BrailleNode getCurrentNodeWithProgress() {
    BrailleNode node = lessonList.getCurrent();
     System.out.println("DEBUG tracker: " + progressTracker);          // ADD THIS
    System.out.println("DEBUG progress: " + progressTracker.getProgressPercentage()); // ADD THIS
    if (node != null) {
        double pct = (progressTracker != null) 
            ? progressTracker.getProgressPercentage() 
            : 0.0;
        node.setProgress(pct);  // always set, even if 0
    }
    return node;
}

    // ---- Progress persistence helpers ----

    private void saveProgress(String mode) {
        if (progressTracker == null) return;
        double pct = progressTracker.getProgressPercentage();
        switch (mode) {
            case "grade1Alphabets": progressGrade1Alphabets = pct; break;
            case "grade1Numbers":   progressGrade1Numbers   = pct; break;
            case "learnWords":      progressLearnWords      = pct; break;
            case "contractions":    progressContractions    = pct; break;
        }
    }

    private void restoreProgress(String mode) {
        // No-op for now — progress resets when you reload a lesson.
        // To persist across page loads you would store this in a DB/session.
        // If you want progress to NOT reset on lesson switch, uncomment the body below.
        /*
        if (progressTracker == null) return;
        double saved = 0;
        switch (mode) {
            case "grade1Alphabets": saved = progressGrade1Alphabets; break;
            case "grade1Numbers":   saved = progressGrade1Numbers;   break;
            case "learnWords":      saved = progressLearnWords;      break;
            case "contractions":    saved = progressContractions;    break;
        }
        // Walk the queue forward to match the saved percentage (optional advanced feature)
        */
    }
}