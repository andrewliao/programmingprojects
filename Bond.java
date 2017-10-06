/*
 Andrew Liao
 a class to describe a bond which is a subclass of Asset
 Bond class
 
 */
public class Bond extends Asset {
	
	// the principal of the bond and does not change ever, use default so it does not change
	private final int principal;
	//the interest rate of the bond
	private double interestRate = 0.0;
	//the number of bonds owned
	public int numberOfBonds = 0;
	
	/* bond constructor */
	 public Bond(String nameOfBond, int principal, double interestRate) {
		 super(nameOfBond, 0);
		 this.principal = (int) principal;
		 this.interestRate = interestRate;
		 this.setCurrentPrice(principal);
	 }
	 
	 /* method to get the principal */
	 public int getPrincipal() {
		 return this.principal;
	 }
	 
	 /* method to get the interest rate of the bond */
	 public double getInterestRate() {
		 return this.interestRate;
	 }
	 
	 /* method to set the interest rate of the bond */
	 public void setInterestRate(double interestRate) {
		 this.interestRate = interestRate;
	 }
	 
	 /* method to calculate the product of interest rate and principal */
	 public double payInterest() {
		 return getInterestRate() * getPrincipal();
	 }
	 
	 /* method when someone buys a bond. it purchases a bond which increases the cost basis, the number
	  * of stocks by one, and returns the cuurentprice of the bond*/
	 public double buy() {
		 this.setCostBasis(this.getCostBasis() + this.getCurrentPrice());
		 this.numberOfBonds += 1;
		 return this.getCurrentPrice();
		 
	 }
	 
	 /* method when someone sells a bond , which returns 0, if there are no bonds, otherwise the cost basis
	  * is reduced, capital gains is increase, and number of bonds is decreased by one, also the 
	  * current price is returned */
	 public double sell() {
		if(this.getNumberOwned() == 0) {
			return 0;
		} else {
			this.setCostBasis(this.getCostBasis() - (this.getCostBasis() / this.getNumberOwned()));
			this.setCapitalGains(this.getCapitalGains() + 
					(this.getCurrentPrice() - (this.getCostBasis() / this.getNumberOwned())));
			this.numberOfBonds = this.numberOfBonds - 1;
			return this.getCurrentPrice();
		}
	 }
	 
	 /* method to get the number of bonds owned */
	 public int getNumberOwned() {
		 return this.numberOfBonds;
	 }
	
}
