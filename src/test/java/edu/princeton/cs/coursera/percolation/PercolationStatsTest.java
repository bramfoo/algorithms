package edu.princeton.cs.coursera.percolation;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Unit tests for Percolation
 */
@RunWith(JUnit4.class)
public class PercolationStatsTest
{
    PercolationStats ps;
    int N;
    int T;
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testSize1()
    {
        N = 1;
        T = 1;
        ps = new PercolationStats(N, T);
    } 

    @Test
    public void testSizeMinus10()
    {
        N = -10;
        T = 1;

        exception.expect(IllegalArgumentException.class);
        ps = new PercolationStats(N, T);
    } 

    @Test
    public void testSizeMinus1()
    {
        N = -1;
        T = 1;

        exception.expect(IllegalArgumentException.class);
        ps = new PercolationStats(N, T);
    } 
    
    @Test
    public void testSize0()
    {
        N = 0;
        T = 1;

        exception.expect(IllegalArgumentException.class);
        ps = new PercolationStats(N, T);
    }    
}
