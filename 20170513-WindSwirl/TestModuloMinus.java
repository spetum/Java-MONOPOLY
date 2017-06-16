
public class TestModuloMinus {

	public static void main(String[] args) {
//		System.out.println(-17%13); // -4
//		System.out.println(-(17*17)	%13); // -3		
//		System.out.println((17%13)*(17%13)); // 16
//		System.out.println(((17%13)*(17%13))%13); // 3
//		System.out.println(-((17%13)*(17%13))%13); // -3
		int dcdd = 271;
		dcdd = 289;
		int i; 
		if (dcdd%2 == 0)return ;
		for ( i=3; i<=(int)Math.sqrt(dcdd);i++) {
			if (dcdd % i == 0) {
				System.out.println(dcdd+" is divided by " + i +".");
				return ;
			}			
		}
		System.out.println(dcdd+" can not find a divisor " + 
				"from " + 3 + " to " +(int)Math.sqrt(dcdd) +".");
		for ( i=(int)Math.sqrt(dcdd)+1;i<dcdd;i++) {
			if (dcdd % i == 0) {
				System.out.println(dcdd+" is divided by " + i +".");
				return ;
			}
		}
		System.out.println(dcdd+" can not find a divisor " + 
				"from " + ((int)Math.sqrt(dcdd)+1) +" to " +dcdd +".") ;
	}
}
