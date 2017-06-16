
public class safeKeeperB extends Thread {
	@Override
	public void run() {
		synchronized (BankData.bank) {
			BankData.bank.saveMoney(3000);
			System.out.println("3000원 입금: "+BankData.bank.getMoney());
			System.out.println("Release safeKeeperA ");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			safeKeeperA sKA = new safeKeeperA();
			sKA.wakeUp();
		}
	}
}
/*
	이녀석들을 실행해 줄 메인 클래스를 볼까요?
	원금을 표시 해 주고, safeKeeperA, 그 다음 safeKeeperB 의 클래스를 실행 합니다.

*/