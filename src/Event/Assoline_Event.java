package Event;

import Object.Assoline_Object;
import Object.Line_Object;


public class Assoline_Event extends Line_Event{
	public Assoline_Event() {
		
	}
	@Override
	public Line_Object linepointset(int ilx, int ilx1, int ily, int ily1) {
		Assoline_Object assoline = new Assoline_Object(ilx, ilx1, ily, ily1);
		return assoline;
	}

}
