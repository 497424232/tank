package com.mashibing.tank;

import java.awt.*;

public class Bullet {

    private int x;
    private int y;
    private int BULLET_WIDTH = 30;
    private int BULLET_HEIGHT = 30;
    private final int speed = 4;
    Dir dir = Dir.Down;
    private boolean isLiving = true;
    private TankFrame tankFrame = null;

    public Bullet(int x, int y, Dir dir, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {
        if (!isLiving) {
            tankFrame.bullets.remove(this);
        }

        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, BULLET_WIDTH, BULLET_WIDTH);
        g.setColor(color);

        move();
    }

    private void move() {

        if (this.dir == Dir.Left) {
            x -= speed;
        } else if (this.dir == Dir.Right) {
            x += speed;
        } else if (this.dir == Dir.Up) {
            y -= speed;
        } else if (this.dir == Dir.Down) {
            y += speed;
        }

        if (x < 0 || x > TankFrame.GAME_WIDTH || y < 0 || y > TankFrame.GAME_HEIGHT) {
            isLiving = false;
        }
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
