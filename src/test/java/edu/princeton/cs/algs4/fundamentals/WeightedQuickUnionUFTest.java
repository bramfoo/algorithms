package edu.princeton.cs.algs4.fundamentals;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import edu.princeton.cs.algs4.fundamentals.WeightedQuickUnionUF;


/**
 * Unit tests for WeightedQuickUnionUF
 */
public class WeightedQuickUnionUFTest
{
    int N;
    WeightedQuickUnionUF uf;
    
    @Before 
    public void setup()
    {
        N = 10;
        uf = new WeightedQuickUnionUF(N);
    }

    @Ignore
    public void testUF()
    {        
        /*
         * Union operations: 7-3 2-4 5-6 8-4 5-7 0-2 2-9 4-1 9-5
         * id[] results    : 2 2 2 7 2 2 5 5 2 2
         * 
         * Here is the id[] array after each union operation:
         *      0 1 2 3 4 5 6 7 8 9 
         * 7-3: 0 1 2 7 4 5 6 7 8 9 
         * 2-4: 0 1 2 7 2 5 6 7 8 9 
         * 5-6: 0 1 2 7 2 5 5 7 8 9 
         * 8-4: 0 1 2 7 2 5 5 7 2 9 
         * 5-7: 0 1 2 7 2 5 5 5 2 9 
         * 0-2: 2 1 2 7 2 5 5 5 2 9 
         * 2-9: 2 1 2 7 2 5 5 5 2 2 
         * 4-1: 2 2 2 7 2 5 5 5 2 2 
         * 9-5: 2 2 2 7 2 2 5 5 2 2 
         */

         for (int i=0; i < N; i++)
            assertEquals("id[" + i + "] should be initialized to " + i, i, uf.find(i));

        uf.union(7, 3);
        uf.union(2, 4);
        uf.union(5, 6);
        uf.union(8, 4);
        uf.union(5, 7);
        uf.union(0, 2);
        uf.union(2, 9);
        uf.union(4, 1);
        uf.union(9, 5);

        int[] result = new int[]{2, 2, 2, 7, 2, 2, 5, 5, 2, 2};
        for (int pos = 0; pos < N; pos++)
            assertEquals("id[" + pos + "] should be " + result[pos], result[pos], uf.find(pos));

    } 

    @Ignore
    public void testUF2()
    {        
        /*
         * Union operations: 7-1 6-9 9-0 5-8 0-4 3-1 2-4 5-3 4-1
         *                    0 1 2 3 4 5 6 7 8 9
         *  id[] results    : 6 7 6 7 6 7 6 6 5 6 
         */
         
        uf.union(7, 1);
        uf.union(6, 9);
        uf.union(9, 0);
        uf.union(5, 8);
        uf.union(0, 4);
        uf.union(3, 1);
        uf.union(2, 4);
        uf.union(5, 3);
        uf.union(4, 1);

        int[] result = new int[]{6, 7, 6, 7, 6, 7, 6, 6, 5, 6};
        for (int pos = 0; pos < N; pos++)
            assertEquals("id[" + pos + "] should be " + result[pos], result[pos], uf.find(pos));
    }

    @Test
    public void testUF3()
    {        
        /*
         * Union operations: 6-4 5-4 2-4
         *                    0 1 2 3 4 5 6 7 8 9
         *  id[] results    : 0 1 6 3 6 6 6 7 8 9 	 
         */
         
        uf.union(6, 4);
        uf.union(5, 4);
        uf.union(2, 4);

        int[] result = new int[]{0, 1, 6, 3, 6, 6, 6, 7, 8, 9};
        for (int pos = 0; pos < N; pos++)
            assertEquals("id[" + pos + "] should be " + result[pos], result[pos], uf.find(pos));
    }
}
