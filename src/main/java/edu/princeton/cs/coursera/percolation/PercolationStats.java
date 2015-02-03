package edu.princeton.cs.coursera.percolation;


/**
 * This class estimates the value of the percolation threshold via Monte Carlo
 * simulation, as described in the <a
 * href="http://coursera.cs.princeton.edu/algs4/
 * assignments/percolation.html">Percolation assignment</a>
 * <p>
 * API definition: <br>
 * <tt>
 * public class PercolationStats {
 * <br>     public PercolationStats(int N, int T)    
 *  // perform T independent computational experiments on an N-by-N grid
 * <br>     public double mean()                     
 *                      // sample mean of percolation threshold
 * <br>     public double stddev()                   
 *              // sample standard deviation of percolation threshold
 * <br>     public double confidenceLo()             
 *              // returns lower bound of the 95% confidence interval
 * <br>     public double confidenceHi()             
 *              // returns upper bound of the 95% confidence interval
 * <br>     public static void main(String[] args)   
 *              // test client, described below
 * <br> }
 * 
 * @author Bram Lohman
 * 
 */
public class PercolationStats
{

    /**
     * Perform T independent computational experiments on an N-by-N grid
     * 
     * @param N
     *            Length of one side of the (square) grid
     * @param T
     *            Number of (independent) experiments
     */
    public PercolationStats(int N, int T)
    {
    }

    /**
     * Sample mean of percolation threshold
     */
    public double mean()
    {
        return -1d;
    }

    /**
     * Sample standard deviation of percolation threshold
     */
    public double stddev()
    {
        return -1d;
    }

    /**
     * Returns lower bound of the 95% confidence interval
     */
    public double confidenceLo()
    {
        return -1d;
    }

    /**
     * Returns upper bound of the 95% confidence interval
     */
    public double confidenceHi()
    {
        return -1d;
    }

    /**
     * Main method. Takes two command-line arguments N and T, performs T
     * independent computational experiments on an N-by-N grid, and prints out
     * the mean, standard deviation, and the 95% confidence interval for the
     * percolation threshold.
     */
    public static void main(String[] args)
    {
    }
}
