public class TestFile {
	public static void main(String[] args) {
		//testing the Asset class methods
		TestFile.testAsset();
		System.out.println();
		
		//testing the Bond class methods
		TestFile.testBond();
		System.out.println();
		
		//testing the Equity class methods
		TestFile.testEquity();
		System.out.println();
		
		//testing the MutualFund class methods
		TestFile.testMutualFund();
		System.out.println();
		
		//testing the Stock class methods
		TestFile.testStock();
		System.out.println();
		
		
		/*
		 * the resulting lines printed onto the console:
		 * 
		 */
	}
	
	//testing the Asset class methods
	public static void testAsset() {
		//create an Asset instance
		Asset x = new Asset("xname", 100);
		
		//testing the setName / getName methods expect it to change the name to X
		x.setName("X");
		System.out.println(x.getName());
		//it results in X
		
		//testing the setDescription/ getDescription methods
		//, expect it change description of Asset to Asset1
		x.setDescription("Asset1");
		System.out.println(x.getDescription());
		//it results in Asset1
		
		//testing the setCostBasis / getCostBasis methods, expect it to change the CostBasis to 10.0
		x.setCostBasis(10);
		System.out.println(x.getCostBasis());
		//it results in 10.0
		
		//testing the set and get CurrentPrice methods, expect it to change the currentPrice to 20.0;
		x.setCurrentPrice(20);
		System.out.println(x.getCurrentPrice());
		//it results in 20.0
		
		//testing the set and get capitalGains method, expect it to change the capitalGains 15.0
		x.setCapitalGains(15);
		System.out.println(x.getCapitalGains());
		//it results in 15.0
	}
	
	//testing the Bond class
	public static void testBond() {
		//create a Bond instance
		Bond x = new Bond("bond1", 100, 20);
		
		//test the getPrincipal method, which is never suppose to change, expect it to be 100
		System.out.println(x.getPrincipal());
		//it results in 100
		
		//test the set get and pay interest methods, I expect the get to result in 10.0
		// which means the pay to result in 1000.0
		x.setInterestRate(10);
		System.out.println(x.getInterestRate());
		System.out.println(x.payInterest());
		//it results in 10.0
		//1000.0
		
		//testing the buy method and the getNumberOwnded, the cost basis is initially 0, 
		//so it should turn to 100.0 because currentPrice
		//is 100.0, number of bonds should increase to 1
		//and we should return 100.0 first because currentPrice is 100.0 which is set in the constructor
		System.out.println(x.buy());
		System.out.println(x.getCostBasis());
		System.out.println(x.getNumberOwned());
		//it returns 100.0
		//100.0
		//1
		
		//testing the sell method, where costBasis is reduced by costBasis / number of bonds owned
		//this should result in costBasis = 0.0, numberOfBonds = 0, and the currentPrice which is 100.0 
		//is return first after you call sell
		System.out.println(x.sell());
		System.out.println(x.getNumberOwned());
		System.out.println(x.getCurrentPrice());
		System.out.println(x.getCostBasis());
		//the result is 100.0
		//0
		//100.0
		//0.0
	}
	
	//testing the Equity class methods
	public static void testEquity() {
		//creating an Equity class instance
		Equity x = new Equity("Equity1", 'A', 100);
		
		//testing the getSymbol method which should return 'A'
		System.out.println(x.getSymbol());
		//it returns A
		
		//testing the set and get NumberOfShares method which should return 10 after I set it
		x.setNumberOfShares(10);
		System.out.println(x.getNumberOfShares());
		//it returns 10.0
	}
	
	//testing the MutualFund class methods
	public static void testMutualFund() {
		//creating a MutualFund instance
		MutualFund x = new MutualFund("MutualFund1", 'M', 2000);
		
		//set and get Load method which should return the percentage that is charged to all 
		//sales of the fund which I will set to 50, expect it to be 50.0
		x.setLoad(50);
		System.out.println(x.getLoad());
		//it results in 50.0
		
		//the buy method in MutualFund, which I will input 200 invested money
		//this should increase the numberOfSharesOwned by 5,
		//the costBasis should also be increased by 200, and 200.0 should be first returned by the method
		System.out.println(x.buy(200));
		System.out.println(x.getNumberOfShares());
		System.out.println(x.getCostBasis());
		//it return 200.0
		//5.0
		//200.0
		
		//the sell method in MutualFund, which I will input 50 which is the amount I will withdraw
		//the number of shares owned should be decreased to 4.975, the costBasis should be changed to
		//199, and the capitalGains should be increased to 49, the amount withdrawn of 50 is first return
		System.out.println(x.sell(50));
		System.out.println(x.getNumberOfShares());
		System.out.println(x.getCostBasis());
		System.out.println(x.getCapitalGains());
		//it returns 50.0
		//4.975
		//199.0
		//49.005, rounding error
	}
	
	public static void testStock() {
		//create a Stock instance
		Stock x = new Stock("Stock1", 'S', 1000);
		
		//the buy method, which will take in 5 stocks and a commission of 100
		//the number of stocks will be increased to 5, z will be 5100 and the result returned
		//and the costBasis becomes 5100
		System.out.println(x.buy(5, 100));
		System.out.println(x.getNumberOfShares());
		System.out.println(x.getCostBasis());
		//the result is 5100.0
		//5.0
		//5100.0
		
		//the sell method, which will take in 3 stocks, and a commission of 75
		//the numberOfShares owned will be decreased to 2 stocks, the costBasis should be decreased until 
		//2040, and the capitalGains should be increased to 2925, and the method returns 2925
		System.out.println(x.sell(3, 75));
		System.out.println(x.getNumberOfShares());
		System.out.println(x.getCostBasis());
		System.out.println(x.getCapitalGains());
		//it results in: 2925.0
		//2.0
		//2040.0
		//2925.0
		
		//the split method, we will input (10, 3), which should return 666.6667 because of the remainder
		//the rest of the logic is the same as the sell method but with a commission of 0
		//the numberOfShares should increase to 6.0
		System.out.println(x.split(10, 3));
		System.out.println(x.getNumberOfShares());
		//it results in: 666.6666666667
		//6.0
	}
}

