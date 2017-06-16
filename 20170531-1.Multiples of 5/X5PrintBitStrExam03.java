import java.io.File;
import java.io.FileOutputStream;
//import java.io.FileWriter;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class X5PrintBitStrExam03 {
	public static void main(String[] args) {
		String strGzippedFilename = new String("5s_Multiple_bitprint.txt.gz") ;
		File PrintOut = new File(strGzippedFilename) ;
		FileOutputStream fOS ;
		GZIPOutputStream gzOS ;
		//final int BufferSize = 4096 ;
		final int BufferSize = 42*50 ;
		byte [ ] buffer = new byte[BufferSize];
		StringBuffer strBuffer ;
		int len =0 ;
		int offset = 0;
		try {
			fOS = new FileOutputStream (PrintOut);
			gzOS= new GZIPOutputStream(fOS); 
			buffer = (bitsPrintOut.bitPrint(5)+"\n").getBytes();
			System.out.println(BufferSize/buffer.length); // 97 times
			System.out.println(BufferSize%buffer.length); // remainder : 22
			int range = (1<<30)-1 ;
			for (int i=5; i<range ;) {			
			//for (int i=5; i<500;) {
				strBuffer = new StringBuffer(BufferSize);
				for (int j=0; j < 50 && i< range ; j ++, i+=5) {
					String tempStr = new String(bitsPrintOut.bitPrint(i)+"\n");
					strBuffer.append(tempStr); 
				}
				System.out.println(i + ":" + strBuffer.length());
//				System.out.println(strBuffer.toString());
				buffer = strBuffer.toString().getBytes() ;
				len = buffer.length ;
				gzOS.write(buffer, 0,len);
				offset += len;
			}			
			gzOS.close();
			fOS.close();
//		} catch (FileNotFoundException e) {
//			return; 
		} catch (IOException e) {
			System.err.println("File Handle Failure"); ;			
			e.printStackTrace();
		} 
	}
}
