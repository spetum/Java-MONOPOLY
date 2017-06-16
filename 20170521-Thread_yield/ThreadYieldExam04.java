// synchronized method
public class ThreadYieldExam04 extends Thread {
//	int result ;
	static int result =0 ;
	public ThreadYieldExam04 (String Name) {
		super(Name) ;
		result = 0;
		start();
	}
	public void run() {
		for (int i=1; i<=10; i++) {
			synchronized (this){
				result += i;
				System.out.println(getName()+ "\'s result: " + result);
			}
			//Thread.yield();
			yield();			
		}
	}
	public static void main(String[] args) {
		ThreadYieldExam04 t01 = new ThreadYieldExam04("First Thread") ;
		ThreadYieldExam04 t02 = new ThreadYieldExam04("Second Thread") ;
		ThreadYieldExam04 t03 = new ThreadYieldExam04("Third Thread") ;
		ThreadYieldExam04 t04 = new ThreadYieldExam04("Fourth Thread") ;
	}
}

