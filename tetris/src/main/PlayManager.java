package main;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

import mino.*;


public class PlayManager {

	final int WIDTH=480;
	final int HEIGHT=660;
	public static int leftX;
	public static int topY;
	public static int rightX;
	public static int bottomY;
	
	public ImageIcon I1;
	public ImageIcon I2;
	public ImageIcon I3;
	public ImageIcon I4;
	public ImageIcon M1;
	public ImageIcon M2;
	public ImageIcon M3;
	public ImageIcon M4;
	public ImageIcon K1;
	public ImageIcon K2;
	public ImageIcon K3;
	public ImageIcon K4;	
	public ImageIcon P1;
	public ImageIcon P2;
	public ImageIcon P3;
	public ImageIcon P4;
	public ImageIcon D1;
	public ImageIcon D2;
	public ImageIcon D3;
	public ImageIcon D4;
	public ImageIcon W1;
	public ImageIcon W2;
	public ImageIcon W3;
	public ImageIcon W4;	
	public ImageIcon MA1;
	public ImageIcon MA2;
	public ImageIcon MA3;
	public ImageIcon MA4;
	
	Mino currentMino;
	final int MINOX;
	final int MINOY;
	public int valm;
	public int vn;
	int count=0;

	
	Mino nextMino;
	final int NMINOX;
	final int NMINOY;
	public static ArrayList<Block> staticBlocks=new ArrayList<>();
	
	public static int dropInterval=60;
	
	boolean effectCounter;
	int effect;
	ArrayList<Integer> effectY=new ArrayList<>();
	
	
	private GamePanel gp;
	
	int level=1;
	int lines;
	int score;
	
	public PlayManager(GamePanel gp) {
		
		this.gp=gp;
		
		leftX=(GamePanel.WIDTH/2)-(WIDTH/2);
		rightX=leftX+WIDTH;
		topY=50;
		bottomY=topY+HEIGHT;
		
		MINOX=leftX+(WIDTH/2)-Block.SIZE;
		MINOY=topY+Block.SIZE;
		
		NMINOX=rightX+200;
		NMINOY=topY+470;
		
		//L1 van gogh
		I1 = new ImageIcon(getClass().getResource("/im/ns.jpg"));
		I2 = new ImageIcon(getClass().getResource("/im/caf.jpg"));
		I4 = new ImageIcon(getClass().getResource("/im/ns2.jpg"));
		I3 = new ImageIcon(getClass().getResource("/im/grano.jpg"));
		//L2 monet
		M1 = new ImageIcon(getClass().getResource("/im/c1.jpg"));
		M2 = new ImageIcon(getClass().getResource("/im/c2.jpg"));
		M4 = new ImageIcon(getClass().getResource("/im/c3.jpg"));
		M3 = new ImageIcon(getClass().getResource("/im/c4.jpg"));
		//T picasso
		P1 = new ImageIcon(getClass().getResource("/im/p1.jpg"));
		P2 = new ImageIcon(getClass().getResource("/im/p2.jpg"));
		P4 = new ImageIcon(getClass().getResource("/im/p3.jpg"));
		P3 = new ImageIcon(getClass().getResource("/im/p4.jpg"));
		//bar klimt
		K1 = new ImageIcon(getClass().getResource("/im/k1.jpg"));
		K2 = new ImageIcon(getClass().getResource("/im/k2.jpg"));
		K4 = new ImageIcon(getClass().getResource("/im/k3.jpg"));
		K3 = new ImageIcon(getClass().getResource("/im/k4.jpg"));
		//square
		D1 = new ImageIcon(getClass().getResource("/im/d1.jpg"));
		D2 = new ImageIcon(getClass().getResource("/im/d2.jpg"));
		D4 = new ImageIcon(getClass().getResource("/im/d3.jpg"));
		D3 = new ImageIcon(getClass().getResource("/im/d4.jpg"));
		//Z1 
		W1 = new ImageIcon(getClass().getResource("/im/w1.jpg"));
		W2 = new ImageIcon(getClass().getResource("/im/wa2.jpg"));
		W4 = new ImageIcon(getClass().getResource("/im/wa1.jpg"));
		W3 = new ImageIcon(getClass().getResource("/im/w4.jpg"));
		//Z2
		MA1 = new ImageIcon(getClass().getResource("/im/ma1.jpg"));
		MA2 = new ImageIcon(getClass().getResource("/im/ma2.jpg"));
		MA4 = new ImageIcon(getClass().getResource("/im/ma3.jpg"));
		MA3 = new ImageIcon(getClass().getResource("/im/ma4.jpg"));

		/*
		 * NOTA: GLI STATIC E I NEXT SONO GIUSTI, IL PROBLEMA è IL CURRENT
		 */
		currentMino=pick();
		currentMino.setXY(MINOX, MINOY);
		nextMino=pickN();
		nextMino.setXY(NMINOX, NMINOY);
	}

	
	private Mino pick() {
		Mino mino=null;
		int i=new Random().nextInt(7);
		
		switch(i) {
		case 0:mino=new L1(I1, I2, I3, I4);break;
		case 1:mino=new L2(M1, M2, M3, M4);break;
		case 2:mino=new Square(D1, D2, D3, D4);break;
		case 3:mino=new Bar(K1, K2, K3, K4);break;
		case 4:mino=new Z1(W1, W2, W3, W4);break;
		case 5:mino=new Z2(MA1, MA2, MA3, MA4);break;
		case 6:mino=new T(P1, P2, P3, P4);break;

		}
		count++;
		
		valm=i;
		return mino;
	}
	private Mino pickN() {
		Mino mino=null;
		int n=new Random().nextInt(7);
		
		switch(n) {
		case 0:mino=new L1(I1, I2, I3, I4);break;
		case 1:mino=new L2(M1, M2, M3, M4);break;
		case 2:mino=new Square(D1, D2, D3, D4);break;
		case 3:mino=new Bar(K1, K2, K3, K4);break;
		case 4:mino=new Z1(W1, W2, W3, W4);break;
		case 5:mino=new Z2(MA1, MA2, MA3, MA4);break;
		case 6:mino=new T(P1, P2, P3, P4);break;

		}
		vn=n;
		return mino;
	}
	
