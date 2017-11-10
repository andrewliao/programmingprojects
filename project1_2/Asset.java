package project1_2;
/*
 Andrew Liao
 Asset class represents any tangible property of an asset
 */

public class Asset {

	//name of asset
	private String name = "";
	//description of the asset
	private String description = "";
	//cost basis of the asset
	private double costBasis = 0.0;
	//current price someone is willing to buy it
	private double currentPrice = 0.0;
	//how price would be made if you sold the asset today
	private double capitalGains = 0.0;
	
	/*constructor for asset */
	public Asset(String name, double costBasis) {
		this.name = name;
		this.costBasis = costBasis;
		this.capitalGains = 0;
	}
	
	/* method to return the name of the asset */
	public String getName() {
		return this.name;
	}
	
	/* method to set the name of the asset */
	public void setName(String name) {
		this.name = name;
	}
	
	/* method to return the String of the description of the asset */
	public String getDescription() {
		return this.description;
	}
	
	/* method to set the description of the asset */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/* method to return the CostBasis of the asset */
	public double getCostBasis() {
		return this.costBasis;
	}
	
	/* method to change the CostBasis of the asset */
	protected void setCostBasis(double costBasis) {
		this.costBasis = costBasis;
	}
	
	/* method to get the current price of the asset */
	public double getCurrentPrice() {
		return this.currentPrice;
	}
	
	/* method to set the current price of the asset */
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	
	/* method to get the capital gains of the asset */
	public double getCapitalGains() {
		return this.capitalGains;
	}
	
	/* method to set the capital gains of the asset */
	protected void setCapitalGains(double capitalGains) {
		this.capitalGains = capitalGains;
	}
	
}
