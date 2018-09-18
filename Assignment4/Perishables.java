public class Perishables extends Item
{
    // private float volumePerUnit;


    public Perishables (String id, float cost)
    {
        super(id, cost);
        // volumePerUnit = vol;
    }

    // public float getTotalVolume(float units)
    // {
    //     return (volumePerUnit * units);
    // }

    @Override
    public boolean isPerishable()
    {
        return true;
    }
}