class Customer
{
    private int id;
    private int total;

    Customer(int id)
    {
        this.id = id;
        this.total = 0;
    }

    public int getId()
    {
        return (this.id);
    }
    
    public int getBalance()
    {
        return (this.total);
    }

    public void deposit(int amt)
    {
        total += amt;
    }
    public void withdraw(int amt)
    {
        total = total - amt;
    }
}