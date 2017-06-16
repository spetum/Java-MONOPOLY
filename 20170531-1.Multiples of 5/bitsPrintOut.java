
public final class bitsPrintOut {
	//private static final int longSize = Long.SIZE ;
	private static final int intSize = Integer.SIZE ;
	private static final int byteSize = Byte.SIZE ;
	private bitsPrintOut() {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int var1 = 0x7FDCBA89 ;
		int var2 = 0x7FDCBA89 ;
		
		System.out.println("count bits of int : "+intSize);
		System.out.println("Original Value : " + var1);
	
		for (int i=1; i <= intSize/8; i++) {
			System.out.println(Integer.toHexString(var1));
			printOut(var1);
			var1 <<= 8;
		}

		for (int j =1; j <= intSize/8; j++){
			System.out.println(Integer.toHexString(var2));
			System.out.println(bitPrint(var2));
			var2 <<= 8;
		}
	}
	
	public static String bitPrint(int value){
		
		int mask = 1 << intSize -1 ;
		StringBuffer strBuf = new StringBuffer(intSize+12);
		//String strBuf = new String();
		
		for (int k=1; k <= intSize; k++) {
			if ((value & mask) == 0)
				strBuf.append("0");
			else 
				strBuf.append("1");
			value <<= 1 ;
			if ((k % 8)== 0 && (k!=intSize))
				strBuf.append(" / ");
		}
		return strBuf.toString() ;
	}
	
	public static String bitPrint(byte value){
		int mask = 1 << byteSize -1 ;
		StringBuffer strBuf = new StringBuffer(byteSize+12);
		//String strBuf = new String();
		
		for (int k=1; k <= byteSize; k++) {
			if ((value & mask) == 0)
				strBuf.append("0");
			else 
				strBuf.append("1");
			value <<= 1 ;
			if ((k % 8)== 0 && (k!=byteSize))
				strBuf.append(" / ");
		}
		return strBuf.toString() ;
	}

	public static void printOut(int value) {
		int mask = 1 << intSize -1 ;
		for (int i = 1 ; i <= intSize; i++) {
			if ((value & mask) == 0)
				System.out.print("0");
			else
				System.out.print("1");
			value <<= 1 ;
			if ((i % 8)== 0 && (i!=intSize))
				System.out.print(" / ");			
		} //end of for
		System.out.println("\n");
	}//end of printOut()
}
