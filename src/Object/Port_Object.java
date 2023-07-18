package Object;


import java.awt.Graphics;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class Port_Object  extends Rectangle{
	int r = 3;
	
	//constructor
	public Port_Object(int x , int y) {
		portposition(x , y);
	}
	
	//public 
	public void portposition(int x , int y) {
		int x_new = x - r;
		int y_new = y - r;
		int width = r + r;
		int height = r + r;
		setBounds(x_new, y_new, width, height);
	}
	public void drawport(Graphics g , Port_Object ports) {
		g.fillRect(ports.x, ports.y, ports.width, ports.height);
//		System.out.println(width);
//		System.out.println(height);
//		System.out.println(x);
//		System.out.println(y);
	}
}
