package edu.princeton.cs.coursera.kdtree;

import edu.princeton.cs.algs4.fundamentals.Point2D;
import edu.princeton.cs.algs4.fundamentals.RectHV;

/**
 * This class is a mutable data type that represents a set of points in the unit
 * square to support efficient range search (find all of the points contained in
 * a query rectangle) and nearest neighbor search (find a closest point to a
 * query point), as described in the <a href="
 * http://coursera.cs.princeton.edu/algs4/assignments/kdtree.html">Kd-Trees</a>
 * assignment. <br>
 * This is the brute-force implementation, implementing the following API by
 * using a red-black BST (using either SET from algs4.jar or java.util.TreeSet).
 * <p>
 * API definition: <br>
 * <tt>
 * public class PointSET
 * <br> {
 * <br> public PointSET()
 * <br>      // construct an empty set of points
 * <br> public boolean isEmpty()
 * <br>     // is the set empty?
 * <br> public int size()
 * <br>    // number of points in the set
 * <br> public void insert(Point2D p)
 * <br>    // add the point p to the set (if it is not already in the set)
 * <br> public boolean contains(Point2D p)
 * <br>    // does the set contain the point p?
 * <br> public void draw()
 * <br>       // draw all of the points to standard draw
 * <br> public Iterable<Point2D> range(RectHV rect)
 * <br>       // all points in the set that are inside the rectangle
 * <br> public Point2D nearest(Point2D p)
 * <br> // a nearest neighbor in the set to p; null if set is empty
 * <br> }
 * </tt>
 * <p>
 * See also the <a
 * href="http://coursera.cs.princeton.edu/algs4/checklists/kdtree.html">
 * Kd-Trees checklist</a>
 * <p>
 * This class uses the Point2D and RectHV data types provided with the
 * assignment
 * 
 * @author Bram Lohman
 */
public class PointSET
{

    /**
     * Construct an empty set of points
     */
    public PointSET()
    {
    }

    /**
     * Is the set empty?
     * 
     * @return True if the set is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return false;
    }

    /**
     * Number of points in the set
     * 
     * @return Number of points in the set
     */
    public int size()
    {
        return 0;
    }

    /**
     * Add the point p to the set (if it is not already in the set)
     * 
     * @param p
     *            Point2D to be added to the set
     */
    public void insert(Point2D p)
    {
    }

    /**
     * Does the set contain the point p?
     * 
     * @param p
     *            Point2D to be checked for containment
     * @return True if the set contains the point, false otherwise
     */
    public boolean contains(Point2D p)
    {
        return false;
    }

    /**
     * Draw all of the points to standard draw
     */
    public void draw()
    {
    }

    /**
     * All points in the set that are inside the rectangle
     * 
     * @param rect
     *            The rectangle specifying the boundaries
     * @return An iterable containing all the points in the set that lie within
     *         the bounding rectangle
     */
    public Iterable<Point2D> range(RectHV rect)
    {
        return null;
    }

    /**
     * A nearest neighbor in the set to p; null if set is empty
     * 
     * @param p
     *            The Point2D to find the nearest neighbor to
     * @return The nearest neighbor of the given point; null if the set is empty
     */
    public Point2D nearest(Point2D p)
    {
        return null;
    }

    /**
     * Unit testing of the methods (optional)
     * 
     * @param args
     */
    public static void main(String[] args)
    {
    }

}