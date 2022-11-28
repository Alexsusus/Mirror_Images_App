import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;


public class Image {


    public static void flip(File input, File output) {
        try {
            BufferedImage image = ImageIO.read(input);
            int width = image.getWidth();
            int height = image.getHeight();
            BufferedImage flipped = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    flipped.setRGB((width-1) - x,y,image.getRGB(x,y));

                }

            }
            ImageIO.write(flipped,"jpg",output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}