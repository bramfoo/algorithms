package edu.princeton.cs.coursera.baseball;

import edu.princeton.cs.introcs.StdOut;

/**
 * This class determines which teams have been mathematically eliminated from
 * winning their division, given the standings in a sports division at some
 * point during the season, as described in the <a href="
 * http://coursera.cs.princeton.edu/algs4/assignments/baseball.html">Baseball
 * Elimination</a> assignment.
 * <p>
 * 
 * The baseball elimination problem: In the <a
 * href="http://riot.ieor.berkeley.edu/~baseball/">baseball elimination
 * problem</a>, there is a division consisting of N teams. At some point during
 * the season, team i has w[i] wins, l[i] losses, r[i] remaining games, and
 * g[i][j] games left to play against team j. A team is mathematically
 * eliminated if it cannot possibly finish the season in (or tied for) first
 * place. The goal is to determine exactly which teams are mathematically
 * eliminated. For simplicity, no games end in a tie (as is the case in Major
 * League Baseball) and that there are no rainouts (i.e., every scheduled game
 * is played).<br>
 * The problem is not easy, in part because the answer depends not only on the
 * number of games won and left to play, but also on the schedule of remaining
 * games.<br>
 * The baseball elimination problem is solved by reducing it to the maxflow
 * problem.
 * 
 * API definition: <br>
 * <tt>
 * 
 * public class BaseballElimination
 * <br> {
 * <br>     // create a baseball division from given filename in format specified below
 * <br>     public BaseballElimination(String filename)
 * <br> 
 * <br>     // number of teams
 * <br>     public int numberOfTeams()
 * <br> 
 * <br>     // all teams
 * <br>     public Iterable<String> teams()
 * <br> 
 * <br>     // number of wins for given team
 * <br>     public int wins(String team)
 * <br> 
 * <br>     // number of losses for given team
 * <br>     public int losses(String team)
 * <br> 
 * <br>     // number of remaining games for given team
 * <br>     public int remaining(String team)
 * <br> 
 * <br>     // number of remaining games between team1 and team2
 * <br>     public int against(String team1, String team2)
 * <br> 
 * <br>     // is given team eliminated?
 * <br>     public boolean isEliminated(String team)
 * <br> 
 * <br>     // subset R of teams that eliminates given team; null if not eliminated
 * <br>     public Iterable<String> certificateOfElimination(String team)
 * <br> }
 * </tt>
 * <p>
 * See also the <a
 * href="http://coursera.cs.princeton.edu/algs4/checklists/baseball.html">
 * Baseball Elimination checklist</a>
 * <p>
 * Note: The main method has been provided as part of the assignment
 * 
 * @author Bram Lohman
 */
public class BaseballElimination
{
    /**
     * Create a baseball division from given filename in format specified below
     * 
     * @param filename
     */
    public BaseballElimination(String filename)
    {
        // Sample input:
        // 4
        // Atlanta 83 71 8 0 1 6 1
        // Philadelphia 80 79 3 1 0 0 2
        // New_York 78 78 6 6 0 0 0
        // Montreal 77 82 3 1 2 0 0
    }

    /**
     * Number of teams
     * 
     * @return
     */
    public int numberOfTeams()
    {
        return -1;
    }

    /**
     * All teams
     * 
     * @return An Iterable of all the teams in the division
     */
    public Iterable<String> teams()
    {
        return null;
    }

    /**
     * Number of wins for given team
     * 
     * @param team
     * @return
     */
    public int wins(String team)
    {
        return -1;
    }

    /**
     * Number of losses for given team
     * 
     * @param team
     * @return
     */
    public int losses(String team)
    {
        return -1;
    }

    /**
     * Number of remaining games for given team
     * 
     * @param team
     * @return
     */
    public int remaining(String team)
    {
        return -1;
    }

    /**
     * Number of remaining games between team1 and team2
     * 
     * @param team1
     * @param team2
     * @return
     */
    public int against(String team1, String team2)
    {
        return -1;
    }

    /**
     * Is given team eliminated? This method checks for both trivial elimination
     * (if the maximum number of games team x can win is less than the number of
     * wins of some other team i, then team x is trivially eliminated; that is,
     * if w[x] + r[x] < w[i], then team x is mathematically eliminated.
     * 
     * @param team
     * @return
     */
    public boolean isEliminated(String team)
    {
        return false;
    }

    /**
     * Subset R of teams that eliminates given team; null if not eliminated
     * 
     * @param team
     * @return
     */
    public Iterable<String> certificateOfElimination(String team)
    {
        return null;
    }

    /**
     * Read in a sports division from an input file and prints out whether each
     * team is mathematically eliminated and a certificate of elimination for
     * each team that is eliminated:
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        BaseballElimination division = new BaseballElimination(args[0]);
        for (String team : division.teams())
        {
            if (division.isEliminated(team))
            {
                StdOut.print(team + " is eliminated by the subset R = { ");
                for (String t : division.certificateOfElimination(team))
                {
                    StdOut.print(t + " ");
                }
                StdOut.println("}");
            }
            else
            {
                StdOut.println(team + " is not eliminated");
            }
        }
    }
}