import java.util.*;
public class Hello 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int a =in.nextInt();
        System.out.println(a);

        
        in.close();
        int[] arr = new int[5];
        for(int i = 0; i<5; i++)
        {
            arr[i] = i;
            System.out.println(arr[i]);
        }
        System.out.println(arr);
        System.out.println(Arrays.toString(arr));
    }
}
