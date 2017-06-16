public class bytesCompact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char a = 'a', b='b', c='c', d='d' ;
		byte[] bytePack = new byte[4];
		int packChar = 0;
		int tm_i = 0;
	
		bytePack[0] = (byte)192 ;
		bytePack[1] = (byte)168;
		bytePack[2] = (byte)0;
		bytePack[3] = (byte)138;
		
		for (int i=0; i<bytePack.length; i++) {
			tm_i |= bytePack[i];

			System.out.println("tm_i after bitwise OR ("+ i + ")");
			bitsPrint.printOut(tm_i);

			System.out.println("packChar after bitwise OR ("+ i + ")");
			bitsPrint.printOut(packChar);

			System.out.println("tm_i Shift left 8 bits (" + i + ")");
			tm_i <<= 8*(bytePack.length-1);
			tm_i >>>= 8 * i;
			bitsPrint.printOut(tm_i);

			packChar |= tm_i;
			System.out.println("packChar Shift left 8 bits (" + i + ")");
			bitsPrint.printOut(packChar);
			//System.out.print("\n");

			tm_i = 0;
		} // end of for
		System.out.println("packing bytes to int : "+packChar);
		System.out.println("bitsPrint of packChar :\n" + bitsPrint.bitPrint(packChar));
	} // end of main

	public static int packBytesToInt(byte[ ] bytePack) {
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
		final int intSize = Integer.SIZE ;
		byte[] bytePack = new byte[4];
		
		for (int i=0; i<bytePack.length; i++){
			bytePack[i] = 
		 	 (byte) (0xFF & (byteUnpack >> (intSize-(8*i+8))));
		}
		return bytePack;
	}
	
}