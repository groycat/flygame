package cn.lazycat.fly.obj.enemy;

import cn.lazycat.fly.flag.Enemy;
import cn.lazycat.fly.flag.FlyingObject;
import cn.lazycat.fly.FlyGame;

import java.util.Random;

/**
 * 小敌机类
 */
public class Airplane extends FlyingObject implements Enemy {

    private int speed = 2;   // 控制飞机的移动速度

    public Airplane() {
        super.image = FlyGame.airplane;
        // 图片的宽度和高度直接从image获取，而不是固定写死
        super.width = super.image.getWidth();
        super.height = super.image.getHeight();
        // 敌机的初始位置在x方向是随机产生的
        // 下面给出两种生成随机数的方式
        // super.x = (int) (Math.random() * (FlyGame.WIDTH - this.width));
        Random random = new Random();
        super.x = random.nextInt(FlyGame.WIDTH - this.width);
        super.y = -this.height;
    }

    @Override
    public int getScore() {
        return 5;  // 打掉一个小敌机得5分
    }

    @Override
    public boolean isDead() {
        return true;
    }

    @Override
    public int getHit() {
        return 1;
    }

    @Override
    public void step() {
        super.y += this.speed;  // 向下前进
    }
}
