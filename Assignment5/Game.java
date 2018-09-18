abstract public class Game
{
    private String name = "";
    //private int gameState;
    private int totalSteps;
    private int noOfSteps;
    private int finalStatus = 2; // 0 for won, 1 for lost, 2 for gameover state
    private String output = "";

    public Game(String name)
    {
       this.name = name;
    //    gameState = 0; 
    }

    public String getName()
    {
        return this.name;
    }

    public void startGame(int steps)
    {
        // this.gameState = 1;
        this.totalSteps = steps;
    }

    abstract public String handleKeyPress(char ch);

    public void incrementNoOfSteps()
    {
        this.noOfSteps +=1 ;
    }

    public int getNoOfSteps()
    {
        return noOfSteps;
    }

    public int getTotalSteps()
    {
        return totalSteps;
    }

    public int getFinalStatus()
    {
        return finalStatus;
    }

    public void setFinalStatus(int a)
    {
        finalStatus = a;
    }

    protected void resetState()
    {
        noOfSteps = 0;
        totalSteps = 0;
        finalStatus = 2;
        output = "";
    }

    abstract public void reset();

}