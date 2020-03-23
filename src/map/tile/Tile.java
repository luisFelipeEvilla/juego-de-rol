package map.tile;

import graphics.Screen;
import graphics.Sprite;

public class Tile {
    public int width;
    public int heigth;
    
    public static final int SIZE = 32;
    
    public Sprite sprite;
    
    // Tiles collection
    public static final Tile VOID = new VoidTile(Sprite.VOID);
    public static final Tile ASPHALT = new AsphaltTile(Sprite.ASPHALT);
    // end of collection
    
    public Tile(Sprite sprite) {
        this.sprite = sprite;
    }
    
    public void draw(int x, int y, Screen screen) { 
        screen.drawTile(x << 5, y << 5, this);
    }
    
    public boolean solid() {
        return false;
    }
}
