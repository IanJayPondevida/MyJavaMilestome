package atm4;

public class checkingAccount extends account
{
	private static double FEE = 2.5;
	
	//Default constructor
	public checkingAccount() 
	{
		super();
	}
	/***
	 * Parameter constructor to initialize CheckingAccount
	 * with custom Account number and a Customer Transaction Fee
	 * @param accountnumber
	 * @param fee
	 */
	public checkingAccount(int accountnumber, double fee) 
	{
		super(accountnumber);
		FEE = fee;
		
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
			System.out.printf("\nAmount: %.2f Deposited%n", amount);
			
			//Apply Transaction Fee
			balance -= FEE;
			System.out.printf("Fee %.2f Applied%n", FEE);
			System.out.printf("Current Balance: %.2f%n", balance);
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
			if (amount+FEE <= balance)
			{
				System.out.printf("\nAmount withdrawn: of %.2f%n", amount);
				balance -= amount;
				balance -= FEE;
				System.out.printf("Fee %.2f Applied%n", FEE);
				System.out.printf("Current Balance: %.2f%n", balance);
			}
		}
		else 
		{
			System.out.println("Insuffient amount!");
		}
	}
}
