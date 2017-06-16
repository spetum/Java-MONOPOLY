import java.io.*;
//import java.util.zip.GZIPInputStream; // for GZipInputStream class
import java.util.zip.GZIPOutputStream; // for GZipOutputStream class
import java.text.SimpleDateFormat; // for SimpleDateFormat class
import java.util.Date; // for Date class

public class GZipCompressionTest {
	private GZipCompressionTest () {}
	public static void main(String[] args) throws java.io.FileNotFoundException {
		//String pathStr = new String(System.getProperties().getProperty("java.io.tmpdir"));
		String pathStr = ".";
		String fileSep = new String(System.getProperties().getProperty("file.separator"));
		String fSourceFileName = new String(pathStr +fileSep + "4321.txt");
		String GZipCompressedFileName = new String (fSourceFileName+".gz") ;
		
		long time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String DateStr = dayTime.format(new Date(time));
		String fOutputFileName = new String (pathStr+fileSep+DateStr+".txt" ) ;
		
		String GZipDecompressedFileName = new String (fOutputFileName) ;
		
		File fSource ; 
		File fGZipFile;
		FileInputStream fis;
		FileOutputStream fos;
		GZIPOutputStream GZipOut;
		// File GZip Compression
		try {
//			File fSource = new File(fSourceFileName) ; 
//			File fGZipFile = new File (GZipCompressedFileName);
//			FileInputStream fis = new FileInputStream(fSource);
//			FileOutputStream fos = new FileOutputStream(fGZipFile ) ;
//			GZIPOutputStream GZipOut = new GZIPOutputStream(fos);
			
			fSource = new File(fSourceFileName) ; 
			fGZipFile = new File (GZipCompressedFileName);
			fis = new FileInputStream(fSource);
			fos= new FileOutputStream(fGZipFile ) ;
			GZipOut = new GZIPOutputStream(fos);

			byte[] readBuffer = new byte[1024];
			int len ;
			
			System.out.println("File ("+fSourceFileName + ") size is " + fSource.length() +" Bytes." );
			while ( (len=fis.read(readBuffer))!=-1) {				
				GZipOut.write(readBuffer, 0, len);				
			}  // end of while 
			
			System.out.println("File ("+GZipCompressedFileName + ") size is " + fGZipFile.length() +" Bytes." );
			
			GZipOut.close(); 
			// 여기에 있어야 Exception이 발생하지 않는다.
			// fos를 close하고 난 다음에 GZipOut을 close를 하면
			//존재하지 않는 스트림을 닫는 셈이 된다.			
			fos.close();
			fis.close();
			//GZipOut.close(); // I don't know why Exception was invoked in GZipOut.close()  			
		} catch (IOException e) {
			e.printStackTrace(System.out);
		} finally {
			
		}
	}
}
