package Event;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Object.Area_Object;
import Object.Basic_Object;
import Object.Group_Object;
import Object.Line_Object;
import Object.Selected_Object;
import UML_interface.UML_Canvas;

public class Select_Event extends Mouse_Event{
	//default
	Selected_Object selected_Object;
	Point selected_area_point;
	List<Basic_Object>  objects;
	List<Group_Object> groups_object;
	int px , py;
	
	//constructor
	public Select_Event() {
		
	}

	// public override
	@Override
	public void Mouse_Clicked(UML_Canvas canvas, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Mouse_Released(UML_Canvas canvas, int x, int y) {
		//show all selected area object
		if(selected_area_point != null) {
			//find area group
			List<Group_Object> grouptmp = new ArrayList<Group_Object>();
			for(Group_Object target : groups_object) {
				if(target.selectedobjectisinarea(selected_area_point, new Point(x , y))) {
					canvas.addselectObject(target);
					grouptmp.add(target);
//					System.out.println("123");
				}
			}
			//find area object
			for(Basic_Object target : objects) {
				if(target.selectedobjectisinarea(selected_area_point, new Point(x , y)) && !checkobjectisinothergroup(grouptmp , target)) {
					canvas.addselectObject(target);
//						System.out.println("456");
				}
			}
		}
		selected_area_point = null;
		canvas.clearselectarea();
		canvas.repaint();
	}

	@Override
	public void Mouse_Dragged(UML_Canvas canvas, int x, int y) {
		if (selected_area_point != null) {
			canvas.addselectarea(new Area_Object(selected_area_point.x, x , selected_area_point.y , y));
		}
		else if (selected_area_point == null) {
			selected_Object.object_move(x - px, y - py);
			canvas.updateline();
			px = x;
			py = y;
		} 
		canvas.repaint();
	}

	@Override
	public void Mouse_Pressed(UML_Canvas canvas, int x, int y) {
		canvas.clearselectObject();
		selected_Object = null;
		px = x;
		py = y;
		int whichport = -1;
		
		// selected group object
		groups_object = canvas.getgroup();
		List<Group_Object> reversedList = new ArrayList<>(groups_object);
		Collections.reverse(reversedList);
		for(Group_Object target : reversedList) {
			// is in group area
			if(target.mousewhereareaport(new Point(x , y)) >= 0) {
				selected_Object = target;
				canvas.addselectObject(selected_Object);
				break;
			}
		}
		
		// no selected object
		if(selected_Object == null) {
			objects = canvas.getObject();
			for(Basic_Object target : objects) {
				// is in object , mouse is in object port
				whichport = target.mousewhereareaport(new Point(x , y));
				if( whichport >= 0) {
					selected_Object = target;
					canvas.addselectObject(selected_Object);
					break;
				}	
			}
			
			// port is pressed by mouse , line can change color
			if(selected_Object != null) {
				List<Line_Object> line_object = canvas.getline();
				for(Line_Object target : line_object) {
					target.setisselect(false);
					if((target.returnfirstport() == whichport && target.returnfirstobject() == selected_Object)||(target.returnsecondport() == whichport && target.returnsecondobject() == selected_Object)) {
						target.setisselect(true);
					}
				}
			}
		}
		//init. show_select_area point
		if (selected_Object == null) {
			selected_area_point = new Point(px , py);
			List<Line_Object> line_object = canvas.getline();
			for(Line_Object target : line_object) {
				target.setisselect(false);
			}
		}
//		canvas.repaint();
	}
	
	private boolean checkobjectisinothergroup(List<Group_Object> g , Basic_Object ob) {
		for(Group_Object target : g) {
			if(target.getselectedobjectingroup().contains(ob)) {
				return true;
			}
		}
		return false;
	}
}
