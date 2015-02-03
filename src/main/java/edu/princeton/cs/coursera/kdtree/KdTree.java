package edu.princeton.cs.coursera.kdtree;

import edu.princeton.cs.algs4.fundamentals.Point2D;

/**
 * This class is a mutable data type that represents a set of points in the unit
 * square to support efficient range search (find all of the points contained in
 * a query rectangle) and nearest neighbor search (find a closest point to a
 * query point), as described in the <a href="
 * http://coursera.cs.princeton.edu/algs4/assignments/kdtree.html">Kd-Trees</a>
 * assignment. <br>
 * This is implementation uses a 2d-tree to implement the following API. A
 * 2d-tree is a generalization of a BST to two-dimensional keys. The idea is to
 * build a BST with points in the nodes, using the x- and y-coordinates of the
 * points as keys in strictly alternating sequence. <li>Search and insert. The
 * algorithms for search and insert are similar to those for BSTs, but at the
 * root we use the x-coordinate (if the point to be inserted has a smaller
 * x-coordinate than the point at the root, go left; otherwise go right); then
 * at the next level, we use the y-coordinate (if the point to be inserted has a
 * smaller y-coordinate than the point in the node, go left; otherwise go
 * right); then at the next level the x-coordinate, and so forth. <li>Draw. A
 * 2d-tree divides the unit square in a simple way: all the points to the left
 * of the root go in the left subtree; all those to the right go in the right
 * subtree; and so forth, recursively. The draw() method should draw all of the
 * points to standard draw in black and the subdivisions in red (for vertical
 * splits) and blue (for horizontal splits). This method need not be
 * efficient—it is primarily for debugging. <br>
 * <p>
 * The prime advantage of a 2d-tree over a BST is that it supports efficient
 * implementation of range search and nearest neighbor search. Each node
 * corresponds to an axis-aligned rectangle in the unit square, which encloses
 * all of the points in its subtree. The root corresponds to the unit square;
 * the left and right children of the root corresponds to the two rectangles
 * split by the x-coordinate of the point at the root; and so forth.
 * <li>Range search. To find all points contained in a given query rectangle,
 * start at the root and recursively search for points in both subtrees using
 * the following pruning rule: if the query rectangle does not intersect the
 * rectangle corresponding to a node, there is no need to explore that node (or
 * its subtrees). A subtree is searched only if it might contain a point
 * contained in the query rectangle.
 * <li>Nearest neighbor search. To find a closest point to a given query point,
 * start at the root and recursively search in both subtrees using the following
 * pruning rule: if the closest point discovered so far is closer than the
 * distance between the query point and the rectangle corresponding to a node,
 * there is no need to explore that node (or its subtrees). That is, a node is
 * searched only if it might contain a point that is closer than the best one
 * found so far. The effectiveness of the pruning rule depends on quickly
 * finding a nearby point. To do this, organize your recursive method so that
 * when there are two possible subtrees to go down, you always choose the
 * subtree that is on the same side of the splitting line as the query point as
 * the first subtree to explore—the closest point found while exploring the
 * first subtree may enable pruning of the second subtree. <br>
 * <p>
 * API definition: <br>
 * <tt>
 * public class KdTree
 * <br> {
 * <br> public KdTree()
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
public class KdTree
{

    /**
     * Construct an empty tree
     */
    public KdTree()
    {
    }

    /**
     * Is the tree empty?
     * 
     * @return True if the tree is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return false;
    }

    /**
     * Number of points in the tree
     * 
     * @return Number of points in the tree
     */
    public int size()
    {
        return -1;
    }

    /**
     * Add the point p to the tree (if it is not already in the tree)
     * 
     * @param p
     *            Point2D to be added to the tree
     */
    public void insert(Point2D p)
    {
    }

    /**
     * Does the tree contain the point p?
     * 
     * @param p
     *            Point2D to be checked for containment
     * @return True if the tree contains the point, false otherwise
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
     * All points in the tree that are inside the rectangle
     * 
     * @param rect
     *            The rectangle specifying the boundaries
     * @return An iterable containing all the points in the tree that lie within
     *         the bounding rectangle
     */
    public Iterable<Point2D> range(RectHV rect)
    {
        return null;
    }

    /**
     * A nearest neighbor in the tree to p; null if set is empty
     * 
     * @param p
     *            The Point2D to find the nearest neighbor to
     * @return The nearest neighbor of the given point; null if the tree is
     *         empty
     */
    public Point2D nearest(Point2D p)
    {
        return null;
    }

    /**
     * Unit testing of the methods (optional) 
     * @param args
     */
    public static void main(String[] args)
    {
    }
}
