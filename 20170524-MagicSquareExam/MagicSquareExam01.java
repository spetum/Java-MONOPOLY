public class MagicSquareExam01 {
	private final int SIZE=5 ;
	private int [][] square_table = new int[5][5];
	public MagicSquareExam01() {
		for (int i=0; i< square_table.length; i++)
			for (int j=0; j < square_table[0].length;j++)
				square_table[i][j] = -1 ;
	}
	public void print_table() {
		for (int i=0; i< square_table.length; i++) {
			for (int j=0; j < square_table[0].length;j++) {
				System.out.print("\t" + square_table[i][j]) ;
			}
			System.out.println() ;
		}
	}
	public void MagicSquare() {		
		int i;
		int col = 0; // 초기 위치
		int row = 2; // 초기 위치
		int [][]a = square_table ;
		a[col][row] = 1 ;
		for (i=1; i<SIZE*SIZE; i++) {
			col --;	row ++;
			try {
				if ( row < 0) row += SIZE;
				if ( col < 0) col += SIZE ;
				if ( row >= SIZE ) row %= SIZE ;
				if ( col >= SIZE ) col %= SIZE ;
				if (a[col][row] != -1) {
					System.out.println("Next Position:("+col+","+ row +")=" + a[col][row] );
					col += 2; row -=1;				
					System.out.println("Recalc Position:("+col+","+ row +")");
					// 원래는 catch절에 있던 내용을 여기로 다시 옮겨본다.
					if ( row < 0) row += SIZE;
					if ( col < 0) col += SIZE ;
					if ( row >= SIZE ) row %= SIZE ;
					if ( col >= SIZE ) col %= SIZE ;
					System.out.println("Preventing Exception Handling :Recalc Position:("
							+col+","+ row +")");
					// 여기까지가 그 내용
				}				
				
				a[col][row] =i+1;
			} catch (java.lang.ArrayIndexOutOfBoundsException e) {
				System.err.println("\n"+col + ", " + row);
				if ( row < 0) row += SIZE;
				if ( col < 0) col += SIZE ;
				if ( row >= SIZE ) row %= SIZE ;
				if ( col >= SIZE ) col %= SIZE ;
				System.out.println("Exception Handling :Recalc Position:("+col+","+ row +")");
				a[col][row] = i+1;
			}
		} //end of for (i=		
	}
	public static void main(String[] args) {
		MagicSquareExam01 square5 = new MagicSquareExam01() ;
		square5.MagicSquare();
		square5.print_table();
	}
}
