package Event;

import Object.Compline_Object;
import Object.Line_Object;

public class Comline_Event extends Line_Event{
	public Comline_Event() {
		
	}

	@Override
	public Line_Object linepointset(int ilx, int ilx1, int ily, int ily1) {
		Compline_Object compline = new Compline_Object(ilx, ilx1, ily, ily1);
		return compline;
	}
}
