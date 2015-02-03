package edu.princeton.cs.coursera.queues;

import java.util.Iterator;

/**
 * This class implements an elementary data structure using arrays and/or linked
 * lists for a randomized queue as described in the <a
 * href="http://coursera.cs.princeton.edu/
 * algs4/assignments/queues.html">Randomized queues and deques assignment</a>: A
 * randomized queue is similar to a stack or queue, except that the item removed
 * is chosen uniformly at random from items in the data structure.
 * <p>
 * API definition: <br>
 * <tt>
 * 
 * public class RandomizedQueue<Item> implements Iterable<Item>
 * <br>    {
 * <br>    public RandomizedQueue()
 *                  // construct an empty randomized queue
 * <br>    public boolean isEmpty()
 *                  // is the queue empty?
 * <br>    public int size()
 *                 // return the number of items on the queue
 * <br>    public void enqueue(Item item)
 *                 // add the item
 * <br>    public Item dequeue()
 *                 // delete and return a random item
 * <br>    public Item sample()
 *                 // return (but do not delete) a random item
 * <br>    public Iterator<Item> iterator()
 *                // return an independent iterator over 
 *                items in random order
 * <br>    public static void main(String[] args)
 *               // unit testing
 * <br>    }
 * </tt>
 * <p>
 * See also the <a href="http://coursera.cs.princeton.edu/
 * algs4/checklists/queues.html">Randomized Queues and Dequeues checklist</a>
 * 
 * @author Bram Lohman
 * 
 */
public class RandomizedQueue<Item> implements Iterable<Item>
{
   /**
     * Construct an empty randomized queue
     */
    public RandomizedQueue()
    {
    }

    /**
     * Is the queue empty?
     * 
     * @return
     */
    public boolean isEmpty()
    {
        return false;
    }

    /**
     * Return the number of items on the queue
     * 
     * @return
     */
    public int size()
    {
        return 0;
    }

    /**
     * Add the item
     * 
     * @param item
     *            Item to be added to back of the queue
     * @throws java.util.NullPointerException
     *             if the item is null
     */
    public void enqueue(Item item)
    {
    }

    /**
     * Delete and return a random item
     * 
     * @return A random item in the queue
     * @throws java.util.NoSuchElementException
     *             if this queue is empty
     */
    public Item dequeue()
    {
        return null;
    }

    /**
     * Return (but do not delete) a random item
     * 
     * @return Item A random item in the queue
     * @throws java.util.NoSuchElementException
     *             if this queue is empty
     */
    public Item sample()
    {
        return null;
    }

    /**
     * Return an independent iterator over items in random order
     * 
     * @return Iterator<Item> Iterator of type item
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
