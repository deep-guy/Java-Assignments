import java.util.*;

import javax.lang.model.util.ElementScanner6;

class Test1
{
    public static void main(String[] args)
    {
        Network myNetwork = new Network("Network-1");
        Scanner in = new Scanner(System.in);
        int noOfPhones = in.nextInt();
        // System.out.println(noOfPhones);
        for(int i = 0; i < noOfPhones; i++)
        {
            int temp = in.nextInt();
            Phone tempPhone = new Phone(temp);
            myNetwork.AttachPhone(tempPhone);
        }
        in.nextLine();
        String s = "";
        while(true)
        {
            s = in.nextLine();
            if (s.compareTo("End") == 0)
            {
                System.out.print(myNetwork.getOutput());
                in.close();
                System.exit(0);
            }
            Request r = new Request(s);
            myNetwork.processRequest(r);
        }

    }
}

class Network
{
    private ArrayList<Phone> phoneList;
    private String id;
    private String output;
    public Network(String s)
    {
        id = s;
        phoneList = new ArrayList<Phone>();
        output = "";
    }

    public void AttachPhone(Phone p)
    {
        phoneList.add(p);
    }

    public void processRequest(Request req)
    {
        Phone caller = null;
        Phone callee = null;
        // if (req.getCalledPhoneNum() == -1)
        // {
        //     callee = null;
        // }
        for(int i = 0; i < phoneList.size(); i++)
        {
            if(phoneList.get(i).getNumber() == req.getCallingPhoneNum())
            {
                caller = phoneList.get(i);
            }
            else if(phoneList.get(i).getNumber() == req.getCalledPhoneNum())
            {
                callee = phoneList.get(i);
            }
        }

        if(req.getRequestType().compareTo("Call") == 0)
        {
            if (caller.getStatus() == 'b')
            {
                output += "Not Available\n";
            }
            else if (callee.getStatus() == 'b')
            {
                output += "Calling " + Integer.toString(callee.getNumber()) + "\nBusy\n";
            }
            else
            {
                output += "Calling " + Integer.toString(callee.getNumber()) + "\nConnected\n";
                caller.setStatus('b');
                callee.setStatus('b');
            }
        }

        else if(req.getRequestType().compareTo("Hangup") == 0)
        {
            if (caller.getStatus() == 'a')
            {
                output += "Not Available\n";
            }
            else
            {
                output += "Disconnected\n";
                caller.setStatus('a');
            }
            
        }

    }

    public String getOutput()
    {
        return output;
    }
}

class Phone
{
    private int phoneNumber;
    private char status;

    public Phone(int no)
    {
        phoneNumber = no;
        status = 'a';
    }

    public int getNumber()
    {
        return this.phoneNumber;
    }

    public char getStatus()
    {
        return this.status;
    }
    public void setStatus(char c)
    {
        this.status = c;
    }

}

class Request
{
    private int callingPhoneNum;
    private int calledPhoneNum;
    private String requestType;
    public Request(String s)
    {
        String[] splited = s.split("\\s+");
        this.requestType = splited[0];
        callingPhoneNum = Integer.parseInt(splited[1]);
        if (requestType.compareTo("Call") == 0)
            calledPhoneNum = Integer.parseInt(splited[2]);
        else
            calledPhoneNum = -1;
    }

    public int getCallingPhoneNum()
    {
        return this.callingPhoneNum;
    }
    public int getCalledPhoneNum()
    {
        return this.calledPhoneNum;
    }
    public String getRequestType()
    {
        return this.requestType;
    }
}