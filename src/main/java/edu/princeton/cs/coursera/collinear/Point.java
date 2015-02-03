package edu.princeton.cs.coursera.collinear;

import java.util.Comparator;

import edu.princeton.cs.introcs.StdDraw;

/**
 * This class implements an immutable data type Point that represents a point in
 * the plane as described in the <a
 * href="http://coursera.cs.princeton.edu/algs4/assignments/collinear.html"
 * >Pattern Recognition</a>:
 * 
 * Create an immutable data type Point that represents a point in the plane by
 * implementing the following API:
 * <p>
 * API definition: <br>
 * <tt>
 * public class Point implements Comparable<Point>
 * <br> {
 * <br> public final Comparator<Point> SLOPE_ORDER;
 *         // compare points by slope to this point
 * <br> public Point(int x, int y)
 *                   // construct the point (x, y)
 * <br> public   void draw()
 *                   // draw this point
 * <br> public   void drawTo(Point that)
 *                   // draw the line segment from this point to that point
 * <br> public String toString()
 *                   // string representation
 * <br> public    int compareTo(Point that)
 *           // is this point lexicographically smaller than that point?
 * <br> public double slopeTo(Point that)
 *              // the slope between this point and that point
 * <br> }
 * </tt>
 * <p>
 * See also the <a href="http://coursera.cs.princeton.edu/
 * algs4/checklists/collinear.html">Pattern Recognition checklist</a>
 * 
 * The constructor and the draw(), drawTo(), and toString() methods were taken
 * from <a href="http://coursera.cs.princeton.edu/algs4/checklists/Point.java"
 * >Point.java</a>
 * 
 * @author Bram Lohman
 * 
 */

public class Point implements Comparable<Point>
{

    // Compare points by slope to this point
    // The SLOPE_ORDER comparator should compare points by the slopes they make
    // with the invoking point (x0, y0).
    public final Comparator<Point> SLOPE_ORDER = null;

    private final int x; // x coordinate
    private final int y; // y coordinate

    /**
     * Construct the point (x, y) Method provided as part of assignment
     * 
     * @param x
     *            The x-coordinate of the point
     * @param y
     *            The y-coordinate of the point
     */
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Draw this point
     * Method provided as part of assignment
     */
    public void draw()
    {
        StdDraw.point(x, y);
    }

    /**
     * Draw the line segment from this point to that point
     * Method provided as part of assignment
     * 
     * @param that
     *            The point to draw to
     */
    public void drawTo(Point that)
    {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // String representation
    // Method provided as part of assignment
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }

    // Is this point lexicographically smaller than that point?
    // The compareTo() method should compare points by their y-coordinates,
    // breaking ties by their x-coordinates. Formally, the invoking point (x0,
    // y0) is less than the argument point (x1, y1) if and only if either y0 <
    // y1 or if y0 = y1 and x0 < x1.
    public int compareTo(Point that)
    {
        return -1;
    }

    /**
     * The slope between this point and that point
     * 
     * The slopeTo() method should return the slope between the invoking point
     * (x0, y0) and the argument point (x1, y1), which is given by the formula
     * (y1 − y0) / (x1 − x0). Treat the slope of a horizontal line segment as
     * positive zero; treat the slope of a vertical line segment as positive
     * infinity; treat the slope of a degenerate line segment (between a point
     * and itself) as negative infinity.
     * 
     * @param that
     *            The point to draw to
     * @return The slope between the invoking point and the argument point
     */
    public double slopeTo(Point that)
    {
        return -1;
    }
}
