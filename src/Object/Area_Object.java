package Object;

import java.awt.Color;
import java.awt.Graphics;

public class Area_Object {
	private int x , x1 , y , y1;
	
	//constructor
	public Area_Object(int ix, int ix1, int iy, int iy1) {
		if (ix > ix1 && iy > iy1) {
			swap(ix , ix1);
			swap(iy, iy1);
		}
		x = ix;
		x1 = ix1;
		y = iy;
		y1 = iy1;
		
	}
	
	//public
	public void draw_area(Graphics g) {
		g.setColor(new Color(20 , 20 , 100 , 50));
		g.fillRect(x, y, x1 - x, y1 - y);
	}
	
	//private
	private void swap(int a,int b){
		int temp=a;
		a=b;
		b=temp;
	}
}
