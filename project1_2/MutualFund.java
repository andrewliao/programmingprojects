package project1_2;

/*
 * Andrew Liao
 * an equity that is the shares of mutual funds
 */
public class MutualFund extends Equity {
	
	//represent the load of the fund
	private double load = 0.0;
	
	//constructor of the MutualFund
	public MutualFund(String nameOfMutualFund, char symbol, double currentPrice) {
		super(nameOfMutualFund, symbol, currentPrice);
	}
	
	//get the load
	public double getLoad() {
		return this.load;
	}
	
	//set the load
	public void setLoad(double load) {
		this.load = load;
	}
	
	//buy method which takes a double representing the amount you are investing. If it is negative, we return 0,
	//otherwise we increase the number of shares, change the costBasis, and return the amountInvested
	public double buy(double amountInvesting) {
		if(amountInvesting < 0) {
			return 0;
		} else {
			this.setNumberOfShares(this.getNumberOfShares() + 
					(amountInvesting * (100 - this.getLoad()) / this.getCurrentPrice()));
			this.setCostBasis(this.getCostBasis() + amountInvesting);
			return amountInvesting;
		}
	}
	
	//sell method, which will check to see if amountWithdrawn is positive and greater than currentPrice.
	//If it is, we sell part of the shares, lower the costBasis, increase the capitals gains, and return 
	//the amount withdrawn
	public double sell(double amountWithdrawn) {
		if (amountWithdrawn < 0 || amountWithdrawn > this.getCurrentPrice()) {
			return 0;
		} else {
			this.setNumberOfShares(this.getNumberOfShares() - amountWithdrawn / this.getCurrentPrice());
			this.setCostBasis(this.getCostBasis() - 
					(((amountWithdrawn / this.getCurrentPrice()) / 
							(this.getNumberOfShares() + (amountWithdrawn/this.getCurrentPrice())))
							* this.getCostBasis()));
			this.setCapitalGains(this.getCapitalGains() + (amountWithdrawn - 
					(((amountWithdrawn / this.getCurrentPrice()) / 
							(this.getNumberOfShares() + (amountWithdrawn/this.getCurrentPrice())))
							* this.getCostBasis())));
			return amountWithdrawn;
		}
	}
	
	
	
	
}
