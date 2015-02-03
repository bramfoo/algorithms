package edu.princeton.cs.coursera.queues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

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
public class SubsetTest
{
    // From http://stackoverflow.com/a/1119559
    String in10 = "A\nB\nC\nD\nE\nF\nG\nH\nI\nJ\n";
    InputStream stdin;
    PrintStream stdout;
    PrintStream stderr;
    private ByteArrayInputStream inContent;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setup()
    {
        // Hold on to original value
        stdin = System.in;
        stdout = System.out;
        stderr = System.err;

        inContent = new ByteArrayInputStream(in10.getBytes());
        System.setIn(inContent);
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        inContent.reset();
        outContent.reset();
    }

    @Test
    public void testEmpty()
    {
        // Reset the streams
        TestUtils.syncIn();
        TestUtils.syncOut(outContent);

        Subset.main(new String[]{"0"});
        assertEquals(0, outContent.size());
    }

    @Test
    public void testOutput()
    {
        // Reset the streams
        TestUtils.syncIn();
        TestUtils.syncOut(outContent);

        Subset.main(new String[]{"3"});
        assertEquals(3, (outContent.toString().split("\n")).length);
    }

    @Test
    public void testRandomness() throws IOException
    {
        // Set up a frequency map based on , all set to zero
        Map<String, Integer> frequency = new HashMap<String, Integer>();
        for (String s : in10.toString().split("\n"))
            frequency.put(s, 0);

        assertEquals("Frequency map not set up properly", 10, frequency.size());

        // Reset the streams
        TestUtils.syncIn();
        TestUtils.syncOut(outContent);

        for (int i = 0; i < 1000; i++)
        {
            outContent.reset();
            Subset.main(new String[]{"1"});
            String[] result = outContent.toString().split("\n");
            for (String s : result)
            {
                if (frequency.containsKey(s))
                {
                    // Increment frequency
                    frequency.put(s, frequency.get(s) + 1);
                }
                else
                {
                    fail("Unexpected output: '" + s + "'");
                }
            }
            // Reset input stream
            inContent.reset();
            TestUtils.syncIn();
        }
        // FIXME: calculate chi-squared and p-value 
        System.setOut(stdout);
        System.out.println("Result: " + frequency);
    }

    @After
    public void cleanUpStreams()
    {
        inContent.reset();
        outContent.reset();

        System.setIn(stdin);
        System.setOut(stdout);
        System.setErr(stderr);
    }
}
