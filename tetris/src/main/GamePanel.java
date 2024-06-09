package main;

import java.awt.*;
import javax.swing.*;

import mino.L1;

public class GamePanel extends JPanel implements Runnable {

    public static final int WIDTH = 1320;
    public static final int HEIGHT = 750;

    final int FPS = 60;
    Thread gameThread;
    PlayManager pm;

    public int gameState;
	public final int playState=1;
	public final int endState=2;
    
    public GamePanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        this.addKeyListener(new KeyHandler(this));
        this.setFocusable(true);
        
        pm = new PlayManager(this);
    }

    public void setUp() {
    	gameState=playState;
    }
    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        // game loop
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
      
    }

    public void update() {
    	if(KeyHandler.pause==false && gameState==playState) {
            pm.update();

    	}
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        pm.draw(g2);
    }

	public void restart() {
		// TODO Auto-generated method stub
		gameState=playState;
		pm.staticBlocks.clear();
		setUp();
		launchGame();
	}
}
