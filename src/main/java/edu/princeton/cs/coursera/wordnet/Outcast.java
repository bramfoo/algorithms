package edu.princeton.cs.coursera.wordnet;

import edu.princeton.cs.algs4.io.In;
import edu.princeton.cs.algs4.io.StdOut;

/**
 * This class implements an immutable data type that calculates the outcast of a
 * list of nouns, i.e. which noun is the least related to the others, as
 * described in the <a href="
 * http://coursera.cs.princeton.edu/algs4/assignments/wordnet.html">WordNet</a>
 * assignment.<br>
 * To identify an outcast, the sum of the distances between each noun and every
 * other one is computed: <br>
 * di = dist(Ai, A1) + dist(Ai, A2) + ... + dist(Ai, An) <br>
 * and the noun At for which dt is maximum is returned.
 * 
 * API definition: <br>
 * <tt>
 * <br> public class Outcast
 * <br> {
 * <br> 
 * <br>          // constructor takes a WordNet object
 * <br>    public Outcast(WordNet wordnet)
 * <br>
 * <br>   // given an array of WordNet nouns, return an outcast
 * <br>    public String outcast(String[] nouns)   
 * <br> 
 * <br>    // see test client below
 * <br>    public static void main(String[] args) 
 * <br> }
 * </tt>
 * <p>
 * See also the <a
 * href="http://coursera.cs.princeton.edu/algs4/checklists/wordnet.html">
 * WordNet checklist</a>
 * <p>
 * This class is uses the WordNet data type whose interface is defined as part
 * of the assignment
 * 
 * @author Bram Lohman
 */
public class Outcast
{
    /**
     * Constructor takes a WordNet object
     * 
     * @param wordnet
     *            A WordNet object
     */
    public Outcast(WordNet wordnet)
    {
    }

    /**
     * Given an array of WordNet nouns, return an outcast
     * 
     * @param nouns
     *            Array of WordNet nouns
     * @return The outcast, or least related noun, of the input
     */
    public String outcast(String[] nouns)
    {
        return null;
    }

    /**
     * Do unit testing of this class. Method provided as part of the assignment.
     * Sample invocation:
     *   java Outcast synsets.txt hypernyms.txt outcast5.txt outcast8.txt outcast11.txt
     * Output:
     *   outcast5.txt: table
     *   outcast8.txt: bed
     *   outcast11.txt: potato
     * @param args
     */
    public static void main(String[] args)
    {
        WordNet wordnet = new WordNet(args[0], args[1]);
        Outcast outcast = new Outcast(wordnet);
        for (int t = 2; t < args.length; t++)
        {
            In in = new In(args[t]);
            String[] nouns = in.readAllStrings();
            StdOut.println(args[t] + ": " + outcast.outcast(nouns));
        }
    }
}
