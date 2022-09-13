package projects.hangman;

import java.util.*;

public class Hangman {
    static void startGame(String hangman, char[] arr) {

        for(int i = 0; i < hangman.length(); i++) {
            if(hangman.charAt(i) == ' ') {
                arr[i] = ' ';
            }
            else {
                arr[i] = '_';
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println("\n" + hangman);
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
        Logo logo = new Logo();
        Scanner in = new Scanner(System.in);
        String visited = "";
        String movie_name = hangman_movie;
        int count = 0, res = 0, lifes = 1;
        for(int i = 0; i < movie_name.length(); i++) {
            if(movie_name.charAt(i) == ' '){
                count++;
            }
        }
        count = movie_name.length() - count;

        while(count > 0 && lifes != 7) {
            char c = in.next().toUpperCase().charAt(0);
            if(visited.indexOf(c) >= 0) {
                System.out.println("Character already entered! Please try a different character");
            }
            else {
                visited += c;
                if (movie_name.indexOf(c) >= 0) {
                    res = updateArray(hangman_movie, arr, c);
                    count -= res;
                }
                else {
                    lifes++;
                    logo.returnsLogo(lifes);
                }
            }
        }
        if(lifes < 7) {
            logo.returnsLogo(8);
        }
    }

    public static void main(String args[]) {
        Movies movies = new Movies();

        String hangman = movies.returnsMovie().toUpperCase();
        char[] arr = new char[hangman.length()];

        startGame(hangman, arr);

    }
}
