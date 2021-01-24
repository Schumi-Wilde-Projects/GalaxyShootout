package schumiwilde.projects.Score;

public interface StageScore {
    public int getScore();
    public int getNormalEnemyKillCount();
    public int getEliteKillCount();
    public int getCommanderKillCount();
    public boolean isBossKilled();

    public void changeScore(int points);
    public void changeKillCount(int normalenemies,int elites,int commanders);
    public void killTheBoss();
}
