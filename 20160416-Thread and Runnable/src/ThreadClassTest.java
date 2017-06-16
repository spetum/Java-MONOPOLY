
public class ThreadClassTest extends Thread {
	public void run() {
		System.out.println("Single Thread run.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadClassTest test1 = new ThreadClassTest() ;
		test1.start();
	}

}
