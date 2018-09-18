public class Item
{
    private float costPerUnit;
    private String itemName;
    private float noOfUnits = 0;

    public Item(String Id, float cost)
    {
        itemName = Id;
        costPerUnit = cost;
    }
    public float getCost()
    {
        return(this.noOfUnits * this.costPerUnit); 
    }

    public void setUnits(float un)
    {
        this.noOfUnits = un;
    }

    public float getUnits()
    {
        return this.noOfUnits;
    }

    public String getId()
    {
        return itemName;
    }

    public boolean isPerishable()
    {
        return false;
    }

}

