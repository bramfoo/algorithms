package edu.princeton.cs.coursera.boggle;

import edu.princeton.cs.algs4.io.In;
import edu.princeton.cs.algs4.io.StdOut;

/**
 * This class finds all valid words in a given Boggle board, using a given dictionary as described in the <a href="
 * http://coursera.cs.princeton.edu/algs4/assignments/boggle.html">Boggle</a> assignment.
 * <p>
 * 
 *  <b>The Boggle game.</b> Boggle is a word game designed by Allan Turoff and distributed by Hasbro. It involves a board made up of 16 cubic dice, where each die has a letter printed on each of its sides. At the beginning of the game, the 16 dice are shaken and randomly distributed into a 4-by-4 tray, with only the top sides of the dice visible. The players compete to accumulate points by building valid words out of the dice according to the following rules:
 *  <ul> 
 *  <li> A valid word must be composed by following a sequence of adjacent dice—two dice are adjacent if they are horizontal, vertical, or diagonal neighbors.
 *  <li> A valid word can use each die at most once.
 *  <li> A valid word must contain at least 3 letters.
 *  <li> A valid word must be in the dictionary (which typically does not contain proper nouns). 
 *  </ul>
 * API definition: <br>
 * <tt>
 * 
 * 
 * public class BoggleSolver
 * <br> {
 * <br> // Initializes the data structure using the given array of strings as the dictionary.
 * <br> // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
 * <br> public BoggleSolver(String[] dictionary)
 * <br> 
 * <br> // Returns the set of all valid words in the given Boggle board, as an Iterable.
 * <br> public Iterable<String> getAllValidWords(BoggleBoard board)
 * <br> 
 * <br> // Returns the score of the given word if it is in the dictionary, zero otherwise.
 * <br> // (You can assume the word contains only the uppercase letters A through Z.)
 * <br> public int scoreOf(String word)
 * <br> }
 * </tt>
 * <p>
 * See also the <a
 * href="http://coursera.cs.princeton.edu/algs4/checklists/boggle.html">
 * Boggle checklist</a>
 * <p>
 * Note: The main method has been provided as part of the assignment
 * 
 */
public class BoggleSolver
{

    /**
     * Initializes the data structure using the given array of strings as the dictionary.
     * (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
     * @param dictionary
     */
    public BoggleSolver(String[] dictionary)
    {
    }

    /**
     * Returns the set of all valid words in the given Boggle board, as an Iterable.
     * @param board
     * @return
     */
    public Iterable<String> getAllValidWords(BoggleBoard board)
    {
        return null;
    }

    /**
     * Returns the score of the given word if it is in the dictionary, zero otherwise.
     * (You can assume the word contains only the uppercase letters A through Z.)
     * @param word
     * @return
     */
    public int scoreOf(String word)
    {
        return -1;
    }

    public static void main(String[] args)
    {
        In in = new In(args[0]);
        String[] dictionary = in.readAllStrings();
        BoggleSolver solver = new BoggleSolver(dictionary);
        BoggleBoard board = new BoggleBoard(args[1]);
        int score = 0;
        for (String word : solver.getAllValidWords(board))
        {
            StdOut.println(word);
            score += solver.scoreOf(word);
        }
        StdOut.println("Score = " + score);
    }

}
