import java.util.*;

class Main
{
    public static void main(String[] args)
    {
        GameConsole console = new GameConsole();
        FlightSimple f = new FlightSimple("FlightSimple");
        RandomWalk r = new RandomWalk("RandomWalk");
        console.addGame(f);
        console.addGame(r);
        Scanner in = new Scanner(System.in);
        String s = "";
        String output = "";
        s = in.nextLine();        
        while(s.equals("End") == false)
        {
            String[] gamedet = s.split("\\s+");
            s = in.nextLine();
            int steps = Integer.parseInt(gamedet[1]);
            console.selectGame(gamedet[0], steps);
            String[] commands = s.split("\\s+");
            for(int i = 0; i < steps; i++)
            {
                console.sendCommand(commands[i].charAt(0));
            }
            output += console.getOutput();
            s = in.nextLine();
        }

        System.out.print(output);
    }
}