package edu.princeton.cs.coursera.collinear;

/**
 * This class examines 4 points at a time and checks whether they all lie on the
 * same line segment as described in the <a href="
 * http://coursera.cs.princeton.edu/algs4/assignments/collinear.html">Pattern
 * Recognition</a>:
 * 
 * Write a program that examines 4 points at a time and checks whether they all
 * lie on the same line segment, printing out any such line segments to standard
 * output and drawing them using standard drawing. To check whether the 4 points
 * p, q, r, and s are collinear, check whether the slopes between p and q,
 * between p and r, and between p and s are all equal. The order of growth of
 * the running time of the program should be N^4 in the worst case and it should
 * use space proportional to N.
 * <p>
 * API definition: <br>
 * <tt>
 * public class Brute
 * <br> {
 * <br>  public BruteCollinearPoints(Point[] points)
 * <br>         // finds all line segments containing 4 points
 * <br>   public int numberOfSegments()
 * <br>         // the number of line segments
 * <br>   public LineSegment[] segments()
 * <br>         // the line segments
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

public class BruteCollinearPoints
{
    public BruteCollinearPoints(Point[] points)
    {
    }

    /**
     * The number of line segments
     * 
     * @return
     */
    public int numberOfSegments()
    {
        return -1;
    }

    /**
     * The line segments
     * 
     * @return
     */
    public LineSegment[] segments()
    {
        return null;
    }
}
