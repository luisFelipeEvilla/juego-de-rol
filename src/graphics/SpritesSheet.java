package graphics;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class SpritesSheet {
    private final int WIDTH;
    private final int HIGTH;
    public final int[] pixels;

    public SpritesSheet(final String path, final int width, final int HIGTH) {
        this.WIDTH = width;
        this.HIGTH = HIGTH;
        this.pixels = new int[WIDTH * HIGTH];
        
        try {
            BufferedImage image = ImageIO.read(SpritesSheet.class.getResource(path));
            image.getRGB(0, 0, WIDTH, HIGTH, pixels, 0, WIDTH);
        } catch (IOException ex) {
            Logger.getLogger(SpritesSheet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getWIDTH() {
        return WIDTH;
    }
}
