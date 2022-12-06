package projects.hangman;

import java.util.*;

// Hangman.
// It is a movie name guessing game where one can guess by entering any random (A-Z) alphabets at a time.
// And then based on the letters selected the game checks whether the alphabet is there or no.
public class Hangman {
    static void startGame(String hangman, char[] arr) {

        // The movie name letters are converted to 'Underscore (_)' and 'spaces ( )' accordingly.
        for(int i = 0; i < hangman.length(); i++) {
            if(hangman.charAt(i) == ' ') {
                arr[i] = ' ';
            }
            else {
                arr[i] = '_';
            }
        }

        // Displaying the array.
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

        playGame(hangman, arr);
    }

    static int updateArray(String hangman, char[] arr, char c) {
        int res = 0;
        for(int i = 0; i < hangman.length(); i++) {
            if(hangman.charAt(i) == c) {
                arr[i] = c;
                res++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();

        return res;
    }

    static void playGame(String hangman_movie, char[] arr) {
        //Accessing logos from logo class to show when we select a wrong letter which is not there in our movie name.
        Logo logo = new Logo();
        Scanner in = new Scanner(System.in);
        String visited = "";
        int count = 0, res = 0, lifes = 1;

        // To get total spaces in the movie and the subtracting it from original length.
        for(int i = 0; i < hangman_movie.length(); i++) {
            if(hangman_movie.charAt(i) == ' '){
                count++;
            }
        }
        count = hangman_movie.length() - count;

        // We check if the character was already entered.
        // Then check for how many times is the same letter is repeating in the movie name.
        // And if the letter is not there in the movie name then the logo will print ascii art of dying hangman.
        while(count > 0 && lifes != 7) {
            char c = in.next().toUpperCase().charAt(0);
            if(visited.indexOf(c) >= 0) {
                System.out.println("Character already entered! Please try a different character");
            }
            else {
                visited += c;
                if (hangman_movie.indexOf(c) >= 0) {
                    res = updateArray(hangman_movie, arr, c);
                    count -= res;
                }
                else {
                    lifes++;
                    logo.returnsLogo(lifes);
                }
            }
        }

        // If the user guessed the movie name within the limit of life he wins the game and displays a logo of game won.
        if(lifes < 7) {
            logo.returnsLogo(8);
        }
    }

    public static void main(String args[]) {
        //Creating object of Movies class.
        Movies movies = new Movies();

        //Fetching movie name.
        String hangman = movies.returnsMovie().toUpperCase();
        char[] arr = new char[hangman.length()];

        startGame(hangman, arr);

    }
}
