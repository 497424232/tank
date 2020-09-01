package com.mashibing.tank;

import com.mashibing.tank.common.ResourceMgr;

import java.awt.*;

public class Tank {
    private int x;
    private int y;
    private int TANK_WIDTH = 50;
    private int TANK_HEIGHT = 50;
    private final int speed = 10;
    Dir dir = Dir.Down;

    private boolean isMoving = false;

    private TankFrame tankFrame = null;

    public Tank(int x, int y, Dir dir, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {
        switch (this.dir) {
            case Up:
                g.drawImage(ResourceMgr.tankU, x, y, null);
                break;
            case Left:
                g.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case Down:
                g.drawImage(ResourceMgr.tankD, x, y, null);
                break;
            case Right:
                g.drawImage(ResourceMgr.tankR, x, y, null);
                break;
            default:
                break;
        }

        move();
    }

    private void move() {
        if (!isMoving) {
            return;
        }

        if (this.dir == Dir.Left) {
            x -= speed;
        } else if (this.dir == Dir.Right) {
            x += speed;
        } else if (this.dir == Dir.Up) {
            y -= speed;
        } else if (this.dir == Dir.Down) {
            y += speed;
        }
    }

    public void fire() {
        tankFrame.bullets.add(new Bullet(this.x, this.y, this.dir, this.tankFrame));
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }
}
