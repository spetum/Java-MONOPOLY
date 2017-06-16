
public class MagicSquareExam02 {
	private int SIZE=7 ;
	private int [][] square_table = new int[SIZE][SIZE];
	private int [][] check_table = new int[SIZE+1][SIZE+2] ;
	public MagicSquareExam02() {		
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
	public void check_table() {
		for (int i=0; i<square_table.length; i++) {
			System.arraycopy(square_table[i], 0, check_table[i],1, square_table[i].length);			
		}
		
		// Sum of Row
		for (int i=0; i<square_table.length; i++){
			for (int j=0; j<square_table[i].length;j++){
				check_table[i][check_table[i].length-1] += square_table[i][j];
			}
		}
		// Sum of Column
		for (int i=0; i<square_table[0].length; i++){
			for (int j=0; j<square_table.length;j++){
				check_table[check_table.length-1][j+1] += square_table[i][j];
			}
		}
		// sum of diagonal, left-top to right-bottom
		for (int i=0; i < square_table.length; i++ )
			check_table[check_table.length-1][check_table[0].length-1] += square_table[i][i] ;

		// sum of diagonal, right-top to left-bottom
		for (int i= square_table.length-1; i >= 0; i-- )
			check_table[check_table.length-1][0] += square_table[i][i] ;
		
		for (int i=0; i <check_table.length; i++) {
			for (int j=0;j<check_table[i].length;j++ ) {
				System.out.print("\t"+check_table[i][j]);
			}
			System.out.println();
		}
	}
	public void MagicSquare() {		
		int i;
		int col = 0; // 초기 위치
		int row = SIZE/2; // 초기 위치
		int [][]a = square_table ;
		a[col][row] = 1 ;
		for (i=1; i<SIZE*SIZE; i++) {
			col --;	row ++;
			try {
/*				
				if ( row < 0) row += SIZE;
				if ( col < 0) col += SIZE ;
				if ( row >= SIZE ) row %= SIZE ;
				if ( col >= SIZE ) col %= SIZE ;
*/
				row = (row+SIZE)%SIZE ;
				col = (col+SIZE)%SIZE ;
				if (a[col][row] != -1) {
//					System.out.println("dup : Next Position:("+col+","+ row +")=" + a[col][row] );
					col += 2; row -=1;				
//					System.out.println("Recalc Position:("+col+","+ row +")");
/*
					// 원래는 catch절에 있던 내용을 여기로 다시 옮겨본다.
					if ( row < 0) row += SIZE;
					if ( col < 0) col += SIZE ;
					if ( row >= SIZE ) row %= SIZE ;
					if ( col >= SIZE ) col %= SIZE ;
					System.out.println("Preventing Exception Handling :Recalc Position:("
							+col+","+ row +")");
					// 여기까지가 그 내용
*/					
					row = (row+SIZE)%SIZE ;
					col = (col+SIZE)%SIZE ;
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
		MagicSquareExam02 square7 = new MagicSquareExam02() ;
		square7.MagicSquare();
		//square7.print_table();
		square7.check_table();
	}
}


/*
	0	30	39	48	1	10	19	28	175
	0	38	47	7	9	18	27	29	175
	0	46	6	8	17	26	35	37	175
	0	5	14	16	25	34	36	45	175
	0	13	15	24	33	42	44	4	175
	0	21	23	32	41	43	3	12	175
	0	22	31	40	49	2	11	20	175
	175	175	175	175	175	175	175	175	175
*/