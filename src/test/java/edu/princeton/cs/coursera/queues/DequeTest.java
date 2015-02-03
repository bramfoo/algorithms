package edu.princeton.cs.coursera.queues;

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
 * Unit tests for Deque
 */
@RunWith(JUnit4.class)
public class DequeTest
{
    Deque<Integer> d;
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
        d = new Deque<Integer>();
        one = new Integer(1);
        two = new Integer(2);
        three = new Integer(3);
        four = new Integer(4);
        five = new Integer(5);
        six = new Integer(6);
    }

    @Test
    public void testInit()
    {
    	assertEquals("Initial size should be zero", 0, d.size());        
    	assertTrue("Initial deque should be empty", d.isEmpty());
    } 

    @Test
    public void testAddFirst()
    {
        d.addFirst(one);
    	assertEquals("Size should be 1", 1, d.size());        
    	assertFalse("Deque should not be empty", d.isEmpty());

        d.addFirst(two);
    	assertEquals("Size should be 2", 2, d.size());        
    	assertFalse("Deque should not be empty", d.isEmpty());

        d.addFirst(three); // First resize (x2)
    	assertEquals("Size should be 3", 3,d.size());        
    	assertFalse("Deque should not be empty",d.isEmpty());

    	// Must be the last test in the class
        exception.expect(NullPointerException.class);
        d.addFirst(null);
    }

    @Test
    public void testRemoveFirst()
    {
        d.addFirst(one);
        result = d.removeFirst();
    	assertEquals("Item should have value " + one, one, result);        
    	assertEquals("Size should be 0", 0, d.size());        
    	assertTrue("Deque should be empty", d.isEmpty());
        
        d.addFirst(two);
        d.addFirst(three);
        d.addFirst(four);     // This should ensure a resize (x2)

        result = d.removeFirst();
    	assertEquals("Item should have value " + four, four, result);
        result = d.removeFirst();
    	assertEquals("Item should have value " + three, three, result);
        result = d.removeFirst();  // Resize (x1/4)
    	assertEquals("Item should have value " + two, two, result);
    	assertEquals("Size should be 0", 0, d.size());        
    	assertTrue("Deque should be empty", d.isEmpty());        

    	// Must be the last test in the class
        exception.expect(NoSuchElementException.class);
        d.removeFirst();
    }

    @Test
    public void testAddLast()
    {
        exception.expect(NullPointerException.class);
        d.addLast(null);
        
        d.addLast(one);
    	assertEquals("Size should be 1", 1, d.size());        
    	assertFalse("Deque should not be empty", d.isEmpty());
        
        d.addLast(two);
    	assertEquals("Size should be 2", 2, d.size());        
    	assertFalse("Deque should not be empty", d.isEmpty());

        d.addLast(three); // First resize (x2)
    	assertEquals("Size should be 3", 3, d.size());        
    	assertFalse("Deque should not be empty", d.isEmpty());
    }

    @Test
    public void testRemoveLast()
    {
        exception.expect(NoSuchElementException.class);
        d.removeLast();

        d.addLast(one);
        result = d.removeLast();
    	assertEquals("Item should have value " + one, one, result);        
    	assertEquals("Size should be 0", 0, d.size());        
    	assertTrue("Deque should be empty", d.isEmpty());
        
        d.addLast(two);
        d.addLast(three);
        d.addLast(four);     // This should ensure a 2*resize

        result = d.removeLast();
    	assertEquals("Item should have value " + two, two, result);
        result = d.removeLast();
    	assertEquals("Item should have value " + three, three, result);
        result = d.removeLast();
    	assertEquals("Item should have value " + four, four, result);
    	assertEquals("Size should be 0", 0, d.size());        
    	assertTrue("Deque should be empty", d.isEmpty());
    }

    @Test
    public void testIsEmpty()
    {
        assertTrue("Deque should be empty", d.isEmpty()); 
        d.addFirst(one);
        d.addLast(two);
    	// head == tail, but not empty
        assertFalse("Deque should not be empty", d.isEmpty()); 
        result = d.removeFirst();
        result = d.removeLast();
        assertTrue("Deque should be empty", d.isEmpty()); 
    }
    
    @Test
    public void testAddFirstRemoveLast()
    {
        d.addFirst(one);
        result = d.removeLast();
    	assertEquals("Item should have value " + one, one, result);        
    	assertEquals("Size should be 0", 0, d.size());        
    	assertTrue("Deque should be empty", d.isEmpty());

        d.addFirst(two);
        result = d.removeLast();
    	assertEquals("Item should have value " + two, two, result);        
    	assertEquals("Size should be 0", 0, d.size());        
    	assertTrue("Deque should be empty", d.isEmpty());

        d.addFirst(three);
        d.addFirst(four);
        d.addFirst(five);  // Resize (x2)
        result = d.removeLast();
    	assertEquals("Item should have value " + three, three, result);        
        result = d.removeLast(); // Resize (x1/4)
    	assertEquals("Item should have value " + four, four, result);        
        result = d.removeLast();
    	assertEquals("Size should be 0", 0, d.size());        
    	assertTrue("Deque should be empty", d.isEmpty());
    }
    
    @Test
    public void testAddLastRemoveFirst()
    {        
        d.addLast(one);
        result = d.removeFirst();
    	assertEquals("Item should have value " + one, one, result);
    	assertEquals("Size should be 0", 0, d.size());        
    	assertTrue("Deque should be empty", d.isEmpty());
        
        d.addLast(two);
        result = d.removeFirst();
    	assertEquals("Item should have value " + two, two, result);
    	assertEquals("Size should be 0", 0, d.size());        
    	assertTrue("Deque should be empty", d.isEmpty());        

        d.addLast(three);
        d.addLast(four);
        d.addLast(five);   // Resize (x2)
        result = d.removeFirst();
    	assertEquals("Item should have value " + three, three, result);
        result = d.removeFirst();
    	assertEquals("Item should have value " + four, four, result);
        result = d.removeFirst();
    	assertEquals("Size should be 0", 0, d.size());        
    	assertTrue("Deque should be empty", d.isEmpty());        
    }
    
    @Test
    public void testAddRemoveFirstLast_1()
    {        
    	assertEquals("Size should be 0", 0, d.size());        
        d.addFirst(one);
        d.addLast(two);
    	assertEquals("Size should be 2", 2, d.size());        
    	// head == tail, but not empty
        assertFalse("Deque should not be empty", d.isEmpty()); 

        d.addLast(three);
        d.addFirst(four);
    	assertEquals("Size should be 4", 4, d.size());        
        
        result = d.removeFirst();
    	assertEquals("Item should have value " + four, four, result);
        result = d.removeFirst();
    	assertEquals("Item should have value " + one, one, result);
        result = d.removeFirst();
    	assertEquals("Item should have value " + two, two, result);
        result = d.removeFirst();
    	assertEquals("Item should have value " + three, three, result);

    	assertEquals("Size should be 0", 0, d.size());        
    	assertTrue("Deque should be empty", d.isEmpty());        
    }

    @Test
    public void testAddRemoveFirstLast_2()
    {        
        d.addLast(one);
        d.addFirst(two);
    	assertEquals("Size should be 2", 2, d.size());        
    	assertFalse("Deque should not be empty", d.isEmpty());        

        d.addFirst(three);
        d.addLast(four);
    	assertEquals("Size should be 4", 4, d.size());        
    	assertFalse("Deque should not be empty", d.isEmpty());        
        
        result = d.removeLast();
    	assertEquals("Item should have value " + four, four, result);
        result = d.removeLast();
    	assertEquals("Item should have value " + one, one, result);
        result = d.removeFirst();
    	assertEquals("Item should have value " + three, three, result);
    	assertEquals("Size should be 1", 1, d.size());        
    	assertFalse("Deque should not be empty", d.isEmpty());        

        d.addFirst(five);
        d.addLast(six);
    	assertEquals("Size should be 3", 3, d.size());        
    	assertFalse("Deque should not be empty", d.isEmpty());        

        result = d.removeLast();
    	assertEquals("Item should have value " + six, six, result);
        result = d.removeLast();
    	assertEquals("Item should have value " + two, two, result);
        result = d.removeFirst();
    	assertEquals("Item should have value " + five, five, result);

    	assertEquals("Size should be 0", 0, d.size());        
    	assertTrue("Deque should be empty", d.isEmpty());        
    }

    @Test
    public void tesIterator_1()
    {
        d.addLast(one);
        d.addFirst(two);
        Iterator<Integer> it = d.iterator();

        exception.expect(UnsupportedOperationException.class);
        it.remove();

        assertTrue("Items left to iterate", it.hasNext());
        assertEquals("Result should be 2", two, it.next());
        assertTrue("Items left to iterate", it.hasNext());
        assertEquals("Result should be 1", one, it.next());
        assertFalse("No items left to iterate", it.hasNext());

        exception.expect(NoSuchElementException.class);
        it.next();
    }
        
    @Test
    public void tesIterator_2()
    {
        d.addLast(four);
        d.addFirst(three);
        d.addFirst(two);
        d.addLast(five);
        d.addFirst(one);
        d.addLast(six);

        Iterator<Integer> it1 = d.iterator();
        Iterator<Integer> it2 = d.iterator();

        assertTrue("Items left to iterate", it1.hasNext());
        assertEquals("Result should be 1", one, it1.next());
        assertTrue("Items left to iterate", it1.hasNext());
        assertEquals("Result should be 2", two, it1.next());
        assertTrue("Items left to iterate", it1.hasNext());
        assertEquals("Result should be 3", three, it1.next());

        assertTrue("Items left to iterate", it2.hasNext());
        assertEquals("Result should be 1", one, it2.next());
        assertTrue("Items left to iterate", it2.hasNext());
        assertEquals("Result should be 2", two, it2.next());
        assertTrue("Items left to iterate", it2.hasNext());
        assertEquals("Result should be 3", three, it2.next());

        assertTrue("Items left to iterate", it1.hasNext());
        assertEquals("Result should be 4", four, it1.next());
        assertTrue("Items left to iterate", it1.hasNext());
        assertEquals("Result should be 5", five, it1.next());
        assertTrue("Items left to iterate", it1.hasNext());
        assertEquals("Result should be 6", six, it1.next());
        assertFalse("No items left to iterate", it1.hasNext());
        exception.expect(NoSuchElementException.class);
        it1.next();

        assertTrue("Items left to iterate", it2.hasNext());
        assertEquals("Result should be 4", four, it2.next());
        assertTrue("Items left to iterate", it2.hasNext());
        assertEquals("Result should be 5", five, it2.next());
        assertTrue("Items left to iterate", it2.hasNext());
        assertEquals("Result should be 6", six, it2.next());
        assertFalse("No items left to iterate", it2.hasNext());
        exception.expect(NoSuchElementException.class);
        it2.next();
    }   

    @Test
    public void tesIterator_3()
    {
        d.addLast(four);
        d.addFirst(three);

        Iterator<Integer> it = d.iterator();
        int size = 0;
        while (it.hasNext())
        {
            it.next();
            size++;
        }
        assertEquals("Iterated items should be 2", 2, size);
        
        d.addFirst(two);
        d.addLast(five);
        d.removeFirst();
        d.removeLast();
        it = d.iterator();
        size = 0;
        while (it.hasNext())
        {
            it.next();
            size++;
        }
        assertEquals("Iterated items should be 2", 2, size);
                
        d.addFirst(one);
        d.addLast(six);
        d.addFirst(one);
        d.addLast(six);
        d.addFirst(one);
        d.addLast(six);
        d.removeLast();
        d.removeLast();
        d.removeFirst();
        d.removeFirst();

        it = d.iterator();
        size = 0;
        while (it.hasNext())
        {
            it.next();
            size++;
        }
        assertEquals("Iterated items should be 4", 4, size);        
    }

}
