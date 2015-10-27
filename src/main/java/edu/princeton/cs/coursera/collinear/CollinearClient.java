package edu.princeton.cs.coursera.collinear;

import edu.princeton.cs.algs4.io.In;
import edu.princeton.cs.algs4.io.StdDraw;
import edu.princeton.cs.algs4.io.StdOut;

/**
 * This client program takes the name of an input file as a command-line
 * argument; read the input file (in the format specified below); prints to
 * standard output the line segments that your program discovers, one per line;
 * and draws to standard draw the line segments.
 * 
 * Copied verbatim as described in <a
 * href="http://coursera.cs.princeton.edu/algs4/assignments/collinear.html"
 * >Pattern Recognition</a>
 * Minor changes made to draw points more clearly
 * @author bram
 * 
 */
public class CollinearClient
{

    public static void main(String[] args)
    {

        // read the N points from a file
        In in = new In(args[0]);
        int N = in.readInt();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++)
        {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.show(0);
        StdDraw.setPenRadius(0.01); // make the points a bit larger
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points)
        {
            p.draw();
        }
        StdDraw.show();

        StdDraw.setPenRadius(); // Reset the pen size

        // print and draw the line segments
//        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments())
        {
            StdOut.println(segment);
            segment.draw();
        }
    }
}
