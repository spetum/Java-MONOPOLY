// main thread�� ���� ������ �ʵ��� �ϱ� ���� join()�� ����غ���.
// ��������� �����Ǵ� ������δ� �ƴ����� ��ٸ��� �ϴ� �޼ҵ尡 join()�̴�. 
import java.util.ArrayList;

public class MultiThreadTestWithJoin extends Thread {
	int seq ;
	public MultiThreadTestWithJoin (int seq) {  // Ŭ������ �������� �̸��� �ٲ�
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
		ArrayList<Thread> threadsList = new ArrayList<Thread> () ;
		
		for (int i=0; i < 10; i++) {
			Thread t = new MultiThreadTestWithJoin(i) ;
			t.start() ;
			threadsList.add(t) ;
		}
		for (int i=0; i<threadsList.size(); i++) {
			Thread t = threadsList.get(i);
			try {
				t.join();
			} catch (Exception e) {
				// VM�� ���� ������� ���
			}
		}
		System.out.println("Main end");
	}
}
