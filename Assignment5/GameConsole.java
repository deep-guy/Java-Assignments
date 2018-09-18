import java.util.*;
public class GameConsole
{
    private String output;
    private ArrayList<Game> games;
    public Game currentGame;
    public GameConsole()
    {
        output = "";
        games = new ArrayList<Game>();
    }

    public void addGame(Game g)
    {
        games.add(g);
    }

    public void selectGame(String game, int steps)
    {
        for (int i = 0; i < games.size(); i++)
        {
            if (games.get(i).getName().equals(game))
            {
                this.currentGame = games.get(i);
                currentGame.reset();
                currentGame.startGame(steps);
            }
        }
    }

    public void sendCommand(char c)
    {
        String s = currentGame.handleKeyPress(c);
        if (s.equals("None") == false)
        {
            output = currentGame.getName() + ": " + s + "\n";
        }
    }

    public String getOutput()
    {
        String s = output;
        output = "";
        return s;
    }
}