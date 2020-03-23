
package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class Keyboard implements KeyListener {

    private final static byte KEYNUMBER = 120;
    private final boolean[] keys = new boolean[KEYNUMBER];
    
    public boolean up;
    public boolean down;
    public boolean left;
    public boolean rigth;
    
    public boolean scape;
    
    public void update() {
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        rigth = keys[KeyEvent.VK_D];
        
        /** if we wanna move with the old controls of keys: up arrow, down arrow, left arrow, rigth arrow,uncomment this block of code
         *and comment the above
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        rigth = keys[KeyEvent.VK_RIGTH]; 
        */
        
        scape = keys[KeyEvent.VK_ESCAPE];
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
    
}
