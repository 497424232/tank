

import static org.junit.Assert.assertNotNull;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;
//import org.junit.jupiter.api.Test;

class ImageTest {

    @Test
    void test() {

        try {
//            BufferedImage image = ImageIO.read(new File("C:/work/javaprojects/Tank_60/src/images/bulletD.gif"));
            BufferedImage image = ImageIO.read(new File("/Users/cmk/Pictures/IMG_0001.JPG"));
            assertNotNull(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
