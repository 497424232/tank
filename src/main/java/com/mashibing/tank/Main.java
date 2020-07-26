package com.mashibing.tank;

public class Main {

    public static void main(String[] args) throws Exception{
        TankFrame tankFrame = new TankFrame();

        while (true){
            Thread.sleep(100);
           tankFrame.repaint();
        }

    }
}
