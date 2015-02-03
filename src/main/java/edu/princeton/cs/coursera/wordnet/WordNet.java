package edu.princeton.cs.coursera.wordnet;

/**
 * This class is an immutable data type that represents a semantic lexicon for
 * the English language, 'WordNet', as described in the <a href="
 * http://coursera.cs.princeton.edu/algs4/assignments/wordnet.html">WordNet</a>
 * assignment.<br>
 * WordNet is used extensively by computational linguists and cognitive
 * scientists. WordNet groups words into sets of synonyms called synsets and
 * describes semantic relationships between them. One such relationship is the
 * is-a relationship, which connects a hyponym (more specific synset) to a
 * hypernym (more general synset). For example, a plant organ is a hypernym of
 * carrot and plant organ is a hypernym of plant root.
 * 
 * API definition: <br>
 * <tt>
 * 
 * public class WordNet
 * <br> {
 * <br> 
 * <br>    // constructor takes the name of the two input files
 * <br>    public WordNet(String synsets, String hypernyms)
 * <br> 
 * <br>    // returns all WordNet nouns
 * <br>    public Iterable<String> nouns()
 * <br> 
 * <br>    // is the word a WordNet noun?
 * <br>    public boolean isNoun(String word)
 * <br> 
 * <br>    // distance between nounA and nounB (defined below)
 * <br>    public int distance(String nounA, String nounB)
 * <br> 
 * <br>    // a synset (second field of synsets.txt) that is the 
 * <br>    // common ancestor of nounA and nounB
 * <br>    // in a shortest ancestral path (defined below)
 * <br>    public String sap(String nounA, String nounB)
 * <br> 
 * <br>    // do unit testing of this class
 * <br>    public static void main(String[] args)
 * <br> }
 * </tt>
 * <p>
 * See also the <a
 * href="http://coursera.cs.princeton.edu/algs4/checklists/wordnet.html">
 * WordNet checklist</a>
 * <p>
 * This class makes use of the SAP data type whose interface is defined as part
 * of the assignment
 * 
 * @author Bram Lohman
 */
public class WordNet
{
    /**
     * Constructor takes the name of the two input files
     * 
     * @param synsets
     *            The name of the file containing the synonym sets
     * @param hypernyms
     *            The name of the file containing the hypernyms
     */
    public WordNet(String synsets, String hypernyms)
    {
    }

    /**
     * Returns all WordNet nouns
     * 
     * @return An {@link Iterable} containing all the WordNet nouns of the given
     *         input
     */
    public Iterable<String> nouns()
    {
        return null;
    }

    /**
     * Is the word a WordNet noun?
     * 
     * @param word
     *            The word to check for noun-ness
     * @return True if the word is a WordNet noun, false otherwise
     */
    public boolean isNoun(String word)
    {
        return false;
    }

    /**
     * Distance between nounA and nounB. The distance is defined as: <br>
     * distance(A, B) = distance is the minimum length of any ancestral path
     * between any synset v of A and any synset w of B
     * 
     * @param nounA
     *            First noun used for checking distance
     * @param nounB
     *            Second noun used for checking distance
     * @return The minimum length of any ancestral path nounA and nounB; -1 if
     *         no such path exists
     */
    public int distance(String nounA, String nounB)
    {
        return -1;
    }

    /**
     * A synset (second field of synsets.txt) that is the common ancestor of
     * nounA and nounB in a {@link SAP}
     * 
     * @param nounA
     *            First noun used for checking distance
     * @param nounB
     *            Second noun used for checking distance
     * @return The string representation of the common ancestor of nounA and
     *         nounB; returns the empty String if no such ancestor exists
     */
    public String sap(String nounA, String nounB)
    {
        return null;
    }

    /**
     * Do unit testing of this class
     * 
     * @param args
     */
    public static void main(String[] args)
    {
    }
}