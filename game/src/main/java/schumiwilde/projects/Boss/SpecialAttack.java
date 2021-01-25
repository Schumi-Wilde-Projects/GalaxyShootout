package schumiwilde.projects.Boss;
import java.util.Random;
public class SpecialAttack implements BossMovment{
    int time=6,attacks=0;
    public SpecialAttack()
    {

    }
    @Override
    public void move(Boss boss) {
        if(boss.getY()<768 && time==6)
            boss.setY(boss.getY()+10);
        else
            if(time==6)
            {
                time=5;
                boss.setX(new Random().nextInt(874)+50);
            }
            else
            {
                if(boss.getY()>668)
                boss.setY(boss.getY()-10);
                else
                    time--;
            }
        if(time==0)
        {
            time=6;
            attacks++;
        }
        if(attacks==5)
            boss.setMovement(new NormalMovement());
    }
}
