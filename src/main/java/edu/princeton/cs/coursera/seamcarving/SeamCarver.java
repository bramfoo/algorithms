package edu.princeton.cs.coursera.seamcarving;

import edu.princeton.cs.algs4.io.Picture;

/**
 * This class implements a content-aware image resizing technique where the
 * image is reduced in size by one pixel of height (or width) at a time, 'seam
 * carving', as described in the <a href="
 * http://coursera.cs.princeton.edu/algs4/assignments/seamCarving.html">Seam
 * Carving</a> assignment.<br>
 * Unlike standard content-agnostic resizing techniques (e.g. cropping and
 * scaling), the most interesting features (aspect ratio, set of objects
 * present, etc.) of the image are preserved. <br>
 * This implementation uses the dual gradient energy function to calculate the
 * energy of each pixel, which is a measure of the importance of each pixel—the
 * higher the energy, the less likely that the pixel will be included as part of
 * a seam
 * <p>
 * API definition: <br>
 * <tt>
 * 
 * public class SeamCarver
 * <br> {
 * <br>    // create a seam carver object based on the given picture
 * <br>    public SeamCarver(Picture picture)
 * <br> 
 * <br>    // current picture
 * <br>    public Picture picture()
 * <br> 
 * <br>    // width of current picture
 * <br>    public     int width()
 * <br> 
 * <br>    // height of current picture
 * <br>    public     int height()
 * <br> 
 * <br>    // energy of pixel at column x and row y
 * <br>    public  double energy(int x, int y)
 * <br> 
 * <br>    // sequence of indices for horizontal seam
 * <br>    public   int[] findHorizontalSeam()
 * <br> 
 * <br>    // sequence of indices for vertical seam
 * <br>    public   int[] findVerticalSeam()
 * <br> 
 * <br>    // remove horizontal seam from current picture
 * <br>    public    void removeHorizontalSeam(int[] seam)
 * <br>
 * <br>    // remove vertical seam from current picture
 * <br>    public    void removeVerticalSeam(int[] seam)
 * <br> }
 * </tt>
 * <p>
 * A vertical seam in an image is a path of pixels connected from the top to the
 * bottom with one pixel in each row. (A horizontal seam is a path of pixels
 * connected from the left to the right with one pixel in each column.)
 * <p>
 * See also the <a
 * href="http://coursera.cs.princeton.edu/algs4/checklists/seamCarving.html">
 * Seam Carving checklist</a>
 * 
 * @author Bram Lohman
 */
public class SeamCarver
{
    /**
     * Create a seam carver object based on the given picture
     * 
     * @param picture
     *            The input picture to be used for seam carving
     */
    public SeamCarver(Picture picture)
    {
    }

    /**
     * Current picture
     * 
     * @return The current picture object
     */
    public Picture picture()
    {
        return null;
    }

    /**
     * Width of current picture
     * 
     * @return Width of current picture in pixels
     */
    public int width()
    {
        return -1;
    }

    /**
     * Height of current picture
     * 
     * @return Height of current picture in pixels
     */
    public int height()
    {
        return -1;
    }

    /**
     * Energy of pixel at column x and row y. This uses the dual gradient energy
     * function:<br>
     * The energy of pixel (x, y) is Δx^2(x, y) + Δy^2(x, y), where the square
     * of the x-gradient Δx^2(x, y) = Rx(x, y)^2 + Gx(x, y)^2 + Bx(x, y)^2, and
     * where the central differences Rx(x, y), Gx(x, y), and Bx(x, y) are the
     * absolute value in differences of red, green, and blue components between
     * pixel (x + 1, y) and pixel (x − 1, y).<br>
     * The square of the y-gradient Δy^2(x, y) is defined in an analogous
     * manner. <br>
     * The energy of pixels at the border of the image is defined to be 2552 +
     * 2552 + 2552 = 195075
     * 
     * @param x
     *            Column of pixel
     * @param y
     *            Row of pixel
     * @return Energy of pixel at column x and row y
     * @throws IndexOutOfBoundsException
     *             if the provided coordinate is outside the prescribed range (0
     *             and W − 1 or 0 and H − 1)
     */
    public double energy(int x, int y)
    {
        return -1d;
    }

    /**
     * Sequence of indices for horizontal seam
     * 
     * @return An array of length w
     */
    public int[] findHorizontalSeam()
    {
        return null;
    }

    /**
     * Sequence of indices for vertical seam
     * 
     * @return
     */
    public int[] findVerticalSeam()
    {
        return null;
    }

    /**
     * Remove horizontal seam from current picture
     * 
     * @param seam
     * @throws NullPointerException
     *             if the argument provided is null
     * @throws IllegalArgumentException
     *             if the current picture dimensions are too low (≤ 1), or if
     *             the provided array is of the wrong length or not a valid seam
     *             (i.e., either an entry is outside its prescribed range or two
     *             adjacent entries differ by more than 1)
     */
    public void removeHorizontalSeam(int[] seam)
    {
    }

    /**
     * Remove vertical seam from current picture
     * 
     * @param seam
     * @throws NullPointerException
     *             if the argument provided is null
     * @throws IllegalArgumentException
     *             if the current picture dimensions are too low (≤ 1), or if
     *             the provided array is of the wrong length or not a valid seam
     *             (i.e., either an entry is outside its prescribed range or two
     *             adjacent entries differ by more than 1)
     */
    public void removeVerticalSeam(int[] seam)
    {
    }
}