package bank.cashcounter;
import bank.Customer;
public class Cashier
{
    private String output = new String();
    private int id;
    private static int time;

    public Cashier(int name)
    {
        this.id = name;
        this.output = "Cashier " + Integer.toString(id) + "\n";
    }

    public void takeRequest(Request req, Customer c)
    {
        //char type = req.getReqType();
        char requestType = req.getReqType();
        if (requestType == 'D')
        {
            c.deposit(req.getAmount());
            time += 5;
            output += "Request " + req.getReqId() + " " + Integer.toString(time) + "\n";
        }
        else if (requestType == 'W')
        {
            c.withdraw(req.getAmount());
            time += 10;
            output += "Request " + req.getReqId() + " " + Integer.toString(time) + "\n";
        }
        else
        {
            time += 2;
            output += "Request " + req.getReqId() + " " + Integer.toString(time) + "\n";
        }
    }

    public void displayTotal(Customer c)
    {
        this.output += "Total " + Integer.toString(c.getBalance()) + "\n";
    }

    public String getOutput()
    {
        return (this.output);
    }
}