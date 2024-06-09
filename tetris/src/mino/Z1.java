package mino;

import javax.swing.ImageIcon;

public class Z1 extends Mino{
	public ImageIcon I1;
	public ImageIcon I2;
	public ImageIcon I3;
	public ImageIcon I4;
    
    public Z1(ImageIcon i1, ImageIcon i2, ImageIcon i3, ImageIcon i4) {
        this.I1 = i1;
        this.I2 = i2;
        this.I3 = i3;
        this.I4 = i4;

        create(i1,i2,i3,i4);
    }



    public void setXY(int x, int y) {
        /* 3	
         * 2 0 
         *   1
        */
        b[0].x = x; // tassello centrale
        b[0].y = y;
        b[1].x = b[0].x;
        b[1].y = b[0].y - Block.SIZE;
        b[2].x = b[0].x - Block.SIZE;
        b[2].y = b[0].y ;
        b[3].x = b[0].x - Block.SIZE;
        b[3].y = b[0].y + Block.SIZE;
    }
	public void getDirection1() {

		tempB[0].x = b[0].x;
		tempB[0].y = b[0].y;
		tempB[1].x = b[0].x;
		tempB[1].y = b[0].y - Block.SIZE;
		tempB[2].x = b[0].x - Block.SIZE;
		tempB[2].y = b[0].y;
		tempB[3].x = b[0].x - Block.SIZE;
		tempB[3].y = b[0].y + Block.SIZE;
		
		updateXY(1);
	}
	public void getDirection2() {

		tempB[0].x = b[0].x;
		tempB[0].y = b[0].y;
		tempB[1].x = b[0].x+ Block.SIZE;
		tempB[1].y = b[0].y;
		tempB[2].x = b[0].x;
		tempB[2].y = b[0].y- Block.SIZE ;
		tempB[3].x = b[0].x- Block.SIZE;
		tempB[3].y = b[0].y- Block.SIZE;
		
		updateXY(2);
	}
	public void getDirection3() {
		getDirection1();
	}
	public void getDirection4() {
		getDirection2();

	}
}
