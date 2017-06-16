public class transposeMatrix {
	public static double [][]C = {{-1,1,2},{3,-1,1},{-1,3,4} } ;
	
	public static double[][] TransposeMatrix (double[][] c) {
		double[][] temp ;
		temp = new double[c[0].length][c.length];
		for (int i=0; i<c[0].length;i++) {
			for (int j=0; j<c.length; j++) {
				temp[i][j]=c[j][i];
			}
		}
		return temp ;
	}
	public static void main(String[] args) {
		double [][]C = {{-1,1,2},{3,-1,1},{-1,3,4} } ;
		double [][]C_inv = {{0,0,0}, {0,0,0}, {0,0,0} } ;
		double [][]C_Transpose ;
		
		AdjacentMatrix.Print3DMatrix(C);
		System.out.println();		
		AdjacentMatrix.InverseMatrix(C, C_inv);
		AdjacentMatrix.Print3DMatrix(C_inv);
		C_Transpose =TransposeMatrix(C_inv);
		AdjacentMatrix.Print3DMatrix(C_Transpose);
		AdjacentMatrix.Print3DMatrix(AdjacentMatrix.MultiTwoMatix(C, C_Transpose));
	}

}
