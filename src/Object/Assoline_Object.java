package Object;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;

public class Assoline_Object extends Line_Object{
	//constructor
		public Assoline_Object(int ilx , int ilx1 , int ily , int ily1) {
			lx = ilx;
			lx1 = ilx1;
			ly = ily;
			ly1 = ily1;
		}
		@Override
		public void line_draw(Graphics2D g) {
			double x3 , y3 , x3_1 , y3_1;
			int h = 20;
			int distence_x = lx1 - lx , distence_y = ly1 - ly;
			double px = lx1 - h * distence_x / Math.sqrt(distence_x * distence_x + distence_y * distence_y);
			double py = ly1 - h * distence_y / Math.sqrt(distence_x * distence_x + distence_y * distence_y);
			
			
			// head
			x3 = lx1 + (Math.cos(Math.PI / 4) * (px - lx1)) - (Math.sin(Math.PI / 4) * (py - ly1));
			y3 = ly1 + (Math.sin(Math.PI / 4) * (px - lx1)) + (Math.cos(Math.PI / 4) * (py - ly1));;
			
			
			x3_1 = lx1 + (Math.cos(-1*Math.PI / 4) * (px - lx1)) - (Math.sin(-1*Math.PI / 4) * (py - ly1));
			y3_1 = ly1 + (Math.sin(-1*Math.PI / 4) * (px - lx1)) + (Math.cos(-1*Math.PI / 4) * (py - ly1));;
			
			Path2D path = new Path2D.Double();
			Line2D[] lines = {
					new Line2D.Double(lx1,ly1,x3,y3),
					new Line2D.Double(lx1,ly1,x3_1,y3_1),						
			};
			for(Line2D line : lines) {
				path.append(line, path.getCurrentPoint()!=null);
			}
			path.closePath();
			Shape shape = path;
			
			//line	
			if(isselect) {
				g.setColor(Color.GREEN);
			}
			else {
				g.setColor(Color.BLACK);
			}
			g.draw(new Line2D.Double(lx, ly, lx1 , ly1));
			g.draw(shape);
			g.setColor(Color.BLACK);
		}
}
