
public class safeKeeperA extends Thread{
	@Override
	public void run() {
		//지역동기화
		synchronized (BankData.bank) {
			try {
				System.out.println("Wait safeKeeperA");
				BankData.bank.wait();//스레드를 잠재워라
			} catch (Exception e) {
				e.printStackTrace();
			}
			BankData.bank.minusMoney(5000);
		}
		System.out.println("safeKeeperA : Withdrawal 5000 Won : "+BankData.bank.getMoney());
	}
	
	public void wakeUp(){
		synchronized(BankData.bank){
			System.out.println("Release SafeKeeperA");
			BankData.bank.notify();
			//BankData.bank.notifyall(); 을 사용 하면 모든 스레드를 모두 깨운다.
		}
	}
}
