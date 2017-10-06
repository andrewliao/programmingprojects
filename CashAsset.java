/*
 * Andrew Liao
 * a class that represents money reserves
 */
public class CashAsset {
	
	//keep track of current balance
	private double currentBalance = 0.0;
	//interest rate paid for savings
	private double interestRateSavings = 0.0;
	//interest rate changed for loans
	private double interestRateLoans = 0.0;
	//loan limit
	private double loanLimit = 0.0;
	//overdraft penalty
	private double overDraft = 0.0;
	//interest accrued over the month
	private double interestAccrued = 0.0;
	//whether or not the account has been overdraft
	private boolean accountOverdraft = false;
	
	//constructor for CashAsset
	public CashAsset(double interestRateSavings, double interestRateLoans, double loanLimit, double 
			overDraftPenalty) {
		this.interestRateSavings = interestRateSavings;
		this.interestRateLoans = interestRateLoans;
		this.loanLimit = loanLimit;
		this.overDraft = overDraftPenalty;
	}
	
	//return the current balance of the account
	public double getBalance() {
		return this.currentBalance;
	}

	//return the interest rate for positive savings
	public double getSavingsRate() {
		return interestRateSavings;
	}

	//setting the interest rate
	public void setSavingsRate(double interestRateSavings) {
		this.interestRateSavings = interestRateSavings;
	}

	//return the interest rate loans for negative loan balances
	public double getLoanRate() {
		return interestRateLoans;
	}

	//setting the loan rate for negative loan balances
	public void setLoanRate(double interestRateLoans) {
		this.interestRateLoans = interestRateLoans;
	}

	//returns the loan limit of the account
	public double getLoanLimit() {
		return loanLimit;
	}

	//setting the loan limit for the account
	public void setLoanLimit(double loanLimit) {
		this.loanLimit = loanLimit;
	}

	//returns the overdraft penalty for the account
	public double getOverDraftPenalty() {
		return this.overDraft;
	}
	
	//set the overdraft penalty for the account
	public void setOverDraftPenalty(double overDraft) {
		this.overDraft = overDraft;
	}
	
	//the deposit method which increases the balance by the amount inputed
	public void deposit(double input) {
		this.currentBalance = this.getBalance() + input;
	}
	
	//the withdraw method which checks if input is smaller than balance, then changes the currentBalance
	//and returns true, a boolean input of true means that we always enter the else statement and take out of 
	//the currentBalance
	public boolean withdraw(double input, boolean input2) {
		if (input > this.getBalance() && input2 == false) {
			return false;
		} else {
			this.currentBalance = this.getBalance() - input;
			return true;
		}
	}
	
	//processDay method which will change the interestAccrued
	public void processDay() {
		if(this.getBalance() >= 0) {
			this.interestAccrued = this.currentBalance * this.getSavingsRate() / 365 + this.interestAccrued;
		} else {
			this.interestAccrued = this.currentBalance * this.getLoanRate() / 365  + this.interestAccrued;
		}
	}
	
	//processMonth method which should also change the interestAccrued and the currentBalance
	public void processMonth() {
		this.currentBalance = this.currentBalance + this.getInterestAccrued();
		this.setInterestAccrued(0);
		if(this.currentBalance < 0 && this.currentBalance > -this.getLoanLimit()) {
			this.currentBalance = this.currentBalance - this.getOverDraftPenalty();
		}
	}

	//optional method added after to test the method
	public double getInterestAccrued() {
		return interestAccrued;
	}

	//optional method
	public void setInterestAccrued(double interestAccrued) {
		this.interestAccrued = interestAccrued;
	}
	
}
