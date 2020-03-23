package graphics;

import map.tile.Tile;

public class Screen {

    private final int width;
    private final int height;

    private int differenceX;
    private int differenceY;
    
    public final int[] pixels;

    // temporal
    private final static int SPRITE_SIZE = 32;
    private final static int SPRITE_MASK = SPRITE_SIZE - 1;
    // temporal end

    public Screen(final int width, final int height) {
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

            if (positiony < 0 || positiony >= height) {
                continue;
            }

            for (int x = 0; x < width; x++) {
                int positionX = x + compensationX;

                if (positionX < 0 || positionX >= width) {
                    continue;
                }
                // temporal
                pixels[positionX + positiony * width] = Sprite.ASPHALT.pixels[(x & SPRITE_MASK) + (y & SPRITE_MASK) * SPRITE_SIZE];
            }
        }
    }

    public void drawTile(int compensationX, int compensationY, Tile tile) {
        compensationX -= differenceX;
        compensationY -= differenceY;
        
        for (int y = 0; y < tile.sprite.getSize(); y++) {
            int positionY = y + compensationY;
            for (int x = 0; x < tile.sprite.getSize(); x++) {
                int positionX = x + compensationX;
                  if (positionX < -tile.sprite.getSize() || positionX >= width || positionY < 0 || positionY >= height ) {
                      break;
                  } 
                  
                  if (positionX < 0) {
                      positionX = 0;
                  }
                  pixels[positionX + positionY * width] = tile.sprite.pixels[x + y * tile.sprite.getSize()];
            }
        }
    }
    
    public void setDifference(final int differenceX, final int differenceY) {
        this.differenceX = differenceX;
        this.differenceY = differenceY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
