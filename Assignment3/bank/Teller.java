package bank;
import java.util.*;
import bank.cashcounter.*;

public class Teller
{
    private ArrayList<Request> requests;
    private ArrayList<Customer> customers;
    private String output;
    private static int count = 1;

    public static Teller createTeller()
    {
        if(count == 1)
        {
            Teller t = new Teller();
            return t;
        }
        else 
            return null;
    }
    private Teller()
    {
        count ++;
        this.output = "" ;
        requests = new ArrayList<Request>();
        customers = new ArrayList<Customer>();
    }
    // public list getRequests()
    // {
    //     return this.requests;
    // }
    public void addRequest(String req, int id)
    {
        Request r = new Request(req, id);
        int custId = r.getCustId();
        if (custId > customers.size())
        {
            Customer cust1 = new Customer(custId);
            customers.add(cust1);
        }
        this.requests.add(r);
    }
    public void isBreak()
    {
        int noOfCashiers;
        if((requests.size() % 3) == 0)
            noOfCashiers = requests.size() / 3;
        else
            noOfCashiers = (requests.size() / 3) + 1;
        // this.output += "+++++++++" + noOfCashiers ;
        for (int i = 1; i <= noOfCashiers; i++)
        {
            Cashier c = new Cashier(i);
            int tempid = 0;
            for (int j = i-1; j < requests.size(); j += noOfCashiers)
            {
                int cid = requests.get(j).getCustId();
                tempid = cid;
                c.takeRequest(requests.get(j) , customers.get(cid - 1));
            }
            c.displayTotal(customers.get(tempid - 1));
            this.output += c.getOutput();
        }

        requests.clear();
        // System.out.println(this.output);
    }

    public String getOutput()
    {
        return (this.output);
    }
    public int getSize()
    {
        return requests.size();
    }
}