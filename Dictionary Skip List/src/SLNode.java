/**
 * A Skiplist Node
 * @param <E> The type of this node
 */
 //SLNODE CLASS TOTAL: 10 MARKS
public class SLNode<E> implements Position<E> {

	//TODO: COMPLETE - 10 MARKS 
 
	/*Data members: SLNodes for next,prev,above,below*/
	/*Data member element*/
		
    /**
     * Constructor for a new SLNode NB keep this ORDER for the parameters.
     * @param next the next link
     * @param prev the prev link
     * @param above the above link
     * @param below the below link
     * @param element the element
     */
	//ORDER ORDER ORDER ORDER VERY IMPORTANT
	//next the next link
	SLNode<E> next;
	//prev the prev link
	SLNode<E> prev;   
	
	//above the above link
	SLNode<E> above;
	//below the below link
	SLNode<E> below;
	//element the element
	E element;
	
  // COnstructor which follows above order
	
	public SLNode(SLNode<E> next, SLNode<E> prev, SLNode<E> above, SLNode<E> below, E element) {
		this.next = next;  
		this.prev = prev;
		this.above = above;
		this.below = below;
		this.element = element;
	}
  
    /**
     * Get the element for this Node
     * @return The element in this node
     */
	
    /*Accessor Methods */
  

    /*Update Methods*/
	@Override
	public E element() {
		// TODO Auto-generated method stub
		return element;
	}
	
	/*Accessor Methods */
	  

    /*Update Methods*/
	public SLNode<E> getNext() {
		return next;
	}

	public void setNext(SLNode<E> next) {
		this.next = next;
	}

	public SLNode<E> getPrev() {
		return prev;
	}

	public void setPrev(SLNode<E> prev) {
		this.prev = prev;
	}

	public SLNode<E> getAbove() {
		return above;
	}

	public void setAbove(SLNode<E> above) {
		this.above = above;
	}

	public SLNode<E> getBelow() {
		return below;
	}

	public void setBelow(SLNode<E> below) {
		this.below = below;
	}

	public E getElement() {  
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

}
