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
		
		//testing the CashAsset class methods
		TestFile.testCashAsset();
		System.out.println();
		
		//testing the Customer class methods
		TestFile.testCustomer();
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
		System.out.println(x);
		
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
		System.out.println(x);
		
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
		System.out.println(x.sell());
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
		System.out.println(x);
		
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
		System.out.println(x);
		
		//set and get Load method which should return the percentage that is charged to all 
		//sales of the fund which I will set to 50, expect it to be 50.0
		x.setLoad(50);
		System.out.println(x.getLoad());
		//it results in 50.0
		
		//the buy method in MutualFund, which I will input 200 invested money
		//this should increase the numberOfSharesOwned by 5,
		//the costBasis should also be increased by 200, and 200.0 should be first returned by the method
		System.out.println(x.buy(-200));
		System.out.println(x.buy(200));
		System.out.println(x.getNumberOfShares());
		System.out.println(x.getCostBasis());
		//it return 0.0
		//200.0
		//5.0
		//200.0
		
		//the sell method in MutualFund, which I will input 50 which is the amount I will withdraw
		//the number of shares owned should be decreased to 4.975, the costBasis should be changed to
		//199, and the capitalGains should be increased to 49, the amount withdrawn of 50 is first return
		//also testing the if sell is negative and if sell is greater than the currentPrice which is 2000
		System.out.println(x.sell(-500));
		System.out.println(x.sell(3000));
		System.out.println(x.sell(50));
		System.out.println(x.getNumberOfShares());
		System.out.println(x.getCostBasis());
		System.out.println(x.getCapitalGains());
		//it returns 0.0
		//0.0
		//50.0
		//4.975
		//199.0
		//49.005, rounding error
	}
	
	public static void testStock() {
		//create a Stock instance
		Stock x = new Stock("Stock1", 'S', 1000);
		System.out.println(x);
		
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
		System.out.println(x.sell(6, 75));
		System.out.println(x.sell(3, 75));
		System.out.println(x.getNumberOfShares());
		System.out.println(x.getCostBasis());
		System.out.println(x.getCapitalGains());
		//it results in: 0.0
		//2925.0
		//2.0
		//2040.0
		//2925.0
		
		//the split method, we will input (10, 3), which should return 666.6667 because of the remainder
		//the rest of the logic is the same as the sell method but with a commission of 0
		//the numberOfShares should increase to 6.0
		//we will fist test if the num is 0, dem = 0 which should both return 0.0
		//last we will check for whole number after the division which will also return 0.0
		System.out.println(x.split(0, 1));
		System.out.println(x.split(1, 0));
		System.out.println(x.split(10, 3));
		System.out.println(x.getCostBasis());
		System.out.println(x.getCapitalGains());
		System.out.println(x.getNumberOfShares());
		System.out.println(x.split(3, 1));
		//it results in: 0.0
		//0.0
		//666.6666666667
		//1836.0
		//3591.666666667
		//6.0
		//0.0
	}
	
	public static void testCashAsset() {
		//creating an instance of CashAsset
		CashAsset x = new CashAsset(15, 10, 13, 10);
		System.out.println(x);
		
		//testing the get balance method, which should return 0.0, because that is the default
		System.out.println(x.getBalance());
		//it returns 0.0
		
		//testing the set/get savings rate methods which I will change from 15 to 20.
		//it should return 20.0
		x.setSavingsRate(20);
		System.out.println(x.getSavingsRate());
		//it returns 20.0
		
		//testing the set/get for loan rate methods, which I will change from 10 to 15
		//it should return 15.0
		x.setLoanRate(15);
		System.out.println(x.getLoanRate());
		//it returns 15.0
		
		//testing the set/get loan limit methods, which I will change from 13, 17
		//it should return 17.0
		x.setLoanLimit(17);
		System.out.println(x.getLoanLimit());
		//it returns 17.0
		
		//testing the set/get overDraftPenalty methods, which I will change from 10 to 12
		//it should return 12.0
		x.setOverDraftPenalty(12);
		System.out.println(x.getOverDraftPenalty());
		//it returns 12.0
		
		//testing the deposit balance which should increase the current balance from 0.0 to 21.0
		//it should return 21.0 after I change it
		x.deposit(21);
		System.out.println(x.getBalance());
		//it returns 21.0
		
		//testing the withdraw method, which I will try to withdraw 17.0, which means current balance
		//should change to 4.0 and return true
		System.out.println(x.withdraw(23, false));
		System.out.println(x.withdraw(17, false));
		System.out.println(x.getBalance());
		//it returns false
		//true
		//4.0
		
		//testing the processDay method, which it should first change the accrued amount to 0.21917
		x.processDay();
		System.out.println(x.getInterestAccrued());
		//it returns 0.21917
		
		//testing the processMonth method, which should change the current balance to 4.219
		x.processMonth();
		System.out.println(x.getBalance());
		//it returns 4.219
		
		//testing the if statement in processDay method
		x.withdraw(5, true);
		System.out.println(x.getBalance());
		x.processDay();
		System.out.println(x.getInterestAccrued());
		x.processMonth();
		System.out.println(x.getBalance());
	}
	
	public static void testCustomer() {
		
		//first will test out the constructor with more inputs because they both are the same, but 
		//we will try it with more inputs as it covers both
		//to have it work we must first create a Bond, MutualFund, Stock, and CashAccount instance
		
		//name is BondOne, principal is 10, and 15 is interestRate
		Bond b1 = new Bond("BondOne", 10, 15); 
		//create a mutualFund named MFone, symbol of M, and currentPrice of 1000
		MutualFund m1 = new MutualFund("MFone", 'M', 1000);
		//create a Stock with name StockOne, symbol of S, and currentPrice of 500
		Stock s1 = new Stock("StockOne", 'S', 500);
		//create a CashAccount with the interestRateSavings of 15, interestRateLoans of 13, loanLimit of 10
		//and overDraftPenalty of 11
		CashAsset c1 = new CashAsset(15, 13, 10 ,11);
		
		//first constructor with only two inputs--commission rate of 5
		Customer first = new Customer(c1, 5);
		System.out.println(first);
		//lets set up the customer also with a commissionRate of 5
		Customer A1 = new Customer(c1, b1, m1, s1, 5);
		System.out.println(A1);
		
		//checking the references for the customer fields and checking the set/get methods for the class instances in Customer
		System.out.println(A1.getCashAccount());
		System.out.println(A1.getBond());
		System.out.println(A1.getMutualFund());
		System.out.println(A1.getStock());
		System.out.println(A1.getCommissionRate());
		//the results are:CashAsset@677327b6
		//Bond@14ae5a5
		//MutualFund@7f31245a
		//Stock@6d6f6e28
		//5.0
		
		//creating new objects references to set the customer fields each with just a different variable name and 1st parameter
		//name is BondTwo, principal a.k.a currentPriceofbond is 10, and 15 is interestRate
		Bond b2 = new Bond("BondTwo", 10, 15); 
		//create a mutualFund named MFTwo, symbol of M, and currentPrice of 1000
		MutualFund m2 = new MutualFund("MFTwo", 'M', 1000);
		//create a Stock with name Stock2, symbol of S, and currentPrice of 500
		Stock s2 = new Stock("StockTwo", 'S', 500);
		//create a CashAccount with the interestRateSavings of 25, interestRateLoans of 13, loanLimit of 10
		//and overDraftPenalty of 11
		CashAsset c2 = new CashAsset(25, 13, 10 ,11);
		
		//changing the references using the set methods, and changing the commissionRate to 7
		A1.setBond(b2);
		A1.setCashAccount(c2);
		A1.setStock(s2);
		A1.setMutualFund(m2);
		A1.setCommissionRate(7);
		
		//testing out if it changed, which the references should change and the commission rate is 7
		System.out.println(A1.getCashAccount());
		System.out.println(A1.getBond());
		System.out.println(A1.getMutualFund());
		System.out.println(A1.getStock());
		System.out.println(A1.getCommissionRate());
		//the results are:CashAsset@135fbaa4
		//Bond@45ee12a7
		//MutualFund@330bedb4
		//Stock@2503dbd3
		//7.0
		//we can see that it now refers to different objects
		
		//testing the currentValue method which should return 10 * 500 * 1000 = 5000000.0
		System.out.println(A1.currentValue());
		//it returns 5000000.0
		
		//testing the getCapitalGains which adds the capitals gains from the bond,stock, and MutualFund instances
		//which here should be set to zero
		System.out.println(A1.getCapitalGains());
		//it returns 0.0
		
		//testing the deposit method which I will add 20 to the cash account balance
		A1.deposit(20);
		System.out.println(A1.getCashAccount().getBalance());
		//it returns 20.0
		
		//testing the withdraw method, which I will take out 10, and should print out true
		System.out.println(A1.withdraw(10));
		System.out.println(A1.getCashAccount().getBalance());
		//it returns true
		//10.0

		//testing the sellBond method, which should return 10.0 because we don't own any bonds at this moment
		A1.sellBond();
		System.out.println(A1.getCashAccount().getBalance());
		//it returns 10.0
		
		//testing the buyBond method which should first return true because it is only 10 and the amount would be
		//0
		System.out.println(A1.buyBond());
		System.out.println(A1.getCashAccount().getBalance());
		//it returns true
		//0.0
		
		//testing the payBond Interest method, which should add 150 into the CashAccount
		A1.payBondInterest();
		System.out.println(A1.getCashAccount().getBalance());
		//it returns 150.0
		
		//testing the withdrawMutualFund method, which should add 20 from my input and change it to 170.0
		A1.withdrawMutualFund(20);
		System.out.println(A1.getCashAccount().getBalance());
		//it returns 170.0
		
		//testing the buyMutualFund method. I will first test when it is larger than 9.0E7 
		//and that should return false. Then I will input 30.0 and it should print out true and the 
		//cashAccount balance should be 140.0
		System.out.println(A1.buyMutualFund(1000000000));
		System.out.println(A1.buyMutualFund(30));
		System.out.println(A1.getCashAccount().getBalance());
		//it returns false
		//true
		//140.0

		//testing the sellStockShares method which I will input 7 and that will be multiplied by 7 the commission
		//rate and that means the CashAccount balance should not be changed at all cause there are no stocks to begin with
		A1.sellStockShares(7);
		System.out.println(A1.getCashAccount().getBalance());
		//it returns 140.0;
		
		//testing the buyStockShares method, which should return true and decrease the cashAccount balance to
		//-3367 because it cost 3507 and we initially had only 140.0 in the cashAccount balance
		System.out.println(A1.buyStockShares(7));
		System.out.println(A1.getCashAccount().getBalance());
		//it return true
		//-3367.0
		
		//Testing the else part of the buyStockShares which  the input of 100 should return false because 
		//the 100 stock shares after the buy method in stock is greater than the currentValue of the Customer class
		System.out.println(A1.buyStockShares(100));
		//it returns false
	}
	
}

