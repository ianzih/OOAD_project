package Object;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Selected_Object {
	int x1 ,x2 ,y1 ,y2;
	
	//public abstract, can override
	public abstract void drawSelectedObject(Graphics g) ;
	public abstract int mousewhereareaport(Point p) ;
	public abstract void object_move(int x, int y)  ;
	public abstract boolean selectedobjectisinarea(Point p1, Point p2)  ;
	public abstract void object_draw(Graphics g);
	//public
	
}
