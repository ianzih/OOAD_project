package Event;

 
import Object.Genline_Object;
import Object.Line_Object;
 

public class Genline_Event extends Line_Event{
	
	public Genline_Event() {
		
	}
	@Override
	public Line_Object linepointset(int ilx, int ilx1, int ily, int ily1) {
		Genline_Object Genline = new Genline_Object(ilx, ilx1, ily, ily1);
		return Genline;
	}
}
