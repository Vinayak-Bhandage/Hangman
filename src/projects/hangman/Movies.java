package projects.hangman;

import java.util.Random;

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

        Random random = new Random();
        int r = random.nextInt(0, movielist.length-1);
        return movielist[r];
    }
}