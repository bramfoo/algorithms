package edu.princeton.cs.coursera.kdtree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import edu.princeton.cs.algs4.fundamentals.Point2D;
import edu.princeton.cs.introcs.In;

/**
 * Unit tests for PointSET
 */
@RunWith(JUnit4.class)
public class PointSETTest
{
    private long startTime;
    private long endTime;
    
    private PointSET empty;
    private PointSET c10;
    private PointSET c1000;
    private PointSET c10000;
    private PointSET in10k;
    private PointSET in20k;
    private PointSET in100k;
    
    private String c10fileName = "/kdtree/circle10.txt";
    private String c1000fileName = "/kdtree/circle1000.txt";
    private String c10000fileName = "/kdtree/circle10000.txt";
    private String in10kfileName = "/kdtree/input10K.txt";
    private String in20kfileName = "/kdtree/input20K.txt";
    private String in100kfileName = "/kdtree/input100K.txt";

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setup()
    {
        empty = new PointSET();
        c10 = createPointSETFromFile(c10fileName);
        c1000 = createPointSETFromFile(c1000fileName);
        c10000 = createPointSETFromFile(c10000fileName);
        in10k = createPointSETFromFile(in10kfileName);
        in20k = createPointSETFromFile(in20kfileName);
        in100k = createPointSETFromFile(in100kfileName);
    }

    private PointSET createPointSETFromFile(String fileName)
    {
        // Files found in the '/test/resources/kdtree/' directory
        assertNotNull("Test file missing", getClass().getResource(fileName));

        In in = new In(fileName);
        double[] input = in.readAllDoubles();

        PointSET ps = new PointSET();
        for (int i = 0; i < input.length; i += 2)
        {
            ps.insert(new Point2D(input[i], input[i + 1]));
        }

        return ps;
    }

    @Test
    public void testIsEmpty()
    {
        assertTrue("Empty set should be empty", empty.isEmpty());
        empty.insert(new Point2D(0.1, 0.1));
        assertFalse("Element added, set should not be empty", empty.isEmpty());

        assertFalse("Set containing points should not be empty", c10.isEmpty());
    }

    @Test
    public void testSize()
    {
        assertEquals("Incorrect number of elements", 0, empty.size());
        empty.insert(new Point2D(0.1, 0.1));
        assertEquals("Incorrect number of elements", 1, empty.size());
        empty.insert(new Point2D(0.1, 0.1));
        assertEquals("Should not accept duplicate elements", 1, empty.size());
        assertEquals("Incorrect number of elements", 10, c10.size());
        assertEquals("Incorrect number of elements", 1000, c1000.size());
        assertEquals("Incorrect number of elements", 10000, c10000.size());
        assertEquals("Incorrect number of elements", 10000, in10k.size());
    }

    @Test
    public void testInsert()
    {
        Point2D p = new Point2D(0.1, 0.1);
        assertTrue("Nothing inserted, set should be empty", empty.isEmpty());
        empty.insert(p);
        assertFalse("Element inserted, set should not be empty", empty.isEmpty());

        assertTrue("Set should contain point " + p.toString(), empty.contains(p));
    }

    @Test
    public void testContains()
    {
        Point2D[] pointsArray = createPointsFromFile(c10fileName);
        for (int i = 0; i < pointsArray.length; i++)
            assertTrue("Set should contain point " + pointsArray[i].toString(),
                    c10.contains(pointsArray[i]));

        pointsArray = createPointsFromFile(c1000fileName);
        for (int i = 0; i < pointsArray.length; i++)
            assertTrue("Set should contain point " + pointsArray[i].toString(),
                    c1000.contains(pointsArray[i]));

        pointsArray = createPointsFromFile(c10000fileName);
        for (int i = 0; i < pointsArray.length; i++)
            assertTrue("Set should contain point " + pointsArray[i].toString(),
                    c10000.contains(pointsArray[i]));

        pointsArray = createPointsFromFile(in20kfileName);
        for (int i = 0; i < pointsArray.length; i++)
            assertTrue("Set should contain point " + pointsArray[i].toString(),
                    in20k.contains(pointsArray[i]));
    }

    private Point2D[] createPointsFromFile(String fileName)
    {
        In in = new In(fileName);
        double[] input = in.readAllDoubles();

        Point2D[] points = new Point2D[input.length / 2];
        for (int i = 0, j = 0; j < input.length; i++, j += 2)
        {
            points[i] = new Point2D(input[j], input[j + 1]);
        }

        return points;
    }

    @Test
    public void testRange()
    {
        RectHV r = new RectHV(0, 0, 0.001, 0.001);
        Iterable<Point2D> iter = c10.range(r);
        assertEquals(0, iterableSize(iter));

        r = new RectHV(0, 0, 0.5, 0.5);
        iter = c10.range(r);
        assertEquals("Wrong number of points in range", 3, iterableSize(iter));

        r = new RectHV(0, 0, 1, 0.5);
        iter = c10.range(r);
        assertEquals("Wrong number of points in range", 5, iterableSize(iter));

        r = new RectHV(0, 0, 1, 1);
        iter = c10.range(r);
        assertEquals("Wrong number of points in range", 10, iterableSize(iter));

        iter = empty.range(r);
        assertEquals("Wrong number of points in range", 0, iterableSize(iter));
        
        r = new RectHV(0, 0, 0.5, 0.5);

        startTime = System.currentTimeMillis();
        iter = in100k.range(r);
        endTime = System.currentTimeMillis();

        assertEquals("Wrong number of points in range", 25120, iterableSize(iter));
        System.out.println("100k point range time (ms): " + (endTime - startTime));            
    }

    private int iterableSize(Iterable<?> iter)
    {
        Iterator<?> it = iter.iterator();
        int i = 0;
        for (; it.hasNext(); ++i)
            it.next();
        return i;
    }

    @Test
    public void testNearest()
    {
        Point2D nearestPoint = empty.nearest(new Point2D(0.1, 0.1));
        assertNull("Empty set so should return null", nearestPoint);

        nearestPoint = c10.nearest(new Point2D(0.50, 1.00));
        Point2D correct = new Point2D(0.50, 1.00);
        assertTrue("Incorrect nearest point, should be " + correct.toString(),
                nearestPoint.equals(correct));

        Point2D p = new Point2D(0.81, 0.30);
        correct = new Point2D(0.975528, 0.345492);
        nearestPoint = c10.nearest(p);
        assertTrue("Incorrect nearest point, should be " + correct.toString(),
                nearestPoint.equals(correct));

        correct = new Point2D(0.920132, 0.228911);

        startTime = System.currentTimeMillis();
        nearestPoint = c10000.nearest(p);
        endTime = System.currentTimeMillis();
        
        assertTrue("Incorrect nearest point, should be " + correct.toString(),
                nearestPoint.equals(correct));
        System.out.println("10000 point nearest time (ms): " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        nearestPoint = in100k.nearest(p);
        endTime = System.currentTimeMillis();
        
        correct = new Point2D(0.809736, 0.299609);
        assertTrue("Incorrect nearest point, should be " + correct.toString(),
                nearestPoint.equals(correct));
        System.out.println("100k point nearest time (ms): " + (endTime - startTime));    
    }
}
