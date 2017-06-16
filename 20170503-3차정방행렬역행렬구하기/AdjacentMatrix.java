
public class AdjacentMatrix {
	public static double [][]C = {{-1,1,2},{3,-1,1},{-1,3,4} } ;
	public static double [][]C_inv = {{0,0,0}, {0,0,0}, {0,0,0} } ;
	
	private AdjacentMatrix() {
		// no new construction of instance
	}
	public static void Print3DMatrix(double[][] Cube) {
		int i,j;
		for (i=0; i < Cube.length; i++) {
			for (j=0; j<Cube[i].length;j++) {
				System.out.printf ("%6.2f\t",Cube[i][j]);
			} //end of for (j
			System.out.println();
		} // end of for(i
	}
	public static double determinant (double[][] matrix) {
		double det =0.0 ;
		int i,j ;
		
		for (i=0; i < 1; i++) {
			for(j=0; j<matrix[i].length; j++) {
				int s1,s2,w1,w2 ;
				s1 = (i+1)%3;
				w1 = (j+1)%3;
				s2 = (i+2)%3;
				w2=  (j+2)%3;
				det +=matrix[i][j] * ( matrix[s1][w1]*matrix[s2][w2] - matrix[s2][w1]*matrix[s1][w2]);
			} // end of for (j
		} // end of for (i
		return det;
	}
	// 여인수 전개(cofactor_expansion) 혹은 라플라스 전개(LaPlace Exapansion)
	// 행렬의 디터미넌트를 나누지 않은 역행렬을 의미한다.
	public static void cofactor_expansion(double[][] src, double[][] dest ) {
		int i, j;
		for (i=0; i<src.length; i++) {
			for (j=0; j<src[i].length; j++) {
				int s1,s2,w1,w2 ;
				s1 = (i+1)%3;
				w1 = (j+1)%3;
				s2 = (i+2)%3;
				w2=  (j+2)%3;
				dest[j][i] = src[s1][w1]*src[s2][w2] - src[s2][w1]*src[s1][w2] ;
			} //end of for (j
		} // end of for(i
	}
	public static void KTimesMatrix (double[][] src, double k) {
		int i,j ;
		for (i=0; i< src.length; i++) 
			for (j=0; j<src[i].length;j++) 
				src[i][j] *= k ;
	}
	public static void InverseMatrix(double[][] src, double[][] dest ) {
		cofactor_expansion(src,dest) ;
		KTimesMatrix(dest,1.0/ determinant (C));
	}
	
	public static double[][] MultiTwoMatix ( double[][] C1, double[][] C2) {
		// 당분간 정방행렬에 대해서만 계산한다.
		double [][] C1XC2 = {{0,0,0}, {0,0,0},{0,0,0}} ;
		int i,j,k;
		for (i=0; i<C1.length;i++) {
			for (j=0;j<C2[0].length; j++) {
				for(k=0;k<C1[0].length;k++) {
					C1XC2[i][j] += C1[i][k]*C2[k][j] ;
				} // end of for (k
			} // end of for (j
		} // end of for (i
		return  C1XC2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, j;
		
		// print a formation of 3 square matrix
//		for (i=0; i<3; i++) {
//			for (j=0; j<3; j++) {
//				int s1,s2,w1,w2 ;
//				s1 = (i+1)%3;
//				w1 = (j+1)%3;
//				s2 = (i+2)%3;
//				w2=  (j+2)%3;
//				System.out.print(
//						"C["+(s1)+"]["+(w1)+"]*C["+(s2)+"]["+(w2)+"]"
//						);
//				System.out.print(
//						" - C["+(s2)+"]["+(w1)+"]*C["+(s1)+"]["+(w2)+"]\t\t"
//						);
//			} //end of for (j
//			System.out.println();
//		} // end of for(i
		
		// calculate the adjacent matrix of the given matrix
//		for (i=0; i<3; i++) {
//			for (j=0; j<3; j++) {
//				int s1,s2,w1,w2 ;
//				s1 = (i+1)%3;
//				w1 = (j+1)%3;
//				s2 = (i+2)%3;
//				w2=  (j+2)%3;
//				C_inv[j][i] = C[s1][w1]*C[s2][w2] - C[s2][w1]*C[s1][w2] ;
//			} //end of for (j
//		} // end of for(i
		System.out.println("Original Matrix, C:") ;
		Print3DMatrix(C);
		double deter = determinant(C);
		System.out.println("determinant of C is "+deter );

//		for (i=0; i < C_inv.length; i++) {
//			for (j=0; j<C_inv[i].length;j++) {
//				System.out.print (C_inv[i][j] + "\t");
//			} //end of for (j
//			System.out.println();
//		} // end of for(i
		InverseMatrix(C, C_inv);
		System.out.println("Inverse matrix of matrix C, C_inv :");
		Print3DMatrix(C_inv);
		System.out.println("determinant of C_inv is "+determinant(C_inv) );
//		double [][] res = new double[3][3] ;
//		res = MultiTwoMatix (C, C_inv);
//		Print3DMatrix(res) ;
		//위의 내용을 한줄로 만들면 다음과 같다.
		System.out.println("Original Matrix multiplies with inverse Matrix, C x C_inv:");
		Print3DMatrix(MultiTwoMatix (C, C_inv));		
	}
}
