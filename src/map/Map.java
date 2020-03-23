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

        screen.setDifference(compensationX, compensationY);
        
        // north, sourth, west, east
        int n = compensationY >> 5; // "/32" bit shifting
        int s = (compensationY + screen.getHeight() + Tile.SIZE) >> 5;
        int w = compensationX >> 5; // "/32" bit shifting
        int e = (compensationX + screen.getWidth() + Tile.SIZE) >> 5;
    
        for (int y = n; y < s; y++) {
            for (int x = w; x < e; x++) {
                getTile(x, y).draw(x, y, screen);
            }
        }
    }
    
    public Tile getTile(final int x, final int y) {
        if (x < 0 || x >= width || y < 0 || y >= heigth) {
            return Tile.VOID;
        }
        switch (tiles[x + y * width]) {
            case 0:
                return Tile.ASPHALT;
            case 1:
            case 2:
            case 3:
                
            default:
                return Tile.VOID;
        }
    }
}
