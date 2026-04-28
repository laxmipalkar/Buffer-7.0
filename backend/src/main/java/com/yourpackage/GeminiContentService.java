package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;
import java.util.Random;

@Service
public class GeminiContentService {

    private static final Map<String, String> ALPHABET_SONGS = Map.ofEntries(
        Map.entry("A", "A is for Apple, round and sweet, Crunch crunch crunch, what a yummy treat!"),
        Map.entry("B", "B is for Ball, bouncy and round, Boing boing boing, hear that bouncy sound!"),
        Map.entry("C", "C is for Cat, soft and furry too, Meow meow meow, the cat says to you!"),
        Map.entry("D", "D is for Dog, fluffy and bright, Woof woof woof, from morning to night!"),
        Map.entry("E", "E is for Elephant, big and grey, Trumpet trumpet, hear the elephant play!"),
        Map.entry("F", "F is for Fish, splish splash splish, Glug glug glug, swimming is their wish!"),
        Map.entry("G", "G is for Goat, on the grassy hill, Maa maa maa, eating hay with thrill!"),
        Map.entry("H", "H is for Horse, clip clop clip, Neigh neigh neigh, on a galloping trip!"),
        Map.entry("I", "I is for Ice cream, cold and sweet, Lick lick lick, what a yummy treat!"),
        Map.entry("J", "J is for Jungle, wild and free, Roar roar roar, come and explore with me!"),
        Map.entry("K", "K is for Kite, flying up high, Swoosh swoosh swoosh, dancing in the sky!"),
        Map.entry("L", "L is for Lion, strong and bright, Roar roar roar, the king of the night!"),
        Map.entry("M", "M is for Monkey, swinging in trees, Ooh ooh ooh, swinging in the breeze!"),
        Map.entry("N", "N is for Nest, cozy and warm, Tweet tweet tweet, safe from every storm!"),
        Map.entry("O", "O is for Owl, hooting at night, Hoo hoo hoo, what a wonderful sight!"),
        Map.entry("P", "P is for Parrot, colorful and bright, Squawk squawk squawk, what a beautiful sight!"),
        Map.entry("Q", "Q is for Queen, royal and grand, Clap clap clap, the best in the land!"),
        Map.entry("R", "R is for Rain, drip drop drip, Pitter patter pitter, on a rainy trip!"),
        Map.entry("S", "S is for Sun, warm and bright, Shine shine shine, from morning to night!"),
        Map.entry("T", "T is for Tiger, stripy and strong, Growl growl growl, all the day long!"),
        Map.entry("U", "U is for Umbrella, keeping us dry, Drip drip drip, as rain falls from the sky!"),
        Map.entry("V", "V is for Violin, music so sweet, Zing zing zing, tapping our feet!"),
        Map.entry("W", "W is for Water, splish and splash, Whoosh whoosh whoosh, hear the water crash!"),
        Map.entry("X", "X is for Xylophone, ding ding ding, Tap tap tap, hear the music ring!"),
        Map.entry("Y", "Y is for Yarn, soft and round, Roll roll roll, without a sound!"),
        Map.entry("Z", "Z is for Zebra, black and white, Clip clop clip, what a beautiful sight!")
    );

    private static final List<String> STORIES = List.of(
        "Once upon a time, a tortoise and a hare decided to have a race. The hare was very fast and ran ahead quickly, so he decided to take a nap under a tree. The tortoise walked slowly but never stopped, passing the sleeping hare along the way. When the hare woke up and ran to the finish line, the tortoise was already there waiting. The tortoise smiled and said, slow and steady wins the race.",

        "Once upon a time, a big lion caught a tiny mouse in the forest. Roar, said the lion, and the little mouse squeaked with fear. The mouse begged the lion to let him go, promising to help him someday. The lion laughed but set the mouse free. Later, the lion got caught in a hunter's net and could not get out. The little mouse came and chewed through the ropes, setting the lion free. From that day on, they were the best of friends.",

        "Once upon a time, a thirsty crow flew over a village looking for water. Caw caw, he called, searching everywhere under the hot sun. He found a tall pot with only a little water at the bottom, too low to reach. The crow thought carefully and began dropping small pebbles into the pot one by one, plop plop plop. Slowly the water rose higher and higher until the crow could finally drink. The crow flew away happy, knowing that thinking carefully can solve any problem."
    );

    public String getAlphabetSong(String letter, String object) {
        String upperLetter = letter.toUpperCase();
        return ALPHABET_SONGS.getOrDefault(upperLetter,
            "Yay for the letter " + upperLetter + "! " + upperLetter + " is for " + object + ", hooray hooray! Let us clap and sing and play all day!");
    }

    public String getClassicStory(String storyName) {
        Random random = new Random();
        return STORIES.get(random.nextInt(STORIES.size()));
    }
}