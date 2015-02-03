package edu.princeton.cs.coursera.wordnet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Unit tests for WordNet
 */
@RunWith(JUnit4.class)
public class WordNetTest
{
    private String dir = "/wordnet/";
    private String syn1Filename = dir + "synsets100-subgraph.txt";
    private String hyp1Filename = dir + "hypernyms100-subgraph.txt";

    private String assignmentSynsFilename = dir + "synsets.txt";
    private String assignmentHypFilename = dir + "hypernyms.txt";

    private WordNet w;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setup()
    {
        w = new WordNet(syn1Filename, hyp1Filename);
    }

    @Test
    public void testNouns()
    {
        Iterable<String> result = w.nouns();
        Iterator<String> it = result.iterator();
        int count = 0;
        while (it.hasNext())
        {
            it.next();
            count++;
        }
        assertEquals("Incorrect number of nouns", 157, count);

        w = new WordNet(assignmentSynsFilename, assignmentHypFilename);
        result = w.nouns();
        it = result.iterator();
        count = 0;
        while (it.hasNext())
        {
            it.next();
            count++;
        }
        assertEquals("Incorrect number of nouns", 119188, count);
    }

    @Test
    public void testIsNounNull()
    {
        exception.expect(NullPointerException.class);
        w.isNoun(null);
    }

    @Test
    public void testIsNoun()
    {
        String[] nouns = new String[]{"C-reactive_protein", "CRP", "collagen",
                "entity", "fibrinase", "factor_XIII", "prothrombin", "factor_II",
                "zymase"};
        for (String word : nouns)
            assertTrue("Noun " + word + " is a WordNet noun", w.isNoun(word));

        String[] notNouns = new String[]{"C-reactive_protei", "CR", "collage",
                "ntity", "ibrinase", "factr_XIII", "prothombin", "factorII", "ymase"};
        for (String word : notNouns)
            assertFalse("Noun " + word + " is NOT a WordNet noun", w.isNoun(word));
    }

    @Test
    public void testDistanceExceptionA()
    {
        exception.expect(IllegalArgumentException.class);
        w.distance("NotAWordInWordNet", "entity");
    }

    @Test
    public void testDistanceNullA()
    {
        exception.expect(NullPointerException.class);
        w.distance(null, "entity");
    }

    @Test
    public void testDistanceExceptionB()
    {
        exception.expect(IllegalArgumentException.class);
        w.distance("entity", "NotAWordInWordNet");
    }

    @Test
    public void testDistanceNullB()
    {
        exception.expect(NullPointerException.class);
        w.distance("entity", null);
    }

    @Test
    public void testDistanceExceptionAB()
    {
        exception.expect(IllegalArgumentException.class);
        w.distance("NotAWordInWordNet", "NotAWordInWordNet");
    }

    @Test
    public void testDistanceNullAB()
    {
        exception.expect(NullPointerException.class);
        w.distance(null, null);
    }

    @Test
    public void testDistance()
    {
        int result;

        w = new WordNet(assignmentSynsFilename, assignmentHypFilename);
        result = w.distance("bird", "worm");
        assertEquals("Incorrect distance", 5, result);

        result = w.distance("municipality", "region");
        assertEquals("Incorrect distance", 3, result);

        result = w.distance("individual", "edible_fruit");
        assertEquals("Incorrect distance", 7, result);

        result = w.distance("white_marlin", "mileage");
        assertEquals("Incorrect distance", 23, result);

        result = w.distance("American_water_spaniel", "histology");
        assertEquals("Incorrect distance", 27, result);

        result = w.distance("Brown_Swiss", "barrel_roll");
        assertEquals("Incorrect distance", 29, result);

        result = w.distance("Black_Plague", "black_marlin");
        assertEquals("Incorrect distance", 33, result);
    }

    @Test
    public void testSapExceptionA()
    {
        exception.expect(IllegalArgumentException.class);
        w.sap("NotAWordInWordNet", "entity");
    }

    @Test
    public void testSapNullA()
    {
        exception.expect(NullPointerException.class);
        w.sap(null, "entity");
    }

    @Test
    public void testSapExceptionB()
    {
        exception.expect(IllegalArgumentException.class);
        w.sap("worm", "NotAWordInWordNet");
    }

    @Test
    public void testSapNullB()
    {
        exception.expect(NullPointerException.class);
        w.sap("entity", null);
    }

    @Test
    public void testSapExceptionAB()
    {
        exception.expect(IllegalArgumentException.class);
        w.sap("NotAWordInWordNet", "NotAWordInWordNet");
    }

    @Test
    public void testSapNullAB()
    {
        exception.expect(NullPointerException.class);
        w.sap(null, null);
    }

    @Test
    public void testSap()
    {
        String result;

        w = new WordNet(assignmentSynsFilename, assignmentHypFilename);
        result = w.sap("bird", "worm");
        assertEquals("Incorrect ancestor",
                "animal animate_being beast brute creature fauna", result);

        result = w.sap("municipality", "region");
        assertEquals("Incorrect ancestor", "region", result);

        result = w.sap("individual", "edible_fruit");
        assertEquals("Incorrect ancestor", "physical_entity", result);

        result = w.sap("white_marlin", "mileage");
        assertEquals("Incorrect ancestor", "entity", result);

        result = w.sap("American_water_spaniel", "histology");
        assertEquals("Incorrect ancestor", "entity", result);

        result = w.sap("Brown_Swiss", "barrel_roll");
        assertEquals("Incorrect ancestor", "entity", result);

        result = w.sap("Black_Plague", "black_marlin");
        assertEquals("Incorrect ancestor", "entity", result);
    }
}