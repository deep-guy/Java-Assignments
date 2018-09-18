import java.util.Comparator;

public class FreqComparator implements Comparator<Word>
{
    private int type;

    public FreqComparator(int order)
    {
        this.type = order;
    }
    @Override
    public int compare(Word w1, Word w2)
    {
        int diff = w1.getFreq() - w2.getFreq();
        return type*diff;
    }
}