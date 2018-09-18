import java.util.Comparator;
public class LexComparator implements Comparator<Word>
{
    public LexComparator(){}
    @Override
    public int compare(Word w1, Word w2)
    {
        return w1.getWord().compareTo(w2.getWord());
    }
}