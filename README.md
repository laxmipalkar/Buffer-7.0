Description - 

Problem Statement : 
Traditional Braille learning methods often rely on physical tools or static textbooks that lack immediate feedback and dynamic progress tracking. For a learner (particularly those with visual impairments), the transition from learning individual letters (Grade 1) to complex words and contractions (Grade 2) requires a structured, interactive environment that adapts to their pace.


Video_link = https://drive.google.com/file/d/1Gc1gSSZAPpu7ogHv3oGRj1iudGxdOjnW/view?usp=drivesdk

Data Structures used - 

1> HashMap - 
A HashMap<Character, Integer>/<Integer,Integer>/<String/Integer> is used to store mappings for letters and numbers in Grade 1, contraction words in Grade 2 
Each character/integers/contraction words maps to an integer representing the 6-bit Braille pattern.

2> Doubly Linked List - 
Users can move forward(next letter/number/word) and backward(previous letter/number/word) through lessons with O(1) efficiency without losing their place.

3> Queue -
Used to track the progress of lesson. Progress bars only fill when the practice is done.

4> Array - 
We used an array to map bitmask values into a 3×2 grid so we can easily represent and display Braille dot positions for input and teaching.

5> ArrayList - 
Stores multiple dots per word.Allows words of any length to be stored in one BrailleNode.SortedWords ListAlphabetizing contractions.Ensures the curriculum follows a logical A-Z order.Progress BridgeFeeds the LessonTracker.Converts the "Linked List" structure into a format the "Queue" can count.

Also while 'teaching lessons', each Braille character/number/word is stored as an integer value in hashmaps. For example, letter A = 32, which converts to binary 100000.

* Bit Masking - 
We use bit masking to compare user input with a stored pattern using a single integer.
Each Braille character/number/word is represented as a 6-bit value (1 = dot up, 0 = dot down).
We map NumPad inputs to dot positions in a 3×2 grid:
7 → dot 1, 
4 → dot 2, 
1 → dot 3, 
8 → dot 4, 
5 → dot 5, 
2 → dot 6, 
Example:
If user presses 7, only dot 1 is active → 100000 (binary) = 32 (decimal).
This generated value is then matched with a stored hashmap value (e.g., for letter “A”) to check correctness.

* TTS (Text to Speech) and STT(Speech to Text) -
Helps guide visually impaired learners. When a Braille character is displayed, the system speaks the dot positions aloud (for example, “Dot 1” for letter A). This helps learners understand how the dots are arranged in the Braille matrix and assists them in practicing tactile recognition.


* Google Gemini AI Integration

Anuvad integrates Google's Gemini AI API to enhance the learning experience for visually impaired children through two features:

AI Song Generator
When a child learns a new letter, the Gemini API generates a personalized nursery rhyme for that letter. For example, when learning the letter A, Gemini creates a fun rhyme like "A is for Apple, round and sweet, crunch crunch crunch, what a yummy treat!" This makes learning joyful and helps children remember letters through music and rhythm.

AI Story Narrator
The Gemini API also generates short, age-appropriate classic stories like The Tortoise and the Hare, The Lion and the Mouse, and The Thirsty Crow — narrated in simple language suitable for a 5-year-old child. These stories are read aloud using the Text to Speech system, keeping the child engaged and entertained between lessons.





api integration - 

application.properties file , 
spring.application.name=demo
server.port=8081
gemini.api.key=AIzaSyDdafL35QtHGelRnnnTOHx6KROrw0uK67g


GeminiContentService.java file - 
package com.example.demo.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import java.util.Map;
import java.util.List;


@Service
public class GeminiContentService {


    @Value("${gemini.api.key}")
    private String apiKey;


    private final RestTemplate restTemplate = new RestTemplate();


    private String callGemini(String prompt) {
        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + apiKey;


        Map<String, Object> body = Map.of(
            "contents", List.of(
                Map.of("parts", List.of(
                    Map.of("text", prompt)
                ))
            )
        );


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);


        ResponseEntity<Map> response = restTemplate.postForEntity(url, request, Map.class);


        List<Map> candidates = (List<Map>) response.getBody().get("candidates");
        Map content = (Map) candidates.get(0).get("content");
        List<Map> parts = (List<Map>) content.get("parts");
        return (String) parts.get(0).get("text");
    }


    public String getAlphabetSong(String letter, String object) {
        return callGemini("You are a gentle fun teacher for a 5-year-old blind child. Write a 2-line catchy rhyme for the letter " + letter + ". The object is " + object + ". Make it sound like a happy song. Keep it to 2 sentences.");
    }


    public String getClassicStory(String storyName) {
        return callGemini("You are a gentle fun teacher for a 5-year-old blind child. Tell a very short 4-sentence version of the story '" + storyName + "'. Use lots of sound effects words like Thump-thump or Swoosh.");
    }
}

update pom.xml according to it

