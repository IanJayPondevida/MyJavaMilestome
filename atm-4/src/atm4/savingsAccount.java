package atm4;


//Savings Account (Child class)
//has an interest rate
//a method to apply interest - profit;
public class savingsAccount extends account
{
	private double interestRate;
	//Default constructor
	public savingsAccount() 
	{
		super();
	}
	/***
	 * Parameter constructor to initialize SavingsAccount
	 * with custom Account number and Interest Rate
	 * @param accountnumber
	 * @param fee
	 */
	public savingsAccount(int accountnumber, double interestRate) 
	{
		super(accountnumber);
		this.interestRate = interestRate;
		
	}
	/***
	 * Function to Deposit funds into the account as long as the amount parameter is > 0
	 * Apply Transaction fee for the CheckingAccount 
	 * @return
	 */
	//getter function
	public double getInterestRate()
	{
		return interestRate;
	}
	public double setInterestRate(double interestRate) 
	{
		return interestRate;
	}
	public double calInterestRate() 
	{
		return balance * interestRate;
	}
	public void applyInterest() 
	{
		double interest = calInterestRate();
		System.out.printf("Interest amount: %.2f added to balance%n", interest);
		deposit(interest);
	}
	
	/* Function to deposit funds into account as long as
	 * the amount parameter is > 0
	 * 
	 * Apply Transaction fee for CheckingAccount;
	 * 
	 * @param amount value to be deposited
	 */
	public void deposit(double amount) 
	{
		//First check amount 
		if (amount > 0)
		{
			balance += amount;
			System.out.printf("Amount: %.2f Deposited%n", amount);
			System.out.printf("Current Balance: %.2fn", balance);
		} 
		else
		{
			System.out.printf("Insuffient amount!");
		}	
	}
		/***
		 * Function to the withdraw from the account as long as
		 * 1. Amount to withdraw must be > 0;
		 * 2. Amount to withdraw must be <= balance
		 * 
		 * @param amount value to be withdrawn
		 */
	public void withdraw(double amount) 
	{
		//Check amount
		if(amount > 0) 
		{
			//Check sufficient balance
			if (amount <= balance)
			{
				System.out.printf("Amount of %.2f withdrawn from Account%n", amount);
				balance -= amount;
				System.out.printf("Current Balance: %.2f%n", balance);
			}
		}
		else 
		{
			System.out.println("Insuffient amount!");
		}
	}
}
