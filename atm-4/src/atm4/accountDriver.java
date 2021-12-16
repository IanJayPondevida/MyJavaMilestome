package atm4;
import java.util.Scanner;

public class accountDriver
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		//Create array of accounts
		account account[] = new account[10];
		int numAccounts = 0;
		int select;
		do 
		{
			select = menu(input);
			System.out.println();//find me! You did it!
			
			if (select == 1)
			{
				account [numAccounts++] = createAccount(input);
			}
			else if(select == 2){
				setDeposit(account, numAccounts, input);
			}
			else if(select  == 3) 
			{
				setWithdraw(account, numAccounts, input);	
			}
			else if(select ==  4) 
			{
				applyInterest(account, numAccounts, input);
			}
			else
			{
				System.out.println("Thank you for using ATM! Come again!");
			}
			System.out.println();
		}
		while(select != 5);
		
	}
	/***
	 * account choice
	 * @param input
	 * @return
	 */
	public static int accountMenu(Scanner input) 
	{
		System.out.println("Select Account Type: ");
		System.out.println("1. Checking Account");
		System.out.println("2. Saving Account");
		
		int select;
		do 
		{
			System.out.println("Select Transaction: \n");
			select = input.nextInt();
		}while(select < 1 || select > 2);
		
		return select;
	} 
	public static int searchAccount(account account[], int count, int accountnumber)  
	{
	   for (int i = 0; i < count; i++)
	{
		if(account[i].getAccountNumber() == accountnumber) 
		{
			return i;
		}
		
	}
		return -1;
	}
	/***
	 * Function to perform deposit account
	 * @param acc
	 * @param count
	 */
	public static void setDeposit(account account[], int count, Scanner input) 
	{
		//Get the account number
		System.out.print("Please enter account number: ");
		int accountnumber = input.nextInt();
		
		//search for account
		int index = searchAccount(account, count, accountnumber);
		
		if(index >= 0) 
		{
			//Amount 
			System.out.print("Please enter Deposit amount: ");
			double amount = input.nextDouble();
			account[index].deposit(amount);
		}
		else
		{
			System.out.println("Account number doesn't exist! "+accountnumber);
		}
	}
	private static void setWithdraw(account account[], int count, Scanner input)
	{
		//Get the account number
		System.out.print("Please enter account number: ");
		int accountnumber = input.nextInt();
		
		//search for account
		int index = searchAccount(account, count, accountnumber);
		
		if(index >= 0) 
		{
			//Amount 
			System.out.print("Please enter Withdraw amount: ");
			double amount = input.nextDouble();
			account[index].withdraw(amount);
		}
		else
		{
			System.out.println("Account number doesn't exist! "+accountnumber);
		}
	} 
	public static void applyInterest(account account[], int count, Scanner input) 
	{
		//Get the account number
		System.out.println("\nPlease enter account number: ");
		int accountnumber = input.nextInt();
		
		//search for account
		int index = searchAccount(account, count, accountnumber);
		
		if(index >= 0) 
		{
			//Must be instance of savings account
			if(account[index] instanceof savingsAccount) 
			{
				((savingsAccount)account[index]).applyInterest();
			}
		}
		else
		{
			System.out.println("Account number doesn't exist! "+accountnumber);
		}
	}
	/**
	 *Function to create a new account
	 */
	public static account createAccount(Scanner input) 
	{
		account acc = null;
		int select = accountMenu(input);
		
		int accountnumber;
		System.out.print("Enter Account Number: ");
		accountnumber = input.nextInt();
		
		if (select == 1)//Checking Account
		{
			System.out.print("Enter Transaction fee: ");
			double fee = input.nextDouble();
			
			acc = new checkingAccount(accountnumber, fee);
		} 
		else//Savings account
		{
			System.out.println("Please enter Interest Rate: ");
			double ir = input.nextDouble();
			acc = new savingsAccount(accountnumber, ir);
		}
		
		return acc;
	}
	/***
	 * Menu to display option and get the user's selection
	 * @param input
	 * @return
	 */
	public static int menu(Scanner input) 
	{
		System.out.println("Bank account menu");
		System.out.println("1. Create New Account");
		System.out.println("2. Deposit Funds");
		System.out.println("3. Withdraw Funds");
		System.out.println("4. Apply Interest");
		System.out.println("5. Exit");
		
		int select;
		do 
		{
			System.out.println("Select Transaction: ");
			select = input.nextInt();
		}while(select < 1 || select > 5);
		
		return select;
	}
	 
}
