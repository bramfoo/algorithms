package edu.princeton.cs.coursera.seamcarving;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

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

    private Picture p3x7;
    private Picture p4x6;
    private Picture p6x5;
    private Picture p12x10;
    private SeamCarver s3x7;
    private SeamCarver s4x6;
    private SeamCarver s6x5;
    private SeamCarver s12x10;
    
    private static final double EPSILON = 1e-02;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setup()
    {
        p3x7 = new Picture(img3x7Filename);
        s3x7 = new SeamCarver(p3x7);
    }

    @Test
    public void testConstructor()
    {
        exception.expect(NullPointerException.class);
        new SeamCarver(null);
    }

    @Test
    public void testWidth()
    {
        assertEquals("Incorrect width", 3, s3x7.width());

        p4x6 = new Picture(img4x6Filename);
        s4x6 = new SeamCarver(p4x6);
        assertEquals("Incorrect width", 4, s4x6.width());
    }

    @Test
    public void testEnergyBounds1()
    {
        exception.expect(IndexOutOfBoundsException.class);
        s3x7.energy(-1, 1);
    }

    @Test
    public void testEnergyBounds2()
    {
        exception.expect(IndexOutOfBoundsException.class);
        s3x7.energy(1, -1);
    }

    @Test
    public void testEnergyBounds3()
    {
        exception.expect(IndexOutOfBoundsException.class);
        s3x7.energy(3, 1);
    }

    @Test
    public void testEnergyBounds4()
    {
        exception.expect(IndexOutOfBoundsException.class);
        s3x7.energy(1, 7);
    }

    @Ignore
    public void testEnergyBounds5()
    {
        // TODO: Remove row/column
        exception.expect(IndexOutOfBoundsException.class);
        s3x7.energy(1, 6);
    }

    @Test
    public void testEnergy()
    {
        // image is 3 pixels wide by 7 pixels high.
        // Printing energy calculated for each pixel.
        //        1000.00* 1000.00  1000.00  
        //        1000.00   294.32* 1000.00  
        //        1000.00   236.17* 1000.00  
        //        1000.00   325.15* 1000.00  
        //        1000.00   251.36* 1000.00  
        //        1000.00   279.64* 1000.00  
        //        1000.00* 1000.00  1000.00  

        assertEquals("Wrong energy", 1000d, s3x7.energy(0, 0), EPSILON);
        assertEquals("Wrong energy", 1000d, s3x7.energy(1, 0), EPSILON);
        assertEquals("Wrong energy", 294.32d, s3x7.energy(1, 1), EPSILON);
        assertEquals("Wrong energy", 236.17d, s3x7.energy(1, 2), EPSILON);
        assertEquals("Wrong energy", 279.64d, s3x7.energy(1, 5), EPSILON);
        assertEquals("Wrong energy", 1000d, s3x7.energy(1, 6), EPSILON);
        assertEquals("Wrong energy", 1000d, s3x7.energy(2, 6), EPSILON);

        p6x5 = new Picture(img6x5Filename);
        s6x5 = new SeamCarver(p6x5);
        // image is 6 pixels wide by 5 pixels high.
        // Printing energy calculated for each pixel.
        //        1000.00  1000.00  1000.00  1000.00* 1000.00  1000.00  
        //        1000.00   237.35   151.02   234.09   107.89* 1000.00  
        //        1000.00   138.69   228.10   133.07*  211.51  1000.00  
        //        1000.00   153.88   174.01*  284.01   194.50  1000.00  
        //        1000.00  1000.00* 1000.00  1000.00  1000.00  1000.00  

        assertEquals("Wrong energy", 1000d, s6x5.energy(0, 0), EPSILON);
        assertEquals("Wrong energy", 1000d, s6x5.energy(1, 0), EPSILON);
        assertEquals("Wrong energy", 237.35d, s6x5.energy(1, 1), EPSILON);
        assertEquals("Wrong energy", 228.10d, s6x5.energy(2, 2), EPSILON);
        assertEquals("Wrong energy", 174.01d, s6x5.energy(2, 3), EPSILON);
        assertEquals("Wrong energy", 284.01d, s6x5.energy(3, 3), EPSILON);
        assertEquals("Wrong energy", 194.50d, s6x5.energy(4, 3), EPSILON);
        assertEquals("Wrong energy", 1000d, s6x5.energy(5, 3), EPSILON);
        assertEquals("Wrong energy", 1000d, s6x5.energy(5, 4), EPSILON);
    }

    @Test
    public void testFindVerticalSeam()
    {
        // Displaying vertical seam calculated.
        //        1000.00* 1000.00  1000.00  
        //        1000.00   294.32* 1000.00  
        //        1000.00   236.17* 1000.00  
        //        1000.00   325.15* 1000.00  
        //        1000.00   251.36* 1000.00  
        //        1000.00   279.64* 1000.00  
        //        1000.00* 1000.00  1000.00  
        int[] correct = new int[]{0, 1, 1, 1, 1, 1, 0};
        int[] result = s3x7.findVerticalSeam();
        assertEquals("Wrong seam length", p3x7.height(), result.length);
        assertArrayEquals("Wrong seam", correct, result);

        p6x5 = new Picture(img6x5Filename);
        s6x5 = new SeamCarver(p6x5);
        // Displaying vertical seam calculated.
        //        1000.00  1000.00  1000.00  1000.00* 1000.00  1000.00  
        //        1000.00   237.35   151.02   234.09   107.89* 1000.00  
        //        1000.00   138.69   228.10   133.07*  211.51  1000.00  
        //        1000.00   153.88   174.01*  284.01   194.50  1000.00  
        //        1000.00  1000.00* 1000.00  1000.00  1000.00  1000.00  
        correct = new int[]{3, 4, 3, 2, 1};
        result = s6x5.findVerticalSeam();
        assertEquals("Wrong seam length", p6x5.height(), result.length);
        assertArrayEquals("Wrong seam", correct, result);

        p12x10 = new Picture(img12x10Filename);
        s12x10 = new SeamCarver(p12x10);
        // Displaying vertical seam calculated.
        //        1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  1000.00* 1000.00  1000.00  1000.00  1000.00  1000.00  
        //        1000.00   218.03   149.70   244.34   283.24   154.42   356.60   155.00*  218.34   283.59   127.79  1000.00  
        //        1000.00   302.49   251.81   374.68   267.69   254.96   212.97   173.89*  268.38   198.94   326.78  1000.00  
        //        1000.00   211.42   343.91   253.05   261.13   249.92   211.04*  289.04   269.88   334.67   210.63  1000.00  
        //        1000.00   278.44   201.02   251.05   290.57   453.32   184.53*  231.94   265.70   256.80   189.91  1000.00  
        //        1000.00   299.81   218.19   230.37   229.30   279.72   237.31   203.21*  259.03   230.00   330.31  1000.00  
        //        1000.00   248.94   325.12   158.91   212.26   213.61   259.53   114.91*  138.97   309.96   194.41  1000.00  
        //        1000.00   294.15   198.64   194.50   184.68   326.50   297.71    99.89*  343.30   267.94   251.26  1000.00  
        //        1000.00   219.97   253.51   150.86   268.54   259.28   227.65   311.86   168.54*  217.37   219.49  1000.00  
        //        1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  1000.00* 1000.00  1000.00  1000.00  1000.00  
        correct = new int[]{6, 7, 7, 6, 6, 7, 7, 7, 8, 7};
        result = s12x10.findVerticalSeam();
        assertEquals("Wrong seam length", p12x10.height(), result.length);
        assertArrayEquals("Wrong seam", correct, result);
    }

    @Test
    public void testFindHorizontalSeam()
    {
        // Displaying horizontal seam calculated.
        //        1000.00  1000.00  1000.00  
        //        1000.00*  294.32  1000.00* 
        //        1000.00   236.17* 1000.00  
        //        1000.00   325.15  1000.00  
        //        1000.00   251.36  1000.00  
        //        1000.00   279.64  1000.00  
        //        1000.00  1000.00  1000.00  
        int[] correct = new int[]{1, 2, 1};
        int[] result = s3x7.findHorizontalSeam();
        assertEquals("Wrong seam length", p3x7.width(), result.length);
        assertArrayEquals("Wrong seam", correct, result);

        p6x5 = new Picture(img6x5Filename);
        s6x5 = new SeamCarver(p6x5);
        // Displaying horizontal seam calculated.
        //        1000.00  1000.00  1000.00  1000.00  1000.00  1000.00* 
        //        1000.00*  237.35   151.02*  234.09   107.89* 1000.00  
        //        1000.00   138.69*  228.10   133.07*  211.51  1000.00  
        //        1000.00   153.88   174.01   284.01   194.50  1000.00  
        //        1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  
        correct = new int[]{1, 2, 1, 2, 1, 0};
        result = s6x5.findHorizontalSeam();
        assertEquals("Wrong seam length", p6x5.width(), result.length);
        assertArrayEquals("Wrong seam", correct, result);

        p12x10 = new Picture(img12x10Filename);
        s12x10 = new SeamCarver(p12x10);
        // Displaying horizontal seam calculated.
        //        1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  
        //        1000.00   218.03   149.70   244.34   283.24   154.42   356.60   155.00   218.34   283.59   127.79  1000.00  
        //        1000.00   302.49   251.81   374.68   267.69   254.96   212.97   173.89   268.38   198.94   326.78  1000.00  
        //        1000.00   211.42   343.91   253.05   261.13   249.92   211.04   289.04   269.88   334.67   210.63  1000.00* 
        //        1000.00   278.44   201.02   251.05   290.57   453.32   184.53   231.94   265.70   256.80   189.91* 1000.00  
        //        1000.00   299.81   218.19   230.37   229.30   279.72   237.31*  203.21   259.03   230.00*  330.31  1000.00  
        //        1000.00   248.94   325.12   158.91   212.26   213.61*  259.53   114.91*  138.97*  309.96   194.41  1000.00  
        //        1000.00*  294.15   198.64*  194.50   184.68*  326.50   297.71    99.89   343.30   267.94   251.26  1000.00  
        //        1000.00   219.97*  253.51   150.86*  268.54   259.28   227.65   311.86   168.54   217.37   219.49  1000.00  
        //        1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  
        correct = new int[]{7, 8, 7, 8, 7, 6, 5, 6, 6, 5, 4, 3};
        result = s12x10.findHorizontalSeam();
        assertEquals("Wrong seam length", p12x10.width(), result.length);
        assertArrayEquals("Wrong seam", correct, result);
    }

    @Test
    public void testRemoveVerticalSeam()
    {
        // Displaying vertical seam calculated.
        //        1000.00* 1000.00  1000.00  
        //        1000.00   294.32* 1000.00  
        //        1000.00   236.17* 1000.00  
        //        1000.00   325.15* 1000.00  
        //        1000.00   251.36* 1000.00  
        //        1000.00   279.64* 1000.00  
        //        1000.00* 1000.00  1000.00  
        int[] result = s3x7.findVerticalSeam();
        s3x7.removeVerticalSeam(result);
        Picture newPic = s3x7.picture();
        assertEquals("Wrong width", 2, newPic.width());
        assertEquals("Wrong height", 7, newPic.height());
        assertEquals("Wrong Color", p3x7.get(1, 0), newPic.get(0, 0));
        assertEquals("Wrong Color", p3x7.get(2, 0), newPic.get(1, 0));
        assertEquals("Wrong Color", p3x7.get(2, 1), newPic.get(1, 1));
        assertEquals("Wrong Color", p3x7.get(2, 2), newPic.get(1, 2));
        assertEquals("Wrong Color", p3x7.get(2, 0), newPic.get(1, 0));
        assertEquals("Wrong Color", p3x7.get(2, 1), newPic.get(1, 1));
        assertEquals("Wrong Color", p3x7.get(2, 2), newPic.get(1, 2));
        assertEquals("Wrong Color", p3x7.get(2, 6), newPic.get(1, 6));

        p6x5 = new Picture(img6x5Filename);
        s6x5 = new SeamCarver(p6x5);
        // Displaying vertical seam calculated.
        //        1000.00  1000.00  1000.00  1000.00* 1000.00  1000.00  
        //        1000.00   237.35   151.02   234.09   107.89* 1000.00  
        //        1000.00   138.69   228.10   133.07*  211.51  1000.00  
        //        1000.00   153.88   174.01*  284.01   194.50  1000.00  
        //        1000.00  1000.00* 1000.00  1000.00  1000.00  1000.00  
        result = s6x5.findVerticalSeam();
        s6x5.removeVerticalSeam(result);
        newPic = s6x5.picture();
        assertEquals("Wrong width", 5, newPic.width());
        assertEquals("Wrong height", 5, newPic.height());
        assertEquals("Wrong Color", p6x5.get(0, 0), newPic.get(0, 0));
        assertEquals("Wrong Color", p6x5.get(2, 1), newPic.get(2, 1));
        assertEquals("Wrong Color", p6x5.get(2, 1), newPic.get(2, 1));
        assertEquals("Wrong Color", p6x5.get(2, 2), newPic.get(2, 2));
        assertEquals("Wrong Color", p6x5.get(3, 1), newPic.get(3, 1));
        assertEquals("Wrong Color", p6x5.get(4, 2), newPic.get(3, 2));
        assertEquals("Wrong Color", p6x5.get(5, 4), newPic.get(4, 4));
        
        exception.expect(NullPointerException.class);
        s6x5.removeHorizontalSeam(null);
    }

    @Test
    public void testRemoveHorizontalSeam()
    {
        // Displaying horizontal seam calculated.
        //        1000.00  1000.00  1000.00  
        //        1000.00*  294.32  1000.00* 
        //        1000.00   236.17* 1000.00  
        //        1000.00   325.15  1000.00  
        //        1000.00   251.36  1000.00  
        //        1000.00   279.64  1000.00  
        //        1000.00  1000.00  1000.00  
        int[] result = s3x7.findHorizontalSeam();
        s3x7.removeHorizontalSeam(result);
        Picture newPic = s3x7.picture();

        assertEquals("Wrong width", 3, newPic.width());
        assertEquals("Wrong height", 6, newPic.height());
        assertEquals("Wrong Color", p3x7.get(0, 0), newPic.get(0, 0));
        assertEquals("Wrong Color", p3x7.get(1, 1), newPic.get(1, 1));
        assertEquals("Wrong Color", p3x7.get(1, 1), newPic.get(1, 1));
        assertEquals("Wrong Color", p3x7.get(0, 2), newPic.get(0, 1));
        assertEquals("Wrong Color", p3x7.get(1, 3), newPic.get(1, 2));
        assertEquals("Wrong Color", p3x7.get(0, 6), newPic.get(0, 5));
        assertEquals("Wrong Color", p3x7.get(1, 6), newPic.get(1, 5));
        assertEquals("Wrong Color", p3x7.get(2, 6), newPic.get(2, 5));

        p6x5 = new Picture(img6x5Filename);
        s6x5 = new SeamCarver(p6x5);
        // Displaying horizontal seam calculated.
        //        1000.00  1000.00  1000.00  1000.00  1000.00  1000.00* 
        //        1000.00*  237.35   151.02*  234.09   107.89* 1000.00  
        //        1000.00   138.69*  228.10   133.07*  211.51  1000.00  
        //        1000.00   153.88   174.01   284.01   194.50  1000.00  
        //        1000.00  1000.00  1000.00  1000.00  1000.00  1000.00  
        result = s6x5.findHorizontalSeam();
        s6x5.removeHorizontalSeam(result);
        newPic = s6x5.picture();

        assertEquals("Wrong width", 6, newPic.width());
        assertEquals("Wrong height", 4, newPic.height());
        assertEquals("Wrong Color", p6x5.get(0, 0), newPic.get(0, 0));
        assertEquals("Wrong Color", p6x5.get(1, 4), newPic.get(1, 3));
        assertEquals("Wrong Color", p6x5.get(4, 2), newPic.get(4, 1));
        assertEquals("Wrong Color", p6x5.get(4, 3), newPic.get(4, 2));
        assertEquals("Wrong Color", p6x5.get(5, 4), newPic.get(5, 3));
        
        exception.expect(NullPointerException.class);
        s6x5.removeHorizontalSeam(null);
    }
}