package lambda;

public class Thread1 implements Runnable{

	@Override
	public void run() {
		
		
		for(int i=0; i<999; i++) {
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
r