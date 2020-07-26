package com.mashibing.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    Tank myTank = new Tank(200, 200, Dir.Down);

    public TankFrame() {
        this.setSize(800, 600);
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

    @Override
    public void paint(Graphics g) {
        // 绘制我的坦克
        myTank.paint(g);
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
                default:
                    break;
            }
        }

        private void setDirection() {
            if (bL) myTank.setDir(Dir.Left);
            if (bR) myTank.setDir(Dir.Right);
            if (bU) myTank.setDir(Dir.Up);
            if (bD) myTank.setDir(Dir.Down);
        }
    }
}
