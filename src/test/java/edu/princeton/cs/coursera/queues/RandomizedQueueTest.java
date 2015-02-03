package edu.princeton.cs.coursera.queues;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Unit tests for RandomizedQueue
 */
@RunWith(JUnit4.class)
public class RandomizedQueueTest
{
    RandomizedQueue<Integer> r;
    Integer result;
    Integer one;
    Integer two;
    Integer three;
    Integer four;
    Integer five;
    Integer six;

    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Before 
    public void setup()
    {
        r = new RandomizedQueue<Integer>();
        one = new Integer(1);
        two = new Integer(2);
        three = new Integer(3);
        four = new Integer(4);
        five = new Integer(5);
        six = new Integer(6);
    }

    @Test
    public void testIsEmpty()
    {
    	assertTrue("Initial randomized queue should be empty", r.isEmpty());
    	assertEquals("Initial randomized queue should be empty", 0, r.size());
    } 

    @Test
    public void testEnqueue()
    {
       	assertTrue("Initial randomized queue should be empty", r.isEmpty());
    	assertEquals("Initial randomized queue should be empty", 0, r.size());
        r.enqueue(one);
       	assertFalse("Randomized queue should not be empty", r.isEmpty());
    	assertEquals("Randomized queue size should be 1", 1, r.size());
        r.enqueue(two);
       	assertFalse("Randomized queue should not be empty", r.isEmpty());
    	assertEquals("Randomized queue size should be 2", 2, r.size());
        r.enqueue(one);
       	assertFalse("Randomized queue should not be empty", r.isEmpty());
    	assertEquals("Randomized queue size should be 3", 3, r.size());
    }

    @Test
    public void testDequeue()
    {
        HashSet<Integer> s = new HashSet<Integer>();
        s.add(one);
        s.add(two);
        s.add(three);
        s.add(four);
        s.add(five);
        s.add(six);

        assertTrue("Initial randomized queue should be empty", r.isEmpty());
    	assertEquals("Initial randomized queue should be empty", 0, r.size());
        r.enqueue(one);
        r.enqueue(two);
        r.enqueue(three);
        r.enqueue(four);
        r.enqueue(five);
        r.enqueue(six);
       	assertFalse("Randomized queue should not be empty", r.isEmpty());
    	assertEquals("Randomized queue size should be 6", 6, r.size());
        result = r.dequeue();
    	assertTrue("Result " + result + " should be in set", s.contains(result));
        s.remove(result);
    	assertEquals("Randomized queue size should be " + s.size(), s.size(), r.size());
        result = r.dequeue();
        assertTrue("Result " + result + " should be in set", s.contains(result));
        s.remove(result);
    	assertEquals("Randomized queue size should be " + s.size(), s.size(), r.size());
        result = r.dequeue();
        assertTrue("Result " + result + " should be in set", s.contains(result));
        s.remove(result);
    	assertEquals("Randomized queue size should be " + s.size(), s.size(), r.size());
        result = r.dequeue();
        assertTrue("Result " + result + " should be in set", s.contains(result));
        s.remove(result);
    	assertEquals("Randomized queue size should be " + s.size(), s.size(), r.size());
        result = r.dequeue();
        assertTrue("Result " + result + " should be in set", s.contains(result));
        s.remove(result);
    	assertEquals("Randomized queue size should be " + s.size(), s.size(), r.size());
        result = r.dequeue();
        assertTrue("Result " + result + " should be in set", s.contains(result));
        s.remove(result);
       	assertTrue("Randomized queue should be empty", r.isEmpty());
    	assertEquals("Randomized queue size should be 0", 0, r.size());

        exception.expect(NoSuchElementException.class);
        r.dequeue();
    }

    @Test
    public void testSample()
    {
        HashSet<Integer> s = new HashSet<Integer>();
        s.add(one);
        s.add(two);
        s.add(three);

        r.enqueue(one);
        r.enqueue(two);
        r.enqueue(three);
        
        result = r.sample();
    	assertTrue("Result should be in set", s.contains(result));
    	assertEquals("Randomized queue size should be 3", 3, r.size());
        result = r.sample();
    	assertTrue("Result should be in set", s.contains(result));
    	assertEquals("Randomized queue size should be 3", 3, r.size());
        result = r.sample();
    	assertTrue("Result should be in set", s.contains(result));
    	assertEquals("Randomized queue size should be 3", 3, r.size());
    }
    
    @Test
    public void tesIterator()
    {
        HashSet<Integer> s = new HashSet<Integer>();
        s.add(one);
        s.add(two);
        s.add(three);
        s.add(four);

        r.enqueue(one);
        r.enqueue(two);
        r.enqueue(three);
        r.enqueue(four);

        Iterator<Integer> it1 = r.iterator();
        Iterator<Integer> it2 = r.iterator();

        assertTrue("Items left to iterate", it1.hasNext());
        assertTrue("Result should be in set", s.contains(it1.next()));
        assertTrue("Items left to iterate", it1.hasNext());
        assertTrue("Result should be in set", s.contains(it1.next()));
        assertTrue("Items left to iterate", it1.hasNext());
        assertTrue("Result should be in set", s.contains(it1.next()));

        assertTrue("Items left to iterate", it2.hasNext());
        assertTrue("Result should be in set", s.contains(it2.next()));
        assertTrue("Items left to iterate", it2.hasNext());
        assertTrue("Result should be in set", s.contains(it2.next()));
        assertTrue("Items left to iterate", it2.hasNext());
        assertTrue("Result should be in set", s.contains(it2.next()));
        assertTrue("Items left to iterate", it2.hasNext());
        assertTrue("Result should be in set", s.contains(it2.next()));
        assertFalse("No items left to iterate", it2.hasNext());
        exception.expect(NoSuchElementException.class);
        it2.next();

        assertTrue("Items left to iterate", it1.hasNext());
        assertTrue("Result should be in set", s.contains(it1.next()));
        assertFalse("No items left to iterate", it1.hasNext());
        exception.expect(NoSuchElementException.class);
        it1.next();
    }
}
