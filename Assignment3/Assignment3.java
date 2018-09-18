import java.util.* ;
import bank.Teller ;

class Assignment3
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String input = " ";
        Teller t1 = Teller.createTeller();
        Teller t2 = Teller.createTeller();
        int num = 0;
        while (true)
        {
            input = in.nextLine();
            if (input.charAt(0) == 'B' || input.charAt(0) == 'E')
            {
                t1.isBreak();
                if(input.charAt(0) == 'E')
                {
                    System.out.print(t1.getOutput());
                    in.close();
                    System.exit(0);
                }
            }
            else
            {
                num ++;
                t1.addRequest(input, num);
            }

        }
        // System.out.println(t1.getSize());
    }
}
