package edu.princeton.cs.coursera;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import edu.princeton.cs.algs4.io.StdIn;
import edu.princeton.cs.algs4.io.StdOut;

public class TestUtils
{

    // From
    // http://one-line-it.blogspot.nl/2013/05/java-testing-with-stdin-and-stdout.html
    public static void syncIn()
    {
        // Re-initialise StdIn's input buffer via reflection
        try
        {
            // StdIn
            Method resync = StdIn.class.getDeclaredMethod("resync");
            resync.setAccessible(true);
            resync.invoke(null);
        }
        catch (NoSuchMethodException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void syncOut(ByteArrayOutputStream baos)
    {
        // Re-initialise StdOut's input buffer via reflection
        try
        {
            Field out = StdOut.class.getDeclaredField("out");
            out.setAccessible(true);
            out.set(null, new PrintWriter(new OutputStreamWriter(baos,
                    "UTF-8"), true));
        }
        catch (NoSuchFieldException | IllegalAccessException
                | IllegalArgumentException | UnsupportedEncodingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
//    // set stdin
//    is = new InputStream()
//    {
//        boolean odd = true;
//        int count = 0;
//
//        @Override
//        public void reset() throws IOException
//        {
//            count = 0;
//        }
//
//        @Override
//        public int read() throws IOException
//        {
//            if (count == 20) return -1;
//            count++;
//            if (odd)
//            {
//                odd = !odd;
//                return 65;
//            }
//            else
//            {
//                odd = !odd;
//                return 10;
//            }
//        }
//    };
//    System.setIn(is);
}
