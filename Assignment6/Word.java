import java.util.*;
class Word implements Comparable<Word>
{
    private String word;
    private int frequency;

    public Word(String s)
    {
        this.word = s;
        this.frequency = 1;
    }

    public String getWord()
    {
        return this.word;
    }

    public int getFreq()
    {
        return frequency;
    }

    public void setFreq(int n)
    {
        frequency = n;
    }

    @Override
    public int compareTo(Word w)
    {
        return word.compareTo(w.getWord());
    }

    @Override
    public boolean equals(Object w)
    {
        if (w == this) 
        {
            return true;
        }

        if ( !(w instanceof Word))
        {
            return false;
        }

        Word w1 = (Word)w;
        return word.equals(w1.getWord());
        
    }

    @Override
    public int hashCode()
    {
        return word.hashCode();
    }

    

}