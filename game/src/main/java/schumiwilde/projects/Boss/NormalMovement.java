package schumiwilde.projects.Boss;

public class NormalMovement implements BossMovment{
    public NormalMovement()
    {

    }
    @Override
    public void move(Boss boss) {
        if(boss.getVX()==0)
            boss.setVX(10);
        if(boss.getX() + boss.getVX()<=0 || boss.getX() + boss.getVX()>=924)
            boss.setVX(-boss.getVX());

        boss.setX(boss.getX() + boss.getVX());

    }
}
