package project1_2;

/*
 * Andrew Liao
 * customer class
 */
public class Customer {
	
	//field to keep track of stock instance
	private Stock stocks = null;
	//field to keep track of bond instance
	private Bond bonds = null;
	//field to keep track of MutualFund instance
	private MutualFund mutualFunds = null;
	//field to keep track of CashAccount instance
	private CashAsset cashAccounts = null;
	//field to keep track of commission rate
	private double commissionRate = 0.0;
	
	//constructor for Customer
	//one with two inputs
	public Customer(CashAsset cashAccount, double commission) {
		this.cashAccounts = cashAccount;
		this.commissionRate = commission;
	}
	
	//second constructor accepts 5 inputs
	public Customer(CashAsset cashAccount, Bond bonds, MutualFund mutualFunds, Stock stocks, double commission) {
		this.cashAccounts = cashAccount;
		this.bonds = bonds;
		this.mutualFunds = mutualFunds;
		this.stocks = stocks;
		this.commissionRate = commission;
	}
	
	//to return the bond instance associated with the class
	public Bond getBond() {
		return bonds;
	}

	//changes the bond instance associated with the class
	public void setBond(Bond bonds) {
		this.bonds = bonds;
	}

	//return the MutualFund instance associated with the class
	public MutualFund getMutualFund() {
		return mutualFunds;
	}
	
	//changes the MutualFund instance associated with the class
	public void setMutualFund(MutualFund mutualFunds) {
		this.mutualFunds = mutualFunds;
	}
	
	//return the Stock instance associated with the class
	public Stock getStock() {
		return stocks;
	}

	//changes the Stock instance associated with the class
	public void setStock(Stock stocks) {
		this.stocks = stocks;
	}

	//return the CashAsset instance associated with the class
	public CashAsset getCashAccount() {
		return cashAccounts;
	}

	//changes the CashAsset instance associated with the class
	public void setCashAccount(CashAsset cashAccounts) {
		this.cashAccounts = cashAccounts;
	}

	//returns the commission rate associated with the class
	public double getCommissionRate() {
		return commissionRate;
	}

	//changes the commission rate associated with the class
	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}
	
	//the currentValue method which returns the cash account balance plus the current price of 
	//the bond plus the number of shares times the currentPrice for both the stock and mutualFund
	public double currentValue() {
		return (this.getCashAccount().getBalance() + this.getBond().getCurrentPrice() + this.getStock().getNumberOfShares()) 
				* this.getStock().getCurrentPrice() * this.getMutualFund().getCurrentPrice();
	}
	
	//getCapitalGains method which returns the sum of capital gains from the bond, mutualFund, and stocks
	public double getCapitalGains() {
		return this.getBond().getCapitalGains() + this.getMutualFund().getCapitalGains() + this.getStock().getCapitalGains();
	}
	
	//the deposit method, which take a double input and adds it to the cash account balance
	public void deposit(double input) {
		this.getCashAccount().deposit(input);
	}
	
	//the withdraw method, which will take a double as an input and returns a boolean
	//it calls the withdraw method from cash account with boolean false in order to withdraw desired amount 
	public boolean withdraw(double input) {
		return this.getCashAccount().withdraw(input, false);
	}
	
	//the sellBond method which will call the sell method in bond and deposit the value returned into 
	//cash account balance
	public void sellBond() {
		this.cashAccounts.deposit(this.getBond().sell());
	}
	
	//the buyBond method which returns a boolean and checks if we are able to buy a bond
	public boolean buyBond() {
		if (this.getBond().getCurrentPrice() > this.currentValue()) {
			return false;
		} else {
			this.getCashAccount().withdraw(this.getBond().buy(), true);
			return true;
		}
	}
	
	//the payBond method which will call the bond's pay interest method and deposit value into cash account
	public void payBondInterest() {
		this.getCashAccount().deposit(this.getBond().payInterest());
	}
	
	//the withDrawMutualFund method which takes a single double input which is the input for the 
	//mutual fund sell method and we add it to the cash balance
	public void withdrawMutualFund(double input) {
		this.cashAccounts.deposit(this.getMutualFund().sell(input));
	}
	
	//the buyMutualFund method which takes a single double input and returns a boolean, if the input is > than the
	//current value of the customer it returns false, otherwise we call the mutualFund buy method with the input
	//value and the cash account balance is reduced by the amount returned by buy method and true is returned
	public boolean buyMutualFund(double input) {
		if (input > this.currentValue()) {
			return false;
		} else {
			this.getCashAccount().withdraw(this.getMutualFund().buy(input), true);
			return true;
		}
	}
	
	//the sellStockShares method takes a single input which represents the number of shares, we then call 
	//the sell method from Stock with the input and account commission value and add the return to cash balance
	public void sellStockShares(int input) {
		this.getCashAccount().deposit(this.getStock().sell(input, this.getCommissionRate()));
	}
	
	//the buyStockShares method which takes in an int, the number of shares, and it returns a boolean,
	//if the stock buy method with the int and account commission is greater than the current value of customer
	//we return false, otherwise we call stock buy and the cash balance is reduced by that amount and returned true
	public boolean buyStockShares(int input) {
		if(this.getStock().buy(input, this.commissionRate) > this.currentValue()) {
			return false;
		} else {
			this.getCashAccount().withdraw(this.getStock().buy(input, this.getCommissionRate()), true);
			return true;
		}
	}
}
