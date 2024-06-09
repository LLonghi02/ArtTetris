package mino;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Block extends Rectangle {

  
    public static final int SIZE = 60; 

    public Image image;

    public Block(Image image) {
        this.image = image;
    }

   

	public Image getImage() {
		return image;
	}


	public void setImage(Image image) {
		this.image = image;
	}



	public void draw(Graphics2D g2, Image image2) {
       int margin=1;
    	g2.drawImage(image2, x, y, SIZE, SIZE, null);
        g2.setColor(Color.BLACK); // Imposta il colore del margine
        g2.drawRect(x+margin, y+margin, SIZE-(margin), SIZE-(margin));

    }



	
}
