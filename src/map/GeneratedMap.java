package map;

import java.util.Random;

public class GeneratedMap extends Map {
    
    private final Random random = new Random();
    
    public GeneratedMap(int width, int heigth) {
        super(width, heigth);
    }
    
    @Override
    protected void generateMap() {
        for (int y = 0; y < heigth ; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x + y * width] = random.nextInt(3); 
            }
        }
    }
}
