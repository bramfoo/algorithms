package edu.princeton.cs.coursera.boggle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import edu.princeton.cs.algs4.io.In;

/**
 * Unit tests for Boggle
 */
@RunWith(JUnit4.class)
public class BoggleTest
{
    protected String dir = "/boggle/";
    protected String board0x4filename = dir + "board0x4.txt";
    protected String board4x0filename = dir + "board4x0.txt";
    protected String board4x4filename = dir + "board4x4.txt";
    protected String boardqfilename = dir + "board-q.txt";
    protected String dictAlgs4filename = dir + "dictionary-algs4.txt";

    protected BoggleBoard board0x4;
    protected BoggleBoard board4x0;
    protected BoggleBoard board4x4;
    protected BoggleBoard boardq;

    protected BoggleSolver solver;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setup()
    {
        board0x4 = new BoggleBoard(board0x4filename);
        board4x0 = new BoggleBoard(board4x0filename);
        board4x4 = new BoggleBoard(board4x4filename);
        boardq = new BoggleBoard(boardqfilename);
        In in = new In(dictAlgs4filename);
        String[] dictionary = in.readAllStrings();
        solver = new BoggleSolver(dictionary);
    }

    @Test
    public void testScore()
    {
        // Not in dictionary
        assertEquals("Incorrect score", 0, solver.scoreOf("F"));
        assertEquals("Incorrect score", 0, solver.scoreOf("FO"));
        assertEquals("Incorrect score", 0, solver.scoreOf("FOO"));
        assertEquals("Incorrect score", 0, solver.scoreOf("FOOB"));
        assertEquals("Incorrect score", 0, solver.scoreOf("FOOBA"));
        assertEquals("Incorrect score", 0, solver.scoreOf("FOOBAR"));
        assertEquals("Incorrect score", 0, solver.scoreOf("FOOBARB"));
        assertEquals("Incorrect score", 0, solver.scoreOf("FOOBARBA"));
        assertEquals("Incorrect score", 0, solver.scoreOf("FOOBARBAZ"));

        // In dictionary
        assertEquals("Incorrect score", 0, solver.scoreOf("AN"));
        assertEquals("Incorrect score", 1, solver.scoreOf("FAR"));
        assertEquals("Incorrect score", 1, solver.scoreOf("TAG"));
        assertEquals("Incorrect score", 1, solver.scoreOf("ATOM"));
        assertEquals("Incorrect score", 1, solver.scoreOf("EXAM"));
        assertEquals("Incorrect score", 2, solver.scoreOf("EXITS"));
        assertEquals("Incorrect score", 2, solver.scoreOf("FACTS"));
        assertEquals("Incorrect score", 3, solver.scoreOf("FORCES"));
        assertEquals("Incorrect score", 3, solver.scoreOf("PIECES"));
        assertEquals("Incorrect score", 5, solver.scoreOf("ROUNDED"));
        assertEquals("Incorrect score", 5, solver.scoreOf("SOMEDAY"));
        assertEquals("Incorrect score", 11, solver.scoreOf("UNMARKED"));
        assertEquals("Incorrect score", 11, solver.scoreOf("MIMICKED"));
        assertEquals("Incorrect score", 11, solver.scoreOf("PROXIMITY"));
        assertEquals("Incorrect score", 11, solver.scoreOf("PUBLISHERS"));
        assertEquals("Incorrect score", 11, solver.scoreOf("COUNTERPRODUCTIVE"));
        assertEquals("Incorrect score", 11, solver.scoreOf("LEXICOGRAPHICALLY"));

        // In dictionary, Qu
        assertEquals("Incorrect score", 2, solver.scoreOf("EQUAL"));
        assertEquals("Incorrect score", 2, solver.scoreOf("QUEUE"));
        assertEquals("Incorrect score", 3, solver.scoreOf("QUOTED"));
        assertEquals("Incorrect score", 5, solver.scoreOf("SQUARES"));
        assertEquals("Incorrect score", 11, solver.scoreOf("ACQUIRED"));
        assertEquals("Incorrect score", 11, solver.scoreOf("FREQUENCY"));
        assertEquals("Incorrect score", 11, solver.scoreOf("INEQUALITIES"));
    }

    @Test
    public void testValidWords()
    {
        Iterable<String> words = solver.getAllValidWords(board0x4);
        HashSet<String> solution = new HashSet<>();
        int i = iterateSolutions(words, solution);
        assertEquals("Incorrect number of solutions", solution.size(), i);

        words = solver.getAllValidWords(board4x0);
        solution = new HashSet<>();
        i = iterateSolutions(words, solution);
        assertEquals("Incorrect number of solutions", solution.size(), i);

        solution = new HashSet<>(Arrays.asList(new String[]{"EQUATION", "EQUATIONS", "ITS", "LET", "LETS", "NET", "ONE", "QUERIES", "QUESTION", "QUESTIONS", "QUITE", "REQUEST", "REQUIRE", "RES", "REST", "SER", "SIN", "SINE", "SIT", "SITE", "SITS", "STATE", "TAT", "TEN", "TENS", "TIE", "TIES", "TIN", "TRIES"}));
        words = solver.getAllValidWords(boardq);
        i = iterateSolutions(words, solution);
        assertEquals("Incorrect number of solutions", solution.size(), i);
    }
    
    protected int iterateSolutions(Iterable<String> words, Set<String> solution)
    {
        int i = 0;
        Iterator<String> it = words.iterator();
        while (it.hasNext())
        {
            String s = it.next();
            assertTrue("Incorrect word", solution.contains(s));
            i++;
        }
        return i;
    }
}
