package lambda;

public class ThreadTest {

	public static void main(String[] args) {
		
		Thread thread = new Thread(new Thread1());
		thread.start();
		
		for(int i=1000; i<1999; i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
	
}
