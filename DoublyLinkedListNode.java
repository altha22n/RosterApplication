/**
 * 
 * @author Nada-Al-Thawr
 *
 * @param <T>
 */
public class DoublyLinkedListNode<T> extends LinkedListNode<T> {

	protected DoublyLinkedListNode<T> previous;

	public DoublyLinkedListNode(T data) {
		super(data);
	}
	
	public DoublyLinkedListNode<T> getPrevious (){
		return previous;
		
	}
	
	public DoublyLinkedListNode<T> getNext (T data){
		return (DoublyLinkedListNode<T>)next;
		
	}
	public void setPrevious (DoublyLinkedListNode<T> DNode){
		this.previous =  DNode;
		
	}
	public void setNext (DoublyLinkedListNode<T> DNode){
	this.next = DNode;
		
	}
}
