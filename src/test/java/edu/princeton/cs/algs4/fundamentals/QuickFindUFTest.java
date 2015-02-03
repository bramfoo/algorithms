package edu.princeton.cs.algs4.fundamentals;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.princeton.cs.algs4.fundamentals.QuickUnionUF;


/**
 * Unit tests for QuickFindUF
 */
public class QuickFindUFTest
{
    int N;
    QuickUnionUF uf;
    
    @Before 
    public void setup()
    {
        N = 10;
        uf = new QuickUnionUF(N);
    }

    @Test
    public void testUF()
    {        
        /* 
         * Union operations: 9-2 4-1 5-0 4-2 2-6 7-2
         * id[] result     : 0 6 6 3 6 0 6 6 8 6
         * 
         * Here is the id[] array after each union operation:
         *      0 1 2 3 4 5 6 7 8 9 
         * 9-2: 0 1 2 3 4 5 6 7 8 2 
         * 4-1: 0 1 2 3 1 5 6 7 8 2 
         * 5-0: 0 1 2 3 1 0 6 7 8 2 
         * 4-2: 0 2 2 3 2 0 6 7 8 2 
         * 2-6: 0 6 6 3 6 0 6 7 8 6 
         * 7-2: 0 6 6 3 6 0 6 6 8 6 
         */ 
        for (int i=0; i < N; i++)
            assertEquals("id[" + i + "] should be initialized to " + i, i, uf.find(i));
        
        uf.union(9, 2);
        int[] result = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 2};
        for (int pos = 0; pos < N; pos++)
            assertEquals("id[" + pos + "] should be " + result[pos], result[pos], uf.find(pos));

        uf.union(4, 1);
        result = new int[]{0, 1, 2, 3, 1, 5, 6, 7, 8, 2};
        for (int pos = 0; pos < N; pos++)
            assertEquals("id[" + pos + "] should be " + result[pos], result[pos], uf.find(pos));

        uf.union(5, 0);
        result = new int[]{0, 1, 2, 3, 1, 0, 6, 7, 8, 2};
        for (int pos = 0; pos < N; pos++)
            assertEquals("id[" + pos + "] should be " + result[pos], result[pos], uf.find(pos));
     
        uf.union(4, 2);
        result = new int[]{0, 2, 2, 3, 2, 0, 6, 7, 8, 2};
        for (int pos = 0; pos < N; pos++)
            assertEquals("id[" + pos + "] should be " + result[pos], result[pos], uf.find(pos));

        uf.union(2, 6);
        result = new int[]{0, 6, 6, 3, 6, 0, 6, 7, 8, 6};
        for (int pos = 0; pos < N; pos++)
            assertEquals("id[" + pos + "] should be " + result[pos], result[pos], uf.find(pos));

        uf.union(7, 2);
        result = new int[]{0, 6, 6, 3, 6, 0, 6, 6, 8, 6};
        for (int pos = 0; pos < N; pos++)
            assertEquals("id[" + pos + "] should be " + result[pos], result[pos], uf.find(pos));
    } 
}
