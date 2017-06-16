// TwoDimSorting.java가 완성작 
public class TwoDimensionalSort {
	public static void PrintByRow( int [][] multiDimension) {
		int i,j ;
		for (i=0; i<multiDimension.length; i++) {
			System.out.print( "{" );
			for (j=0; j < multiDimension[i].length-1; j++) {
				System.out.print(multiDimension[i][j] + "," );
			} // end of j
			System.out.print(multiDimension[i][j] + "}\n" );
		} // end of i
	} // end of PrintByRow
	

	public static void SortByRows(int [][] multiDimension) {
		for (int i=0; i < multiDimension.length; i++) {
			int temp ;
			for (int j=0; j < multiDimension[i].length; j++ ){
				for (int k = 0; k < multiDimension[i].length-1; k++) {
					if (multiDimension[i][k] < multiDimension[i][k+1]) {
						swapTwoDim(multiDimension, i,k,i,k+1);
//						temp = multiDimension[i][k];
//						multiDimension[i][k] = multiDimension[i][k+1];
//						multiDimension[i][k+1] = temp;
					}// end of if
				} // end of k
			} // end of j
		} // end of i
	} // end of SortByRow
	
	public static void SortByRow(int [] RowOfArray) {
		for (int i=0; i < RowOfArray.length; i++) {
			for (int j=0; j<RowOfArray.length-1; j++) {
				if ( RowOfArray[j] < RowOfArray[j+1] ) {
					int temp ;
					temp = RowOfArray[j] ;
					RowOfArray[j] = RowOfArray[j+1] ;
					RowOfArray[j+1] = temp ;
				}  // end of if
			}  // end of j
		}  // end of i
	} // end of SortByRow
	
	public static void swapTwoDim(int[][] multiDimension, int i,int j, int m, int n) {
		int temp = multiDimension[i][j] ;
		multiDimension[i][j] = multiDimension[m][n];
		multiDimension[m][n] = temp ;
	}
	
	public static void main(String[] args) {
		// int [][] TwoDimension = new int [4][5] ;
		int [][] TwoDim = {
				{ 11, 14, 16, 19, 25 },
				{ 30, 17, 12, 13, 39},
				{ 10, 35, 21, 42, 47},
				{ 32, 45, 66, 52, 28}
				}; 
		
		System.out.println("Before sorting");
		PrintByRow(TwoDim) ;
		
		// sort by row
		SortByRows(TwoDim) ;

		System.out.println("After sorting by a row");
		PrintByRow(TwoDim) ;
		
		// sort by Column(0)
		for (int i=0; i < TwoDim.length; i++) {
			for (int j=0; j < TwoDim.length-1; j++) {
				if ( TwoDim[j][0] < TwoDim[j+1][0]) {
					swapTwoDim(TwoDim, j,0,j+1,0);
				} // end of if 
			} // end of j
		}  // end of i
		System.out.println("After sorting by a Column (0)");
		PrintByRow(TwoDim) ;

		for (int i=1; i <TwoDim.length; i++) {
//			System.out.printf("After sorting by a row(%d)\n", i);
			SortByRow(TwoDim[i]) ;
//			PrintByRow(TwoDim) ;
		}
		System.out.println("After sorting by a rows");
		PrintByRow(TwoDim) ;
		
		for (int i=0; i < TwoDim.length; i++) {
			for (int j=1; j < TwoDim.length; j++) {
				if ( TwoDim[0][1] < TwoDim[j][0]) {
					swapTwoDim(TwoDim, 0,1 , j, 0) ;
					// Test and scan
					System.out.printf("after swapping TwoDim[%d][%d] and TwoDim[%d][%d]\n", 0,1,j,0);
					PrintByRow(TwoDim) ;
				} // end of if 
			} // end of j
		}  // end of i
		for (int i=1; i <TwoDim.length; i++) {
			SortByRow(TwoDim[i]) ;
		}
		System.out.println("After sorting by a rows");
		PrintByRow(TwoDim) ;
	
	} // end of main
}
