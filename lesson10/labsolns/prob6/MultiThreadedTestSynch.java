package lesson10.labsolns.prob6;

public class MultiThreadedTestSynch {	
	public static void main(String[] args) {	
		MultiThreadedTestSynch mtt = new MultiThreadedTestSynch();
		for(int i = 0; i < 10; ++i) {
			mtt.multipleCalls();
		}	
		System.out.println("Number of elements in the queue: " + mtt.q.countElements());
	}
	final QueueSynch q = new QueueSynch();
	Runnable r = () -> {	
		q.add(0);q.add(0);
		q.add(0);q.add(0);q.remove();q.remove();
	
	};
	
	
	public void multipleCalls() {
		for(int i = 0; i < 500; ++i) {		
			new Thread(r).start();		
		}		
	}
}
