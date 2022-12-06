package projects.hangman;

import java.util.Random;

// All the names of the movies which will be given randomly when the function ReturnsMovie is called.
public class Movies {
    public String returnsMovie() {
        String[] movielist = {"The Shawshank Redemption", "The Godfather", "The Dark Knight",
                "Pulp Fiction", "Spiderman", "Amelie", "The Hangover", "The Amityville Horror", "Jaws",
                "The Truman Show", "Witness for the Prosecution", "Toy Story", "Knocked Up", "Titanic",
                "Goodfellas", "Inglorious Basterds", "Finding Nemo", "Madagascar", "Star Trek", "Chocolat",
                "Daredevil", "Bridesmaids", "I Know What You Did Last Summer", "Thank you for Smoking", "Gladiator",
                "Buffy the Vampire Slayer", "Avatar", "Shutter Island", "The Silence of the Lambs", "War of the Worlds",
                "The Exorcist", "Slumdog Millionaire", "Howl's Moving Castle", "Kick Ass", "The Sixth Sense",
                "Forrest Gump"};

        // Random number generator
        Random random = new Random();

        // Selecting random number from 0 to arrays length.
        int r = random.nextInt(0, movielist.length-1);
        return movielist[r];
    }
}
