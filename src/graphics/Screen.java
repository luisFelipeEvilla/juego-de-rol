
package graphics;

public class Screen {
    private final int width;
    private final int height;
    
    public final int[] pixels;
    
    // temporal
    private final static int SPRITE_SIZE = 32;
    private final static int SPRITE_MASK = SPRITE_SIZE-1;
    // temporal end
    
    public Screen(final int width,final int height) {
        this.width = width;
        this.height = height;
    
        pixels = new int[width * height];
    }
    
    public void clean() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }
    //compensations are the movements(x,y) of the player
    public void draw(final int compensationX, final int compensationY) {
        for (int y = 0; y < height; y++) {
            int positiony = y + compensationY;
            
            if( positiony < 0 || positiony >= height) {
                continue;
            }
            
            for (int x = 0; x < width; x ++) {
                int positionX = x + compensationX;
            
                if( positionX < 0 || positionX >= width) {
                    continue;
                }
                // temporal
                pixels[positionX + positiony * width] = Sprite.asphalt.pixels[(x & SPRITE_MASK) + (y & SPRITE_MASK) * SPRITE_SIZE];
            }
        }
    }
}
