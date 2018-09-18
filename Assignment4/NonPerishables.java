public class NonPerishables extends Item
{
    private float volumePerUnit;


    public NonPerishables (String id, float cost, float vol)
    {
        super(id, cost);
        volumePerUnit = vol;
    }

    public float getTotalVolume()
    {
        return (volumePerUnit * super.getUnits());
    }

    @Override
    public boolean isPerishable()
    {
        return false;
    }
}