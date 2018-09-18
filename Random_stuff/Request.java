class Request
{
    private int reqId;
    private char reqType;
    private int custId;
    private int amount;

    Request(String s, int n)
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