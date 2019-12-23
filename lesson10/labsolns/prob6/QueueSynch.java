package lesson10.labsolns.prob6;

/** This version is, by most standards, considered
 * threadsafe. However, it is possible to corrupt the
 * Queue by alternately calling add and remove -- this is
 * a well-known problem that is documented in Java's
 * Vector class. Typically it is expected that the
 * user of the class will properly lock blocks of code
 * that access adds and removes in succession. See
 * QueueSynch2 for a version that anticipates this problem
 * (and takes the responsibility out of the client's
 * hands)
 * @author pcorazza
 *
 */
public class QueueSynch {
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
