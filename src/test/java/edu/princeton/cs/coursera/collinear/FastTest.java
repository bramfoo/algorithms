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

import edu.princeton.cs.coursera.TestUtils;

/**
 * Unit tests for Deque
 */
@RunWith(JUnit4.class)
public class FastTest
{

    PrintStream stdout;
    PrintStream stderr;
    private ByteArrayOutputStream outContent;
    private ByteArrayOutputStream errContent;

    private String random23fileName  = "/collinear/random23.txt";
    private String in3fileName       = "/collinear/input3.txt";
    private String in6fileName       = "/collinear/input6.txt";
    private String in8fileName       = "/collinear/input8.txt";
    private String in40fileName      = "/collinear/input40.txt";
    private String in300fileName     = "/collinear/input300.txt";
    private String in400fileName     = "/collinear/input400.txt";
    private String equifileName      = "/collinear/equidistant.txt";
    private String horizfileName     = "/collinear/horizontal5.txt";
    private String vertfileName      = "/collinear/vertical5.txt";
    private String inarowfileName    = "/collinear/inarow.txt";

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setup()
    {
        // Hold on to original value
        stdout = System.out;
        stderr = System.err;

        outContent = new ByteArrayOutputStream();
        errContent = new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        
        outContent.reset();
    }

    @Test
    public void testNoLines()
    {
        // Reset the streams
        TestUtils.syncOut(outContent);

        // No results expected
        Fast.main(new String[]{random23fileName});
        assertEquals("Should have no solutions", 0, outContent.size());
    }

    @Test
    public void testNotEnoughPoints()
    {
        // Reset the streams
        TestUtils.syncOut(outContent);

        // No results expected
        Fast.main(new String[]{in3fileName});
        assertEquals("Should have no solutions", 0, outContent.size());
    }

    @Test
    public void testInput8()
    {
        // Reset the streams
        TestUtils.syncOut(outContent);

        // Expected results:
        // (10000, 0) -> (7000, 3000) -> (3000, 7000) -> (0, 10000)
        // (3000, 4000) -> (6000, 7000) -> (14000, 15000) -> (20000, 21000)
        Set<String> solutions = new HashSet<String>();
        solutions.add("(10000, 0) -> (7000, 3000) -> (3000, 7000) -> (0, 10000)");
        solutions.add("(3000, 4000) -> (6000, 7000) -> (14000, 15000) -> (20000, 21000)");
        
        Fast.main(new String[]{in8fileName});
        String[] result = outContent.toString().split("\n");
        assertEquals("Incorrect number of solutions", solutions.size(), result.length);

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
        solutions.add("(1000, 17000) -> (13000, 17000) -> (17000, 17000) -> (29000, 17000)");
        solutions.add("(1000, 17000) -> (1000, 27000) -> (1000, 28000) -> (1000, 31000)");
        solutions.add("(2000, 24000) -> (9000, 24000) -> (14000, 24000) -> (25000, 24000)");
        solutions.add("(2000, 29000) -> (4000, 29000) -> (22000, 29000) -> (28000, 29000)");
        
        Fast.main(new String[]{in40fileName});
        String[] result = outContent.toString().split("\n");
        assertEquals("Incorrect number of solutions", solutions.size(), result.length);

        for (String s : result)
            assertTrue("Result not in solution set: " + s, solutions.contains(s));    
    }
    
