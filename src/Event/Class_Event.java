package Event;

import Object.Class_object;
import UML_interface.UML_Canvas;

public class Class_Event extends Mouse_Event {
	
	//constructor
	public Class_Event() {
		
	}
	
	//public
	public void Mouse_Released(UML_Canvas canvas , int x , int y) {
		Class_object new_obj = new Class_object(x , y);
		canvas.addObject(new_obj);
		canvas.repaint();
	}
}
