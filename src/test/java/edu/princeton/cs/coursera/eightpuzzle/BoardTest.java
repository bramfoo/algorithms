package edu.princeton.cs.coursera.eightpuzzle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import edu.princeton.cs.algs4.io.In;

/**
 * Unit tests for Board
 */
@RunWith(JUnit4.class)
public class BoardTest
{
    int[][] puzzle1;
    int[][] puzzle4;
    int[][] puzzle6;
    int[][] puzzle8;
    int[][] puzzle9;
    Board board1;
    Board board4;
    Board board6;
    Board board8;
    Board board9;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setup()
    {
        // Files found in the '/test/resources/eightpuzzle/' directory
        assertNotNull("Test file missing",
                getClass().getResource("/eightpuzzle/puzzle01.txt"));
        assertNotNull("Test file missing",
                getClass().getResource("/eightpuzzle/puzzle04.txt"));
        assertNotNull("Test file missing",
                getClass().getResource("/eightpuzzle/puzzle06.txt"));
        assertNotNull("Test file missing",
                getClass().getResource("/eightpuzzle/puzzle08.txt"));
        assertNotNull("Test file missing",
                getClass().getResource("/eightpuzzle/puzzle09.txt"));
        // 1 0
        // 3 2
        In in = new In("/eightpuzzle/puzzle01.txt");
        int N = in.readInt();
        puzzle1 = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                puzzle1[i][j] = in.readInt();

        // 0 1 3
        // 4 2 5
        // 7 8 6
        in = new In("/eightpuzzle/puzzle04.txt");
        N = in.readInt();
        puzzle4 = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                puzzle4[i][j] = in.readInt();

        // 0 1 2 3
        // 5 6 7 4
        // 9 10 11 8
        // 13 14 15 12
        in = new In("/eightpuzzle/puzzle06.txt");
        N = in.readInt();
        puzzle6 = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                puzzle6[i][j] = in.readInt();

        // 2 3 5
        // 1 0 4
        // 7 8 6
        in = new In("/eightpuzzle/puzzle08.txt");
        N = in.readInt();
        puzzle8 = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                puzzle8[i][j] = in.readInt();

        // 2 0 3 4
        // 1 10 6 8
        // 5 9 7 12
        // 13 14 11 15
        in = new In("/eightpuzzle/puzzle09.txt");
        N = in.readInt();
        puzzle9 = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                puzzle9[i][j] = in.readInt();

        board1 = new Board(puzzle1);
        board4 = new Board(puzzle4);
        board6 = new Board(puzzle6);
        board8 = new Board(puzzle8);
        board9 = new Board(puzzle9);
    }

    @Test
    public void testConstructor()
    {
        int N = 2;
        int[][] t = new int[N][N];
        for (int i = 0; i < N; i++)
            Arrays.fill(t[i], N);
        Board b = new Board(t);
        assertEquals("Size 2 expected", 2, b.dimension());

        String out = new String("2\n" + " 2  2 \n" + " 2  2 \n");
        assertEquals("Unexpected toString() output", out, b.toString());

        N = 1;
        t = new int[N][N];
        for (int i = 0; i < N; i++)
            Arrays.fill(t[i], N);
        exception.expect(RuntimeException.class);
        b = new Board(t);
    }

    @Test
    public void testConstructor2()
    {

        int N = 127;
        int[][] t = new int[N][N];
        for (int i = 0; i < N; i++)
            Arrays.fill(t[i], N);
        Board b = new Board(t);
        assertEquals("Size 127 expected", 127, b.dimension());

        N = 128;
        t = new int[N][N];
        for (int i = 0; i < N; i++)
            Arrays.fill(t[i], N);
        exception.expect(RuntimeException.class);
        b = new Board(t);
    }

    @Test
    public void testDimension()
    {
        assertEquals("Size 2 expected", 2, board1.dimension());
        assertEquals("Size 3 expected", 3, board4.dimension());
        assertEquals("Size 4 expected", 4, board6.dimension());
    }

    @Test
    public void testHamming()
    {
        assertEquals("Hamming 1 expected", 1, board1.hamming());
        assertEquals("Hamming 4 expected", 4, board4.hamming());
        assertEquals("Hamming 6 expected", 6, board6.hamming());
    }

    @Test
    public void testManhattan()
    {
        assertEquals("Manhattan 1 expected", 1, board1.manhattan());
        assertEquals("Manhattan 8 expected", 8, board8.manhattan());
        assertEquals("Manhattan 9 expected", 9, board9.manhattan());

        // Test cached Manhattan value
        assertEquals("Manhattan 1 expected", 1, board1.manhattan());
        assertEquals("Manhattan 8 expected", 8, board8.manhattan());
        assertEquals("Manhattan 9 expected", 9, board9.manhattan());
    }

    @Test
    public void testIsGoal()
    {
        assertFalse("Not solved", board1.isGoal());
        assertFalse("Not solved", board4.isGoal());
        assertFalse("Not goal", board9.isGoal());

        Board b = generateSolvedBoard(2);
        assertTrue("Solved", b.isGoal());

        b = generateSolvedBoard(4);
        assertTrue("Solved", b.isGoal());
    }

    @Test
    public void TestEquals()
    {
        assertTrue("Board should equal self", board4.equals(board4));
        assertTrue("Board should equal self", board9.equals(board9));

        assertFalse("Board should not equal null", board9.equals(null));

        assertFalse("Board should not equal other class", board9.equals(new Date()));
        assertFalse("Board should not equal other class",
                board9.equals(new Integer(1)));

        assertFalse("Board should not equal different size board",
                board4.equals(board6));

        assertFalse("Board should not equal different board of same size",
                board4.equals(board8));
        assertFalse("Board should not equal different board of same size",
                board4.equals(board4.twin()));

        assertTrue(
                "Board should equal identical board",
                board8.equals(generateBoard(new int[] { 2, 3, 5, 1, 0, 4, 7, 8, 6 })));
        assertTrue(
                "Board should equal identical board",
                board4.equals(generateBoard(new int[] { 0, 1, 3, 4, 2, 5, 7, 8, 6 })));
    }

