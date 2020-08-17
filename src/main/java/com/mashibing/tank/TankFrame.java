package com.mashibing.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {

    static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;


    Tank myTank = new Tank(200, 200, Dir.Down, this);

    List<Bullet> bullets = new ArrayList<Bullet>();

    public TankFrame() {
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setTitle("tank");
        this.setVisible(true);
        this.setResizable(false);

        this.addKeyListener(new MyKeyListener());

        this.addWindowListener(new WindowAdapter() {
            // 重写方法退出窗口
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    Image offScreenImage = null;

    /**
     * 解决双缓冲区导致界面闪烁问题
     * @param g
     */
    @Override
    public void update(Graphics g) {
        if(offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }


    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量:" + bullets.size(), 10, 60);
        g.setColor(c);

        // 绘制我的坦克
        myTank.paint(g);

        // 绘制子弹
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);

        }
    }

    /**
     * 定义匿名内部类键盘监听事件
     */
    class MyKeyListener extends KeyAdapter {

        private boolean bL;
        private boolean bR;
        private boolean bU;
        private boolean bD;

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }

            setDirection();

        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;

                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                    break;
                default:
                    break;
            }
        }

        private void setDirection() {
            // 判断是否运动状态
            if (!bL && !bR && !bU && !bD) {
                myTank.setMoving(false);
            } else {
                myTank.setMoving(true);
                if (bL) myTank.setDir(Dir.Left);
                if (bR) myTank.setDir(Dir.Right);
                if (bU) myTank.setDir(Dir.Up);
                if (bD) myTank.setDir(Dir.Down);
            }
        }
    }
}
