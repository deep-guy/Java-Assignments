import java.util.*;
class Assignment2
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] drawOrder = new int[num];
        int[][] priority = new int[num][num];
        for(int i = 0; i < (num); i++)
        {
            for(int j = 0; j < num; j++)
            {
                priority[i][j] = in.nextInt();
            }
        }
        for(int i = 0; i < num; i++)
        {
            drawOrder[i] = in.nextInt() - 1;
        }
        in.close();
        Team[] teamList = new Team[num];
        for(int i = 0; i < num; i++)
        {
            teamList[i] = new Team(i);
        }
        Tournament tourn1 = new Tournament(priority, drawOrder, teamList);
        tourn1.generateOutput();
        System.out.print(tourn1.getOutput());
    }
}

class Team
{
    private int id;
   // private String name;
    //constructor
    Team(int n/* ,String nam*/)
    {
        this.id = n;
       // this.name = nam;
    }

    //getters
    public int getId()
    {
        return this.id;
    }
    // public String getName()
    // {
    //     return this.name;
    // }

    //setters
    public void setId(int n)
    {
        this.id = n;
    }
    // public void setName(String s)
    // {
    //     this.name = s;
    // }
}

class Match
{
    private Team t1;
    private Team t2;
    private Team win;
    
    Match(Team a1, Team a2)
    {
        this.t1 = a1;
        this.t2 = a2;      
    }

    public Team getWinner(int[][] priority)
    {
        int versus = priority[this.t1.getId()][this.t2.getId()];
        if (versus == -1 || versus == 0)
        {
            this.win = this.t1;
        }
        else if (versus == 1)
        {
            this.win = this.t2;
        }
        return this.win;
    }

        
}


class Tournament
{
    private int[][] priority;
    private int[] drawOrder;
    private Team[] teamList;
    private String output;
    
    //constructors, getters setters
    Tournament(int[][] pri, int[] draw, Team[] tl)
    {
        this.priority = pri;
        this.drawOrder = draw;
        this.teamList = tl;
        this.output = "";
    }

    public void generateOutput()
    {
        int l = this.drawOrder.length;
        int count = 1;
        while (l != 1)
        {
            this.output += "Round "+count+" winners: ";
            count ++;
            l = l/2;
            int[] teams = new int[l];
            for (int i = 1; i <= l; i++)
            {
                Team t1 = teamList[drawOrder[(i*2)-2]];
                Team t2 = teamList[drawOrder[(i*2)-1]];
                Match m = new Match(t1, t2);
                teams[i-1] = m.getWinner(this.priority).getId();
                this.output += (teams[i - 1] + 1) + " ";
            }
            this.output += "\n";
            this.drawOrder = teams;
        }
    }
    public String getOutput()
    {
        return this.output;
    }
}