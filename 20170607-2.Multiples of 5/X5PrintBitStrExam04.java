
public class X5PrintBitStrExam04 {

	public static void main(String[] args) {
		for (int i =5; i <256; i+=5) { 
			System.out.printf("%4d: ", i) ;
			System.out.println( bitsPrintOut.bitPrint(i) );
		}
		System.out.println( (Math.log(1048576)+Math.log(1048576))/Math.log(2));
	}

}
