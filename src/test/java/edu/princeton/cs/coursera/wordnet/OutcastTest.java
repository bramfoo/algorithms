package edu.princeton.cs.coursera.wordnet;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import edu.princeton.cs.algs4.io.In;

/**
 * Unit tests for SAP
 */
@RunWith(JUnit4.class)
public class OutcastTest
{
    protected String dir = "/wordnet/";

    protected String assignmentSynsFilename = dir + "synsets.txt";
    protected String assignmentHypFilename = dir + "hypernyms.txt";
    protected String outcast5Filename = dir + "outcast5.txt";
    protected String outcast8Filename = dir + "outcast8.txt";
    protected String outcast11Filename = dir + "outcast11.txt";

    protected WordNet w;
    protected Outcast o;
    protected String result;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setup()
    {
        w = new WordNet(assignmentSynsFilename, assignmentHypFilename);
        o = new Outcast(w);
    }

    private String[] fileToArray(String fileName)
    {
        In in = new In(fileName);
        return in.readAllStrings();
    }

    @Test
    public void testOutcast()
    {
        result = o.outcast(fileToArray(outcast5Filename));
        assertEquals("Incorrect outcast", "table", result);

        result = o.outcast(fileToArray(outcast8Filename));
        assertEquals("Incorrect outcast", "bed", result);

        result = o.outcast(fileToArray(outcast11Filename));
        assertEquals("Incorrect outcast", "potato", result);
    }
}
