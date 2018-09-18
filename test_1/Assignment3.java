import java.util.* ;

class Assignment3
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String input = " ";
        Teller t1 = Teller.createTeller();
       // Teller t2 = Teller.createTeller();
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

class Customer
{
    private int id;
   // private int total;

    public Customer(int id)
    {
        this.id = id;
       // this.total = 0;
    }

    public int getId()
    {
        return (this.id);
    }
    
    // public int getBalance()
    // {
    //     return (this.total);
    // }

    // public void deposit(int amt)
    // {
    //     total += amt;
    // }
    // public void withdraw(int amt)
    // {
    //     total = total - amt;
    // }
}

class Teller
{
    private ArrayList<Request> requests;
   // private ArrayList<Customer> customers;
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
     //   customers = new ArrayList<Customer>();
    }
    // public list getRequests()
    // {
    //     return this.requests;
    // }
    public void addRequest(String req, int id)
    {
        Request r = new Request(req, id);
        // int custId = r.getCustId();
        // if (custId > customers.size())
        // {
        //     Customer cust1 = new Customer(custId);
        //     customers.add(cust1);
        // }
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
          //  int tempid = 0;
            for (int j = i-1; j < requests.size(); j += noOfCashiers)
            {
          //      int cid = requests.get(j).getCustId();
          //      tempid = cid;
                c.takeRequest(requests.get(j) /*, customers.get(cid - 1)*/);
            }
            c.displayTotal(/*customers.get(tempid - 1)*/);
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


class Cashier
{
    private String output = new String();
    private int id;
    private int total;
    private ArrayList<Request> requestList = new ArrayList<Request>();
    private static int time;

    public Cashier(int name)
    {
        this.id = name;
        this.output = "Cashier " + Integer.toString(id) + "\n";
    }

    public void takeRequest(Request req)
    {
        this.requestList.add(req);
        
    }

    public void displayTotal()
    {
        for(int i = this.requestList.size() - 1; i>=0; i--)
        {
            char requestType = this.requestList.get(i).getReqType();
            if (requestType == 'D')
            {
                //c.deposit(req.getAmount());
                total += this.requestList.get(i).getAmount();
                time += 5;
                output += "Request " + this.requestList.get(i).getReqId() + " " + Integer.toString(time) + "\n";
            }
            else if (requestType == 'W')
            {
            // c.withdraw(req.getAmount());
            total -= this.requestList.get(i).getAmount();
                time += 10;
                output += "Request " + this.requestList.get(i).getReqId() + " " + Integer.toString(time) + "\n";
            }
            else
            {
                time += 2;
                output += "Request " + this.requestList.get(i).getReqId() + " " + Integer.toString(time) + "\n";
            }
        }
        this.output += "Total " + Integer.toString(total) + "\n";
    }

    public String getOutput()
    {
        return (this.output);
    }
}


class Request
{
    private int reqId;
    private char reqType;
    private int custId;
    private int amount;

    public Request(String s, int n)
    {
        reqId = n;
        String[] splited = s.split("\\s+");
        this.reqType = s.charAt(0);
        if (reqType == 'B' || reqType == 'E')
        {
            custId = 0;
            amount = 0;
        }
        else if (reqType == 'Q')
        {
            custId = Integer.parseInt(splited[1]);
            amount = 0;
        }
        else
        {
            custId = Integer.parseInt(splited[1]);            
            amount = Integer.parseInt(splited[2]);
        }
    }

    public void setReqId(int n)
    {
        this.reqId = n;
    }
    public String getReqId()
    {
        return (Integer.toString(reqId));
    }

    public char getReqType()
    {
        return (this.reqType);
    }
    public int getCustId()
    {
        return (this.custId);
    }
    public int getAmount()
    {
        return (this.amount);
    }

}
