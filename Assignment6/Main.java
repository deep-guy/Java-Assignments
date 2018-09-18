import java.util.*;
class Main
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        in.close();
        Analyzer analyzer = new Analyzer(s2);
        analyzer.addReserved(s1);
        ArrayList<Word> out = analyzer.inOrder();
        // System.out.println("");
        for (Word w1 : out)
        {
            System.out.print(w1.getWord() + " ");
        }
        System.out.println("");

        out = analyzer.lexicographicOrder();
        for (Word w1 : out)
        {
            System.out.print(w1.getWord() + " ");
        }
        System.out.println("");

        out = analyzer.lengthOrder();
        for (Word w1 : out)
        {
            System.out.print(w1.getWord() + " ");
        }
        System.out.println("");

        out = analyzer.freqOrder();
        for (Word w1 : out)
        {
            System.out.print(w1.getWord() + " ");
        }
        System.out.println("");

        ArrayList<String> ans = analyzer.alphabetFrequency();
        for(String s : ans)
        {
            System.out.println(s);
        }

        out = analyzer.reservedInOrder();
        for (Word w1 : out)
        {
            System.out.print(w1.getWord() + " ");
        }
        System.out.println("");

        out = analyzer.reservedFreqOrder();
        for (Word w1 : out)
        {
            System.out.print(w1.getWord() + " ");
        }
        System.out.println("");
    }
}