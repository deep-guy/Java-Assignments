public class Packer
{
    float freePer;
    float perRate;
    float freeNonPer;
    float nonPerRate;

    public Packer(float f1, float r1, float f2, float r2)
    {
        freePer = f1;
        freeNonPer = f2;
        perRate = r1;
        nonPerRate = r2;
    }

    public float getShippingCost(Cart c1)
    {
        float shipping;
        float totwt = 0.0f;
        float totvol = 0.0f;
        for (int i = 0; i < c1.getPerList().size(); i++)
        {
            totwt += c1.getPerList().get(i).getUnits();
        }
        for (int i = 0; i < c1.getNonPerList().size(); i++)
        {
            totvol += c1.getNonPerList().get(i).getTotalVolume();
        }
        // System.out.println(Float.toString(totwt) + "weight");
        // System.out.println(Float.toString(totvol) + "volume");

        if (totwt <= freePer)
            totwt = 0.0f;
        else
        {
            totwt -= freePer;
        }
        if (totvol <= freeNonPer)
            totvol = 0.0f;
        else    
            totvol -= freeNonPer;

        shipping = (perRate * totwt) + (nonPerRate * totvol);
        return shipping;
    }
}