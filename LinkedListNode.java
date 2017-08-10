/**
 * This is a class to initialize a linked list node 
 * With all the methods used 
 * @author Nada Al-Thawr
 * @param <T> 
 */
public class LinkedListNode<T> {

		protected T data;
		protected LinkedListNode<T> next;

		public LinkedListNode (T data){
			this.data = data;
		}
		// get the data stored at this node
		public T getData() {

			return data;
		}

		// set the data stored at this node
		public void setData(T data) {
			this.data = data;
		}

		// get (pointer to) next node
		protected LinkedListNode<T> getNext() {
			return next;
		}

		// set the next pointer to the passed node
		protected void setNext(LinkedListNode<T> node) {
			this.next = node;
		}

		// returns a string representation of this node
		public String toString() {
			return data.toString();
		}

	}


