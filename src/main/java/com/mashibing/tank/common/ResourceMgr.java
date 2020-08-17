package com.mashibing.tank.common;

import com.mashibing.tank.util.ImageUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {

    public static BufferedImage tankL, tankR, tankU, tankD;
    public static BufferedImage goodTankU, goodTankL, goodTankD, goodTankR;

    static {
        try {
            goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodTankL = ImageUtil.rotateImage(goodTankU, -90);
            goodTankR = ImageUtil.rotateImage(goodTankU, 90);
            goodTankD = ImageUtil.rotateImage(goodTankU, 180);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
