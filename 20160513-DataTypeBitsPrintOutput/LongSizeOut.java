class LongSizeOut {
	public static String BitStringOut (long lValue) {
		int longSize = Long.SIZE ;
		// 	long mask= (1L << longSize)-1L  ;
		long mask = 1L << (longSize-1) ; // 0x8000 0000 = (1000 0000 0000 0000  0000 0000 0000 0000)
		StringBuffer strBuf = new StringBuffer(longSize+12);
		// System.out.println("Maximum value of long type is " + longSize);
		 System.out.println("Mask is " + Long.toHexString(mask));
		// mask = 1L << (longSize-1) ;
		// System.out.println("Mask is " + Long.toHexString(mask));
		
		for (int k=1; k <= longSize; k++){
			if ((lValue & mask) == 0)
				strBuf.append("0");
			else
				strBuf.append("1");
			
			lValue <<= 1;
			if ((k%4) == 0)
				if ((k%8) == 0 && k != longSize)
					strBuf.append(" / ");
				else 
					strBuf.append(" ");			
		}
		return strBuf.toString() ;
	}
	public static void main(String[] args){
		long long_value =  1<<3 | 1 << 7 | 1 << 11 | 1 << 15 | 1 << 19 | 1 << 23 | 1 << 27 | 1<< 31;
		System.out.println("bit String for 1L:\n" + BitStringOut(1L) );
		System.out.println("bit String for long_value:\n" + BitStringOut(long_value) );
		
	}
}