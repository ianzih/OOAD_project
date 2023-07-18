package Event;

import UML_interface.UML_Canvas;

public abstract class Mouse_Event {
	public  void Mouse_Clicked(UML_Canvas canvas, int x, int y) {};
	public  void Mouse_Released(UML_Canvas canvas, int x, int y) {};
	public  void Mouse_Dragged(UML_Canvas canvas, int x, int y) {};
	public  void Mouse_Pressed(UML_Canvas canvas, int x, int y) {};
}
