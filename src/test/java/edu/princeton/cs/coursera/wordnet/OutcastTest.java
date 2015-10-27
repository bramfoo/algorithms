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
    private String dir = "/wordnet/";

    private String assignmentSynsFilename = dir + "synsets.txt";
    private String assignmentHypFilename = dir + "hypernyms.txt";
    private String outcast5Filename = dir + "outcast5.txt";
    private String outcast8Filename = dir + "outcast8.txt";
    private String outcast11Filename = dir + "outcast11.txt";

    private WordNet w;
    private Outcast o;
    private String result;

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
