package map;

import graphics.Screen;
import map.tile.Tile;

public abstract class Map {
    protected int width;
    protected int heigth;
    
    protected int[] tiles;

    public Map(int width, int heigth) {
        this.width = width;
        this.heigth = heigth;
    
        this.tiles = new int[width * heigth];
        generateMap();
    }
    
    public Map(String path) {
        loadMap(path);
    }
    
    // generate a random map
    protected void generateMap() {
        
    }
    
    // load a predefinited map
    private void loadMap(String path) {
        
    }
    
    public void update() {
        
    }
    
    public void draw(final int compensationX, final int compensationY, final Screen screen) {
        // north, sourth, west, east
        int n = compensationY >> 5; // "/32" bit shifting
        int s = (compensationY + screen.getHeight());
        int w = compensationX >> 5; // "/32" bit shifting
        int e = (compensationX + screen.getWidth())/32;
    }
    
    public Tile getTile(final int x, final int y) {
        
        switch (tiles[x + y * width]) {
            case 0:
                return Tile.ASPHALT;
            default:
                return null;
        }
    }
}
