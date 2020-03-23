package map.tile;

import graphics.Screen;
import graphics.Sprite;

public class VoidTile extends Tile {
    
    public VoidTile(Sprite sprite) {
        super(sprite);
    }
    
    @Override
    public void draw(int x, int y, Screen screen) {
        screen.drawTile(x, y, this);
    }
}
