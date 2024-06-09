package mino;

import javax.swing.ImageIcon;

public class Square extends Mino {
	public ImageIcon I1;
	public ImageIcon I2;
	public ImageIcon I3;
	public ImageIcon I4;
    
    public Square(ImageIcon i1, ImageIcon i2, ImageIcon i3, ImageIcon i4) {
        this.I1 = i1;
        this.I2 = i2;
        this.I3 = i3;
        this.I4 = i4;

        create(i1,i2,i3,i4);
    }



    public void setXY(int x, int y) {
        /* 
         * 3 1 
         * 2 0
        */
        b[0].x = x; // tassello centrale
        b[0].y = y;
        b[1].x = b[0].x;
        b[1].y = b[0].y + Block.SIZE;
        b[2].x = b[0].x + Block.SIZE;
        b[2].y = b[0].y;
        b[3].x = b[0].x+ Block.SIZE;
        b[3].y = b[0].y+ Block.SIZE;
    }
	public void getDirection1() {

	}
	public void getDirection2() {

	}
	public void getDirection3() {
	}
	public void getDirection4() {

	}
}
