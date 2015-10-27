package edu.princeton.cs.coursera.collinear;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import edu.princeton.cs.algs4.io.In;
import edu.princeton.cs.coursera.TestUtils;

/**
 * Unit tests for BruteCollinearPoints
 */
@RunWith(JUnit4.class)
public class BruteCollinearPointsTest
{

    PrintStream stdout;
    PrintStream stderr;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    private String noLinesfileName  = "/collinear/random23.txt";
    private String in3fileName      = "/collinear/input3.txt";
    private String in8fileName      = "/collinear/input8.txt";
    private String in40fileName     = "/collinear/input40.txt";
    private String in48fileName     = "/collinear/input48.txt";
    private String equifileName     = "/collinear/equidistant.txt";
    private String horizfileName    = "/collinear/horizontal5.txt";
    private String vertfileName     = "/collinear/vertical5.txt";

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setup()
    {
        // Hold on to original value
        stdout = System.out;
        stderr = System.err;

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        outContent.reset();
    }

    private Point[] readInput(String inputFile)
    {
        In in = new In(inputFile);
        int N = in.readInt();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }
        
        return points;
    }
    
    @Test
    public void testNoLines()
    {
        // No results expected
        BruteCollinearPoints brute = new BruteCollinearPoints(readInput(noLinesfileName));
        
        assertEquals("Should have no solutions", 0, brute.numberOfSegments());
    }

    @Test
    public void testNotEnoughPoints()
    {
        // No results expected
        BruteCollinearPoints brute = new BruteCollinearPoints(readInput(in3fileName));
        assertEquals("Should have no solutions", 0, brute.numberOfSegments());
    }

    @Test
    public void testDuplicatePoints()
    {
        // IllegalArgumentException expected
        Point[] p = new Point[]{new Point(0, 0), new Point(1, 1), new Point(2, 2), new Point(1, 1), new Point(3, 3)};

        // Must be the last test in the class
        exception.expect(IllegalArgumentException.class);
        BruteCollinearPoints brute = new BruteCollinearPoints(p);
    }

    @Test
    public void testNull()
    {
        // NullPointerException expected
        // Must be the last test in the class
        exception.expect(NullPointerException.class);
        BruteCollinearPoints brute = new BruteCollinearPoints(null);
    }

    @Test
    public void testNullPoints()
    {
        // NullPointerException expected
        Point[] p = new Point[]{new Point(0, 0), new Point(1, 1), new Point(2, 2), null, new Point(3, 3)};

        // Must be the last test in the class
        exception.expect(NullPointerException.class);
        BruteCollinearPoints brute = new BruteCollinearPoints(p);
    }
    
    @Test
    public void testInput8()
    {
        // Expected results:
        // (10000, 0) -> (7000, 3000) -> (3000, 7000) -> (0, 10000)
        // (3000, 4000) -> (6000, 7000) -> (14000, 15000) -> (20000, 21000)
        Set<String> solutions = new HashSet<String>();
        solutions.add("(10000, 0) -> (0, 10000)");
        solutions.add("(3000, 4000) -> (20000, 21000)");
       
        BruteCollinearPoints brute = new BruteCollinearPoints(readInput(in8fileName));
        assertEquals("Incorrect number of solutions", solutions.size(), brute.numberOfSegments());

        for (LineSegment s : brute.segments())
            System.out.println(s);
        String[] result = outContent.toString().split("\n");
        
        for (String s : result)
            assertTrue("Result not in solution set: " + s, solutions.contains(s));    
    }

    @Test
    public void testInput40()
    {
        assertNotNull("Test file missing",
                getClass().getResource(in40fileName));

        // Reset the streams
        TestUtils.syncOut(outContent);

        // Expected results:
        //        (1000, 17000) -> (13000, 17000) -> (17000, 17000) -> (29000, 17000)
        //        (1000, 17000) -> (1000, 27000) -> (1000, 28000) -> (1000, 31000)
        //        (2000, 24000) -> (9000, 24000) -> (14000, 24000) -> (25000, 24000)
        //        (2000, 29000) -> (4000, 29000) -> (22000, 29000) -> (28000, 29000)
        Set<String> solutions = new HashSet<String>();
        solutions.add("(1000, 17000) -> (29000, 17000)");
        solutions.add("(1000, 17000) -> (1000, 31000)");
        solutions.add("(2000, 24000) -> (25000, 24000)");
        solutions.add("(2000, 29000) -> (28000, 29000)");
        
        BruteCollinearPoints brute = new BruteCollinearPoints(readInput(in40fileName));
        assertEquals("Incorrect number of solutions", solutions.size(), brute.numberOfSegments());

        for (LineSegment s : brute.segments())
            System.out.println(s);
        String[] result = outContent.toString().split("\n");

        for (String s : result)
            assertTrue("Result not in solution set: " + s, solutions.contains(s));    
    }

    @Test
    public void testInput48()
    {
        assertNotNull("Test file missing",
                getClass().getResource(in48fileName));

        // Reset the streams
        TestUtils.syncOut(outContent);

        // Expected results:
        //        (1000, 23000) -> (3000, 23000) -> (18000, 23000) -> (24000, 23000)
        //        (6000, 2000) -> (16000, 22000) -> (18000, 26000) -> (19000, 28000)
        //        (18000, 13000) -> (18000, 23000) -> (18000, 26000) -> (18000, 27000)
        //        (1000, 26000) -> (9000, 26000) -> (11000, 26000) -> (18000, 26000)
        //        (9000, 1000) -> (12000, 10000) -> (15000, 19000) -> (16000, 22000)
        //        (1000, 2000) -> (1000, 9000) -> (1000, 23000) -> (1000, 26000)
        Set<String> solutions = new HashSet<String>();
        solutions.add("(1000, 23000) -> (24000, 23000)");
        solutions.add("(6000, 2000) -> (19000, 28000)");
        solutions.add("(18000, 13000) -> (18000, 27000)");
        solutions.add("(1000, 26000) -> (18000, 26000)");
        solutions.add("(9000, 1000) -> (16000, 22000)");
        solutions.add("(1000, 2000) -> (1000, 26000)");
        
        BruteCollinearPoints brute = new BruteCollinearPoints(readInput(in48fileName));
        assertEquals("Incorrect number of solutions", solutions.size(), brute.numberOfSegments());

        for (LineSegment s : brute.segments())
            System.out.println(s);
        String[] result = outContent.toString().split("\n");

        for (String s : result)
            assertTrue("Result not in solution set: " + s, solutions.contains(s));    
    }

    @Test
    public void testEquidistant()
    {
        assertNotNull("Test file missing",
                getClass().getResource(equifileName));

        // Reset the streams
        TestUtils.syncOut(outContent);

        // Expected results:
        //        (10000, 0) -> (13000, 0) -> (20000, 0) -> (30000, 0)
        //        (10000, 0) -> (8000, 2000) -> (2000, 8000) -> (0, 10000)
        //        (13000, 0) -> (11000, 3000) -> (9000, 6000) -> (5000, 12000)
        //        (30000, 0) -> (20000, 10000) -> (10000, 20000) -> (0, 30000)
        Set<String> solutions = new HashSet<String>();
        solutions.add("(10000, 0) -> (30000, 0)");
        solutions.add("(10000, 0) -> (0, 10000)");
        solutions.add("(13000, 0) -> (5000, 12000)");
        solutions.add("(30000, 0) -> (0, 30000)");
        
        BruteCollinearPoints brute = new BruteCollinearPoints(readInput(equifileName));
        assertEquals("Incorrect number of solutions", solutions.size(), brute.numberOfSegments());

        for (LineSegment s : brute.segments())
            System.out.println(s);
        String[] result = outContent.toString().split("\n");

        for (String s : result)
            assertTrue("Result not in solution set: " + s, solutions.contains(s));    
    }
    
    @Test
    public void testHorizontal()
    {
        // Reset the streams
        TestUtils.syncOut(outContent);

        // Expected results:
        //        (4750, 4652) -> (5766, 4652) -> (9972, 4652) -> (16307, 4652)
        //        (1888, 7657) -> (7599, 7657) -> (12772, 7657) -> (13832, 7657)
        //        (8934, 7996) -> (10411, 7996) -> (13291, 7996) -> (20547, 7996)
        //        (10375, 12711) -> (14226, 12711) -> (18177, 12711) -> (20385, 12711)
        //        (2682, 14118) -> (5067, 14118) -> (7453, 14118) -> (7821, 14118)
        Set<String> solutions = new HashSet<String>();
        solutions.add("(4750, 4652) -> (16307, 4652)");
        solutions.add("(1888, 7657) -> (13832, 7657)");
        solutions.add("(8934, 7996) -> (20547, 7996)");
        solutions.add("(10375, 12711) -> (20385, 12711)");
        solutions.add("(2682, 14118) -> (7821, 14118)");
        
        BruteCollinearPoints brute = new BruteCollinearPoints(readInput(horizfileName));
        assertEquals("Incorrect number of solutions", solutions.size(), brute.numberOfSegments());

        for (LineSegment s : brute.segments())
            System.out.println(s);
        String[] result = outContent.toString().split("\n");

        for (String s : result)
            assertTrue("Result not in solution set: " + s, solutions.contains(s));    
    }

    @Test
    public void testVertical()
    {
        // Reset the streams
        TestUtils.syncOut(outContent);

        // Expected results:
        //        (8421, 1829) -> (8421, 11344) -> (8421, 15144) -> (8421, 18715)
        //        (15976, 3370) -> (15976, 4589) -> (15976, 8933) -> (15976, 9945)
        //        (5757, 3426) -> (5757, 13581) -> (5757, 16647) -> (5757, 20856)
        //        (2088, 6070) -> (2088, 7091) -> (2088, 11500) -> (2088, 16387)
        //        (14407, 10367) -> (14407, 17188) -> (14407, 17831) -> (14407, 19953)
        
        Set<String> solutions = new HashSet<String>();
        solutions.add("(8421, 1829) -> (8421, 18715)");
        solutions.add("(15976, 3370) -> (15976, 9945)");
        solutions.add("(5757, 3426) -> (5757, 20856)");
        solutions.add("(2088, 6070) -> (2088, 16387)");
        solutions.add("(14407, 10367) -> (14407, 19953)");
        
        BruteCollinearPoints brute = new BruteCollinearPoints(readInput(vertfileName));
        assertEquals("Incorrect number of solutions", solutions.size(), brute.numberOfSegments());

        for (LineSegment s : brute.segments())
            System.out.println(s);
        String[] result = outContent.toString().split("\n");

        for (String s : result)
            assertTrue("Result not in solution set: " + s, solutions.contains(s));    
    }
    
    @After
    public void cleanUpStreams()
    {
        outContent.reset();
        System.setOut(stdout);
        System.setErr(stderr);
    }
}