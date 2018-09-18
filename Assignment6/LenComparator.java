import java.util.Comparator;

public class LenComparator implements Comparator<Word>
{

    public LenComparator(){}
    @Override
    public int compare(Word w1, Word w2)
    {
        int diff = w1.getWord().length() - w2.getWord().length();
        if(diff != 0)
            return diff;
        else
        {
            LexComparator ls = new LexComparator();
            return ls.compare(w1, w2);
        }
    }
}