package edu.princeton.cs.coursera.collinear;


/**
 * This class implements a faster, sorting-based solution algorithm for
 * examining 4 points at a time and checks whether they all lie on the same line
 * segment as described in the <a href="
 * http://coursera.cs.princeton.edu/algs4/assignments/collinear.html">Pattern
 * Recognition</a>:
 * 
 * Given a point p, the following method determines whether p participates in a
 * set of 4 or more collinear points.
 * 
 * <li>Think of p as the origin.</li> <li>For each other point q, determine the
 * slope it makes with p.</li> <li>Sort the points according to the slopes they
 * makes with p.</li> <li>Check if any 3 (or more) adjacent points in the sorted
 * order have equal slopes with respect to p. If so, these points, together with
 * p, are collinear.</li>
 * 
 * Applying this method for each of the N points in turn yields an efficient
 * algorithm to the problem. The algorithm solves the problem because points
 * that have equal slopes with respect to p are collinear, and sorting brings
 * such points together. The algorithm is fast because the bottleneck operation
 * is sorting.
 * 
 * The order of growth of the running time of your program should be N^2 log N
 * in the worst case and it should use space proportional to N.
 * <p>
 * API definition: <br>
 * <tt>
 * public class Fast
 * <br> {
 * <br>     public static void main(String[] args)
 * <br> }
 * </tt>
 * <p>
 * See also the <a href="
 * http://coursera.cs.princeton.edu/algs4/checklists/collinear.html">Pattern
 * Recognition checklist</a>
 * 
 * @author Bram Lohman
 * 
 */

public class Fast
{
    public static void main(String[] args)
    {
    }
}