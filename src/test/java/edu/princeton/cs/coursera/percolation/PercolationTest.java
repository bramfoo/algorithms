package edu.princeton.cs.coursera.percolation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import edu.princeton.cs.introcs.In;

/**
 * Unit tests for Percolation
 */
@RunWith(JUnit4.class)
public class PercolationTest
{
    int N;
    Percolation p;

    // These are used by the assignment tests
    private Percolation in;

    private String in3fileName = "/percolation/input3.txt";
    private String in4fileName = "/percolation/input4.txt";
    private String in7fileName = "/percolation/input7.txt";
    private String in10fileName = "/percolation/input10.txt";
    private String in20fileName = "/percolation/input20.txt";
    private String in50fileName = "/percolation/input50.txt";


    final String ioob = "row index i out of bounds"; 
    final String joob = "row index j out of bounds";
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Before 
    public void setup()
    {
        N = 5;
        p = new Percolation(N);
    }

    @Test
    public void testSizeMinus10()
    {
        N = -10;

        exception.expect(IllegalArgumentException.class);
        p = new Percolation(N);
    } 

    @Test
    public void testSize0()
    {
        N = 0;

        exception.expect(IllegalArgumentException.class);
        p = new Percolation(N);
    } 

    @Test
    public void testSize1()
    {
        N = 1;
        p = new Percolation(1);
        // All sites set to false
        for (int i = 1; i <= N; i++) 
            for (int j = 1; j <= N; j++)
                assertFalse(p.isOpen(i, j));
        
        assertFalse("No route", p.percolates());

        p.open(1, 1);
        assertTrue("Single site should be open", p.isOpen(1, 1));
        assertTrue("Single site should be full", p.isFull(1, 1));
        assertTrue("Single site is full, should percolate", p.percolates());
    } 

    @Test
    public void testInit()
    {
        // All sites set to false
        for (int i = 1; i <= N; i++) 
            for (int j = 1; j <= N; j++)
                assertFalse(p.isOpen(i, j));
    } 

    @Test
    public void testParams()
    {
        // Lower bounds
        try {
            p.open(0, 0);
        } catch (IndexOutOfBoundsException e) {
            assertEquals(e.getMessage(), ioob);
        }
        try {
            p.isOpen(1, 0);
        } catch (IndexOutOfBoundsException e) {
            assertEquals(e.getMessage(), joob);
        } 
        
        // Upper bounds
        try {
            p.isFull(N+1, 0);
        } catch (IndexOutOfBoundsException e) {
            assertEquals(e.getMessage(), ioob);
        } 
        try {
            p.open(1, N+1);
        } catch (IndexOutOfBoundsException e) {
            assertEquals(e.getMessage(), joob);
        } 
    }

    @Test
    public void testOpen()
    {
        for (int i = 1; i <= N; i++) 
            for (int j = 1; j <= N; j++)
            {
                assertFalse(p.isOpen(i, j));        
                p.open(i, j);
                assertTrue(p.isOpen(i, j));
            }

        // Opening again does not change state
        p.open(2, 3);
        assertTrue(p.isOpen(2, 3));
    } 

    @Test
    public void testIsFull()
    {
        // Virtual top/bottom sites should be connected
        // Note: cannot test bottom site directly
        for (int j = 1; j <= N; j++)
        {
            p.open(1, j);
            assertTrue(p.isOpen(1, j));
            assertTrue("Top row site should be auto-connected in constructor", p.isFull(1, j));
        }
        
        assertFalse("Site is not open, so not full", p.isFull(3, 4));
        
        p.open(3, 1);
        assertTrue(p.isOpen(3, 1));
        assertFalse("No route exists", p.isFull(3, 1));

        p.open(2, 1);
        assertTrue(p.isOpen(2, 1));
        assertTrue("Route exists", p.isFull(2, 1));
        assertTrue("Route exists", p.isFull(3, 1));
        
    }

    @Test
    public void testPercolates()
    {
        assertFalse(p.percolates());
        
        p.open(1, 3);
        p.open(2, 3);
        p.open(5, 4);
        p.open(4, 4);
        p.open(3, 4);
        assertFalse(p.percolates());

        p.open(3, 3);
        assertTrue(p.percolates());
        
        // Still percolates
        p.open(1, 1);
        assertTrue(p.percolates());

        p.open(2, 1);
        p.open(3, 1);
        p.open(4, 1);
        p.open(5, 1);
        assertTrue(p.percolates());
    }
    
    @Test
    public void testBackwash()
    {
    	// From assignment: Check for backwash with predetermined sites
    	in = createPercolationFromFile(in10fileName, 56);
    	assertTrue("System should percolate", in.percolates());
    	assertFalse("Backwash detected: site should be open but not full", in.isFull(9, 1));
    			
    	in = createPercolationFromFile(in20fileName, 231);
    	assertTrue("System should percolate", in.percolates());
    	assertFalse("Backwash detected: site should be open but not full", in.isFull(18, 1));

    	in = createPercolationFromFile(in50fileName, 2099);
    	assertTrue("System should percolate", in.percolates());
    	assertFalse("Backwash detected: site should be open but not full", in.isFull(22, 28));
    }

    @Test
    public void testBackwash2()
    {
    	// From assignment: Check for backwash with predetermined sites that have
    	//  multiple percolating paths

    	in = createPercolationFromFile(in3fileName, 4);
    	assertTrue("System should percolate", in.percolates());
    	assertFalse("Backwash detected: site should be open but not full", in.isFull(3, 1));

    	in = createPercolationFromFile(in4fileName, 7);
    	assertTrue("System should percolate", in.percolates());
    	assertFalse("Backwash detected: site should be open but not full", in.isFull(4, 4));

    	in = createPercolationFromFile(in7fileName, 12);
    	assertTrue("System should percolate", in.percolates());
    	assertFalse("Backwash detected: site should be open but not full", in.isFull(6, 1));
    }
    
    private Percolation createPercolationFromFile(String fileName, int linesToRead)
    {
        // Files found in the '/test/resources/percolation/' directory
        assertNotNull("Test file missing", getClass().getResource(fileName));

        In in = new In(fileName);
        int N = in.readInt();

        Percolation p = new Percolation(N);

        // Fill array of points
        for (int i = 0; i < linesToRead; i++)
        {
        	int x = in.readInt();
        	int y = in.readInt();
        	p.open(x, y);
        }        
        return p;
    }
}
