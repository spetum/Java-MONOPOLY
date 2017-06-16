public class Exam01_Euclidean_Algorithm {
	// 4. 메소드로 만들어 봄
	public static int EuclideanTest (int x, int y) {
		int r, s ;
		r = x%y;
		s = y;
		while (s != 0 && r%s!=0 ){
			r = r % s;
			s = s % r;
			//System.out.println("r := " + r + " , s := " + s);
		}
		// return s ;
		// 5. s가 0이 되면 바로 직전에 나뉘어진 수 r이  최대 공약수가 된다.
		return (s ==0) ? r : s ;
	}
	public static void main(String[] args) {
		int x = 1071 ;
		int y = 1029 ;
		// 1. 처음에는 이렇게 해봄.
//		System.out.println(x%y);
//		System.out.println(y%(x%y));
//		System.out.println((x%y) % (y%(x%y)));
		
		// 2. 반복문의 구조로 만들어봄 
		int r, s ;		
//		r = x%y;
//		s = y;
//		while (r%s!=0){
//			r = r % s;
//			s = s % r;
//		}
//		System.out.println("r := " + r + " , s := " + s);
		
		// 3. 나눈 나머지가 0이 된 상황을 회피하는 코드로 변형
		x = 78696;
		y = 19332 ;
		
		r = x%y;
		s = y;
		while (s != 0 && r%s!=0 ){
			r = r % s;
			s = s % r;
			System.out.println("r := " + r + " , s := " + s);
		}
//		System.out.println("r := " + r + " , s := " + s);
		
		int result ;
		result = EuclideanTest(1071, 1029);
		System.out.println(result);
		
		result = EuclideanTest(78696, 19332);
		System.out.println(result);
	}
}
