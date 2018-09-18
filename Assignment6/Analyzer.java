import java.util.*;

class Analyzer
{
    private ArrayList<Word> input = new ArrayList<Word>();
    private ArrayList<Word> reserved = new ArrayList<Word>();

    public Analyzer(String s)
    {
        String[] temp = s.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        for (String k : temp)
        {
            k.toLowerCase();
            {    
                Word t = new Word(k);
                input.add(t);
            }
        }
    }

    public void addReserved(String s)
    {
        String[] temp = s.split("\\s+");
        for(String k : temp)
        {
            Word t = new Word(k);
            reserved.add(t);
        }
    }

    public void calculateFrequency()
    {
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (Word w : input)
        {
            Integer j = map.get(w.getWord());
            map.put(w.getWord(), (j == null) ? 1 : j + 1);
        }

        for (Word w : input)
        {
            w.setFreq(map.get(w.getWord()));
        }
    }

    public ArrayList<Word> inOrder()
    {
        LinkedHashSet<Word> s = new LinkedHashSet<Word>(input);
        ArrayList<Word> ans = new ArrayList<Word>(s);
        return ans;
    }

    public ArrayList<Word> lexicographicOrder()
    {
        Set<Word> s = new HashSet<Word>(input);
        ArrayList<Word> ans = new ArrayList<>(s);
        Collections.sort(ans, new LexComparator());
        return ans;
    }

    public ArrayList<Word> lengthOrder()
    {
        Set<Word> s = new HashSet<Word>(input);
        ArrayList<Word> ans = new ArrayList<>(s);
        Collections.sort(ans, new LenComparator());
        return ans;
    }

    public ArrayList<Word> freqOrder()
    {
        this.calculateFrequency();
        Set<Word> s = new LinkedHashSet<Word>(input);
        ArrayList<Word> ans = new ArrayList<>(s);
        Collections.sort(ans, new FreqComparator(1));
        return ans;
    }



    public ArrayList<String> alphabetFrequency()
    {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (Word w : input)
        {
            Integer j = map.get(w.getWord().charAt(0));
            map.put(w.getWord().charAt(0), (j == null) ? 1 : j + 1);
        }

        ArrayList<String> ans = new ArrayList<String>();

        for (Word w : input)
        {
            if (map.get(w.getWord().charAt(0)) != 0)
            {
                ans.add(w.getWord().charAt(0) + " " + Integer.toString(map.get(w.getWord().charAt(0))));
                map.put(w.getWord().charAt(0), 0);
            }
        }
        ans.sort(null);
        return ans;
    }

    public ArrayList<Word> reservedFreqOrder()
    {
        this.calculateFrequency();
        Set<Word> s = new LinkedHashSet<Word>(input);
        ArrayList<Word> ans = new ArrayList<>(s);
        ans.retainAll(reserved);
        Collections.sort(ans, new FreqComparator(-1));
        return ans;
    }

    public ArrayList<Word> reservedInOrder()
    {
        Set<Word> s = new LinkedHashSet<Word>(input);
        ArrayList<Word> ans = new ArrayList<>(s);
        ans.retainAll(reserved);
        return ans;
    }

}