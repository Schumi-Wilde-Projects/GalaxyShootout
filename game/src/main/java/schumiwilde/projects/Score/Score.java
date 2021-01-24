package schumiwilde.projects.Score;

public class Score implements StageScore
{
    private int score=0;
    private int normalenemykillcount=0;
    private int elitekillcount=0;
    private int commanderkillcount=0;
    private boolean bosskilled=false;

    public int getScore()
    {
        return score;
    }
    public int getNormalEnemyKillCount()
    {
        return normalenemykillcount;
    }
    public int getEliteKillCount()
    {
        return elitekillcount;
    }
    public int getCommanderKillCount()
    {
        return commanderkillcount;
    }
    public boolean isBossKilled()
    {
        return bosskilled;
    }

    public void changeScore(int points)
    {
        score=+points;
    }
    public void changeKillCount(int normalenemies,int elites,int commanders)
    {
        normalenemykillcount=+normalenemies;
        elitekillcount=+elites;
        commanderkillcount=+commanders;
    }
    public void killTheBoss()
    {
        bosskilled=true;
    }
}
