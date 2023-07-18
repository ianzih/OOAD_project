package Object;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

public class Class_object extends Basic_Object{
	//constructor
	public Class_object(int x , int y){
		width = 100;
		height = 100;
		setobjectname("Class");
		inibasicposition(new Point(x , y) , width , height);
		iniportposition(); 
	}
	
	 
	//public
	@Override
	public void object_move(int x , int y) {
		Point new_point =  new Point(x1 + x , y1 + y);
		inibasicposition(new_point , width , height);
		iniportposition();
	}
	
	@Override
	public void object_draw(Graphics g) {
		g.setColor(Color.ORANGE);
		g.drawRect(x1, y1, width, height);	
		
		g.setColor(Color.BLACK);
		g.drawLine(x1, y1 + (height / 3) , x2, y1 + (height / 3));
		g.drawLine(x1, y1 + (height / 3) * 2, x2, y1 + (height / 3) * 2);
		
		//name
		Font font = new Font("Arial", Font.BOLD, 14);
		int stringWidth = g.getFontMetrics(font).stringWidth(name);
		int x = (Math.abs(x1 - x2) - stringWidth) / 2;
		g.setFont(font);	
		g.drawString(name, x1 + x , y1 + 25);
	}
}
