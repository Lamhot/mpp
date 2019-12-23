package lesson10.labsolns.prob6;

public class MultiThreadedTestSynch3 {	
	public static void main(String[] args) {	
		MultiThreadedTestSynch3 mtt = new MultiThreadedTestSynch3();
		for(int i = 0; i < 10; ++i) {
			mtt.multipleCalls();
		}
		//sleep(200);
		System.out.println("Number of elements in the queue: " + mtt.q.countElements());
	}
	final QueueSynch3 q = new QueueSynch3();
	Runnable r = () -> {
			q.addRemove(0,0);
	};
	
	@SuppressWarnings("unused")
	private static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch(InterruptedException e) {
			System.out.println("InterruptedException");
		}
	}
	public void multipleCalls() {
		for(int i = 0; i < 500; ++i) {		
			new Thread(r).start();		
		}		
	}
}
