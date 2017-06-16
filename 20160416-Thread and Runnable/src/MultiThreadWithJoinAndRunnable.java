//main thread가 먼저 끝나지 않도록 하기 위해 join()를 사용해보자.
//결과적으로 생성되는 순서대로는 아니지만 기다리게 하는 메소드가 join()이다. 
import java.util.ArrayList;

public class MultiThreadWithJoinAndRunnable implements Runnable {
	// Java는 다중 상속을 할 수 없기 때문에 두개의 클래스들로부터 상속받아야 한다.
	// 그렇게 때문에 클래스가 다른 클래스를 상속(extends)했을 때 다중 스레드를 사용해야 한다면
	// Runnable interface를 구현하면 된다.
	// Runnable interface를 구현하기 위해서는 구현할 클래스에 반드시 run() 메소드를 가져야 한다.
	// 참고로 모든 interface를 구현하겠다고 하면 interface에 등록된 메소드를 모두 구현해야 한다.
	// 인터페이스의 구현을 기능과 특질의 상속이라고도 한다.
	int seq ;
	public MultiThreadWithJoinAndRunnable (int seq) {  // 클래스와 생성자의 이름을 바꿈
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
			Thread t = new Thread(new MultiThreadWithJoinAndRunnable(i)) ;
			// 현재 수행하고 있는 클래스의 인스턴스를 스레드화해서 실행시키게 된다.
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