    @Test
    public void testInput300()
    {
        assertNotNull("Test file missing",
                getClass().getResource(in300fileName));

        // Reset the streams
        TestUtils.syncOut(outContent);

        // Expected results:
        //        (1650, 2050) -> (11750, 7100) -> (17350, 9900) -> (28350, 15400)
        //        (7300, 10050) -> (7300, 10450) -> (7300, 17000) -> (7300, 25700) -> (7300, 31650)
        //        (23000, 8500) -> (29550, 8500) -> (30000, 8500) -> (30950, 8500)
        //        (2950, 200) -> (2950, 4050) -> (2950, 5600) -> (2950, 25400)
        //        (3250, 17450) -> (8500, 17450) -> (13400, 17450) -> (17250, 17450)
        //        (31000, 500) -> (29900, 1600) -> (23000, 8500) -> (21900, 9600)
        Set<String> solutions = new HashSet<String>();
        solutions.add("(1650, 2050) -> (11750, 7100) -> (17350, 9900) -> (28350, 15400)");
        solutions.add("(7300, 10050) -> (7300, 10450) -> (7300, 17000) -> (7300, 25700) -> (7300, 31650)");
        solutions.add("(23000, 8500) -> (29550, 8500) -> (30000, 8500) -> (30950, 8500)");
        solutions.add("(2950, 200) -> (2950, 4050) -> (2950, 5600) -> (2950, 25400)");
        solutions.add("(3250, 17450) -> (8500, 17450) -> (13400, 17450) -> (17250, 17450)");
        solutions.add("(31000, 500) -> (29900, 1600) -> (23000, 8500) -> (21900, 9600)");
        
        Fast.main(new String[]{in300fileName});
        String[] result = outContent.toString().split("\n");
        assertEquals("Incorrect number of solutions", solutions.size(), result.length);

        for (String s : result)
            assertTrue("Result not in solution set: " + s, solutions.contains(s));    
    }

    @Test
    public void testInput400()
    {
        assertNotNull("Test file missing",
                getClass().getResource(in400fileName));

        // Reset the streams
        TestUtils.syncOut(outContent);

        // Expected results:
        //        (16050, 950) -> (15250, 1750) -> (14750, 2250) -> (1050, 15950)
        //        (18150, 7150) -> (17500, 8450) -> (17150, 9150) -> (11250, 20950)
        //        (26000, 8900) -> (20250, 19250) -> (20000, 19700) -> (15250, 28250)
        //        (20950, 9500) -> (20950, 10850) -> (20950, 14450) -> (20950, 15000) -> (20950, 17250) -> (20950, 28700)
        //        (16450, 10750) -> (16500, 10750) -> (21000, 10750) -> (23200, 10750)
        //        (29100, 24300) -> (25200, 24950) -> (20400, 25750) -> (18900, 26000)
        //        (27400, 24750) -> (25200, 24950) -> (24650, 25000) -> (22450, 25200) -> (21900, 25250)
        Set<String> solutions = new HashSet<String>();
        solutions.add("(16050, 950) -> (15250, 1750) -> (14750, 2250) -> (1050, 15950)");
        solutions.add("(18150, 7150) -> (17500, 8450) -> (17150, 9150) -> (11250, 20950)");
        solutions.add("(26000, 8900) -> (20250, 19250) -> (20000, 19700) -> (15250, 28250)");
        solutions.add("(20950, 9500) -> (20950, 10850) -> (20950, 14450) -> (20950, 15000) -> (20950, 17250) -> (20950, 28700)");
        solutions.add("(16450, 10750) -> (16500, 10750) -> (21000, 10750) -> (23200, 10750)");
        solutions.add("(29100, 24300) -> (25200, 24950) -> (20400, 25750) -> (18900, 26000)");
        solutions.add("(27400, 24750) -> (25200, 24950) -> (24650, 25000) -> (22450, 25200) -> (21900, 25250)");
        
        Fast.main(new String[]{in400fileName});
        String[] result = outContent.toString().split("\n");
        assertEquals("Incorrect number of solutions", solutions.size(), result.length);

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
        solutions.add("(10000, 0) -> (13000, 0) -> (20000, 0) -> (30000, 0)");
        solutions.add("(10000, 0) -> (8000, 2000) -> (2000, 8000) -> (0, 10000)");
        solutions.add("(13000, 0) -> (11000, 3000) -> (9000, 6000) -> (5000, 12000)");
        solutions.add("(30000, 0) -> (20000, 10000) -> (10000, 20000) -> (0, 30000)");
        
        Fast.main(new String[]{equifileName});
        String[] result = outContent.toString().split("\n");
        assertEquals("Incorrect number of solutions", solutions.size(), result.length);

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
        solutions.add("(4750, 4652) -> (5766, 4652) -> (9972, 4652) -> (16307, 4652)");
        solutions.add("(1888, 7657) -> (7599, 7657) -> (12772, 7657) -> (13832, 7657)");
        solutions.add("(8934, 7996) -> (10411, 7996) -> (13291, 7996) -> (20547, 7996)");
        solutions.add("(10375, 12711) -> (14226, 12711) -> (18177, 12711) -> (20385, 12711)");
        solutions.add("(2682, 14118) -> (5067, 14118) -> (7453, 14118) -> (7821, 14118)");
        
        Fast.main(new String[]{horizfileName});
        String[] result = outContent.toString().split("\n");
        assertEquals("Incorrect number of solutions", solutions.size(), result.length);

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
        solutions.add("(8421, 1829) -> (8421, 11344) -> (8421, 15144) -> (8421, 18715)");
        solutions.add("(15976, 3370) -> (15976, 4589) -> (15976, 8933) -> (15976, 9945)");
        solutions.add("(5757, 3426) -> (5757, 13581) -> (5757, 16647) -> (5757, 20856)");
        solutions.add("(2088, 6070) -> (2088, 7091) -> (2088, 11500) -> (2088, 16387)");
        solutions.add("(14407, 10367) -> (14407, 17188) -> (14407, 17831) -> (14407, 19953)");
        
        Fast.main(new String[]{vertfileName});
        String[] result = outContent.toString().split("\n");
        assertEquals("Incorrect number of solutions", solutions.size(), result.length);

        for (String s : result)
            assertTrue("Result not in solution set: " + s, solutions.contains(s));    
    }
    
