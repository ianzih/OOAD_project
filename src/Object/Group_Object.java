package Object;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Group_Object extends Selected_Object {
	List<Selected_Object> selectedobject_group = new ArrayList<Selected_Object>();
	int width , height  ;
	
	//constructor
	// set group area
	public Group_Object(List<Selected_Object> selectedobjectlist) {
		x1 = selectedobjectlist.get(0).x1;
		x2 = selectedobjectlist.get(0).x2;
		y1 = selectedobjectlist.get(0).y1;
		y2 = selectedobjectlist.get(0).y2;
		
		for(Selected_Object target : selectedobjectlist) {
			x1 = Math.min(x1, target.x1);
			y1 = Math.min(y1, target.y1);
			x2 = Math.max(x2, target.x2);
			y2 = Math.max(y2, target.y2);
		}
		width = x2 - x1;
		height = y2 - y1;
		selectedobject_group.addAll(selectedobjectlist);
	}

	@Override
	public void drawSelectedObject(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//is mouse in group area
	public int mousewhereareaport(Point p) {
		if(p.x >= x1 && p.y >= y1 && p.x <= x2 && p.y <= y2)
			return 1;
		return -1;
	}

	@Override
	public void object_move(int x, int y) {
		//ini. group position
		x1 = x1 + x;
		y1 = y1 + y;
		x2 = x1 + x + width;
		y2 = y1 + y + height;
		
		//move (object in group)
		for(Selected_Object target : selectedobject_group) {
			target.object_move(x, y);
		}
	}
	@Override
	public boolean selectedobjectisinarea(Point p1, Point p2) {
		if(p1.x > p2.x && p1.y > p2.y) {
			Point[] swaplist = {p1 , p2};
			swaplist = swap(swaplist);
			p1 = swaplist[0];
			p2 = swaplist[1];
		}
    	if(p1.x < x1 && p1.y < y1 && p2.x > x2 && p2.y > y2)
    		return true;
		return false;
	}

	//public
	public List<Selected_Object> getselectedobjectingroup(){
		return selectedobject_group;
	}
	
	//private
	private Point[] swap(Point[] swaplist) {
		Point tmp;
		tmp = swaplist[0];
		swaplist[0] = swaplist[1];
		swaplist[1] = tmp;
		return swaplist;
	}

	@Override
	public void object_draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
