/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPG;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author luisf
 */
public class RPG extends Canvas implements Runnable {
        
    private static final int WIDE = 800;
    private static final int HIGHT = 600;
    
    private static final String TITLE = "Juego de rol";
    
    // with the word volatile this variable cannot be used at the same time by the two threads
    private volatile static boolean running = false; 
    
    private static JFrame window;
    private static Thread thread;
    
    private RPG() {
        setPreferredSize(new Dimension(WIDE, HIGHT));

        window = new JFrame(TITLE);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        window.setResizable(false);
        window.setLayout(new BorderLayout());
        window.add(this, BorderLayout.CENTER); // add canvas to the window and center it
        window.pack(); //the items inside the window will fullfill it
        window.setLocationRelativeTo(null);
        window.setVisible(true);
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
    
    @Override
    public void run() {
        // this will be called every time a new thread is started
        while(running) {
            
        }
    }
    
}
