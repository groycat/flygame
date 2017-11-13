package cn.lazycat.fly.obj.boss;

import cn.lazycat.fly.flag.Award;
import cn.lazycat.fly.flag.Boss;
import cn.lazycat.fly.flag.Enemy;
import cn.lazycat.fly.obj.bullet.BossBullet;
import cn.lazycat.fly.FlyGame;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Boss3 extends Boss implements Enemy {

    public Boss3(int level) {
        super.image = FlyGame.boss3;
        super.speed = 2;
        super.health = 80 * level;
        super.width = image.getWidth();
        super.height = image.getHeight();
    }

    @Override
    public int getScore() {
        return 1000;
    }

    @Override
    public int getHit() {
        return 5;
    }

    @Override
    public List<BossBullet> shoot() {
        Random random = new Random();
        int y = super.y + 40;
        List<BossBullet> bossBullets = new LinkedList<>();
        int num = random.nextInt(4);
        bossBullets.add(new BossBullet(1, 1, FlyGame.bossBullet1, random.nextInt(FlyGame.WIDTH), y));
        if (num <= 2) {
            bossBullets.add(new BossBullet(2, 2, FlyGame.bossBullet2, random.nextInt(FlyGame.WIDTH), y));
        }

        return bossBullets;
    }

    @Override
    public int getType() {
        return Award.SPEED_HIGH;
    }
}
