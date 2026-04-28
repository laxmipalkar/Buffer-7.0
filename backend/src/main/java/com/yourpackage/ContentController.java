package com.example.demo.controller;
import com.example.demo.service.GeminiContentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin(origins = "*") // Allows your HTML to talk to this Java code
public class ContentController {

    private final GeminiContentService geminiService;

    public ContentController(GeminiContentService geminiService) {
        this.geminiService = geminiService;
    }

    // Endpoint for Alphabet Songs
    // Example call: /api/ai/song?letter=A&object=Apple
    @GetMapping("/song")
    public String getSong(@RequestParam String letter, @RequestParam String object) {
        return geminiService.getAlphabetSong(letter, object);
    }

    // Endpoint for Stories
    // Example call: /api/ai/story?name=Tortoise and the Hare
    @GetMapping("/story")
    public String getStory(@RequestParam String name) {
        return geminiService.getClassicStory(name);
    }
}