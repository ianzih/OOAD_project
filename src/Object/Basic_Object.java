package Object;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class Basic_Object extends Selected_Object{
	//default
	int width , height;
	String name = "basic name";
	Port_Object[] ports = new Port_Object[4];
	
	//constructor 	
	public Basic_Object(){}
	
	//public 
	public void setobjectname(String s) {
		name = s; 
	}
	public void inibasicposition(Point p , int iwidth , int iheight) {
		x1 = p.x;
		y1 = p.y;
		x2 = p.x + iwidth;
		y2 = p.y + iheight;
	}
	
	public void iniportposition() {
		ports[3] = new Port_Object((x1 + x2) / 2 , y1);
    	ports[2] = new Port_Object(x2 , (y1 + y2) / 2);
    	ports[1] = new Port_Object((x1 + x2) / 2 , y2);
    	ports[0] = new Port_Object(x1 , (y1 + y2) / 2);
	}
	
	public Port_Object getportposition(int i) {
		return ports[i];
	}
	
	//override
	@Override
	//draw selected object port
	public void drawSelectedObject(Graphics g) {
		for(Port_Object target : ports) {
			target.drawport(g, target);
		}
	}
	@Override
	//return  the port position number where the mouse is currently located
	public int mousewhereareaport(Point p) {
		int[] objectpoint_x = {x1 , x1 , x2 , x2};
		int[] objectpoint_y = {y1 , y2 , y2 , y1};
		Polygon poly = new Polygon();
		for(int i = 0 ; i < 4 ; i++) {
			poly.addPoint(objectpoint_x[i], objectpoint_y[i]);
			poly.addPoint(objectpoint_x[(i + 1) % 4], objectpoint_y[(i + 1) % 4]);
			poly.addPoint((x1 + x2) / 2 - 5, (y1 + y2) / 2 - 5);
			
			if (poly.contains(p)) {
//				System.out.println(i);
				return i;
			}
		}
		return -1;
	}
	@Override
	public boolean selectedobjectisinarea(Point p1, Point p2) {
		if(p1.x > p2.x && p1.y > p2.y) {
			Point[] swaplist = {p1 , p2};
			swaplist = swap(swaplist);
			p1 = swaplist[0];
			p2 = swaplist[1];
		}
//		System.out.println(p1);
//		System.out.println(p2);
    	if(p1.x < x1 && p1.y < y1 && p2.x > x2 && p2.y > y2)
    		return true;
		return false;
	}

	@Override
	public void object_move(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void object_draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	//private
	private Point[] swap(Point[] swaplist) {
		Point tmp;
		tmp = swaplist[0];
		swaplist[0] = swaplist[1];
		swaplist[1] = tmp;
		return swaplist;
	}
}
