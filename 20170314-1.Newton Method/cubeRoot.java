
public class cubeRoot {
	public static double cbrt_NewtonMethod1(double x) {
		double z =1.0 ;
		for (int i=0; i < 10; i++)
			//z = z - (z * z - x) / (2 * z) ; // Square Root
			z = z - (z * z * z -x) /(3*z*z) ; // Cube Root
		return z;
	}
	
	public static double cbrt_NewtonMethod2(double x) {
		double z =1.0 ;
		for (int i=0; i < 15; i++)
			//z = z - (z * z - x) / (2 * z) ; // Square Root
			z = z - (z * z * z -x) /(3*z*z) ; // Cube Root
		return z;
	}

	public static double cbrt_NewtonMethod3(double x) {
		double z =1.0 ;
		for (int i=0; i < 20; i++)
			//z = z - (z * z - x) / (2 * z) ; // Square Root
			z = z - (z * z * z -x) /(3*z*z) ; // Cube Root
		return z;
	}

	public static double cbrt_NewtonMethod4(double x) {
		double z =1.0 ;
		for (int i=0; i < 25; i++)
			//z = z - (z * z - x) / (2 * z) ; // Square Root
			z = z - (z * z * z -x) /(3*z*z) ; // Cube Root
		return z;
	}
	
	public static double cbrt_NewtonMethod5(double x) {
		double z =1.0 ;
		for (int i=0; i < 30; i++)
			//z = z - (z * z - x) / (2 * z) ; // Square Root
			z = z - (z * z * z -x) /(3*z*z) ; // Cube Root
		return z;
	}

	public static void main(String[] args) {
		System.out.println("Cube Root of 8.0 is " + cbrt_NewtonMethod1(8.0) ) ; // 2 ^ 3		
		System.out.println("Cube Root of 343.0 is " + cbrt_NewtonMethod1(343.0) ) ; // 7 ^ 3		
		
		System.out.println("Cube Root of 343.0 is " + cbrt_NewtonMethod2(343.0) ) ; // 7 ^ 3 		
		System.out.println("Cube Root of 32768.0 is " + cbrt_NewtonMethod2(32768.0) ) ; // 32 ^3
		
		System.out.println("Cube Root of 32768.0 is " + cbrt_NewtonMethod3(32768.0) ) ; // 32 ^3

		System.out.println("Cube Root of 262144.0 is " + cbrt_NewtonMethod3(262144.0) ) ; // 64 ^3
		System.out.println("Cube Root of 262144.0 is " + cbrt_NewtonMethod4(262144.0) ) ; // 64 ^3
		System.out.println("Cube Root of 262144.0 is " + cbrt_NewtonMethod5(262144.0) ) ; // 64 ^3
	}
}
