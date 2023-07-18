package Object;

 
import java.awt.Graphics2D;

public class Line_Object {
	int lx , lx1 , ly , ly1;
	int firstport, secondport;
	Basic_Object firstobj , secondobj;
	boolean isselect = false;
	
	//constructor
	public Line_Object() {
		
	}
	
	
	public void line_draw(Graphics2D g) {
	}
	
	//public
	public void updatelineposition() {
		lx = (int)firstobj.getportposition(firstport).getCenterX();
		ly = (int)firstobj.getportposition(firstport).getCenterY();
		lx1 = (int)secondobj.getportposition(secondport).getCenterX();
		ly1 = (int)secondobj.getportposition(secondport).getCenterY();
		
	}
	public void initfirstobjectport(Basic_Object obj , int whitchport) {
		firstobj = obj;
		firstport = whitchport;
	}
	
	public void initsecondobjectport(Basic_Object obj , int whitchport) {
		secondobj = obj;
		secondport = whitchport;
	}
	public int returnfirstport() {
		return firstport;
	}
	public int returnsecondport() {
		return secondport;
	}
	public Basic_Object returnfirstobject() {
		return firstobj;
	}
	public Basic_Object returnsecondobject() {
		return secondobj;
	}
	public void setisselect(boolean bool) {
		isselect = bool;
	}
}
