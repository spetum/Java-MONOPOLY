
public class squareRoot {
	public static double sqrt_NewtonMethod1(double x) {
		double z =1.0 ;
		for (int i=0; i < 10; i++)
			z = z - (z * z - x) / (2 * z) ;
		return z;
	}
	public static double sqrt_NewtonMethod2(double x) {
		double z =1.0 ;
		for (int i=0; i < 20; i++)
			z = z - (z * z - x) / (2 * z) ;
		return z;
	}
	public static double sqrt_NewtonMethod3(double x) {
		double z =1.0 ;
		for (int i=0; i < 25; i++)
			z = z - (z * z - x) / (2 * z) ;
		return z;
	}
	
	public static void main(String[] str){
		//z = z - (z * z - x) / (2 * z)
		// cbrt : z = z - (z * z * z - x) / (3 * z * z) 
		System.out.println(" Square root of 49.0 is " + sqrt_NewtonMethod1(49.0) ) ;
		System.out.println(" Square root of 1048576.0 is " + sqrt_NewtonMethod1(1048576.0) ) ;
		
		System.out.println(" Square root of 49.0 is " + sqrt_NewtonMethod2(49.0) ) ;
		System.out.println(" Square root of 1048576.0 is " + sqrt_NewtonMethod2(1048576.0) ) ;
		
		System.out.println(" Square root of 49.0 is " + sqrt_NewtonMethod2(49.0) ) ;
		System.out.println(" Square root of 1073741824.0 is " + sqrt_NewtonMethod2(1073741824.0) ) ;

		System.out.println(" Square root of 49.0 is " + sqrt_NewtonMethod3(49.0) ) ;
		System.out.println(" Square root of 1099511627776.0 is " + sqrt_NewtonMethod3(1099511627776.0) ) ;

	}
}
