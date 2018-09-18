public class Test1
{
    public static void main (String args[])
    {
        int N = 10;
        int M = 100000;
        int[][] boxes = new int[N][];
        for(int i = 0; i <= N; i++)
        {
            int[] box = new int[M];
            boxes[i] = box; //On commenting out this line, the program starts working again. Read "Garbage Collection"
        }
    }
}