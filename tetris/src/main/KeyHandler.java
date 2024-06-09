package main;

import java.awt.event.KeyEvent;


import java.awt.event.*;

public class KeyHandler implements KeyListener {

	public static boolean upPressed,downPressed,pause,leftPressed,rightPressed,enter;
	
	private GamePanel gp;
	
	KeyHandler(GamePanel gp) {
		this.gp=gp;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code=e.getKeyCode();
		
		if(code==KeyEvent.VK_UP) {
			upPressed=true;
		}
		if(code==KeyEvent.VK_DOWN) {
			downPressed=true;
		}
		if(code==KeyEvent.VK_LEFT) {
			leftPressed=true;
		}
		if(code==KeyEvent.VK_RIGHT) {
			rightPressed=true;
		}
		if(code==KeyEvent.VK_SPACE) {
			if(pause) {
				pause=false;
			}else {
				pause=true;
			}
		}
		
		if(gp.gameState == gp.endState) {
			if (code == KeyEvent.VK_ENTER) {
				gp.gameState=gp.playState;
				gp.restart();
			}
		}
		
			
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
