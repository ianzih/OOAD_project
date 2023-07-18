package Object;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

public class Usecase_Object extends Basic_Object{
	//constructor
	public Usecase_Object(int x , int y){
		width = 150;
		height = 120;
		setobjectname("Usecase");
		inibasicposition(new Point(x , y) , width , height);
		iniportposition();
	}

	@Override
	public void object_move(int x , int y) {
		Point new_point =  new Point(x1 + x , y1 + y);
		inibasicposition(new_point , width , height);
		iniportposition();
	}
	@Override
	public void object_draw(Graphics g) {
		g.setColor(Color.ORANGE);
		g.drawOval(x1, y1, width, height);
		
		//name
		Font font = new Font("Arial", Font.BOLD, 14);
		int stringWidth = g.getFontMetrics(font).stringWidth(name);
		int x = (Math.abs(x1 - x2) - stringWidth) / 2;	
		g.setFont(font);	
		g.setColor(Color.BLACK);
		g.drawString(name, x1 + x , y1 + 60);	
	}
}
