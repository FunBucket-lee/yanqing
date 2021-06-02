package game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Column {
    //图片
    BufferedImage image;

    //位置
    int x, y;
    //宽高
    int weight, height;
    //柱子间隙
    int gap;
    //柱子间距离
    int distance;
    //随机数工具
    Random random = new Random();

    /*
     * 初始化第N个柱子
     * */
    public Column(int n) throws IOException {
        image = ImageIO.read(getClass().getResource("/resources/column.png"));
        weight = image.getWidth();
        height = image.getHeight();
        gap = 144;
        distance = 245;
        x = 550 + (n - 1) * distance;
        y = random.nextInt(218) + 132;
    }

    public void step() {
        x--;
        if (x == -weight / 2) {
            x = distance * 2 - weight / 2;
            y = random.nextInt(218) + 132;
        }
    }
}
