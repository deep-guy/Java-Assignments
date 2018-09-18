import java.util.*;

class Assignment4
{
    public static void main(String args[])
    {
        Packer packer = new Packer(5.0f, 5.0f, 4.0f, 2.0f);
        Biller biller = new Biller();
        Store store = new Store(biller, packer);
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        while (true)
        {
            if(str.trim().equals("End"))
            {
                // System.out.println("#########");
                break;
            }
            else
            {
                store.addItem(str);
                str = in.nextLine();    
            }
        }
        // System.out.println("#########");
        Cart cart = new Cart();

       while (true)
       {
           str = in.nextLine();
           if (str.trim().equals("Checkout"))
           {
               break;
           }
           else
           {
               String order[] = str.split("\\s+");
               Item sel = store.getItem(order[0]);
               if (sel.isPerishable())
               {
                   cart.addPerishable(sel, Float.parseFloat(order[1]));
               }
               else
               {
                   cart.addNonPerishable(sel, Float.parseFloat(order[1]));
               }
           }
       }
       in.close();

       System.out.println(store.getBiller().printBill(cart, store.getPacker()));
    }
}
