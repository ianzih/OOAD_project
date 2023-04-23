package Event;

import Object.Usecase_Object;
import UML_interface.UML_Canvas;

public class Usecase_Event extends Mouse_Event{
	
	public Usecase_Event() {
		
	}

	//public
	public void Mouse_Released(UML_Canvas canvas, int x, int y) {
		Usecase_Object new_obj = new Usecase_Object(x , y);
		canvas.addObject(new_obj);
		canvas.repaint();
	}
}
