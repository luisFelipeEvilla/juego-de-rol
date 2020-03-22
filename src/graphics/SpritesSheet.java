package graphics;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class SpritesSheet {
    private final int WIDTH;
    private final int HEIGHT;
    public final int[] pixels;

    // spriteSheets collection
        public static SpritesSheet desert = new SpritesSheet("/textures/desert.png", 320, 320);
    
    // end collection

    public SpritesSheet(final String path, final int width, final int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.pixels = new int[WIDTH * HEIGHT];
        
        try {
            BufferedImage image = ImageIO.read(SpritesSheet.class.getResource(path));
            image.getRGB(0, 0, WIDTH, HEIGHT, pixels, 0, WIDTH);
        } catch (IOException ex) {
            Logger.getLogger(SpritesSheet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getWIDTH() {
        return WIDTH;
    }
}
