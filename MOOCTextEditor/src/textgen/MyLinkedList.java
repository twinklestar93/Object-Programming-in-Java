package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		this.size = 0;
		this.head = new LLNode<E>(null);
		this.tail = new LLNode<E>(null);
		this.head.next = this.tail;
		this.tail.prev = this.head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		// Create a new node
		LLNode<E> n = new LLNode<E>(element);
		if (element == null){
			throw new NullPointerException("null element sent");
		}
		LLNode<E> prev = tail.prev;
		n.next = tail;
		n.prev = prev;
		n.next.prev = n;
		n.prev.next = n;
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(!(index >= 0 && index <= size-1)){
			throw new IndexOutOfBoundsException("Index can not be reached");
		}
		LLNode<E> traversal = head;
		for (int i = 0; i <= index; i++){
			traversal = traversal.next;
		}
		return traversal.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (element == null){
			throw new NullPointerException("null element sent");
		}
		if ((index < 0 || index > size-1) && (size != 0 || index != 0)){
			throw new IndexOutOfBoundsException("Index can not be reached");
		}
		LLNode<E> traversal = head;
		LLNode<E> nodeToAdd = new LLNode<E>(element);
		for (int i = 0; i <= index; i++){
			traversal = traversal.next;
		}
		nodeToAdd.next = traversal;
		nodeToAdd.prev = traversal.prev;
		nodeToAdd.next.prev = nodeToAdd;
		nodeToAdd.prev.next = nodeToAdd;
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(!(index >= 0 && index <= size-1)){
			throw new IndexOutOfBoundsException("Index can not be reached");
		}
		LLNode<E> traversal = head;
		for (int i = 0; i <= index; i++){
			traversal = traversal.next;
		}
		LLNode<E> prev = traversal.prev;
		LLNode<E> next = traversal.next;
		prev.next = next;
		next.prev = prev;
		size--;
		E value = traversal.data;
		return value;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(!(index >= 0 && index <= size-1)){
			throw new IndexOutOfBoundsException("Index can not be reached");
		}
		if (element == null){
			throw new NullPointerException("null element sent");
		}
		LLNode<E> traversal = head;
		for (int i = 0; i <= index; i++){
			traversal = traversal.next;
		}
		traversal.data = element;
		return element;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	public LLNode(){
		this.data = null;
		this.prev = null;
		this.next = null;
	}

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
