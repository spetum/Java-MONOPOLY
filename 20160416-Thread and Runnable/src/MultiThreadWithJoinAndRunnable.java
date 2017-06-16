//main thread�� ���� ������ �ʵ��� �ϱ� ���� join()�� ����غ���.
//��������� �����Ǵ� ������δ� �ƴ����� ��ٸ��� �ϴ� �޼ҵ尡 join()�̴�. 
import java.util.ArrayList;

public class MultiThreadWithJoinAndRunnable implements Runnable {
	// Java�� ���� ����� �� �� ���� ������ �ΰ��� Ŭ������κ��� ��ӹ޾ƾ� �Ѵ�.
	// �׷��� ������ Ŭ������ �ٸ� Ŭ������ ���(extends)���� �� ���� �����带 ����ؾ� �Ѵٸ�
	// Runnable interface�� �����ϸ� �ȴ�.
	// Runnable interface�� �����ϱ� ���ؼ��� ������ Ŭ������ �ݵ�� run() �޼ҵ带 ������ �Ѵ�.
	// ����� ��� interface�� �����ϰڴٰ� �ϸ� interface�� ��ϵ� �޼ҵ带 ��� �����ؾ� �Ѵ�.
	// �������̽��� ������ ��ɰ� Ư���� ����̶�� �Ѵ�.
	int seq ;
	public MultiThreadWithJoinAndRunnable (int seq) {  // Ŭ������ �������� �̸��� �ٲ�
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
			Thread t = new Thread(new MultiThreadWithJoinAndRunnable(i)) ;
			// ���� �����ϰ� �ִ� Ŭ������ �ν��Ͻ��� ������ȭ�ؼ� �����Ű�� �ȴ�.
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
