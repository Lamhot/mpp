package lesson10.labsolns.prob6;

public class MultiThreadedTest {	
	public static void main(String[] args) {	
		MultiThreadedTest mtt = new MultiThreadedTest();
		for(int i = 0; i < 10; ++i) {
			mtt.multipleCalls();
		}	
		System.out.println("Number of elements in the queue: " + mtt.q.countElements());
	}
	final Queue q = new Queue();
	Runnable r = () -> {	
		q.add(0);q.add(0);q.remove();
	
	};
	
	
	public void multipleCalls() {
		for(int i = 0; i < 500; ++i) {		
			new Thread(r).start();		
		}		
	}
}
