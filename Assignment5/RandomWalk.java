public class RandomWalk extends Game
{
    private int xpos;
    private int ypos;

    public RandomWalk(String s)
    {
        super(s);
        xpos = 10;
        ypos = 10;
    }

    public String handleKeyPress(char c)
    {
        if (super.getNoOfSteps() < super.getTotalSteps() && super.getFinalStatus() == 2)
        {
            if (c == 'U')
                ypos ++;
            else if (c == 'D')
            {
                ypos --;
            }
            else if (c == 'L')
            {
                if (xpos != 0)
                    xpos --;
            }
            else if (c == 'R')
                xpos ++;
        }
        super.incrementNoOfSteps();

        if (ypos == 0)
            super.setFinalStatus(0);
        else if (xpos > 19 || ypos > 19)
            super.setFinalStatus(1);

        if (super.getNoOfSteps() < super.getTotalSteps())
        {
            return "None";
        }
        else
        {
            if (super.getFinalStatus() == 1)
            {
                return "Lost";
            }
            else if (super.getFinalStatus() == 2)
            {
                return "Game Over";
            }
            else if (super.getFinalStatus() == 0)
            {
                return "Won";
            }
            else
                return "None";
        }
    }

    public void reset()
    {
        super.resetState();
        xpos = 10;
        ypos = 10;
    }
}