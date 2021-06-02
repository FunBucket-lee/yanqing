package game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Ground {
    //图片
    BufferedImage image;
    //位置
    int x, y;
    //宽高
    int weight, height;

    //初始化地面
    public Ground() throws IOException {
        image = ImageIO.read(getClass().getResource("/resources/ground.png"));
        weight = image.getHeight();
        height = image.getHeight();
        x = 0;
        y = 500;
    }

    //向左一步
    public void step() {
        x--;
        if (x == -109) {
            x=0;
        }
    }
}
