/**
 * This program provides an implementation of the Deque interface
 * and demonstrates it.
 *
 * Completion time: 10 hours
 *
 * @author Brett Perry, Acuna
 * @version 1.0, 28 January 2020
 */

import java.util.NoSuchElementException;

//TODO: implement.
public class PerryDeque<Item> implements Deque<Item> {

  //attributes
  private Node<Item> head;
  private Node<Item> tail;
  private int size;
  
  public void PerryDeque() {
    head = null;
    tail = null;
    size = 0;
  }

  /**
   * Adds one element to the front of this deque.
   * @param element the element to be added to the front of the deque
   */
  @Override
  public void enqueueFront(Item element) {               
    Node node = new Node(element);
    if (head == null) {
      head = node;
      tail = node;
    } else {
      node.setNext(head);
      head.setPrev(node);
      head = node;
    }
    size++;
  }

  /**
   * Adds one element to the back of this deque.
   * @param element the element to be added to the back of the deque
   */
  @Override
  public void enqueueBack(Item element) {                 
    Node node = new Node(element);
    if (tail == null) {
      head = node;
      tail = node;
    } else {
      tail.setNext(node);
      node.setPrev(tail);
      tail = node;
    }
    size++;
  }

  /**
   * Removes and returns the element at the front of this deque.
   * Throws an exception if the deque is empty.
   * @return the element at the front of this deque
   * @throws NoSuchElementException if the deque is empty
   */
  @Override                                                
  public Item dequeueFront() throws NoSuchElementException { 
    if (head == null) {
      throw new NoSuchElementException("Deque is empty.");
    }
    Item item = head.getItem();
    head = head.getNext();
    if (head == null) {
      tail = null;
    } else {
      head.setPrev(null);
    }
    size--;
    return item;
  }

  /**
   * Removes and returns the element at the back of this deque.
   * Throw an exception if the deque is empty.
   * @return the element at the back of the deque.
   * @throws NoSuchElementException if the deque is empty
   */
  @Override                                              
  public Item dequeueBack() throws NoSuchElementException {
      if (tail == null) {
        throw new NoSuchElementException("Deque is empty.");
      }
      Item item = tail.getItem();
      tail = tail.getPrev();
      if (tail == null) {
        head = null;
      } else {
        tail.setNext(null);
      }
      size--;
      return item;
  }

  /**
   * Returns, without removing, the element at the front of this deque.
   * Should throw an exception if the deque is empty.
   * @return the first element in the deque
   * @throws NoSuchElementException if the deque is empty
   */
  @Override                                             
  public Item first() throws NoSuchElementException {
    if (head == null) {
      throw new NoSuchElementException("Deque is empty.");
    }
    Item item = head.getItem();
    return item;
  }

  /**
   * Returns, without removing, the element at the back of this deque.
   * Should throw an exception if the deque is empty.
   * @return the last element in the deque
   * @throws NoSuchElementException if the deque is empty
   */
  @Override                                              
  public Item last() throws NoSuchElementException {
    if (tail == null) {
      throw new NoSuchElementException("Deque is empty.");
    }
    Item item = tail.getItem();
    return item;
  }

  /**
   * Returns true if this deque is empty and false otherwise.
   * @return if deque empty
   */
  @Override                                              
  public boolean isEmpty() {
    return head == null || tail == null;
  }

  /**
   * Returns the number of elements in this deque.
   * @return the number of elements in the deque
   */
  @Override                                             
  public int size() {
    return size;
  }

  /**
   * Returns a string representation of this deque. The back element
   * occurs first, and each element is separated by a space. If the
   * deque is empty, returns "empty".
   * @return the string representation of the deque
   */
  @Override                                             
  public String toString() {
    String result = "";
    if (isEmpty()) {
      result = "empty";
    } else {
      Node node = tail;
      while (node != null) {
        result += node.getItem() + " ";
        node = node.prev;
      }
    }
    return result;
  }

/****************************************************************************/

    /**
     * Program entry point for deque.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        PerryDeque<Integer> deque = new PerryDeque<Integer>();

        //standard queue behavior
        deque.enqueueBack(3);
        deque.enqueueBack(7);
        deque.enqueueBack(4);
        deque.dequeueFront();
        deque.enqueueBack(9);
        deque.enqueueBack(8);
        deque.dequeueFront();
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());

        //deque features
        System.out.println(deque.dequeueFront());
        deque.enqueueFront(1);
        deque.enqueueFront(11);
        deque.enqueueFront(3);
        deque.enqueueFront(5);
        System.out.println(deque.dequeueBack());
        System.out.println(deque.dequeueBack());
        System.out.println(deque.last());
        deque.dequeueFront();
        deque.dequeueFront();
        System.out.println(deque.first());
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());
    }
}

/**************************************************************************/