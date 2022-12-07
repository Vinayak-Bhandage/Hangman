package projects.hangman;

import java.util.*;

/**
 *  @author Vinayak Bhandage
 *  <li>Hangman.</li>
 *  <li>It is a movie name guessing game where one can guess by entering any random (A-Z) alphabets at a time.</li>
 *  <li>And then based on the letters selected the game checks whether the alphabet is there or no.</li>
 */

public class Hangman {

    /**
     * <li>This method is the start of Hangman game.</li>
     * @param hangman first parameter.
     * @param arr second parameter
     */
    static void startGame(String hangman, char[] arr) {

        for(int i = 0; i < hangman.length(); i++) { //The movie name letters are converted to 'Underscore (_)' and 'spaces ( )' accordingly.
            if(hangman.charAt(i) == ' ') { // Check if character is space or alphabet.
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

        playGame(hangman, arr); // Calling the function where user can enter character and play the game.
    }

    /**
     * <li>Checks for the alphabet in the movie string and then updating the array with those character
     * for how many times that alphabet occurred.
     * </li>
     * @param hangman string parameter
     * @param arr 1D array parameter
     * @param c Character parameter
     * @return count of total alphabets updated.
     */
    static int updateArray(String hangman, char[] arr, char c) {
        int res = 0; // Initialised res value to 0

        for(int i = 0; i < hangman.length(); i++) { // Loop for checking the same alphabet repeated how many times.
            if(hangman.charAt(i) == c) { // Changing the character at specific place where the character occurred in the string.
                arr[i] = c; // Updating at that exact location.
                res++; // Counting total number of times the character occurred.
            }
        }

        for (int i = 0; i < arr.length; i++) { // Displaying the updated array.
            System.out.print(arr[i]);
        }
        System.out.println();

        return res;
    }

    /**
     * <li>We check if the character was already entered.</li>
     * <li>Then check for how many times is the same letter is repeating in the movie name.</li>
     * <li>And if the letter is not there in the movie name then the logo will print ascii art of dying hangman.</li>
     * @param hangman_movie String parameter
     * @param arr 1D array parameter
     */
    static void playGame(String hangman_movie, char[] arr) {
        //Accessing logos from logo class to show when we select a wrong letter which is not there in our movie name.
        Logo logo = new Logo();
        Scanner in = new Scanner(System.in);
        String visited = ""; //Empty string for later checking of repeated alphabets.
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
            if(visited.indexOf(c) >= 0) { // Check whether this entered character was already there or not.
                System.out.println("Character already entered! Please try a different character");
            }
            else { // If this character is new then update the visited string.
                visited += c;
                if (hangman_movie.indexOf(c) >= 0) {
                    // Call updateArray function to check how many times the same
                    // character is repeating.
                    res = updateArray(hangman_movie, arr, c);
                    count -= res; // subtract the total length of movie from result of total character updated.
                }
                else { // Display the dying hangman logo.
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


    /**
     * <li>Start of the main method.</li>
     */
    public static void main(String args[]) {
        //Creating object of Movies class.
        Movies movies = new Movies();

        //Fetching movie name.
        String hangman = movies.returnsMovie().toUpperCase();
        char[] arr = new char[hangman.length()]; // Initialising a character array with return movie name.

        startGame(hangman, arr); // Game starts from here.

    }
}
