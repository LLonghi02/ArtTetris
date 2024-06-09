package mino;

import java.awt.*;
import java.awt.Graphics2D;

import javax.swing.*;

import main.KeyHandler;
import main.PlayManager;

public class Mino extends JFrame{

	public Block b[]=new Block[4];
	public Block tempB[]=new Block[4];
	int autodropCounter=0;
	public int direction=1;
	boolean leftCollision,rightCollision, bottomCollision;
	public boolean active=true;
	boolean dea;
	int deaCounter=0;
	public boolean deactivating;
	
	public void create(ImageIcon i1, ImageIcon i2, ImageIcon i3, ImageIcon i4) {
	    Image im1 = i1.getImage();
	    Image im2 = i2.getImage();
	    Image im3 = i3.getImage();
	    Image im4 = i4.getImage();

	    // Scale the image to fit the block size
	    Image si1 = im1.getScaledInstance(Block.SIZE, Block.SIZE, Image.SCALE_SMOOTH);
	    Image si2 = im2.getScaledInstance(Block.SIZE, Block.SIZE, Image.SCALE_SMOOTH);
	    Image si3 = im3.getScaledInstance(Block.SIZE, Block.SIZE, Image.SCALE_SMOOTH);
	    Image si4 = im4.getScaledInstance(Block.SIZE, Block.SIZE, Image.SCALE_SMOOTH);

	    
	    b[0] = new Block(si1);
        b[1] = new Block(si2);
        b[2] = new Block(si3);
        b[3] = new Block(si4);

        tempB[0] = new Block(si1);
        tempB[1] = new Block(si2);
        tempB[2] = new Block(si3);
        tempB[3] = new Block(si4);
	   
	}



	public void setXY(int x,int y) {
		
	}
	public void updateXY(int direction) {
		crc();
		if(leftCollision==false&&rightCollision==false && bottomCollision==false) {
			this.direction=direction;
			b[0].x = tempB[0].x;
			b[0].y = tempB[0].y;
			b[1].x = tempB[1].x;
			b[1].y = tempB[1].y;
			b[2].x = tempB[2].x;
			b[2].y = tempB[2].y;
			b[3].x = tempB[3].x;
			b[3].y = tempB[3].y;
		}
		
	}
	
	public void getDirection1() {
		
	}
	public void getDirection2() {
		
	}
	public void getDirection3() {
		
	}
	public void getDirection4() {
		
	}
	
	public void cmc() {
		//check movement collision
		leftCollision=false;
		rightCollision=false;
		bottomCollision=false;
		csbc();
		
		for(int i=0;i<b.length;i++) {
			if(b[i].x==PlayManager.leftX) {
				leftCollision=true;
			}
		}
		for(int i=0;i<b.length;i++) {
			if(b[i].x+Block.SIZE==PlayManager.rightX) {
				rightCollision=true;
			}
		}
		for(int i=0;i<b.length;i++) {
			if(b[i].y+Block.SIZE==PlayManager.bottomY) {
				bottomCollision=true;
			}
		}

	}
	public void crc() {
		//check rotation collision
		leftCollision=false;
		rightCollision=false;
		bottomCollision=false;
		csbc();
		for(int i=0;i<b.length;i++) {
			if(tempB[i].x<PlayManager.leftX) {
				leftCollision=true;
			}
		}
		for(int i=0;i<b.length;i++) {
			if(tempB[i].x+Block.SIZE>PlayManager.rightX) {
				rightCollision=true;
			}
		}
		for(int i=0;i<b.length;i++) {
			if(tempB[i].y+Block.SIZE>PlayManager.bottomY) {
				bottomCollision=true;
			}
		}
	}
	private void csbc() {
		for(int i=0;i<PlayManager.staticBlocks.size();i++) {
			int targetX=PlayManager.staticBlocks.get(i).x;
			int targetY=PlayManager.staticBlocks.get(i).y;

			//check down
			for(int ii=0;ii<b.length;ii++) {
				if(b[ii].y+Block.SIZE==targetY&&b[ii].x==targetX) {
					bottomCollision=true;
				}
			}
			//check left
			for(int ii=0;ii<b.length;ii++) {
				if(b[ii].y+Block.SIZE==targetY&&b[ii].x==targetX) {
					leftCollision=true;
				}
			}
			//check down
			for(int ii=0;ii<b.length;ii++) {
				if(b[ii].y+Block.SIZE==targetY&&b[ii].x==targetX) {
					rightCollision=true;
				}
			}
		}
	}
	public void update() {
		if(dea) {
			deactivating();
		}
		
		if(KeyHandler.upPressed) {
			switch (direction) {
			case 1: getDirection2();break;
			case 2: getDirection3();break;
			case 3: getDirection4();break;
			case 4: getDirection1();break;

			}
			KeyHandler.upPressed=false;

		}
		cmc();
		if(KeyHandler.leftPressed) {
			if(leftCollision==false) {
				b[0].x-=Block.SIZE;
				b[1].x-=Block.SIZE;
				b[2].x-=Block.SIZE;
				b[3].x-=Block.SIZE;
					
			}
			
			KeyHandler.leftPressed=false;

		}
		if(KeyHandler.downPressed) {
			if(bottomCollision==false) {
				b[0].y+=Block.SIZE;
				b[1].y+=Block.SIZE;
				b[2].y+=Block.SIZE;
				b[3].y+=Block.SIZE;

				autodropCounter=0;
			}

			KeyHandler.downPressed=false;
		}
		if(KeyHandler.rightPressed) {
			if(rightCollision==false) {
				b[0].x+=Block.SIZE;
				b[1].x+=Block.SIZE;
				b[2].x+=Block.SIZE;
				b[3].x+=Block.SIZE;
				
			}
			
			KeyHandler.rightPressed=false;

		}
		if(bottomCollision) {
			dea=true;
			
		}else {
		autodropCounter++;
			if(autodropCounter==PlayManager.dropInterval) {
				b[0].y+=Block.SIZE;
				b[1].y+=Block.SIZE;
				b[2].y+=Block.SIZE;
				b[3].y+=Block.SIZE;
	
				autodropCounter=0;
			}
		}
	}
	
	private void deactivating() {
		// TODO Auto-generated method stub
		deaCounter++;
		if(deaCounter==45) {
			deaCounter=0;
			cmc();
			if(bottomCollision) {
				active=false;
			}
		}
	}



	public void draw(Graphics2D g2, ImageIcon i1, ImageIcon i2, ImageIcon i3, ImageIcon i4) {
 
		int margin=1;

		b[0].draw(g2, i1.getImage());
	    b[1].draw(g2, i2.getImage());
	    b[2].draw(g2, i3.getImage());
	    b[3].draw(g2, i4.getImage());
	    for (Block block : b) {
	        g2.setColor(Color.BLACK); // Imposta il colore del margine
	        g2.drawRect(block.x+margin, block.y+margin, Block.SIZE-(margin), Block.SIZE-(margin));
	    }
	    
		

	}

	
}
