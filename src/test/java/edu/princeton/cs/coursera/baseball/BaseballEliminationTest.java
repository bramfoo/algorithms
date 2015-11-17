package edu.princeton.cs.coursera.baseball;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
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

/**
 * Unit tests for BaseballElimination
 */
@RunWith(JUnit4.class)
public class BaseballEliminationTest
{
    protected String dir = "/baseball/";
    protected String teams1 = dir + "teams1.txt";
    protected String teams4 = dir + "teams4.txt";
    protected String teams5 = dir + "teams5.txt";
    protected String teams12 = dir + "teams12.txt";
    protected String teams32 = dir + "teams32.txt";

    protected BaseballElimination b1;
    protected BaseballElimination b4;
    protected BaseballElimination b5;
    protected BaseballElimination b12;
    protected BaseballElimination b32;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setup()
    {
        b1 = new BaseballElimination(teams1);
        b4 = new BaseballElimination(teams4);
        b5 = new BaseballElimination(teams5);
        b12 = new BaseballElimination(teams12);
        b32 = new BaseballElimination(teams32);
    }

    @Test
    public void testNumberOfTeams()
    {
        assertEquals("Wrong number of teams", 1, b1.numberOfTeams());
        assertEquals("Wrong number of teams", 4, b4.numberOfTeams());
    }

    private void iterateTeams(BaseballElimination b, List<String> t, int s)
    {
        int size = 0;
        for (String team : b.teams())
        {
            assertTrue("Team not found: " + team, t.contains(team));
            size++;
        }
        assertEquals("Wrong number of teams", s, size);
    }

    @Test
    public void testTeams()
    {
        iterateTeams(b1, Arrays.asList("Turing"), 1);
        iterateTeams(b4, Arrays.asList("Atlanta", "Philadelphia", "New_York",
                "Montreal"), 4);
    }

    @Test
    public void testWins()
    {
        assertEquals("Wrong number of wins", 100, b1.wins("Turing"));
        assertEquals("Wrong number of wins", 83, b4.wins("Atlanta"));
        assertEquals("Wrong number of wins", 80, b4.wins("Philadelphia"));
        assertEquals("Wrong number of wins", 78, b4.wins("New_York"));
        assertEquals("Wrong number of wins", 77, b4.wins("Montreal"));

        // Must be the last test in the class
        exception.expect(IllegalArgumentException.class);
        b4.wins("Dilapidators");
    }

    @Test
    public void testLosses()
    {
        assertEquals("Wrong number of losses", 55, b1.losses("Turing"));
        assertEquals("Wrong number of losses", 71, b4.losses("Atlanta"));
        assertEquals("Wrong number of losses", 79, b4.losses("Philadelphia"));
        assertEquals("Wrong number of losses", 78, b4.losses("New_York"));
        assertEquals("Wrong number of losses", 82, b4.losses("Montreal"));

        // Must be the last test in the class
        exception.expect(IllegalArgumentException.class);
        b4.losses("Dilapidators");
    }

    @Test
    public void testRemaining()
    {
        assertEquals("Wrong number of games remaining", 0,
                b1.remaining("Turing"));
        assertEquals("Wrong number of games remaining", 8,
                b4.remaining("Atlanta"));
        assertEquals("Wrong number of games remaining", 3,
                b4.remaining("Philadelphia"));
        assertEquals("Wrong number of games remaining", 6,
                b4.remaining("New_York"));
        assertEquals("Wrong number of games remaining", 3,
                b4.remaining("Montreal"));

        // Must be the last test in the class
        exception.expect(IllegalArgumentException.class);
        b4.remaining("Dilapidators");
    }

    private void against(BaseballElimination b, String[] teams, int[] results)
    {
        for (int i = 0; i < teams.length; i++)
            for (int j = i; j < teams.length; j++)
                assertEquals("Wrong number of games remaining: " + teams[i]
                        + " against " + teams[j],
                        results[i * teams.length + j],
                        b.against(teams[i], teams[j]));
    }

    @Test
    public void testAgainst()
    {
        against(b1, new String[]{"Turing"}, new int[]{0});
        against(b4, new String[]{"Atlanta", "Philadelphia", "New_York",
                "Montreal"}, new int[]{0, 1, 6, 1, 1, 0, 0, 2, 6, 0, 0, 0, 1,
                2, 0, 0});

        // Must be the last test in the class
        exception.expect(IllegalArgumentException.class);
        b4.against("Atlanta", "Dilapidators");
    }

    @Test
    public void testAgainstException()
    {
        // Must be the last test in the class
        exception.expect(IllegalArgumentException.class);
        b4.against("Dilapidators", "Atlanta");
    }

    @Test
    public void testEliminationTrivial()
    {
        // Montreal can win max. 80; Atlanta already has 83
        assertTrue("Team is eliminated", b4.isEliminated("Montreal"));

        // Must be the last test in the class
        exception.expect(IllegalArgumentException.class);
        b4.isEliminated("Dilapidators");
    }

    @Test
    public void testElimination()
    {
        // Atlanta/New_York are not eliminated
        assertFalse("Team is not eliminated", b4.isEliminated("Atlanta"));
        assertFalse("Team is not eliminated", b4.isEliminated("New_York"));

        // Non-trivial elimination
        assertTrue("Team is eliminated", b4.isEliminated("Philadelphia"));

        // Non-trivial elimination
        assertTrue("Team is eliminated", b5.isEliminated("Detroit"));

        assertTrue("Team is eliminated", b12.isEliminated("Japan"));

        assertTrue("Team is eliminated", b32.isEliminated("Team25"));
        assertTrue("Team is eliminated", b32.isEliminated("Team29"));
        assertFalse("Team is eliminated", b32.isEliminated("Team24"));
        assertFalse("Team is eliminated", b32.isEliminated("Team26"));
        assertFalse("Team is eliminated", b32.isEliminated("Team27"));
        // Team28 is a trivial elimination
        assertFalse("Team is eliminated", b32.isEliminated("Team30"));
        assertFalse("Team is eliminated", b32.isEliminated("Team31"));

    }

    @Test
    public void testCertificate()
    {
        // Atlanta/New_York are not eliminated
        assertNull("No certificate", b4.certificateOfElimination("Atlanta"));
        assertNull("No certificate", b4.certificateOfElimination("New_York"));

        Iterable<String> iter = b4.certificateOfElimination("Montreal");
        for (String s : iter)
            assertEquals("Wrong certificate", s, "Atlanta");

        iter = b4.certificateOfElimination("Philadelphia");
        ArrayList<String> a = new ArrayList<String>();
        for (String s : iter)
            a.add(s);

        assertEquals("Wrong certificate size", 2, a.size());
        assertTrue("Wrong team in certificate", a.contains("Atlanta"));
        assertTrue("Wrong team in certificate", a.contains("New_York"));

        iter = b5.certificateOfElimination("Detroit");

        a = new ArrayList<String>();
        for (String s : iter)
            a.add(s);

        assertEquals("Wrong certificate size", 4, a.size());
        assertTrue("Wrong team in certificate", a.contains("New_York"));
        assertTrue("Wrong team in certificate", a.contains("Baltimore"));
        assertTrue("Wrong team in certificate", a.contains("Boston"));
        assertTrue("Wrong team in certificate", a.contains("Toronto"));

        // Must be the last test in the class
        exception.expect(IllegalArgumentException.class);
        b4.certificateOfElimination("Dilapidators");
    }
}
