import java.util.*;
public class Biller
{
    private String output;
    public float total;

    public Biller()
    {
        output = "";
        total = 0;
    }

    public String printBill(Cart c1, Packer p1)
    {
        ArrayList<Item> items = c1.getItems();
        for (int i = 0; i < items.size(); i++)
        {
            float cost = items.get(i).getCost();
            if (cost != 0)
            {
                output += items.get(i).getId() + " " + Float.toString(items.get(i).getUnits()) + " " + Float.toString(cost) + "\n";
                total += cost;
            }
        }

        total += p1.getShippingCost(c1);
        output += "Shipping " + Float.toString(p1.getShippingCost(c1)) + "\n";
        output += "Total " + Float.toString(total);

        return output;
    }
}