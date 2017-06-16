// by nowinlove@gmail.com 2017.05.06(Sat)

//package matrix;
//public class Matrix {

public class matrix_operation {
	public static void main(String[] args) {
		System.out.println("Hello world!");

		//2*3 matrix
		double[][] mat_a = {{1,2,3}, {4,5,6}};
		//3*2 matrix
		double[][] mat_b = {{1,4}, {2,5}, {3,6}};
		double[][] mat_r = new double[2][2];
		double res = 0;
		
		for (int k= 0; k < mat_a.length; k++) {
			System.out.println("\na=>>["+ k +"]=>>>");
			for (int i = 0; i < mat_a.length; i++) {
				for (int j = 0; j < mat_b.length; j++) {
					System.out.print("a=["+ k +"]["+ j +"] * b=["+ j +"]["+ i +"]=" + mat_a[k][j] + "*" + mat_b[j][i]+"\t");
					//System.out.println("res = " +multi_matrix(mat_a[k][j], mat_b[j][i]));
					System.out.println("res = " +multi_matrix(mat_a[k][j], mat_b[j][i]));
					res +=  multi_matrix(mat_a[k][j], mat_b[j][i]);
				}
				//    System.out.println("mat_result["+ k +"][" + i +"]=" +res);
				mat_r[k][i] = res;
				res = 0;
			}
		}
		for (int j=0; j < mat_r.length; j++) {
			for (int i=0; i < mat_r[j].length; i++) {
				System.out.println("mat_result["+ i +"]["+ j +"]=" + mat_r[i][j]);
			}
		}
	}

	static double multi_matrix(double a, double b) {
		return a*b;
	}
}
