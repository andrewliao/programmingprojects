/*
 * Andrew Liao
 * where you own shares of the asset
 */
public class Equity extends Asset {
	
	//symbol of the equity, which are single characters
	private char symbol;
	//number of shares of the equity
	private double numOfEquity = 0;
	
	//Equity constructor
	public Equity(String nameOfEquity,char symbol, double currentPrice) {
		super(nameOfEquity, 0);
		this.symbol = symbol;
		this.setCurrentPrice(currentPrice);
	}
	
	//return single character symbol
	public char getSymbol() {
		return this.symbol;
	}
	
	//returns the number of shares of equity
	public double getNumberOfShares() {
		return this.numOfEquity;
	}
	
	//set the number of shares of equity
	protected void setNumberOfShares(double numOfShares) {
		this.numOfEquity = numOfShares;
	}	
	
}
