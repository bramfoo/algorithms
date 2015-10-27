package edu.princeton.cs.coursera.seamcarving;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import edu.princeton.cs.algs4.io.Picture;

/**
 * Unit tests for SeamCarver
 */
@RunWith(JUnit4.class)
public class SeamCarverTest
{
    private String dir = "/seamcarving/";
    private String img3x7Filename = dir + "3x7.png";
    private String img4x6Filename = dir + "4x6.png";
    private String img5x6Filename = dir + "5x6.png";
    private String img6x5Filename = dir + "6x5.png";
    private String img12x10Filename = dir + "12x10.png";

    private String assignmentImgFilename = dir + "HJocean.png";

    private Picture p;
    private SeamCarver s;

    private static final double EPSILON = 1e-15;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setup()
    {
        p = new Picture(img3x7Filename);
        s = new SeamCarver(p);
    }

    @Test
    public void testWidth()
    {
        assertEquals("Incorrect width", 3, s.width());
    }

    @Test
    public void testEnergyBounds1()
    {
        exception.expect(IndexOutOfBoundsException.class);
        s.energy(-1, 1);
    }

    @Test
    public void testEnergyBounds2()
    {
        exception.expect(IndexOutOfBoundsException.class);
        s.energy(1, -1);
    }

    @Test
    public void testEnergyBounds3()
    {
        exception.expect(IndexOutOfBoundsException.class);
        s.energy(3, 1);
    }

    @Test
    public void testEnergyBounds4()
    {
        exception.expect(IndexOutOfBoundsException.class);
        s.energy(1, 7);
    }

    @Ignore
    public void testEnergyBounds5()
    {
        // TODO: Remove row/column
        exception.expect(IndexOutOfBoundsException.class);
        s.energy(1, 6);
    }

    @Test
    public void testEnergy()
    {
        // image is 3 pixels wide by 7 pixels high.
        // Printing energy calculated for each pixel.
        // 195075 195075 195075
        // 195075 86627 195075
        // 195075 55775 195075
        // 195075 105720 195075
        // 195075 63180 195075
        // 195075 78196 195075
        // 195075 195075 195075

        assertEquals("Wrong energy", 195075d, s.energy(0, 0), EPSILON);
        assertEquals("Wrong energy", 195075d, s.energy(1, 0), EPSILON);
        assertEquals("Wrong energy", 86627d, s.energy(1, 1), EPSILON);
        assertEquals("Wrong energy", 55775d, s.energy(1, 2), EPSILON);
        assertEquals("Wrong energy", 78196d, s.energy(1, 5), EPSILON);
        assertEquals("Wrong energy", 195075d, s.energy(1, 6), EPSILON);
        assertEquals("Wrong energy", 195075d, s.energy(2, 6), EPSILON);

        p = new Picture(img6x5Filename);
        s = new SeamCarver(p);
        // image is 6 pixels wide by 5 pixels high.
        // Printing energy calculated for each pixel.
        // 195075 195075 195075 195075 195075 195075
        // 195075 23346 51304 31519 55112 195075
        // 195075 47908 61346 35919 38887 195075
        // 195075 31400 37927 14437 63076 195075
        // 195075 195075 195075 195075 195075 195075

        assertEquals("Wrong energy", 195075d, s.energy(0, 0), EPSILON);
        assertEquals("Wrong energy", 195075d, s.energy(1, 0), EPSILON);
        assertEquals("Wrong energy", 23346d, s.energy(1, 1), EPSILON);
        assertEquals("Wrong energy", 61346d, s.energy(2, 2), EPSILON);
        assertEquals("Wrong energy", 37927d, s.energy(2, 3), EPSILON);
        assertEquals("Wrong energy", 14437d, s.energy(3, 3), EPSILON);
        assertEquals("Wrong energy", 63076d, s.energy(4, 3), EPSILON);
        assertEquals("Wrong energy", 195075d, s.energy(5, 3), EPSILON);
        assertEquals("Wrong energy", 195075d, s.energy(5, 4), EPSILON);
    }

