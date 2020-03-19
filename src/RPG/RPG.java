/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RPG;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author luisf
 */
public class RPG extends Canvas implements Runnable {
        
    private static final int WIDE = 800;
    private static final int HIGHT = 600;
    
    private static final String TITLE = "Juego de rol";
    
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

    private void start() {
        this.thread = new Thread(this, "Graphics");
        thread.start();
    }
    
    private void stop() {
        
    }
    
    @Override
    public void run() {
        // this will be called every time a new thread is started
    }
    
}
