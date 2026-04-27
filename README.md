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
7 → dot 1
4 → dot 2
1 → dot 3
8 → dot 4
5 → dot 5
2 → dot 6
Example:
If user presses 7, only dot 1 is active → 100000 (binary) = 32 (decimal).
This generated value is then matched with a stored hashmap value (e.g., for letter “A”) to check correctness.

* TTS (Text to Speech) and STT(Speech to Text) -
Helps guide visually impaired learners. When a Braille character is displayed, the system speaks the dot positions aloud (for example, “Dot 1” for letter A). This helps learners understand how the dots are arranged in the Braille matrix and assists them in practicing tactile recognition. 
