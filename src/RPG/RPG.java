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
public class RPG extends Canvas {
        
    private static final int WIDE = 800;
    private static final int HIGHT = 600;
    
    private static final String TITLE = "Juego de rol";
    
    private static JFrame window;
    
    private RPG() {
        setPreferredSize(new Dimension(WIDE, HIGHT));

        window = new JFrame(TITLE);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLayout(new BorderLayout());
        window.add(this, BorderLayout.CENTER);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
    
    public static void main(String[] args) {
        RPG app = new RPG();
    }
    
}
