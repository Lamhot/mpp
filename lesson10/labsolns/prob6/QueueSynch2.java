package lesson10.labsolns.prob6;

/** This version properly locks blocks of code
 * that might be needed for testing.
 * 
 * @author pcorazza
 *
 */
public class QueueSynch2 {
	class Node {
		Object value;
		Node next;
	}
	private Node head;
	private Node tail;
	synchronized public void add(Object newValue) {
		Node n = new Node();
		if(head == null) head = n;
		else tail.next = n;
		tail = n;
		tail.value = newValue;
	}
	synchronized public Object remove() {
		if(head == null) return null;
		Node n = head;
		head = n.next;
		return n.value;
	}
	//This ensures that an entire block of code has a lock 
	synchronized public Object addRemove(Object ... argsToAdd) {
		for(Object x : argsToAdd) add(x);
		return remove();
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
