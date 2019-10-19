import java.security.SecureRandom;
import java.util.Scanner;

public class Problem1
{
    static double x, y;

    public static void main(String[] args)
    {
        int i, j, c, correct, type;
        double a, d;
        Scanner sc = new Scanner(System.in);
        SecureRandom rand = new SecureRandom();

        do
        {
            correct = 0;
            System.out.println("Please enter a difficulty level (1 to 4):");
            int diff = sc.nextInt();
            while(diff>4 || diff<1)
            {
                System.out.println("Please enter from 1-4 ONLY");
                diff = sc.nextInt();
            }
            type = type();

            rand(diff);

            switch(type)
            {
                case 1:
                    for(j=0; j<10; j++)
                    {
                        System.out.printf("%d. How much is %d plus %d\n", (j+1), (int)x, (int)y);
                        a = sc.nextDouble();
                        if(a == (x+y))
                        {
                            message(1);
                            correct++;
                        }
                        else
                            message(0);
                        rand(diff);
                    }
                    break;
                case 2:
                    for(j=0; j<10; j++)
                    {
                        System.out.printf("%d. How much is %d times %d\n", (j+1), (int)x, (int)y);
                        a = sc.nextDouble();
                        if(a == (x*y))
                        {
                            message(1);
                            correct++;
                        }
                        else
                            message(0);
                        rand(diff);
                    }
                    break;
                case 3:
                    for(j=0; j<10; j++)
                    {
                        System.out.printf("%d. How much is %d minus %d\n", (j+1), (int)x, (int)y);
                        a = sc.nextDouble();
                        if(a == (x-y))
                        {
                            message(1);
                            correct++;
                        }
                        else
                            message(0);
                        rand(diff);
                    }
                    break;
                case 4:
                    System.out.println("Please round your answer to 2 decimal places, if needed");
                    for(j=0; j<10; j++)
                    {
                        while(y==0)
                            rand(diff);
                        System.out.printf("%d. How much is %d divided %d\n", (j+1), (int)x, (int)y);
                        d = sc.nextDouble();
                        String p = String.format("%.2f", d);
                        String ans = String.format("%.2f", x/y);
                        if(p.equals(ans))
                        {
                            message(1);
                            correct++;
                        }
                        else
                            message(0);
                        rand(diff);
                    }
                    break;
                case 5:
                    for(j=0; j<10; j++)
                    {
                        i = rand.nextInt(4)+1;
                        if(i == 1)
                        {
                            System.out.printf("%d. How much is %d plus %d\n", (j+1), (int)x, (int)y);
                            a = sc.nextDouble();
                            if(a == (x+y))
                            {
                                message(1);
                                correct++;
                            }
                            else
                                message(0);
                        }
                        else if(i == 2)
                        {
                            System.out.printf("%d. How much is %d times %d\n", (j+1), (int)x, (int)y);
                            a = sc.nextDouble();
                            if(a == (x*y))
                            {
                                message(1);
                                correct++;
                            }
                            else
                                message(0);
                        }
                        else if(i == 3)
                        {
                            System.out.printf("%d. How much is %d minus %d\n", (j+1), (int)x, (int)y);
                            a = sc.nextDouble();
                            if(a == (x-y))
                            {
                                message(1);
                                correct++;
                            }
                            else
                                message(0);
                        }
                        else if(i == 4)
                        {
                            while(y==0)
                                rand(diff);
                            System.out.printf("%d. How much is %d divided %d\n", (j+1), (int)x, (int)y);
                            d = sc.nextDouble();
                            String p = String.format("%.2f", d);
                            String ans = String.format("%.2f", x/y);
                            if(p.equals(ans))
                            {
                                message(1);
                                correct++;
                            }
                            else
                                message(0);
                        }

                        rand(diff);
                    }
                    break;

            }

            System.out.println("\nCorrect: "+correct);
            System.out.println("Incorrect: "+(10-correct));
            System.out.printf("The percentage of correct answer is %d%c\n\n", (10*correct), '%');
            double percent = correct/10.0 * 100.0;
            if(percent<75)
            {
                System.out.println("Please ask your teacher for extra help.");
            }
            else
            {
                System.out.println("Congratulations, you are ready to go to the next level!");
            }
            System.out.println("\nDo you want to start another session? Enter '1' for yes and '0' for no");
            c = sc.nextInt();
        }while (c == 1);

        System.out.println("Session has ended");

    }

    public static void rand(int diff)
    {
        SecureRandom rand = new SecureRandom();
        if(diff == 1)
        {
            x = rand.nextInt(10);
            y = rand.nextInt(10);
        }
        if(diff == 2)
        {
            x = rand.nextInt(100);
            y = rand.nextInt(100);
        }
        if(diff == 3)
        {
            x = rand.nextInt(1000);
            y = rand.nextInt(1000);
        }
        if(diff == 4)
        {
            x = rand.nextInt(10000);
            y = rand.nextInt(10000);
        }

    }

    public static void message(int i)
    {
        int k;
        SecureRandom rand = new SecureRandom();
        k = rand.nextInt(4)+1;

        if(i == 1)
        {
            switch(k)
            {
                case 1:
                    System.out.println("Very good!");
                    break;
                case 2:
                    System.out.println("Excellent!");
                    break;
                case 3:
                    System.out.println("Nice work!");
                    break;
                case 4:
                    System.out.println("Keep up the good work!");
                    break;
            }
        }

        else if(i == 0)
        {
            switch(k)
            {
                case 1:
                    System.out.println("No. Please try again.");
                    break;
                case 2:
                    System.out.println("Wrong. Try once more.");
                    break;
                case 3:
                    System.out.println("Don't give up!");
                    break;
                case 4:
                    System.out.println("No. Keep trying.");
                    break;
            }
        }

    }

    public static int type()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPlease enter '1' for addition problems only");
        System.out.println("Please enter '2' for multiplication problems only");
        System.out.println("Please enter '3' for subtraction problems only");
        System.out.println("Please enter '4' for division problems only");
        System.out.println("Please enter '5' for a random mixture of all types of problems");
        int type = sc.nextInt();
        return type;
    }

}

