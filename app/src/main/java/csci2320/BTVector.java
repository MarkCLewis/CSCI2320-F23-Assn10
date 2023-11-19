package csci2320;

import java.util.Arrays;  // You will probably find Arrays.copyOf useful for this assignment.
import java.util.Iterator;

public abstract class BTVector<E> implements Iterable<E> {
  /**
   * Create a new vector with this element added to the end.
   * @param elem the new element
   * @return a new vector that is one bigger
   */
  abstract public BTVector<E> add(E elem);

  /**
   * Gets the value at a particular index.
   */
  abstract public E get(int index);

  /**
   * Returns a new vector where the value at the given location has been changed. Note that
   * the original collection is not altered in any way.
   * @param index location to change
   * @param elem value to set it to
   * @return a new vector with one value modified
   */
  abstract public BTVector<E> set(int index, E elem);

  /**
   * Returns the size of the vector.
   */
  abstract public int size();

  /**
   * Returns an iterator that runs through the elements in the vector. In the leaf, this can
   * be your normal iterator through an array with an index. In the internal nodes, the fast
   * approach keeps an index for a child and the iterator for that child. In the next() it
   * calls next() on the child iterator. Then, if the child iterator doesn't have a next after
   * that call, it moves the index forward and creates a new child iterator. It is done when
   * the index reaches the end.
   */
  abstract public Iterator<E> iterator();

  /**
   * This protected method is helpful in add because you need to be able to tell if the next add
   * would overflow your last child. Having this method allows you to know in advance if you need
   * create a new child or, if your last available child is full, if you need to create a new
   * parent.
   * @return a boolean telling if a node can hold more elements
   */
  abstract protected boolean isFull();

  /**
   * I found this protected method to be helpful. It has a node create a new sibling that
   * works with the same nibble `this` which contains the one provided element. This is
   * needed because when a parent needs a new child, it can ask the child to make a sibling
   * so it is of the right type (leaf/internal).
   * @param elem the one element in the new sibling
   * @return a new vector node with one element in it.
   */
  abstract protected BTVector<E> makeSibling(E elem);

  /**
   *  Our implementation groups bits into groups of 4. This constant is here so you don't have
   * "magic numbers" scattered through your code.
   */
  private static int BITS_IN_ALPHABET = 4;

  /**
   * Creates an empty leaf to begin construction of a vector.
   */
  public static <E> BTVector<E> empty() {
    return new Leaf<E>();
  }

  /**
   * This class represents an internal node in the binary trie.
   */
  private static class Internal<E> extends BTVector<E> {
    // TODO: Add your data here.

    // TODO: Include appropriate constructors.
    // My implementation had three constructors. One took a single child. One took an array of
    // children. The last took an array and a new child to add.
    // You can make a BTVector<E>[] by instantiating an array of the raw type and casting it
    // this look ssomething like (BTVector<E>) new BTVector[size].

    @Override
    public BTVector<E> add(E elem) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public E get(int index) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public BTVector<E> set(int index, E elem) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public int size() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public Iterator<E> iterator() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    protected boolean isFull() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isFull'");
    }

    @Override
    protected BTVector<E> makeSibling(E elem) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'makeSibling'");
    }
  }

  /**
   * This class represents a leaf in the binary trie.
   */
  private static class Leaf<E> extends BTVector<E> {
    // TODO: Add your array of data here. If you make the array the proper size, you don't
    // have to store a number of elements in the leaves.

    // TODO: Add you constructors here.
    // My implementation had four. One took no arguments and made an array of length zero.
    // One took a single element. One took an array of elements. The last took an array and 
    // the new element to add.

    // You can create an E[] the way we have in the past with (E[]) new Object[0].

    @Override
    public BTVector<E> add(E elem) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public E get(int index) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public BTVector<E> set(int index, E elem) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public int size() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public Iterator<E> iterator() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    protected boolean isFull() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'isFull'");
    }

    @Override
    protected BTVector<E> makeSibling(E elem) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'makeSibling'");
    }
  }
}
