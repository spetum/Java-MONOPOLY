public class ThreadYieldExam02 extends Thread{
//	int result ;
	static int result =0 ;
	public ThreadYieldExam02 (String Name) {
		super(Name) ;
		//result = 0;
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
		ThreadYieldExam02 t01 = new ThreadYieldExam02("First Thread") ;
		ThreadYieldExam02 t02 = new ThreadYieldExam02("Second Thread") ;
		ThreadYieldExam02 t03 = new ThreadYieldExam02("Third Thread") ;
		ThreadYieldExam02 t04 = new ThreadYieldExam02("Fourth Thread") ;
	}
}
