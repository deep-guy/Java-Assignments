import java.util.ArrayList;

public class Store
{
    private ArrayList<Perishables> pitems;
    private ArrayList<NonPerishables> npitems;
    private Biller biller;
    private Packer packer;

    public Store(Biller b, Packer p)
    {
        biller = b;
        packer = p;
        pitems = new ArrayList<Perishables>();
        npitems = new ArrayList<NonPerishables>();
    }

    public void addItem(String s)
    {
        String item[] = s.split("\\s+");
        if (item.length == 2)
        {
            Perishables p = new Perishables(item[0], Float.parseFloat(item[1]));
            pitems.add(p);
        }
        else if (item.length == 3)
        {
            NonPerishables np = new NonPerishables(item[0], Float.parseFloat(item[1]), Float.parseFloat(item[2]));
            npitems.add(np);
        }
    }

    public Item getItem(String id)
    {
        for (int i = 0; i < pitems.size(); i++)
        {
            if (pitems.get(i).getId().equals(id))
            {
                return pitems.get(i);
            }
        }
        for (int i = 0; i < npitems.size(); i++)
        {
            if (npitems.get(i).getId().equals(id))
            {
                return npitems.get(i);
            }
        }
        return null;
    }

    public Biller getBiller()
    {
        return biller;
    }

    public Packer getPacker()
    {
        return packer;
    }
}