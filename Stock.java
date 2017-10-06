/*
 * Andrew Liao
 * shares of a stock in a company
 */
public class Stock extends Equity {
	
	//constructor for Stock
	public Stock(String nameOfStock, char symbol, double currentPrice) {
		super(nameOfStock, symbol, currentPrice);
	}
	
	//buy method takes two integers the number of shares and the commission rate. W e will increase the number
	//of shares by the input. the Commission rate is then added on with the number of shares into the costBasis
	//we will then return the number added onto the costBasis
	public double buy(int numOfShares, double commission) {
		this.setNumberOfShares(this.getNumberOfShares() + numOfShares);
		double z = numOfShares * this.getCurrentPrice() + commission;
		this.setCostBasis(this.getCostBasis()+ z);
		return z;
	}
	
	//sell method which takes in the number of shares and the commission rate, if the number of shares is greater than the
	//one current we return 0, because we can't sell more than we have. Otherwise we reduce the number of shares, costbasis,
	//and add to the capitals and we return the price of what we sold for the shares minus the commission fee
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
	
	
	//split method takes two input the numerator and the denominator for the ratio and if either is 0 we return 0
	//otherwise we will we will increase/decrease the number of shares by the amount of the fraction. If there is a fractional
	//part to it we will have to sell it off and we decrease the costBasis and increase the capital gains
	//we will return the remainder multiplied by the currentPrice of the stock if there is a fractional part, otherwise we return 0
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
			//this is returned if there are no fractional part
			return 0;
		}
	}
	
}
