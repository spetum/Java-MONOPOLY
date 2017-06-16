import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class X5PrintBitStrExam02 {
	public static void main(String[] args) {
//		for (int i=5; i<(1<<30)-1;i +=5)
//			System.out.println(bitsPrintOut.bitPrint(i));
		File PrintOut = new File("5s_Multiple_bitprint.txt") ;		
		FileWriter  fw ;
		try {
			fw = new FileWriter(PrintOut) ;
			for (int i=5; i<(1<<30)-1;i +=5) {
				fw.write(bitsPrintOut.bitPrint(i)+"\n");
				fw.flush();
			}
			fw.close();
//		} catch (FileNotFoundException e) {
//			return; 
		} catch (IOException e) {
			System.err.println("File Handle Failure"); ;			
			e.printStackTrace();
		} 
	}
}