    @Test
    public void testFindVerticalSeam()
    {
        // Displaying vertical seam calculated.
        // [195075] 195075 195075
        // 195075 [ 86627] 195075
        // 195075 [ 55775] 195075
        // 195075 [105720] 195075
        // 195075 [ 63180] 195075
        // 195075 [ 78196] 195075
        // [195075] 195075 195075
        int[] correct = new int[]{0, 1, 1, 1, 1, 1, 0};
        int[] result = s.findVerticalSeam();
        assertEquals("Wrong seam length", p.height(), result.length);
        assertArrayEquals("Wrong seam", correct, result);

        p = new Picture(img6x5Filename);
        s = new SeamCarver(p);
        // Displaying vertical seam calculated.
        // 195075 195075 [195075] 195075 195075 195075
        // 195075 23346 51304 [ 31519] 55112 195075
        // 195075 47908 61346 [ 35919] 38887 195075
        // 195075 31400 37927 [ 14437] 63076 195075
        // 195075 195075 [195075] 195075 195075 195075
        correct = new int[]{2, 3, 3, 3, 2};
        result = s.findVerticalSeam();
        assertEquals("Wrong seam length", p.height(), result.length);
        assertArrayEquals("Wrong seam", correct, result);

        p = new Picture(img12x10Filename);
        s = new SeamCarver(p);
        // Displaying vertical seam calculated.
        // 195075 195075 195075 195075 195075 195075 [195075] 195075 195075
        // 195075 195075 195075
        // 195075 47535 22411 59701 80223 23846 127161 [ 24026] 47672 80424
        // 16330 195075
        // 195075 91500 63408 140387 71656 65003 45355 [ 30236] 72026 39576
        // 106787 195075
        // 195075 44700 118273 64032 68187 62460 [ 44539] 83547 72837 112001
        // 44363 195075
        // 195075 77527 40409 63028 84431 205496 [ 34050] 53795 70597 65945
        // 36064 195075
        // 195075 89889 47608 53072 52580 78242 56315 [ 41294] 67094 52900
        // 109104 195075
        // 195075 61973 105703 25252 45055 45631 67356 [ 13205] 19313 96078
        // 37795 195075
        // 195075 86524 39457 37831 34108 106604 88634 [ 9978] 117856 71794
        // 63131 195075
        // 195075 48388 64267 22759 72114 67226 51823 97255 [ 28405] 47249 48174
        // 195075
        // 195075 195075 195075 195075 195075 195075 195075 [195075] 195075
        // 195075 195075 195075
        correct = new int[]{6, 7, 7, 6, 6, 7, 7, 7, 8, 7};
        result = s.findVerticalSeam();
        assertEquals("Wrong seam length", p.height(), result.length);
        assertArrayEquals("Wrong seam", correct, result);
    }

    @Test
    public void testFindHorizontalSeam()
    {
        // Displaying horizontal seam calculated.
        // 195075 195075 195075
        // [195075] 86627 [195075]
        // 195075 [ 55775] 195075
        // 195075 105720 195075
        // 195075 63180 195075
        // 195075 78196 195075
        // 195075 195075 195075
        int[] correct = new int[]{1, 2, 1};
        int[] result = s.findHorizontalSeam();
        assertEquals("Wrong seam length", p.width(), result.length);
        assertArrayEquals("Wrong seam", correct, result);

        p = new Picture(img6x5Filename);
        s = new SeamCarver(p);
        // Displaying horizontal seam calculated.
        // 195075 195075 195075 195075 195075 195075
        // 195075 23346 51304 31519 55112 [195075]
        // [195075] 47908 61346 35919 [ 38887] 195075
        // 195075 [ 31400] [ 37927] [ 14437] 63076 195075
        // 195075 195075 195075 195075 195075 195075
        correct = new int[]{2, 3, 3, 3, 2, 1};
        result = s.findHorizontalSeam();
        assertEquals("Wrong seam length", p.width(), result.length);
        assertArrayEquals("Wrong seam", correct, result);

        p = new Picture(img12x10Filename);
        s = new SeamCarver(p);
        // Displaying horizontal seam calculated.
        // 195075 195075 195075 195075 195075 195075 195075 195075 195075 195075
        // 195075 195075
        // 195075 47535 22411 59701 80223 23846 127161 24026 47672 80424 16330
        // 195075
        // 195075 91500 63408 140387 71656 65003 45355 30236 72026 39576 106787
        // 195075
        // 195075 44700 118273 64032 68187 62460 44539 83547 72837 112001 44363
        // [195075]
        // 195075 77527 40409 63028 84431 205496 34050 53795 70597 65945 [
        // 36064] 195075
        // 195075 89889 47608 53072 52580 78242 [ 56315] 41294 67094 [ 52900]
        // 109104 195075
        // 195075 61973 105703 25252 45055 [ 45631] 67356 [ 13205] [ 19313]
        // 96078 37795 195075
        // [195075] 86524 [ 39457] 37831 [ 34108] 106604 88634 9978 117856 71794
        // 63131 195075
        // 195075 [ 48388] 64267 [ 22759] 72114 67226 51823 97255 28405 47249
        // 48174 195075
        // 195075 195075 195075 195075 195075 195075 195075 195075 195075 195075
        // 195075 195075
        correct = new int[]{7, 8, 7, 8, 7, 6, 5, 6, 6, 5, 4, 3};
        result = s.findHorizontalSeam();
        assertEquals("Wrong seam length", p.width(), result.length);
        assertArrayEquals("Wrong seam", correct, result);
    }

