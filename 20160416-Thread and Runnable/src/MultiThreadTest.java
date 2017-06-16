
public class MultiThreadTest extends Thread {
	int seq ;
	public MultiThreadTest (int seq) {
		this.seq = seq ;
	}
	public void run() {
		System.out.println(this.seq + " Thread Start.");
		try {
			Thread.sleep(500); ;
		} catch(Exception e) {
			// 거의 VM Error일 확률이 높지만 여기서는 파악하기 힘들다.
		}
		System.out.println(this.seq + " Thread Ended.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i=0; i < 10; i++) {
			Thread t = new MultiThreadTest(i) ;
			t.start() ;
		}
		System.out.println("Main end");
	}
}
