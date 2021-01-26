package schumiwilde.projects.stages;

import com.badlogic.gdx.math.Vector2;
import schumiwilde.projects.EnemyShips.EnemyShip;
import schumiwilde.projects.player.Player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stage {
    private final List<EnemyShip> enemyShips;

    private static class EnemyShipIterator implements Iterator<EnemyShip> {

        private final List<EnemyShip> enemyShips;
        private int currentIndex;

        public EnemyShipIterator(List<EnemyShip> enemyShips) {
            this.enemyShips = enemyShips;
            currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < enemyShips.size() - 1;
        }

        @Override
        public EnemyShip next() {
            EnemyShip e = enemyShips.get(currentIndex);
            currentIndex++;
            return e;
        }
    }

    public Stage() {
        enemyShips = new ArrayList<>();
    }

    public void spawnEnemy(EnemyShip enemy) {
        enemyShips.add(enemy);
    }

    public void hurtEnemyOnSpot(Player player, int x, int y) {
        for(EnemyShip e: enemyShips) {
            if(e.getBoundingRectangle().contains(new Vector2(x, y))) {
                e.damage(player.getWeapon().getDamage());
                if(e.getHP() <= 0) {
                    killEnemy(e);
                }
            }
        }
    }

    public Iterator<EnemyShip> getEnemies() {
        return new EnemyShipIterator(enemyShips);
    }

    private void killEnemy(EnemyShip enemy) {
        enemyShips.remove(enemy);
    }

    public boolean isStageClear() {
        return enemyShips.isEmpty();
    }
}
