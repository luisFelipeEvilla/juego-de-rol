
package graphics;

public final class Sprite {
    private final int size;

    public int getSize() {
        return size;
    }
    
    private int x;
    private int y;
    
    public int[] pixels;
    private final SpritesSheet sheet;
    
    // Sprites collection
        public static final Sprite VOID = new Sprite(32, 0); // black tile
        public static final Sprite ASPHALT = new Sprite(32, 0, 0, SpritesSheet.desert);
    
    // collection end

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
    
    public Sprite(final int size, final int color) {
        this.size = size;
        this.sheet = null;
        
        pixels = new int[size * size];
        
        for(int i = 0; i < pixels.length; i++) {
            pixels[i] = color;
        }
    }
}
