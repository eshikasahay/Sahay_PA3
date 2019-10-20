public class Application
{

    public static void main(String[] args)
    {
        int i;
        SavingsAccount saver1 = new SavingsAccount(2000);
        SavingsAccount saver2 = new SavingsAccount(3000);
        SavingsAccount.modifyInterestRate(0.04);

        System.out.println("Month\t\tSaver1");
        for(i=0; i<12; i++)
        {
            saver1.setSavingsBalance(saver1.getSavingsBalance() + saver1.calculateMonthlyInterest(saver1.getSavingsBalance(), saver1.getAnnualInterestRate()));
            System.out.printf("%d.\t\t$%.2f\n", (i+1), saver1.getSavingsBalance());
        }

        System.out.println("\nMonth\t\tSaver2");
        for(i=0; i<12; i++)
        {
            saver2.setSavingsBalance(saver2.getSavingsBalance() + saver2.calculateMonthlyInterest(saver2.getSavingsBalance(), saver2.getAnnualInterestRate()));
            System.out.printf("%d.\t\t$%.2f\n", (i+1), saver2.getSavingsBalance());
        }

        SavingsAccount.modifyInterestRate(0.05);
        saver1.setSavingsBalance(saver1.getSavingsBalance() + saver1.calculateMonthlyInterest(saver1.getSavingsBalance(), saver1.getAnnualInterestRate()));
        System.out.printf("\nBalance for saver1 next month with 0.05 interest rate will be $%.2f\n",saver1.getSavingsBalance());
        saver2.setSavingsBalance(saver2.getSavingsBalance() + saver2.calculateMonthlyInterest(saver2.getSavingsBalance(), saver2.getAnnualInterestRate()));
        System.out.printf("Balance for saver2 next month with 0.05 interest rate will be $%.2f\n",saver2.getSavingsBalance());
    }

}
