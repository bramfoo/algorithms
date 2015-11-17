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
    protected String dir = "/wordnet/";
    protected String syn1Filename = dir + "synsets100-subgraph.txt";
    protected String hyp1Filename = dir + "hypernyms100-subgraph.txt";

    protected String assignmentSynsFilename = dir + "synsets.txt";
    protected String assignmentHypFilename = dir + "hypernyms.txt";

    protected WordNet w1;
    protected WordNet wA;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setup()
    {
        w1 = new WordNet(syn1Filename, hyp1Filename);
    }

    /*
     * This is in a separate setup method to avoid being instantiated for every test
     */
    public void setupHeavy()
    {
        wA = new WordNet(assignmentSynsFilename, assignmentHypFilename);
    }

    @Test
    public void testNouns()
    {
        Iterable<String> result = w1.nouns();
        Iterator<String> it = result.iterator();
        int count = 0;
        while (it.hasNext())
        {
            it.next();
            count++;
        }
        assertEquals("Incorrect number of nouns", 157, count);

        setupHeavy();
        result = wA.nouns();
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
        w1.isNoun(null);
    }

    @Test
    public void testIsNoun()
    {
        String[] nouns = new String[]{"C-reactive_protein", "CRP", "collagen",
                "entity", "fibrinase", "factor_XIII", "prothrombin", "factor_II",
                "zymase"};
        for (String word : nouns)
            assertTrue("Noun " + word + " is a WordNet noun", w1.isNoun(word));

        String[] notNouns = new String[]{"C-reactive_protei", "CR", "collage",
                "ntity", "ibrinase", "factr_XIII", "prothombin", "factorII", "ymase"};
        for (String word : notNouns)
            assertFalse("Noun " + word + " is NOT a WordNet noun", w1.isNoun(word));
    }

    @Test
    public void testDistanceExceptionA()
    {
        exception.expect(IllegalArgumentException.class);
        w1.distance("NotAWordInWordNet", "entity");
    }

    @Test
    public void testDistanceNullA()
    {
        exception.expect(NullPointerException.class);
        w1.distance(null, "entity");
    }

    @Test
    public void testDistanceExceptionB()
    {
        exception.expect(IllegalArgumentException.class);
        w1.distance("entity", "NotAWordInWordNet");
    }

    @Test
    public void testDistanceNullB()
    {
        exception.expect(NullPointerException.class);
        w1.distance("entity", null);
    }

    @Test
    public void testDistanceExceptionAB()
    {
        exception.expect(IllegalArgumentException.class);
        w1.distance("NotAWordInWordNet", "NotAWordInWordNet");
    }

    @Test
    public void testDistanceNullAB()
    {
        exception.expect(NullPointerException.class);
        w1.distance(null, null);
    }

    @Test
    public void testDistance()
    {
        setupHeavy();
        int result;

        result = wA.distance("bird", "worm");
        assertEquals("Incorrect distance", 5, result);

        result = wA.distance("municipality", "region");
        assertEquals("Incorrect distance", 3, result);

        result = wA.distance("individual", "edible_fruit");
        assertEquals("Incorrect distance", 7, result);

        result = wA.distance("white_marlin", "mileage");
        assertEquals("Incorrect distance", 23, result);

        result = wA.distance("American_water_spaniel", "histology");
        assertEquals("Incorrect distance", 27, result);

        result = wA.distance("Brown_Swiss", "barrel_roll");
        assertEquals("Incorrect distance", 29, result);

        result = wA.distance("Black_Plague", "black_marlin");
        assertEquals("Incorrect distance", 33, result);
    }

    @Test
    public void testSapExceptionA()
    {
        exception.expect(IllegalArgumentException.class);
        w1.sap("NotAWordInWordNet", "entity");
    }

    @Test
    public void testSapNullA()
    {
        exception.expect(NullPointerException.class);
        w1.sap(null, "entity");
    }

    @Test
    public void testSapExceptionB()
    {
        exception.expect(IllegalArgumentException.class);
        w1.sap("worm", "NotAWordInWordNet");
    }

    @Test
    public void testSapNullB()
    {
        exception.expect(NullPointerException.class);
        w1.sap("entity", null);
    }

    @Test
    public void testSapExceptionAB()
    {
        exception.expect(IllegalArgumentException.class);
        w1.sap("NotAWordInWordNet", "NotAWordInWordNet");
    }

    @Test
    public void testSapNullAB()
    {
        exception.expect(NullPointerException.class);
        w1.sap(null, null);
    }

    @Test
    public void testSap()
    {
        setupHeavy();
        String result;

        result = wA.sap("bird", "worm");
        assertEquals("Incorrect ancestor",
                "animal animate_being beast brute creature fauna", result);

        result = wA.sap("municipality", "region");
        assertEquals("Incorrect ancestor", "region", result);

        result = wA.sap("individual", "edible_fruit");
        assertEquals("Incorrect ancestor", "physical_entity", result);

        result = wA.sap("white_marlin", "mileage");
        assertEquals("Incorrect ancestor", "entity", result);

        result = wA.sap("American_water_spaniel", "histology");
        assertEquals("Incorrect ancestor", "entity", result);

        result = wA.sap("Brown_Swiss", "barrel_roll");
        assertEquals("Incorrect ancestor", "entity", result);

        result = wA.sap("Black_Plague", "black_marlin");
        assertEquals("Incorrect ancestor", "entity", result);
    }
}