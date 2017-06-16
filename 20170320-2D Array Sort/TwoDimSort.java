// TwoDimSorting.java가 완성작
public class TwoDimSort {
	
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
		
		// Extra case 
		// sort by Column(0)
/*		for (int i=0; i < TwoDim.length; i++) {
			for (int j=0; j < TwoDim.length-1; j++) {
				if ( TwoDim[j][0] < TwoDim[j+1][0]) {
					swapTwoDim(TwoDim, j,0,j+1,0);
					SortByRow(TwoDim[j+1]);
				} // end of if 
			} // end of j
		}  // end of i
		System.out.println("After sorting by (0,0)");
		PrintByRow(TwoDim) ;
*/	
//		for (int i=1; i <TwoDim.length; i++) {
//			System.out.printf("After sorting by a row(%d)\n", i);
//			SortByRow(TwoDim[i]) ;
//			PrintByRow(TwoDim) ;
//		}

		// (0,1) - (1,0) , (0,1) - (2,0) , (0,1) - (3,0)
		// (0,2) - (1,0) , (0,2) - (2,0) , (0,2) - (3,0)
		// (0,3) - (1,0) , (0,3) - (2,0) , (0,3) - (3,0)
		// (0,4) - (1,0) , (0,4) - (2,0) , (0,4) - (3,0)
		
		int k ;
		
		k = 0;
		for (int m =0; m < TwoDim[ k ].length; m++) {
			for (int p=k+1; p < TwoDim.length; p++){
				System.out.println("Comparing (" + k + ", " + m +") to (" + p + ", " + 0 +")");
				if (TwoDim[k][m] < TwoDim[p][0]) {
					swapTwoDim(TwoDim, k, m, p, 0);
//					System.out.println("After swapping"+" ("+k+", "+m+") and (" + p + ", " + 0 + ")");
//					PrintByRow(TwoDim) ;
					
					SortByRow(TwoDim[p]);
//					System.out.println("After sorting by a row (" + p+")");
//					PrintByRow(TwoDim) ;
				} // end of if 
			}// end of P
		} // end of L
		System.out.println("After sorting by a (0,1)~(0,m-1)");
		PrintByRow(TwoDim) ;
		System.out.print("\n");
		
		// (1,2) - (2,0), (1,2) - (3,0)
		// (1,3) - (2,0), (1,3) - (3,0)
		// (1,4) - (2,0), (1,4) - (3,0)
		k=1;
		for (int m =0; m < TwoDim[ k ].length; m++) {
			for (int p=k+1; p < TwoDim.length; p++){
				System.out.println("Comparing (" + k + ", " + m +") to (" + p + ", " + 0 +")");
				if (TwoDim[k][m] < TwoDim[p][0]) {
					swapTwoDim(TwoDim, k,m,p,0);
//					System.out.println("After swapping"+" ("+k+", "+m+") and (" + p + ", " + 0 + ")");
//					PrintByRow(TwoDim) ;
					
					SortByRow(TwoDim[p]);
//					System.out.println("After sorting by a row (" + p+")");
//					PrintByRow(TwoDim) ;
				} // end of if 
			}// end of P
		} // end of L
		System.out.println("After sorting by a (1,1)~(1,m-1)");
		PrintByRow(TwoDim) ;
		System.out.print("\n");
		
		k=2;
		for (int m =0; m < TwoDim[ k ].length; m++) {
			for (int p=k+1; p < TwoDim.length; p++){
				if (TwoDim[k][m] < TwoDim[p][0]) {
					System.out.println("Comparing (" + k + ", " + m +") to (" + p + ", " + 0 +")");
					swapTwoDim(TwoDim, k,m,p,0);
					System.out.println("After swapping"+" ("+k+", "+m+") and (" + p + ", " + 0 + ")");
					PrintByRow(TwoDim) ;
					
					SortByRow(TwoDim[p]);
					System.out.println("After sorting by a row (" + p+")");
					PrintByRow(TwoDim) ;
				} // end of if 
			}// end of P
		} // end of L
		System.out.println("After sorting by a (1,1)~(1,m-1)");
		PrintByRow(TwoDim) ;
		System.out.print("\n");
		
	} // end of main
}
