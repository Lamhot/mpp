package lesson10.labsolns.prob6;

public class MultiThreadedTestSynch2 {	
	public static void main(String[] args) {	
		MultiThreadedTestSynch2 mtt = new MultiThreadedTestSynch2();
		for(int i = 0; i < 10; ++i) {
			mtt.multipleCalls();
		}	
		System.out.println("Number of elements in the queue: " + mtt.q.countElements());
	}
	final QueueSynch2 q = new QueueSynch2();
	Runnable r = () -> {
			q.addRemove(0,0,0,0);
	};
	
	
	public void multipleCalls() {
		for(int i = 0; i < 500; ++i) {		
			new Thread(r).start();		
		}		
	}
}
