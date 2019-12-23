package lesson10.labsolns.prob6;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MultiThreadedTestSynch3WithExec {
	private static Executor exec 
	   = Executors.newCachedThreadPool();
	public static void main(String[] args) {	
		MultiThreadedTestSynch3WithExec mtt = new MultiThreadedTestSynch3WithExec();
		for(int i = 0; i < 10; ++i) {
			mtt.multipleCalls();
		}
		//sleep(200);
		System.out.println("Number of elements in the queue: " + mtt.q.countElements());
	}
	static final QueueSynch3 q = new QueueSynch3();
	static Runnable r = () -> {
			q.addRemove(0,0);
	};
	
	
	public static void multipleCalls() {
		for(int i = 0; i < 100; ++i) {
			exec.execute(r);		
		}
		try {
			Thread.sleep(10);
		} catch(InterruptedException e) {}
	}
}
