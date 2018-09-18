import java.util.*;
public class Cart
{
    private ArrayList<Perishables> perItems;
    private ArrayList<NonPerishables> nonPerItems;
    private ArrayList<Item> items;

    public Cart()
    {
    perItems = new ArrayList<Perishables>();
    items = new ArrayList<Item>();
    nonPerItems = new ArrayList<NonPerishables>();
    }

    public void addPerishable(Item a, float q)
    {
        a.setUnits(q);
        Perishables p = (Perishables) a;
        perItems.add(p);
        items.add(a);
    }

    public void addNonPerishable(Item a, float q)
    {
        a.setUnits(q);
        NonPerishables n = (NonPerishables) a;
        nonPerItems.add(n);
        items.add(a);
    }

    public ArrayList<Perishables> getPerList()
    {
        return perItems;
    }

    public ArrayList<NonPerishables> getNonPerList()
    {
        return nonPerItems;
    }

    public ArrayList<Item> getItems()
    {
        return items;
    }
    
}