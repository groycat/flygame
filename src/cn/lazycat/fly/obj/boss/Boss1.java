package cn.lazycat.fly.obj.boss;


import cn.lazycat.fly.flag.Award;
import cn.lazycat.fly.flag.Boss;
import cn.lazycat.fly.flag.Enemy;
import cn.lazycat.fly.obj.bullet.BossBullet;
import cn.lazycat.fly.FlyGame;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Boss1 extends Boss implements Enemy {

    public Boss1(int level) {
        super.image = FlyGame.boss1;
        super.speed = 1;
        super.health = 20 * level;
        super.width = image.getWidth();
        super.height = image.getHeight();
    }


    @Override
    public int getScore() {
        return 100;
    }

    @Override
    public int getHit() {
        return 1;
    }

    @Override
    public List<BossBullet> shoot() {
        Random random = new Random();
        int y = super.y + 40;
        List<BossBullet> bossBullets = new LinkedList<>();
        BossBullet bossBullet = new BossBullet(1, 1, FlyGame.bossBullet1, random.nextInt(FlyGame.WIDTH),  y);
        bossBullets.add(bossBullet);
        return bossBullets;
    }

    @Override
    public int getType() {
        return Award.SPEED_SLOW;
    }
}
