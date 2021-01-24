package schumiwilde.projects.Score;

public class ScoreProxy implements StageScore
{
    private Score score;
    public ScoreProxy()
    {
        score=new Score();
    }
    public int getScore()
    {
        return score.getScore();
    }
    public void newStage()
    {
        score=new Score();
    }
    public int getNormalEnemyKillCount()
    {
        return score.getNormalEnemyKillCount();
    }
    public int getEliteKillCount()
    {
        return score.getEliteKillCount();
    }
    public int getCommanderKillCount()
    {
        return score.getCommanderKillCount();
    }
    public boolean isBossKilled()
    {
        return score.isBossKilled();
    }

    public void changeScore(int points)
    {
        score.changeScore(points);
    }
    public void changeKillCount(int normalenemies,int elites,int commanders)
    {
        score.changeKillCount(normalenemies, elites, commanders);
    }
    public void killTheBoss()
    {
        score.killTheBoss();
    }
    public Score getStageScore()
    {
        return score;
    }
}
