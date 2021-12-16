package atm4;

public abstract class account
{
	//Account Number
	private int accountnumber;
	
	//balance
	protected double balance;
	
	//Default Constructor
	public account()
	{
		
	}
	
	public account(int accountNumber) 
	{
		this.accountnumber = accountNumber;
		balance = 0;
	}
	
	public double getBalance() 
	{
		return this.balance;
	}
	
	public int getAccountNumber() 
	{
		return this.accountnumber;
	}
	
	//Abstract 
	/*
	 * Function to deposit funds into account as long as
	 * the amount parameter is > 0
	 * 
	 * Apply Transaction fee for CheckingAccount;
	 * 
	 * @param amount value to be deposited
	 */
	public abstract void deposit(double amount);
		/***
		 * Function to the withdraw from the account as long as
		 * 1. Amount to withdraw must be > 0;
		 * 2. Amount to withdraw must be <= balance
		 * 
		 * @param amount value to be withdrawn
		 */
	public abstract void withdraw(double amount);
}
