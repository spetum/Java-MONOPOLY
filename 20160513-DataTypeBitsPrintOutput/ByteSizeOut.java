
public class ByteSizeOut {
	public static String BitStringOut (long lValue) {
		final int longSize = Long.SIZE ;

		long mask = 1L << longSize -1 ; // rather than 1 without L
										// // 0x8000 0000 = (1000 0000 0000 0000  0000 0000 0000 0000)
		StringBuffer strBuf = new StringBuffer(longSize+12);
		
		for (int k=1; k <= longSize; k++) {
			if ((lValue & mask) == 0)
				strBuf.append("0");
			else 
				strBuf.append("1");
			
			lValue <<= 1 ;
			
			if ((k%4)==0) 
				if ((k % 8)== 0 && (k!=longSize))
					strBuf.append(" / ");
				else
					strBuf.append(" ");
		}
		return strBuf.toString() ;
	}
	public static String BitStringOut (byte bValue) {
		int byteSize = Byte.SIZE ;
		byte mask = (byte)(1 << (byteSize-1)) ; // 0x80 = (1000 0000)
		StringBuffer strBuf = new StringBuffer(byteSize+12);

		for (int k=1; k <= byteSize; k++){
			if ((bValue & mask) == 0)
				strBuf.append("0");
			else
				strBuf.append("1");
			
			bValue <<= 1;
			if ((k%4) == 0)
				if ((k%8) == 0 && k != byteSize)
					strBuf.append(" / ");
				else 
					strBuf.append(" ");			
		}
		return strBuf.toString() ;
	}
	public static void main(String[] args){
		byte byte_value = (byte)( 1<<7 | 1 << 4 | 1 << 3 | 1 << 1 );		
		byte byte_value2 = (byte) (0b01011001);
		long long_value = 0x9876543210ABCDEFL ;
	
//		System.out.println("bit String for byte_value without Byte.toUnsignedInt(byte_value):\n" + Integer.toBinaryString(byte_value));
//		System.out.println("bit String for byte_value without Byte.toUnsignedInt(byte_value2):\n" + Integer.toBinaryString(byte_value2));
//		
//		System.out.println("bit String for byte_value:\n" + Integer.toBinaryString(Byte.toUnsignedInt(byte_value)));
//		System.out.println("bit String for byte_value2:\n" + Integer.toBinaryString(Byte.toUnsignedInt(byte_value2)));
			
		System.out.println("bit String for byte_value:\n"+ByteSizeOut.BitStringOut(byte_value));
		System.out.println("bit String for byte_value2:\n"+ByteSizeOut.BitStringOut(byte_value2));
		
//		System.out.println("bit String for long_value with Long.toBinartString(..):\n" + Long.toBinaryString(long_value));
		System.out.println("bit String for long_value:\n" + ByteSizeOut.BitStringOut(long_value));
	}
}
