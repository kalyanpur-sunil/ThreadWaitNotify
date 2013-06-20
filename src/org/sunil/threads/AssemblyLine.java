package org.sunil.threads;

public class AssemblyLine {

	public void produce(){
		System.out.println(" object produced!");

		//note: i am obtaining intrensic lock on the AssemblyLine object 
		synchronized (this) {
			try {
				//after produce wait for sometime for object to get consumed.
				//Wait() method releases intrensic lock on the object and goes
				// to waiting state. when wait() is called it releases lock 
				//immediately
				wait();
				System.out.println("Lock released!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}


	}

	public void consume(){
		//wait for something to get produced
		try {
			Thread.sleep(5000);
			synchronized (this) {
				System.out.println("Consumed object!");
				//unlike wait(), notify() does not immediately releases the
				//lock. Wakes up a single thread that is waiting on 
				//this object's monitor
				notify();

				System.out.println("Make it sleep for 5 sec");

				Thread.sleep(5000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
