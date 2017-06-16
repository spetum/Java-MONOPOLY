
public class SingleDimensionSort {

	public static void main(String[] args) {
		int [] OneDim = {
				11, 14, 16, 19, 25, 
				30, 17, 12, 13, 39 ,
				10, 35, 21, 30, 47,
				 32, 45, 66, 52, 28	} ;
		
		int i, j ;
		
		System.out.println("Print an Array: ");
		for (i=0; i< OneDim.length; i++) {
			System.out.print(OneDim[i] + " ");
		}

		System.out.print("\nPrint an Array(Re-mastered):\n{ ");
		for (i=0; i< OneDim.length-1; i++) {
			System.out.print(OneDim[i] + ", ");
		}
		System.out.println(OneDim[OneDim.length-1] + " }");

		for (i=0; i < OneDim.length; i++) {
			for (j=0; j<OneDim.length-1; j++) {
				if ( OneDim[j] < OneDim[j+1] ) {
					int temp ;
					temp = OneDim[j] ;
					OneDim[j] = OneDim[j+1] ;
					OneDim[j+1] = temp ;
				}  // end of if
			}  // end of j
		}  // end of i
		
		System.out.print("Print an Array(Sorted and Re-mastered):\n{ ");		
		for (i=0; i< OneDim.length-1; i++) {
			System.out.print(OneDim[i] + ", ");
		}
		System.out.println(OneDim[OneDim.length-1] + " }");
	} // end of main
} // end of class
