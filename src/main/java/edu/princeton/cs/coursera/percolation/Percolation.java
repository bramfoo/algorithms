package edu.princeton.cs.coursera.percolation;

import java.util.logging.Logger;

import edu.princeton.cs.algs4.fundamentals.WeightedQuickUnionUF;

/**
 * This class implements a percolation system as defined in the <a
 * href="http://coursera.cs.princeton.edu/
 * algs4/assignments/percolation.html">Percolation assignment</a>: We model a
 * percolation system using an N-by-N grid of sites. Each site is either open or
 * blocked. A full site is an open site that can be connected to an open site in
 * the top row via a chain of neighboring (left, right, up, down) open sites. We
 * say the system percolates if there is a full site in the bottom row. In other
 * words, a system percolates if we fill all open sites connected to the top row
 * and that process fills some open site on the bottom row.
 * <p>
 * API definition: <br>
 * <tt>
 *  public class Percolation {
 *  <br>    public Percolation(int N)              
 *                  // create N-by-N grid, with all sites blocked
 *  <br>    public void open(int i, int j)        
 *                  // open site (row i, column j) if it is not already
 *  <br>    public boolean isOpen(int i, int j)
 *                  // is site (row i, column j) open?
 *  <br>    public boolean isFull(int i, int j)
 *                  // is site (row i, column j) full?
 *  <br>    public boolean percolates()
 *                  // does the system percolate?
 *  <br> }
 * <p>
 * See also the <a href="http://coursera.cs.princeton.edu/
 * algs4/checklists/percolation.html">Percolation checklist</a>
 * 
 * @author Bram Lohman
 * 
 */
public class Percolation
{
    /**
     * Create N-by-N grid, with all sites blocked
     * 
     * @param N
     *            Length of one side of the (square) grid
     */
    public Percolation(int N)
    {
    }

    /**
     * Open the site at position (i, j)
     * 
     * @param i
     *            The row number (starting at 1)
     * @param j
     *            The column number (starting at 1)
     */
    public void open(int i, int j)
    {
    }

    /**
     * Check if site (i, j) is open
     * 
     * @param i
     *            The row number (starting at 1)
     * @param j
     *            The column number (starting at 1)
     * @return
     */
    public boolean isOpen(int i, int j)
    {
        return false;
    }

    /**
     * Check if site (i, j) is full. A site is full if it is open, and connected
     * to the top row (or the virtual node above it)
     * 
     * @param i
     *            The row number (starting at 1)
     * @param j
     *            The column number (starting at 1)
     * @return True if the site if full, false if not
     */
    public boolean isFull(int i, int j)
    {
        return false;
    }

    /**
     * Check if the system percolates. The system percolates if any site in the
     * top row is connected to any site in the bottom row.
     * 
     * @return True if the system percolates, false if not
     */
    public boolean percolates()
    {
        return false;
    }
}
