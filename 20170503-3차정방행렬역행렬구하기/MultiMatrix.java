
public class MultiMatrix {
	public static double[][] multi_mat(double[][] a, double[][] b) {
		int i,j,k ;
		double[][]  temp = new double[a.length][b[0].length] ;
		if ( a[0].length != b.length ) 
			throw new java.lang.IllegalArgumentException("two matrixes can not multiply.");
		
		for (i=0; i < a.length; i++ ){
			for (j=0; j < b[0].length; j++) {
				for (k=0; k<a[0].length; k++) {
					temp[i][j] += a[i][k] * b[k][j];
				} // end of for (k=0;
			} // end of for (j=0;
		}// end of for (i=0;
		return temp ;
	}
	public static void main(String[] args) {
		//2*3 matrix
		double[][] mat_a = {{1,2,3}, {4,5,6}};
		//3*2 matrix
		double[][] mat_b = {{1,4}, {2,5}, {3,6}};
		
		double [][] res ;
		res = multi_mat(mat_a, mat_b) ;
		AdjacentMatrix.Print3DMatrix(res) ;
	}

}
