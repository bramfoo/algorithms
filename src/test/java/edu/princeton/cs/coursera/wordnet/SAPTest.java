package edu.princeton.cs.coursera.wordnet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import edu.princeton.cs.algs4.graphs.Digraph;
import edu.princeton.cs.introcs.In;

/**
 * Unit tests for SAP
 */
@RunWith(JUnit4.class)
public class SAPTest
{
    private String dir = "/wordnet/";
    private String input1Filename = dir + "digraph1.txt";

    private In in;
    private Digraph d;
    private SAP s;
    private int result;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setup()
    {
        in = new In(input1Filename);
        d = new Digraph(in);
        s = new SAP(d);
    }

    @Test
    public void testInputBounds1()
    {
        // Must be the last test in the class
        exception.expect(IndexOutOfBoundsException.class);
        s.length(-1, 0);
    }

    @Test
    public void testInputBounds2()
    {
        // Must be the last test in the class
        exception.expect(IndexOutOfBoundsException.class);
        s.length(0, -1);
    }

    @Test
    public void testInputBounds3()
    {
        // Must be the last test in the class
        exception.expect(IndexOutOfBoundsException.class);
        s.length(d.V() + 1, 0);
    }

    @Test
    public void testInputBounds4()
    {
        // Must be the last test in the class
        exception.expect(IndexOutOfBoundsException.class);
        s.length(0, d.V() + 1);
    }

    @Test
    public void testInputBounds5()
    {
        // Must be the last test in the class
        exception.expect(IndexOutOfBoundsException.class);
        s.ancestor(-1, 0);
    }

    @Test
    public void testInputBounds6()
    {
        // Must be the last test in the class
        exception.expect(IndexOutOfBoundsException.class);
        s.ancestor(0, -1);
    }

    @Test
    public void testInputBounds7()
    {
        // Must be the last test in the class
        exception.expect(IndexOutOfBoundsException.class);
        s.ancestor(d.V() + 1, 0);
    }

    @Test
    public void testInputBounds8()
    {
        // Must be the last test in the class
        exception.expect(IndexOutOfBoundsException.class);
        s.ancestor(0, d.V() + 1);
    }

    @Test
    public void testLengthSingleVertices()
    {
        result = s.length(3, 11);
        assertEquals("Incorrect length", 4, result);

        result = s.length(9, 12);
        assertEquals("Incorrect length", 3, result);

        result = s.length(7, 2);
        assertEquals("Incorrect length", 4, result);

        result = s.length(1, 6);
        assertEquals("Incorrect length", -1, result);

        result = s.length(1, 10);
        assertEquals("Incorrect length", 2, result);
    }

    @Test
    public void testAncestorSingleVertices()
    {
        result = s.ancestor(3, 11);
        assertEquals("Incorrect ancestor", 1, result);

        result = s.ancestor(9, 12);
        assertEquals("Incorrect ancestor", 5, result);

        result = s.ancestor(7, 2);
        assertEquals("Incorrect ancestor", 0, result);

        result = s.ancestor(1, 6);
        assertEquals("Incorrect ancestor", -1, result);

        result = s.ancestor(1, 10);
        assertEquals("Incorrect ancestor", 1, result);
    }

    @Test
    public void testLengthMultiVertices()
    {
        List<Integer> v = new ArrayList<Integer>(Arrays.asList(7, 8, 9));
        List<Integer> w = new ArrayList<Integer>(Arrays.asList(7, 8, 9));
        result = s.length(v, w);
        assertEquals("Incorrect length", 0, result);

        w = new ArrayList<Integer>(Arrays.asList(10, 11, 12));
        result = s.length(v, w);
        assertEquals("Incorrect length", 2, result);

        v = new ArrayList<Integer>(Arrays.asList(3, 4, 5));
        result = s.length(v, w);
        assertEquals("Incorrect length", 1, result);

        v = new ArrayList<Integer>(Arrays.asList(6));
        result = s.length(v, w);
        assertEquals("Incorrect length", -1, result);
    }

    @Test
    public void testAncestorMultiVertices()
    {
        List<Integer> v = new ArrayList<Integer>(Arrays.asList(7, 8, 9));
        List<Integer> w = new ArrayList<Integer>(Arrays.asList(7, 8, 9));
        result = s.ancestor(v, w);
        assertTrue("Incorrect ancestor", (result == 7 || result == 8 || result == 9));

        w = new ArrayList<Integer>(Arrays.asList(10, 11, 12));
        result = s.ancestor(v, w);
        assertEquals("Incorrect ancestor", 5, result);

        v = new ArrayList<Integer>(Arrays.asList(3, 4, 5));
        result = s.ancestor(v, w);
        assertEquals("Incorrect ancestor", 5, result);

        v = new ArrayList<Integer>(Arrays.asList(6));
        result = s.ancestor(v, w);
        assertEquals("Incorrect ancestor", -1, result);
    }
}
