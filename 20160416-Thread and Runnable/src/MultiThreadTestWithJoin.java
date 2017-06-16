// main thread가 먼저 끝나지 않도록 하기 위해 join()를 사용해보자.
// 결과적으로 생성되는 순서대로는 아니지만 기다리게 하는 메소드가 join()이다. 
import java.util.ArrayList;

public class MultiThreadTestWithJoin extends Thread {
	int seq ;
	public MultiThreadTestWithJoin (int seq) {  // 클래스와 생성자의 이름을 바꿈
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
				// VM이 먼저 사라지는 경우
			}
		}
		System.out.println("Main end");
	}
}
