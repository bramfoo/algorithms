package edu.princeton.cs.coursera.eightpuzzle;


/**
 * This class creates an immutable data type Board to solve the 8-puzzle problem
 * (and its natural generalizations) using the A* search algorithm as described
 * in the <a href="
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
 * public class Board {
 * <br> {
 * <br> public Board(int[][] blocks) 
 *                  // construct a board from an N-by-N array of blocks
 *                  // (where blocks[i][j] = block in row i, column j)
 * <br> public int dimension()
 *                  // board dimension N
 * <br> public int hamming()
 *                  // number of blocks out of place
 * <br> public int manhattan()
 *                  // sum of Manhattan distances between blocks and goal
 * <br> public boolean isGoal()
 *                 // is this board the goal board?
 * <br> public Board twin()
 *                 // a board obtained by exchanging two adjacent 
 *                 // blocks in the same row
 * <br> public boolean equals(Object y)
 *                 // does this board equal y?
 * <br> public Iterable<Board> neighbors()
 *                // all neighboring boards
 * <br> public String toString()
 *                // string representation of the board 
 *                // (in the output format specified below)
 * <br> }
 * </tt>
 * <p>
 * See also the <a href="
 * http://coursera.cs.princeton.edu/algs4/checklists/8puzzle.html"> 8 Puzzle
 * checklist</a>
 * 
 * The toString() method was provided as part of the assignment
 * 
 * @author Bram Lohman
 * 
 */

public class Board
{
    private int N;          // Board dimension
    private char[][] tiles; // Board

    /**
     * Construct a board from an N-by-N array of blocks (where blocks[i][j] =
     * block in row i, column j) Note: current limitation is 2 ≤ N < 128
     * 
     * @param blocks
     *            Square array of integers
     */
    public Board(int[][] blocks)
    {
    }
    
    /**
     * Board dimension N
     * 
     * @return Integer size of Board
     */
    public int dimension()
    {
        return -1;
    }

    /**
     * Number of blocks out of place
     * 
     * @return Number of blocks in wrong position
     */
    public int hamming()
    {
        return -1;
    }

    /**
     * Sum of Manhattan distances between blocks and goal<br>
     * The sum of the Manhattan distances (sum of the vertical and horizontal
     * distance) from the blocks to their goal positions
     * 
     * For speed optimisation, a cached value is returned after the first call to this function
     * 
     * @return The sum of the vertical and horizontal distance of the blocks
     *         from their goal positions
     */
    public int manhattan()
    {
        return -1;
    }

    /**
     * Is this board the goal board?
     * 
     * @return True if this board is the goal board, false otherwise
     */
    public boolean isGoal()
    {
        return false;
    }

    /**
     * A board obtained by exchanging two adjacent blocks in the same row
     * 
     * @return A twin board, with two adjacent blocks in the same row exchanged
     */
    public Board twin()
    {
        return null;
    }

    @Override
    public boolean equals(Object y)
    {
        return false;
    }

    /**
     * All neighboring boards, i.e. all boards where the possible tiles are
     * moved into the empty position
     * 
     * @return Iterable of Boards of all neighboring boards
     */
    public Iterable<Board> neighbors()
    {
        return null;
    }

    @Override
    public String toString()
    {
        // Taken from the checklist
        StringBuilder s = new StringBuilder();
        s.append(N + "\n");
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                s.append(String.format("%2d ", tiles[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }
}
