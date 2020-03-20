
package graphics;

public final class Sprite {
    private final int size;
    
    private int x;
    private int y;
    
    public int[] pixels;
    private final SpritesSheet sheet;
    
    public Sprite(final int size, final int col, final int row, final SpritesSheet sheet) {
        this.size = size;
        
        this.pixels = new int [size * size];
        
        this.x = col * size;
        this.y = row * size;
        this.sheet = sheet;
        
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                pixels[x + y * size] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.getWIDTH()];
            }
        }
    }
}
