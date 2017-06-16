public class BankData {
	private int money=100_000;
	public static BankData bank=new BankData();
	
	private BankData(){}
	public int getMoney(){
		return money;
	}
	public void setMoney(int money){
		this.money= money;
	}
	
	//ют╠щ
	public void saveMoney(int save){
		int myMoney=bank.getMoney();
		this.money=myMoney+save;
	}
	
	// Withdrawal
	public void minusMoney(int minus){
		int myMoney=bank.getMoney();
		this.money=myMoney-minus;
	}
} // end of class