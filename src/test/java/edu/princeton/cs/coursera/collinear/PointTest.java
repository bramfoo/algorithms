package edu.princeton.cs.coursera.collinear;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Unit tests for Point
 */
@RunWith(JUnit4.class)
public class PointTest
{
    Point p;
    Point q;
    Point r;
    final int LESS = -1;
    final int EQUAL = 0;
    final int GREATER = 1;
    final double NEG_INF = Double.NEGATIVE_INFINITY;
    final double POS_INF = Double.POSITIVE_INFINITY;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setup()
    {
    }

    @Test
    public void testCompareTo()
    {
        p = new Point(0, 0);
        q = new Point(0, 0);

        assertEquals("Result should be equal", EQUAL, p.compareTo(p));
        assertEquals("Result should be equal", EQUAL, p.compareTo(q));
        assertEquals("Result should be equal", EQUAL, q.compareTo(p));

        q = new Point(0, 1);
        assertEquals("Result should be less than", LESS, p.compareTo(q));
        assertEquals("Result should be greater than", GREATER, q.compareTo(p));

        q = new Point(1, 0);
        assertEquals("Result should be less than", LESS, p.compareTo(q));
        assertEquals("Result should be greater than", GREATER, q.compareTo(p));

        q = new Point(1, 1);
        assertEquals("Result should be less than", LESS, p.compareTo(q));
        assertEquals("Result should be greater than", GREATER, q.compareTo(p));

        q = new Point(0, -1);
        assertEquals("Result should be greater than", GREATER, p.compareTo(q));
        assertEquals("Result should be less than", LESS, q.compareTo(p));

        q = new Point(-1, 0);
        assertEquals("Result should be greater than", GREATER, p.compareTo(q));
        assertEquals("Result should be less than", LESS, q.compareTo(p));

        q = new Point(-1, -1);
        assertEquals("Result should be greater than", GREATER, p.compareTo(q));
        assertEquals("Result should be less than", LESS, q.compareTo(p));

        q = null;
        exception.expect(NullPointerException.class);
        p.compareTo(q);
    }

    @Test
    public void testSlopeTo()
    {
        p = new Point(0, 0);
        q = new Point(0, 0);
        
        assertEquals("Result should be negative infinity", NEG_INF, p.slopeTo(p), 0.01);
        assertEquals("Result should be negative infinity", NEG_INF, p.slopeTo(q), 0.01);
        assertEquals("Result should be negative infinity", NEG_INF, q.slopeTo(p), 0.01);
        
        q = new Point(1, 0);
        assertEquals("Result should be 0", 0d, q.slopeTo(p), 0.01);
        assertEquals("Result should be 0", 0d, p.slopeTo(q), 0.01);
        q = new Point(-1, 0);
        assertEquals("Result should be 0", 0d, q.slopeTo(p), 0.01);
        assertEquals("Result should be 0", 0d, p.slopeTo(q), 0.01);

        q = new Point(0, 1);
        assertEquals("Result positive infinity", POS_INF, p.slopeTo(q), 0.01);
        assertEquals("Result positive infinity", POS_INF, q.slopeTo(p), 0.01);
        q = new Point(0, -1);
        assertEquals("Result positive infinity", POS_INF, p.slopeTo(q), 0.01);
        assertEquals("Result positive infinity", POS_INF, q.slopeTo(p), 0.01);
        
        q = new Point(1, 1);
        assertEquals("Slope not correct", 1, p.slopeTo(q), 0.01);
        assertEquals("Slope not correct", 1, q.slopeTo(p), 0.01);

        q = new Point(1, -1);
        assertEquals("Slope not correct", -1, p.slopeTo(q), 0.01);
        assertEquals("Slope not correct", -1, q.slopeTo(p), 0.01);

        q = new Point(5, 4);
        assertEquals("Slope not correct", 4/5d, p.slopeTo(q), 0.01);
        assertEquals("Slope not correct", 4/5d, q.slopeTo(p), 0.01);
        
        q = null;
        exception.expect(NullPointerException.class);
        p.compareTo(q);
    }
    
    @Test
    public void testSlopeOrder()
    {
        p = new Point(0, 0);
        q = new Point(1, 1);
        assertEquals("Slope order not correct", 1, p.SLOPE_ORDER.compare(q, p));
        assertEquals("Slope order not correct", 1, q.SLOPE_ORDER.compare(p, q));
        assertEquals("Slope order not correct", -1, p.SLOPE_ORDER.compare(p, q));
        assertEquals("Slope order not correct", -1, q.SLOPE_ORDER.compare(q, p));
        
        r = new Point(1, 1);
        assertEquals("Slope order not correct", 0, p.SLOPE_ORDER.compare(q, r));
        assertEquals("Slope order not correct", 1, q.SLOPE_ORDER.compare(p, r));

        
        r = new Point(2, 3);
        assertEquals("Slope order not correct", -1, p.SLOPE_ORDER.compare(q, r));
        assertEquals("Slope order not correct", 1, p.SLOPE_ORDER.compare(r, q));

        r = null;
        exception.expect(NullPointerException.class);
        p.SLOPE_ORDER.compare(q, r);
    }
    
    @Test
    public void testToString()
    {
        p = new Point(0, 0);
        assertEquals("Unexpected string output", "(0, 0)", p.toString());
        q = new Point(-1, 1);
        assertEquals("Unexpected string output", "(-1, 1)", q.toString());
    }
}
