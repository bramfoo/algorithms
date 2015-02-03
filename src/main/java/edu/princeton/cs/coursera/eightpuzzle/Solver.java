package edu.princeton.cs.coursera.eightpuzzle;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

/**
 * This class solve the 8-puzzle problem (and its natural generalizations) using
 * the A* search algorithm as described in the <a href="
 * http://coursera.cs.princeton.edu/algs4/assignments/8puzzle.html">8
 * Puzzle</a>:
 * <p>
 * The 8-puzzle problem is a puzzle invented and popularized by Noyes Palmer
 * Chapman in the 1870s. It is played on a 3-by-3 grid with 8 square blocks
 * labeled 1 through 8 and a blank square. Your goal is to rearrange the blocks
 * so that they are in order, using as few moves as possible. You are permitted
 * to slide blocks horizontally or vertically into the blank square.
 * <p>
 * Now, we describe a solution to the problem that illustrates a general
 * artificial intelligence methodology known as the A* search algorithm. We
 * define a search node of the game to be a board, the number of moves made to
 * reach the board, and the previous search node. First, insert the initial
 * search node (the initial board, 0 moves, and a null previous search node)
 * into a priority queue. Then, delete from the priority queue the search node
 * with the minimum priority, and insert onto the priority queue all neighboring
 * search nodes (those that can be reached in one move from the dequeued search
 * node). Repeat this procedure until the search node dequeued corresponds to a
 * goal board. The success of this approach hinges on the choice of priority
 * function for a search node. We consider two priority functions:
 * <p>
 * <li>Hamming priority function. The number of blocks in the wrong position,
 * plus the number of moves made so far to get to the search node. Intuitively, a
 * search node with a small number of blocks in the wrong position is close to
 * the goal, and we prefer a search node that have been reached using a small
 * number of moves.</li>
 * <li>Manhattan priority function. The sum of the Manhattan distances (sum of
 * the vertical and horizontal distance) from the blocks to their goal
 * positions, plus the number of moves made so far to get to the search node.</li>
 * <p>
 * We make a key observation: To solve the puzzle from a given search node on
 * the priority queue, the total number of moves we need to make (including
 * those already made) is at least its priority, using either the Hamming or
 * Manhattan priority function. (For Hamming priority, this is true because each
 * block that is out of place must move at least once to reach its goal
 * position. For Manhattan priority, this is true because each block must move
 * its Manhattan distance from its goal position. Note that we do not count the
 * blank square when computing the Hamming or Manhattan priorities.)
 * Consequently, when the goal board is dequeued, we have discovered not only a
 * sequence of moves from the initial board to the goal board, but one that
 * makes the fewest number of moves.
 * <p>
 * API definition: <br>
 * <tt>
 * public class Solver
 * <br> {
 * <br> public Solver(Board initial)
 *             // find a solution to the initial board (using the A* algorithm)
 * <br> public boolean isSolvable()
 *              // is the initial board solvable?
 * <br> public int moves()
 *             // min number of moves to solve initial board; -1 if no solution
 * <br> public Iterable<Board> solution()
 *             // sequence of boards in a shortest solution; null if no solution
 * <br> public static void main(String[] args)
 *            // solve a slider puzzle (given below)
 * <br> }
 * </tt>
 * <p>
 * See also the <a href="
 * http://coursera.cs.princeton.edu/algs4/checklists/8puzzle.html"> 8 Puzzle
 * checklist</a>
 * <p>
 * The main() method was provided as part of the assignment
 * 
 * @author Bram Lohman
 * 
 */
public class Solver
{
    /**
     * Find a solution to the initial board (using the A* algorithm)
     * 
     * @param initial
     */
    public Solver(Board initial)
    {
     }

    /**
     * Is the initial board solvable?
     * 
     * @return
     */
    public boolean isSolvable()
    {
        return false;
    }

    /**
     * Min number of moves to solve initial board; -1 if no solution
     * 
     * @return
     */
    public int moves()
    {
        return -1;
    }

    /**
     * Sequence of boards in a shortest solution; null if no solution
     * 
     * @return
     */
    public Iterable<Board> solution()
    {
        return null;
    }

    /**
     * Solve a slider puzzle (provided as part of assignment)
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        // create initial board from file
        In in = new In(args[0]);
        int N = in.readInt();
        int[][] blocks = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else
        {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}