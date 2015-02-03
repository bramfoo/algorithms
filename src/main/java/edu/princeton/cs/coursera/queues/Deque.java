package edu.princeton.cs.coursera.queues;

import java.util.Iterator;

/**
 * This class implements an elementary data structure using 
 * arrays for a deque as described in the <a
 * href="http://coursera.cs.princeton.edu/
 * algs4/assignments/queues.html">Randomized queues and deques assignment</a>: A
 * double-ended queue or deque (pronounced "deck") is a generalization of a
 * stack and a queue that supports inserting and removing items from either the
 * front or the back of the data structure. Create a generic data type Deque
 * that implements the following API:
 * <p>
 * API definition: <br>
 * <tt>
 * public class Deque<Item> implements Iterable<Item> {
 * <br>    public Deque()     // construct an empty deque
 * <br>    public boolean isEmpty() // is the deque empty?
 * <br>    public int size()
 *                     // return the number of items on the deque
 * <br>    public void addFirst(Item item)
 *                     // insert the item at the front
 * <br>    public void addLast(Item item)
 *                     // insert the item at the end
 * <br>    public Item removeFirst()
 *                    // delete and return the item at the front
 * <br>    public Item removeLast()
 *                    // delete and return the item at the end
 * <br>    public Iterator<Item> iterator()
 *    // return an iterator over items in order from front to end
 * <br>    public static void main(String[] args) // unit testing
 * <br>    }
 * </tt>
 * <p>
 * See also the <a href="http://coursera.cs.princeton.edu/
 * algs4/checklists/queues.html">Randomized Queues and Dequeues checklist</a>
 * 
 * @author Bram Lohman
 * 
 */
public class Deque<Item> implements Iterable<Item>
{

    /**
     * Construct an empty deque
     */
    public Deque()
    {
    }

    /**
     * Is the deque empty?
     * 
     * @return True if empty (size is 0), false if not
     */
    public boolean isEmpty()
    {
        return false;
    }

    /**
     * Return the number of items on the deque
     * 
     * @return Number of items on the deque
     */
    public int size()
    {
        return -1;
    }

    /**
     * Insert the item at the front
     * 
     * @param item
     *            Item to be added to the front of the deque
     */
    public void addFirst(Item item)
    {
    }

    /**
     * Insert the item at the end
     * 
     * @param item
     *            Item to be added to the end of the deque
     */
    public void addLast(Item item)
    {
    }

    /**
     * Delete and return the item at the front
     * 
     * @return Item removed from the front of the deque
     */
    public Item removeFirst()
    {
        return null;
    }

    /**
     * Delete and return the item at the end
     * 
     * @return Item removed from the end of the deque
     */
    public Item removeLast()
    {
        return null;
    }

    /**
     * Return an iterator over items in order from front to end
     * 
     * @return Iterator<Item> Iterator of type Item
     * @throws UnsupportedOperationException
     *             if remove() is called
     */
    public Iterator<Item> iterator()
    {
        return null;
    }


    /**
     * Unit testing
     * 
     * @param args
     */
    public static void main(String[] args)
    {

    }
}