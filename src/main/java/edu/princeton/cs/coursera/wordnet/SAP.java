package edu.princeton.cs.coursera.wordnet;

import edu.princeton.cs.algs4.graphs.Digraph;
import edu.princeton.cs.algs4.io.In;
import edu.princeton.cs.algs4.io.StdIn;
import edu.princeton.cs.algs4.io.StdOut;

/**
 * This class implements an immutable data type that calculates the Shortest
 * Ancestral Path (SAP) between two vertices v and w in a digraph, as described
 * in the <a href="
 * http://coursera.cs.princeton.edu/algs4/assignments/wordnet.html">WordNet</a>
 * assignment.<br>
 * 
 * An ancestral path is a directed path from v to a common ancestor x, together
 * with a directed path from w to the same ancestor x. A shortest ancestral path
 * is an ancestral path of minimum total length.
 * 
 * 
 * API definition: <br>
 * <tt>
 * public class SAP
 * <br>  {
 * <br> 
 * <br>    // constructor takes a digraph (not necessarily a DAG)
 * <br>    public SAP(Digraph G)
 * <br> 
 * <br>    // length of shortest ancestral path between v and w; -1 if no such path
 * <br>    public int length(int v, int w)
 * <br> 
 * <br>    // a common ancestor of v and w that participates in a  
 * <br>    // shortest ancestral path; -1 if no such path
 * <br>    public int ancestor(int v, int w)
 * <br> 
 * <br>    // length of shortest ancestral path between any vertex in v and
 * <br>    //  any vertex in w; -1 if no such path
 * <br>    public int length(Iterable<Integer> v, Iterable<Integer> w)
 * <br> 
 * <br>    // a common ancestor that participates in shortest ancestral 
 * <br>    // path; -1 if no such path
 * <br>    public int ancestor(Iterable<Integer> v, Iterable<Integer> w)
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
 * This class is used by the WordNet data type whose interface is defined as
 * part of the assignment
 * 
 * @author Bram Lohman
 */
public class SAP
{
    /**
     * Constructor takes a {@link Digraph} (not necessarily a DAG)
     * 
     * @param G
     *            The input digraph
     */
    public SAP(Digraph G)
    {
    }

    /**
     * Length of shortest ancestral path between v and w; -1 if no such path
     * 
     * @param v
     *            Vertex of the digraph
     * @param w
     *            Vertex of the digraph
     * @return Length of shortest ancestral path between v and w; -1 if no such
     *         path
     */
    public int length(int v, int w)
    {
        return -1;
    }

    /**
     * A common ancestor of v and w that participates in a shortest ancestral
     * path; -1 if no such path
     * 
     * @param v
     *            Vertex of the digraph
     * @param w
     *            Vertex of the digraph
     * @return A common ancestor of v and w that participates in a shortest
     *         ancestral path; -1 if no such path
     */
    public int ancestor(int v, int w)
    {
        return -1;
    }

    /**
     * Length of shortest ancestral path between any vertex in v and any vertex
     * in w; -1 if no such path
     * 
     * @param v
     *            An iterable containing a number of vertices in the digraph
     * @param w
     *            An iterable containing a number of vertices in the digraph
     * @return Length of shortest ancestral path between any vertex in v and any
     *         vertex in w; -1 if no such path
     */
    public int length(Iterable<Integer> v, Iterable<Integer> w)
    {
        return -1;
    }

    /**
     * A common ancestor that participates in shortest ancestral path; -1 if no
     * such path
     * 
     * @param v
     *            An iterable containing a number of vertices in the digraph
     * @param w
     *            An iterable containing a number of vertices in the digraph
     * @return A common ancestor that participates in shortest ancestral path;
     *         -1 if no such path
     */
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w)
    {
        return -1;
    }

    /**
     * Do unit testing of this class. Method provided as part of the assignment.
     * Sample invocation: java SAP digraph1.txt 3 11 9 12
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        // Read Digraph (vertices, edges, pairs of vertices)
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        SAP sap = new SAP(G);

        // Read pair of vertices in graph, calculate length of sap, ancestor
        while (!StdIn.isEmpty())
        {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            int length = sap.length(v, w);
            int ancestor = sap.ancestor(v, w);
            StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
        }
    }
}