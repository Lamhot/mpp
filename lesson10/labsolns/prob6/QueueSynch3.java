package lesson10.labsolns.prob6;

/** This version properly lock blocks of code
 * that might be needed for testing.
 * 
 * @author pcorazza
 *
 */
public class QueueSynch3 {
	class Node {
		Object value;
		Node next;
	}
	private Node head;
	private Node tail;
	public void add(Object newValue) {
		Node n = new Node();
		if(head == null) head = n;
		else tail.next = n;
		tail = n;
		tail.value = newValue;
	}
	public Object remove() {
		if(head == null) return null;
		Node n = head;
		head = n.next;
		return n.value;
	}
	//This ensures that an entire block of code has a lock 
	public Object addRemove(Object ... argsToAdd) {
		synchronized(this) {
			for(Object x : argsToAdd) add(x);
			return remove();
		}
	}
	public int countElements(){
		int count = 0;
		Node temp = head;
		while (temp != null){
			count++;
			temp = temp.next;
		}
		return count;
		
	}
}
