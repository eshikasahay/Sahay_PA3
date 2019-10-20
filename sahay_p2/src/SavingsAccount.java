public class SavingsAccount
{
    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double balance)
    {
        savingsBalance = balance;
    }

    public static void modifyInterestRate(double r)
    {
        annualInterestRate = r;
    }

    public double getAnnualInterestRate()
    {
        return annualInterestRate;
    }

    public double getSavingsBalance()
    {
        return savingsBalance;
    }

    public void setSavingsBalance(double balance)
    {
        savingsBalance = balance;
    }

    public double calculateMonthlyInterest(double bal, double r)
    {
        return bal * r / 12.0;
    }
}
