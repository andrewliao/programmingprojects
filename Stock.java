/*
 * Andrew Liao
 * shares of a stock in a company
 */
public class Stock extends Equity {
	
	//constructor for Stock
	public Stock(String nameOfStock, char symbol, double currentPrice) {
		super(nameOfStock, symbol, currentPrice);
	}
	
	//buy method
	public double buy(int numOfShares, double commission) {
		this.setNumberOfShares(this.getNumberOfShares() + numOfShares);
		double z = numOfShares * this.getCurrentPrice() + commission;
		this.setCostBasis(this.getCostBasis()+ z);
		return z;
	}
	
	//sell method
	public double sell(int numOfShares, double commission) {
		if(numOfShares > this.getNumberOfShares()) {
			return 0;
		} else {
			this.setNumberOfShares(this.getNumberOfShares() - numOfShares);
			this.setCostBasis(this.getCostBasis() - 
					(numOfShares / (this.getNumberOfShares() + numOfShares)) * this.getCostBasis());
			this.setCapitalGains(this.getCapitalGains() + (numOfShares * this.getCurrentPrice() - commission));
			return numOfShares * this.getCurrentPrice() - commission;
		}
	}
	
	
	//split method
	public double split(int ratioNum, int ratioDen) {
		if(ratioNum == 0 || ratioDen == 0) {
			return 0;
		} else {
			this.setNumberOfShares(this.getNumberOfShares() * ((double)ratioNum / (double)ratioDen));
			if(this.getNumberOfShares() > ((int)this.getNumberOfShares())) {
				//this stores the fractional part of the shares
				double remainder = this.getNumberOfShares() - (int)this.getNumberOfShares();
				//repeat the sell method but with a commission of 0
				this.setNumberOfShares(this.getNumberOfShares() - remainder);
				this.setCostBasis(this.getCostBasis() - 
						(remainder / (this.getNumberOfShares() + remainder)) * this.getCostBasis());
				this.setCapitalGains(this.getCapitalGains() + (remainder * this.getCurrentPrice() - 0));
				return remainder * this.getCurrentPrice() - 0;	
			}
			return 0;
		}
	}
	
}