    @Test
    public void testFivePointLines()
    {
        // Reset the streams
        TestUtils.syncOut(outContent);

        // Expected results:
        //        (14000, 10000) -> (18000, 10000) -> (19000, 10000) -> (21000, 10000) -> (32000, 10000)
        Set<String> solutions = new HashSet<String>();
        solutions.add("(14000, 10000) -> (18000, 10000) -> (19000, 10000) -> (21000, 10000) -> (32000, 10000)");
        
        Fast.main(new String[]{in6fileName});
        String[] result = outContent.toString().split("\n");
        assertEquals("Incorrect number of solutions", solutions.size(), result.length);

        for (String s : result)
            assertTrue("Result not in solution set: " + s, solutions.contains(s));    
    }

    @Test
    public void testSevenPointLines()
    {
        assertNotNull("Test file missing",
                getClass().getResource(inarowfileName));

        // Reset the streams
        TestUtils.syncOut(outContent);

        // Expected results:
        //        (0, 0) -> (5000, 0) -> (10000, 0) -> (15000, 0) -> (20000, 0) -> (25000, 0) -> (30000, 0)
        //        (5000, 0) -> (10000, 3100) -> (15000, 6200) -> (20000, 9300) -> (25000, 12400)
        //        (0, 0) -> (2300, 4100) -> (4600, 8200) -> (11500, 20500)
        //        (0, 0) -> (0, 5000) -> (0, 10000) -> (0, 11000) -> (0, 15000) -> (0, 20000) -> (0, 25000) -> (0, 30000)
        //        (30000, 0) -> (27000, 7500) -> (26000, 10000) -> (20000, 25000) -> (19000, 27500) -> (18000, 30000)
        Set<String> solutions = new HashSet<String>();
        solutions.add("(0, 0) -> (5000, 0) -> (10000, 0) -> (15000, 0) -> (20000, 0) -> (25000, 0) -> (30000, 0)");
        solutions.add("(5000, 0) -> (10000, 3100) -> (15000, 6200) -> (20000, 9300) -> (25000, 12400)");
        solutions.add("(0, 0) -> (2300, 4100) -> (4600, 8200) -> (11500, 20500)");
        solutions.add("(0, 0) -> (0, 5000) -> (0, 10000) -> (0, 11000) -> (0, 15000) -> (0, 20000) -> (0, 25000) -> (0, 30000)");
        solutions.add("(30000, 0) -> (27000, 7500) -> (26000, 10000) -> (20000, 25000) -> (19000, 27500) -> (18000, 30000)");
        
        Fast.main(new String[]{inarowfileName});
        String[] result = outContent.toString().split("\n");
        assertEquals("Incorrect number of solutions", solutions.size(), result.length);

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
