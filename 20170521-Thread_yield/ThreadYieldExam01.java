public class ThreadYieldExam01 extends Thread {
	int result ;
	public ThreadYieldExam01 (String Name) {
		super(Name) ;
		result = 0;
		start();		
	}
	public void run() {
		for (int i=1; i<=5; i++) {
			result += i;
			System.out.println(getName()+ "\'s result: " + result);
			//Thread.yield();
			yield();
		}
	}
	public static void main(String[] args) {
		ThreadYieldExam01 t01 = new ThreadYieldExam01("First Thread") ;
		ThreadYieldExam01 t02 = new ThreadYieldExam01("Second Thread") ;
		ThreadYieldExam01 t03 = new ThreadYieldExam01("Third Thread") ;
		ThreadYieldExam01 t04 = new ThreadYieldExam01("Fourth Thread") ;
	}

}