    @Test
    public void testRemoveVerticalSeam()
    {
        // Displaying vertical seam calculated.
        // [195075] 195075 195075
        // 195075 [ 86627] 195075
        // 195075 [ 55775] 195075
        // 195075 [105720] 195075
        // 195075 [ 63180] 195075
        // 195075 [ 78196] 195075
        // [195075] 195075 195075
        int[] result = s.findVerticalSeam();
        s.removeVerticalSeam(result);
        Picture newPic = s.picture();
        assertEquals("Wrong width", 2, newPic.width());
        assertEquals("Wrong height", 7, newPic.height());
        assertEquals("Wrong Color", p.get(1, 0), newPic.get(0, 0));
        assertEquals("Wrong Color", p.get(2, 0), newPic.get(1, 0));
        assertEquals("Wrong Color", p.get(2, 1), newPic.get(1, 1));
        assertEquals("Wrong Color", p.get(2, 2), newPic.get(1, 2));
        assertEquals("Wrong Color", p.get(2, 0), newPic.get(1, 0));
        assertEquals("Wrong Color", p.get(2, 1), newPic.get(1, 1));
        assertEquals("Wrong Color", p.get(2, 2), newPic.get(1, 2));
        assertEquals("Wrong Color", p.get(2, 6), newPic.get(1, 6));

        p = new Picture(img6x5Filename);
        s = new SeamCarver(p);
        // Displaying vertical seam calculated.
        // 195075 195075 [195075] 195075 195075 195075
        // 195075 23346 51304 [ 31519] 55112 195075
        // 195075 47908 61346 [ 35919] 38887 195075
        // 195075 31400 37927 [ 14437] 63076 195075
        // 195075 195075 [195075] 195075 195075 195075
        result = s.findVerticalSeam();
        s.removeVerticalSeam(result);
        newPic = s.picture();
        assertEquals("Wrong width", 5, newPic.width());
        assertEquals("Wrong height", 5, newPic.height());
        assertEquals("Wrong Color", p.get(0, 0), newPic.get(0, 0));
        assertEquals("Wrong Color", p.get(2, 1), newPic.get(2, 1));
        assertEquals("Wrong Color", p.get(2, 1), newPic.get(2, 1));
        assertEquals("Wrong Color", p.get(2, 2), newPic.get(2, 2));
        assertEquals("Wrong Color", p.get(4, 1), newPic.get(3, 1));
        assertEquals("Wrong Color", p.get(4, 2), newPic.get(3, 2));
        assertEquals("Wrong Color", p.get(5, 4), newPic.get(4, 4));
    }

    @Test
    public void testRemoveHorizontalSeam()
    {
        // Displaying horizontal seam calculated.
        // 195075 195075 195075
        // [195075] 86627 [195075]
        // 195075 [ 55775] 195075
        // 195075 105720 195075
        // 195075 63180 195075
        // 195075 78196 195075
        // 195075 195075 195075
        int[] result = s.findHorizontalSeam();
        s.removeHorizontalSeam(result);
        Picture newPic = s.picture();

        assertEquals("Wrong width", 3, newPic.width());
        assertEquals("Wrong height", 6, newPic.height());
        assertEquals("Wrong Color", p.get(0, 0), newPic.get(0, 0));
        assertEquals("Wrong Color", p.get(1, 1), newPic.get(1, 1));
        assertEquals("Wrong Color", p.get(1, 1), newPic.get(1, 1));
        assertEquals("Wrong Color", p.get(0, 2), newPic.get(0, 1));
        assertEquals("Wrong Color", p.get(1, 3), newPic.get(1, 2));
        assertEquals("Wrong Color", p.get(0, 6), newPic.get(0, 5));
        assertEquals("Wrong Color", p.get(1, 6), newPic.get(1, 5));
        assertEquals("Wrong Color", p.get(2, 6), newPic.get(2, 5));

        p = new Picture(img6x5Filename);
        s = new SeamCarver(p);
        // Displaying horizontal seam calculated.
        // 195075 195075 195075 195075 195075 195075
        // 195075 23346 51304 31519 55112 [195075]
        // [195075] 47908 61346 35919 [ 38887] 195075
        // 195075 [ 31400] [ 37927] [ 14437] 63076 195075
        // 195075 195075 195075 195075 195075 195075
        result = s.findHorizontalSeam();
        s.removeHorizontalSeam(result);
        newPic = s.picture();

        assertEquals("Wrong width", 6, newPic.width());
        assertEquals("Wrong height", 4, newPic.height());
        assertEquals("Wrong Color", p.get(0, 0), newPic.get(0, 0));
        assertEquals("Wrong Color", p.get(1, 4), newPic.get(1, 3));
        assertEquals("Wrong Color", p.get(4, 1), newPic.get(4, 1));
        assertEquals("Wrong Color", p.get(4, 3), newPic.get(4, 2));
        assertEquals("Wrong Color", p.get(5, 4), newPic.get(5, 3));
    }
}