package Event;

import java.awt.Point;
import java.util.List;
import Object.Basic_Object;
import Object.Line_Object;
import Object.Port_Object;
import UML_interface.UML_Canvas;

public abstract class Line_Event extends Mouse_Event{
	//default
	List<Basic_Object> basicobjects;
	Basic_Object firstobject = null , secondobject = null;
	int firstobjectport = -1, secondobjectport = -1;
	Line_Object lineobject;
	
	//constructor
	public Line_Event() {
		
	}
	// abstract to set line
	public abstract Line_Object linepointset(int ilx , int ilx1 , int ily , int ily1);
	
	//public
	public void initlineallstatus() {
		firstobjectport = -1;
		firstobject = null ;
		secondobjectport = -1;
		secondobject = null;
	}
	
	// override
	@Override
	public  void Mouse_Clicked(UML_Canvas canvas, int x, int y) {
	}
	@Override
	public  void Mouse_Released(UML_Canvas canvas, int x, int y) {
		if(firstobjectport >= 0) {
			basicobjects = canvas.getObject();
			for(Basic_Object target : basicobjects) {
				int whereportnum = target.mousewhereareaport(new Point(x,y));
				if(whereportnum >= 0) {
					secondobjectport = whereportnum;
					secondobject = target;
					break;
				}	
			}
		}
		
		//setting draw parameter
		if(firstobjectport >= 0 && secondobjectport >= 0 && firstobject != secondobject) {
			Port_Object firstPort = firstobject.getportposition(firstobjectport);
			Port_Object secondPort = secondobject.getportposition(secondobjectport);
			Line_Object buildline = linepointset((int)firstPort.getCenterX(), (int)secondPort.getCenterX() , (int)firstPort.getCenterY(),(int)secondPort.getCenterY());
			buildline.initfirstobjectport(firstobject, firstobjectport);
			buildline.initsecondobjectport(secondobject, secondobjectport);
			canvas.addline(buildline);
		}
		canvas.repaint();
		
		//init all line status
		initlineallstatus();
		canvas.cleardrawinglinestatus();
	}
	@Override
	public  void Mouse_Dragged(UML_Canvas canvas, int x, int y) {
		if(firstobjectport >= 0) {
			Port_Object firstport = firstobject.getportposition(firstobjectport);
			Line_Object line = linepointset((int)firstport.getCenterX(),x , (int)firstport.getCenterY(), y );
			canvas.setdrawinglinestatus(line);
			canvas.repaint();
		}
	}
	@Override
	public void Mouse_Pressed(UML_Canvas canvas, int x, int y) {
		basicobjects = canvas.getObject();
		for(Basic_Object target : basicobjects) {
			int whereportnum = target.mousewhereareaport(new Point(x,y));
			if(whereportnum >= 0) {
				firstobjectport = whereportnum;
				firstobject = target;
				break;
			}	
		}
	}
}
