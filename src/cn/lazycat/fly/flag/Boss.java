package cn.lazycat.fly.flag;

import cn.lazycat.fly.obj.bullet.BossBullet;
import cn.lazycat.fly.FlyGame;

import java.util.List;

/**
 * 代表所有Boss的接口
 */
public abstract class Boss extends FlyingObject implements Enemy, Award {

    protected int speed = 1;
    protected int health;

    protected Boss() {
        super.x = 200;  // 从中间入场
        super.y = 0;
    }

    /**
     * Boss发射子弹
     * @return 所有发射的子弹
     */
    public abstract List<BossBullet> shoot();

    @Override
    public boolean isDead() {
        --health;
        return health <= 0;
    }

    @Override
    public void step() {
        if (super.y < 15) {  // 向下入场
            super.y += this.speed;
        } else { // 左右摇摆
            x += speed;
            if (x <= 0) {  // 此时到最左边了
                speed = 1;
            }
            if (x >= FlyGame.WIDTH - this.width) {  // 此时到最右边了
                speed = -1;
            }
        }

    }

    public int getHealth() {
        return health;
    }
}