    @Test
    public void TestTwin()
    {
        // This board only has a single twin
        Board board1twin = board1.twin();
        assertEquals("Twins not identical!", board1twin.toString(),
                generateBoard(new int[] { 1, 0, 2, 3 }).toString());

        // Note that this doesn't work with a (Hash)Set as Board does not
        // implement HashCode() (which Set uses to test equality)

        // 0 1 3
        // 4 2 5
        // 7 8 6
        List<Board> board4twins = new ArrayList<Board>();
        board4twins.add(generateBoard(new int[] { 0, 3, 1, 4, 2, 5, 7, 8, 6 }));
        board4twins.add(generateBoard(new int[] { 0, 1, 3, 2, 4, 5, 7, 8, 6 }));
        board4twins.add(generateBoard(new int[] { 0, 1, 3, 4, 5, 2, 7, 8, 6 }));
        board4twins.add(generateBoard(new int[] { 0, 1, 3, 4, 2, 5, 8, 7, 6 }));
        board4twins.add(generateBoard(new int[] { 0, 1, 3, 4, 2, 5, 7, 6, 8 }));

        assertTrue("Twin not found in possible twins",
                board4twins.contains(board4.twin()));

        // 2 3 5
        // 1 0 4
        // 7 8 6
        List<Board> board8twins = new ArrayList<Board>();
        board8twins.add(generateBoard(new int[] { 3, 2, 5, 1, 0, 4, 7, 8, 6 }));
        board8twins.add(generateBoard(new int[] { 2, 5, 3, 1, 0, 4, 7, 8, 6 }));
        board8twins.add(generateBoard(new int[] { 2, 3, 5, 1, 0, 4, 8, 7, 6 }));
        board8twins.add(generateBoard(new int[] { 3, 2, 5, 1, 0, 4, 7, 6, 8 }));
        assertTrue("Twin not found in possible twins",
                board8twins.contains(board8.twin()));

    }

    @Test
    public void TestNeighbors()
    {
        List<Board> board1neighbors = new ArrayList<Board>();
        board1neighbors.add(generateBoard(new int[] { 0, 1, 3, 2 }));
        board1neighbors.add(generateBoard(new int[] { 1, 2, 3, 0 }));
        for (Board b : board1.neighbors())
        {
            assertTrue("Neighbor not found in possible neighbors",
                    board1neighbors.contains(b));
        }
        
        List<Board> board4neighbors = new ArrayList<Board>();
        board4neighbors.add(generateBoard(new int[] { 1, 0, 3, 4, 2, 5, 7, 8, 6 }));
        board4neighbors.add(generateBoard(new int[] { 4, 1, 3, 0, 2, 5, 7, 8, 6 }));
        for (Board b : board4.neighbors())
        {
            assertTrue("Neighbor not found in possible neighbors",
                    board4neighbors.contains(b));
        }

        List<Board> board8neighbors = new ArrayList<Board>();
        board8neighbors.add(generateBoard(new int[] { 2, 0, 5, 1, 3, 4, 7, 8, 6 }));
        board8neighbors.add(generateBoard(new int[] { 2, 3, 5, 0, 1, 4, 7, 8, 6 }));
        board8neighbors.add(generateBoard(new int[] { 2, 3, 5, 1, 4, 0, 7, 8, 6 }));
        board8neighbors.add(generateBoard(new int[] { 2, 3, 5, 1, 8, 4, 7, 0, 6 }));
        for (Board b : board8.neighbors())
        {
            assertTrue("Neighbor not found in possible neighbors",
                    board8neighbors.contains(b));
        }

        // 2 0 3 4
        // 1 10 6 8
        // 5 9 7 12
        // 13 14 11 15
        List<Board> board9neighbors = new ArrayList<Board>();
        board9neighbors.add(generateBoard(new int[] { 0, 2, 3, 4, 1, 10, 6, 8, 5, 9,
                7, 12, 13, 14, 11, 15 }));
        board9neighbors.add(generateBoard(new int[] { 2, 3, 0, 4, 1, 10, 6, 8, 5, 9,
                7, 12, 13, 14, 11, 15 }));
        board9neighbors.add(generateBoard(new int[] { 2, 10, 3, 4, 1, 0, 6, 8, 5, 9,
                7, 12, 13, 14, 11, 15 }));
        for (Board b : board9.neighbors())
        {
            assertTrue("Neighbor not found in possible neighbors",
                    board9neighbors.contains(b));
        }

    }

    @Test
    public void TestToString()
    {
        String out = new String("3\n" + " 0  1  3 \n" + " 4  2  5 \n"
                + " 7  8  6 \n");
        assertEquals("Unexpected toString() output", out, board4.toString());

        out = new String("4\n" + " 0  1  2  3 \n" + " 5  6  7  4 \n"
                + " 9 10 11  8 \n" + "13 14 15 12 \n");
        assertEquals("Unexpected toString() output", out, board6.toString());
    }

    private Board generateSolvedBoard(int size)
    {
        int[][] solved = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                solved[i][j] = i * size + j + 1;
        solved[size - 1][size - 1] = 0;
        return new Board(solved);
    }

    private Board generateBoard(int[] input)
    {
        int size = (int) Math.sqrt(input.length);
        int[][] blocks = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                blocks[i][j] = input[i * size + j];
        return new Board(blocks);
    }
}
