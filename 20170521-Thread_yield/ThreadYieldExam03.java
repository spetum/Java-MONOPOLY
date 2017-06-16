// synchronized method
public class ThreadYieldExam03 extends Thread {
//	int result ;
	static int result =0 ;
	public ThreadYieldExam03 (String Name) {
		super(Name) ;
//		result = 0;
		start();
	}
	public synchronized void run() {
		for (int i=1; i<=10; i++) {
			result += i;
			System.out.println(getName()+ "\'s result: " + result);
			//Thread.yield();
			yield();
		}
	}
	public static void main(String[] args) {
		ThreadYieldExam03 t01 = new ThreadYieldExam03("First Thread") ;
		ThreadYieldExam03 t02 = new ThreadYieldExam03("Second Thread") ;
		ThreadYieldExam03 t03 = new ThreadYieldExam03("Third Thread") ;
		ThreadYieldExam03 t04 = new ThreadYieldExam03("Fourth Thread") ;
	}
}

