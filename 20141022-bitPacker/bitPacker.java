
public class bitPacker {
	private static final int intSize = Integer.SIZE ;
	private static final int byteSize = Byte.SIZE ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// char a = 'a', b='b', c='c', d='d' ;
		char a = 192, b=168, c=146, d=55 ;
		byte[] bytePack = new byte[4];
		byte[] byteUnpack = new byte[4];
		int packChar = 0;
		int tm_i = 0;
/*		
		bytePack[0] = (byte)a;
		bytePack[1] = (byte)b;
		bytePack[2] = (byte)c;
		bytePack[3] = (byte)d;
*/
		bytePack[0] = (byte)192;	// 1100 0000
		bytePack[1] = (byte)168;	// 1010 1000
		bytePack[2] = (byte)146;	// 1001 0010
		bytePack[3] = (byte)55 ;	// 0011 0111

/*
 * 127을 넘어가면 byte는 최상위 비트를 부호로 인식하기 때문에 1이 모두 설정이 된다.
 * 이 때 bitwise OR Operation을 수행하면 모두가 1로 설정되기 때문에 
 * tm_i와 << 연산 이후에 추가적인 >>>이 있어야만 원하는 결과를 얻을 수 있다.
*/
		for (int i=0; i<bytePack.length; i++) {
			// packChar <<= 8*(bytePack.length-i+1);
			// System.out.println("Shift left 8 bits before bitwise OR " + i);
			
			tm_i |= bytePack[i];			
			System.out.println("tm_i after bitwise OR ("+ i + ")");			
			printOut(tm_i);
			System.out.println("packChar after bitwise OR ("+ i + ")");
			printOut(packChar);
			System.out.println("tm_i Shift left 8 bits (" + i + ")");
			tm_i <<= 8*(bytePack.length-1);
			tm_i >>>= 8 * i;
			printOut(tm_i);			
			packChar |= tm_i;
			System.out.println("packChar Shift left 8 bits (" + i + ")");
			printOut(packChar);
			System.out.print("\n");
			tm_i = 0;
		} // end of for

		System.out.println("packing char to int : "+ packChar);
		System.out.println("packBytesToInt(bytePack) : " + packBytesToInt(bytePack));
		
		byteUnpack = unpackIntToBytes(packChar);
		for (int i = 0; i < byteUnpack.length; i++ )
			printOut(byteUnpack[i]);
		
	} // end of main
	
	public static int packBytesToInt(byte[] bytePack) {
		int packChar = 0;
		int tm_i = 0;
		for (int i=0; i<bytePack.length; i++){
			tm_i |= bytePack[i];
			tm_i <<= 8*(bytePack.length-1);
			tm_i >>>= 8 * i;
			packChar |= tm_i;
			tm_i = 0;
		}
		return packChar;
	}
	
	public static byte[] unpackIntToBytes(int byteUnpack) {
		byte[] bytePack = new byte[4];
		
		for (int i=0; i<bytePack.length; i++){
			bytePack[i] = (byte)(0xFF & (byteUnpack >> (intSize-(8*i+8))));
		}
		return bytePack;
	}
	
	public static void printOut(int value) {
		int mask = 1 << intSize - 1 ;
		for (int i = 1 ; i <= intSize; i++) {			
			if ((value & mask) == 0)			
				System.out.print("0");
			else
				System.out.print("1");
			value <<= 1 ;
			if ((i % 8)== 0 && (i!=intSize))
				System.out.print(" / ");			
		} //end of for
		System.out.print("\n");
	}//end of printOut(int)
	
	public static void printOut(byte value) {
		int mask = 1 << byteSize - 1 ;
		for (int i = 1 ; i <= byteSize; i++) {			
			if ((value & mask) == 0)			
				System.out.print("0");
			else
				System.out.print("1");
			value <<= 1 ;
			if ((i % 8)== 0 && (i!=byteSize))
				System.out.print(" / ");			
		} //end of for
		System.out.print("\n");
	}//end of printOut(byte) 
}
