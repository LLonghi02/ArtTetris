package mino;

import javax.swing.ImageIcon;

public class Bar extends Mino{
	public ImageIcon K1;
	public ImageIcon K2;
	public ImageIcon K3;
	public ImageIcon K4;
    
    public Bar(ImageIcon i1, ImageIcon i2, ImageIcon i3, ImageIcon i4) {
        this.K1 = i1;
        this.K2 = i2;
        this.K3 = i3;
        this.K4 = i4;

        create(i1,i2,i3,i4);
    }



    public void setXY(int x, int y) {
        /* 
         * 1 0 2 3
         * 
        */
        b[0].x = x; // tassello centrale
        b[0].y = y;
        b[1].x = b[0].x- Block.SIZE;
        b[1].y = b[0].y;
        b[2].x = b[0].x + Block.SIZE;
        b[2].y = b[0].y;
        b[3].x = b[0].x + Block.SIZE*2;
        b[3].y = b[0].y;
    }
	public void getDirection1() {
	     /* 
         * 1 0 2 3
         * 
        */
		tempB[0].x = b[0].x; 
		tempB[0].y = b[0].y;
		tempB[1].x = b[0].x - Block.SIZE;
		tempB[1].y = b[0].y;
		tempB[2].x = b[0].x + Block.SIZE;
		tempB[2].y = b[0].y;
		tempB[3].x = b[0].x + Block.SIZE*2;
		tempB[3].y = b[0].y;
		
		updateXY(1);
	}
	public void getDirection2() {
		 /*1 
         * 0 
         * 2
           3 */ 
		tempB[0].x = b[0].x; 
		tempB[0].y = b[0].y;
		tempB[1].x = b[0].x ;
		tempB[1].y = b[0].y- Block.SIZE;
		tempB[2].x = b[0].x ;
		tempB[2].y = b[0].y+ Block.SIZE;
		tempB[3].x = b[0].x;
		tempB[3].y = b[0].y + Block.SIZE*2;
		
		updateXY(2);
	}
	public void getDirection3() {
		getDirection1();
	}
	public void getDirection4() {
		getDirection2();

	}
}