	public void update() {
		if(currentMino.active==false) {
			
				staticBlocks.add(currentMino.b[0]);
				staticBlocks.add(currentMino.b[1]);
				staticBlocks.add(currentMino.b[2]);
				staticBlocks.add(currentMino.b[3]);
				//aggiunge 4 blocchi ogni mino
			if(currentMino.b[0].x==MINOX &&currentMino.b[0].y==MINOY) {
				gp.gameState=gp.endState;
			}
				
			currentMino.deactivating=false;
			
			valm=vn;
			currentMino=nextMino;
			currentMino.setXY(MINOX, MINOY);
			
			nextMino=pickN();
			nextMino.setXY(NMINOX, NMINOY);
			
			checkdelete();
		}else {
			currentMino.update();

		}
		
	}

	private void  checkdelete() {
		int x=leftX;
		int y=topY;
		int blockCount=0;
		int lineCount=0;
		
		while(x<rightX && y<bottomY) {
			for(int i=0;i<staticBlocks.size();i++) {
				if(staticBlocks.get(i).x==x && staticBlocks.get(i).y==y) {
					blockCount++;
				}
			}
			x+=Block.SIZE;
			
			if(x==rightX){
				if(blockCount==8) {
					effectCounter=true;
					effectY.add(y);
					
					for(int i=staticBlocks.size()-1;i>-1;i--) {
						if(staticBlocks.get(i).y==y) {
							staticBlocks.remove(i);
						}
					}
					
					lineCount++;
					lines++;
					
					//ogni 10 righe eliminate il livello incrementa e il tempo di caduta diminusice
					if(lines%10==0 && dropInterval>1) {
						level++;
						if(dropInterval>10) {
							dropInterval-=10;							
						}else {
							dropInterval-=1;
						}
					}
					
					//scalare i blocchi
					for(int i=0;i<staticBlocks.size();i++) {
						if(staticBlocks.get(i).y<y) {
							staticBlocks.get(i).y+=Block.SIZE;
						}
					}
				}
				
				blockCount=0;
				x=leftX;
				y+=Block.SIZE;
			}
		}
		if(lineCount>0) {
			int sls=10*level; //single line score
			score+=sls*lineCount;
		}
		
	}
	public void draw(Graphics2D g2) {

		g2.setColor(Color.white);
		g2.setStroke(new BasicStroke(4f));
		g2.drawRect(leftX-4, topY-4, WIDTH+8, HEIGHT+8);
		
		int x=rightX+100;
		int y=bottomY-300;
		g2.drawRect(x, y, 300, 250);
		g2.setFont(new Font("Times New Roman", Font.PLAIN,30));
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.drawString("NEXT",x+110,y+40);
		
		g2.drawRect(x, topY, 250, 280);
		x+=40;
		y=topY+80;
		g2.drawString("LIVELLO: "+level,x,y);
		y+=70;
		g2.drawString("LINES: "+lines,x,y);
		y+=70;
		g2.drawString("SCORE: "+score,x,y);
		
		//draw mino
		if(currentMino!=null ) {
			System.out.println(valm);
			switch(valm) {
			case 0:currentMino.draw(g2, I1,I2,I3,I4);break;
			case 1:currentMino.draw(g2,M1, M2, M3, M4);break;
			case 2:currentMino.draw(g2,D1, D2, D3, D4);break;
			case 3:currentMino.draw(g2,K1, K2, K3, K4);break;
			case 4:currentMino.draw(g2,W1, W2, W3, W4);break;
			case 5:currentMino.draw(g2,MA1, MA2, MA3, MA4);break;
			case 6:currentMino.draw(g2,P1, P2, P3, P4);break;

			}
			
		}
		
		//draw next
		switch(vn) {
		case 0:nextMino.draw(g2, I1,I2,I3,I4);break;
		case 1:nextMino.draw(g2,M1, M2, M3, M4);break;
		case 2:nextMino.draw(g2,D1, D2, D3, D4);break;
		case 3:nextMino.draw(g2,K1, K2, K3, K4);break;
		case 4:nextMino.draw(g2,W1, W2, W3, W4);break;
		case 5:nextMino.draw(g2,MA1, MA2, MA3, MA4);break;
		case 6:nextMino.draw(g2,P1, P2, P3, P4);break;

		}


		for(int i=0;i<staticBlocks.size();i++) {
			Image bl;
			bl=staticBlocks.get(i).getImage();
			staticBlocks.get(i).draw(g2,bl);
		}
		
		//effect
		if(effectCounter) {
			effect++;
			
			g2.setColor(Color.red);
			int margin=1;
			for(int i=0;i<effectY.size();i++) {
			    x = leftX - margin; // Sottrai il margine dalla coordinata x sinistra
			    y = effectY.get(i) - margin; // Sottrai il margine dalla coordinata y superiore
			    int width = WIDTH + 2 * margin; // Aggiungi il margine al larghezza del rettangolo
			    int height = Block.SIZE + 2 * margin; // Aggiungi il margine all'altezza del rettangolo
			    
			    // Disegna un rettangolo nero per il margine
			    g2.setColor(Color.black);
			    g2.fillRect(x, y, width, height);
			    
			    // Disegna il rettangolo rosso all'interno del margine nero
			    g2.setColor(Color.red);
			    g2.fillRect(x + margin, y + margin, WIDTH, Block.SIZE);
				
			}
			if(effect==10) {
				effectCounter=false;
				effect=0;
				effectY.clear();
			}
		}
		
		//pause
		g2.setColor(Color.yellow);
		g2.setFont(g2.getFont().deriveFont(50f));
		if(KeyHandler.pause) {
			x=leftX+150;
			y=topY+320;
			g2.drawString("PAUSA", x, y);
		}
		
		
		//titolo
		x=35;
		y=topY+320;
		g2.setColor(Color.white);
		g2.setFont(new Font("Tetris Blocks",Font.ITALIC,40));
		g2.drawString("TUVWX", x, y);
		g2.setFont(new Font("Tetris",Font.ITALIC,60));
		g2.drawString("art", x, y-70);

		//GO
		
		if(gp.gameState==gp.endState) {

			g2.setColor(Color.black);
			g2.fillRect(0,0,1320,750);
			g2.setColor(Color.RED);
			g2.setFont(new Font("Times New Roman",Font.BOLD,60));
			String text="HAI PERSO";
			y=GamePanel.HEIGHT/2;
			x=GamePanel.WIDTH/2-150;
			g2.drawString(text,x,y);
			
			g2.setColor(Color.white);
			g2.setFont(new Font("Times New Roman",Font.ITALIC,30));
			y=GamePanel.HEIGHT/2+100;
			x=GamePanel.WIDTH/2-150;
			g2.drawString("press enter per ricominciare",x,y);
		}
						

	
	}
	

 
}
