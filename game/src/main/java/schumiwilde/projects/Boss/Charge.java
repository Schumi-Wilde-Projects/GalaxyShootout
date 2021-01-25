package schumiwilde.projects.Boss;

public class Charge implements BossMovment{
    public Charge()
    {

    }
    @Override
    public void move(Boss boss) {
        if(boss.getVY()==0)
            boss.setVY(10);
        boss.setY(boss.getY() - boss.getVY());
        if(boss.getY()<0)
        {
            boss.setY(600);
            boss.setMovement(new NormalMovement());
        }
    }
}
