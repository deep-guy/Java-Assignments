class FlightSimple extends Game
{
    private int altitude;
    private int speed;
    private boolean speedbool = false;
    private boolean altbool = false;

    public FlightSimple(String name)
    {
        super(name);
        altitude = 0;
        speed = 0;
    }

    public String handleKeyPress(char c)
    {
        if (super.getNoOfSteps() < super.getTotalSteps() && super.getFinalStatus() == 2)
        {
            if (c == 'R')
            {
                speed ++;
                speedbool = true;
            }
            else if (c == 'L')
            {
                if (speed != 0)
                    speed --;
            }
            if (c == 'U')
            {
                if (speed > 2)
                {
                    altitude ++;
                    altbool = true;
                }
            }
            if (c == 'D')
            {
                altitude --;
            }
        }
        super.incrementNoOfSteps();

        if (speed == 0 && altitude > 0)
        {
            super.setFinalStatus(1);
        }
        else if (altitude < 0)
        {
            super.setFinalStatus(1);
        }
        else if (altitude == 0 && speed == 0 && (speedbool || altbool))
        {
            super.setFinalStatus(0);
        }
        else
        {
            super.setFinalStatus(2);
        }

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
            return "None";
        }
    }

    public void reset()
    {
        super.resetState();
        altbool = false;
        speedbool = false;
        altitude = 0;
        speed = 0;
    }
}