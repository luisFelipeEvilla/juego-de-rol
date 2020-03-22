/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPG;

import control.Keyboard;
import graphics.Screen;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author luisf
 */
public class RPG extends Canvas implements Runnable {
        
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    
    private static final String TITLE = "Juego de rol";
    
    private static int ups = 0;
    private static int fps = 0;
    
    private static int x = 0;
    private static int y = 0;
    
    // with the word volatile this variable cannot be used at the same time by the two threads
    private volatile static boolean running = false; 
    
    private static JFrame window;
    private static Thread thread;
    private static Keyboard keyboard;
    private static Screen screen;
    
    private static BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private static int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
    private static final ImageIcon icon = new ImageIcon(RPG.class.getResource("/icon/icon.png"));
    
    private RPG() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        screen = new Screen(WIDTH, HEIGHT);
        
        keyboard = new Keyboard();
        addKeyListener(keyboard);
        
        window = new JFrame(TITLE);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        window.setResizable(false);
        window.setIconImage(icon.getImage());
        window.setLayout(new BorderLayout());
        window.add(this, BorderLayout.CENTER); // add canvas to the window and center it
        window.pack(); //the items inside the window will fullfill it
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        requestFocus();
    }
    
    public static void main(String[] args) {
        RPG app = new RPG();
        app.start();
    }

    // with synchronized the two methods won't be able to execute at the same time
    private synchronized void start() {
        running = true;
        
        thread = new Thread(this, "Graphics");
        thread.start();
    }
    
    private synchronized void stop() {
        running = false;
        
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    private void update() {
        keyboard.update();
        
        if (keyboard.up) {
            y++;
        }
        if (keyboard.down) {
            y--;
        }
        if (keyboard.left) {
            x--;
        }
        if (keyboard.rigth) {
            x++;
        }
        
        ups++;
    }
    
    
    private void draw() {
        BufferStrategy strategy = getBufferStrategy();
        
        if (strategy == null) {
            createBufferStrategy(3);
            return;
        }
        
        System.arraycopy(screen.pixels, 0, pixels, 0, pixels.length);
        
        screen.clean();
        screen.draw(x, y);
         
        Graphics g = strategy.getDrawGraphics();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.dispose();
        
        strategy.show();
        
        fps++;
    }
    
    // this will be called every time a new thread is started
    @Override
    public void run() {
        final int NS_PER_SECOND = 1000000000;
        final byte UPS_OBJETIVE = 60; //update per seconds objetive
        final double NS_PER_UPDATE = NS_PER_SECOND / UPS_OBJETIVE; //How many nanoseconds does it take for a update
        
        long updateReference = System.nanoTime();
        long countReference = System.nanoTime();
        
        double timeElapsed;
        double delta = 0;
        
        while(running) {
            final long bucleStart = System.nanoTime();
            
            timeElapsed = bucleStart - updateReference;
            updateReference = bucleStart;
            
            delta += timeElapsed / NS_PER_UPDATE;
        
            while(delta >= 1) {
                update();
                delta--;
            }
            
            draw();
            
            if (System.nanoTime() - countReference > NS_PER_SECOND) {
                window.setTitle(TITLE + " || UPS: " + ups + " || FPS: " + fps);
                ups = 0;
                fps = 0;
                countReference = System.nanoTime();
            }
        }
    }
    
}
