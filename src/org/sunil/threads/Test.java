package org.sunil.threads;

public class Test {
	public static void main(String []args){

		final AssemblyLine line = new AssemblyLine();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				line.produce();

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				line.consume();

			}
		});

		//start t1 and t2
		t1.start();
		t2.start();

		try{
			t1.join();
			t2.join();
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
	}
}
