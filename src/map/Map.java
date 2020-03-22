package map;

import graphics.Screen;

public abstract class Map {
    private int width;
    private int heigth;
    
    private int[] tiles;

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
    private void generateMap() {
        
    }
    
    // load a predefinited map
    private void loadMap(String path) {
        
    }
    
    public void update() {
        
    }
    
    public void draw(int compensationX, int compensationY, Screen screen) {
        
    }
}
