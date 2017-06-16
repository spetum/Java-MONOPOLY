
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
			// ���� VM Error�� Ȯ���� ������ ���⼭�� �ľ��ϱ� �����.
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
