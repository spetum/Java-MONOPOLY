/*
	이녀석들을 실행해 줄 메인 클래스를 볼까요?
	원금을 표시 해 주고, safeKeeperA, 그 다음 safeKeeperB 의 클래스를 실행 합니다.

*/
public class safeMain {
	public static void main(String[] args) {
		System.out.println("원금: "+BankData.bank.getMoney());
		
		safeKeeperB sKB = new safeKeeperB();
		safeKeeperA sKA = new safeKeeperA();
		sKA.start();
		sKB.start();
	}
}