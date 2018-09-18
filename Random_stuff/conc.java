public class conc
{
    public static void main(String args[])
    {
        String[] sentence = {"This", "is", "a", "short", "sentence"};
        String temp = "";
        for(int i = 0; i<5; i++)
        {
            temp += sentence[i] + " " ;
        }
        System.out.println(temp);
    }
}