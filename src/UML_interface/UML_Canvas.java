package UML_interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import Event.Mouse_Event;
import Object.Area_Object;
import Object.Basic_Object;
import Object.Group_Object;
import Object.Line_Object;
import Object.Selected_Object;
 

@SuppressWarnings("serial")
public class UML_Canvas extends JPanel{
	//default //
	Mouse_Event curr_mouse_event = null;
	List<Basic_Object> objects = new ArrayList<Basic_Object>();
	List<Selected_Object> selectobjects = new ArrayList<Selected_Object>();
	List<Line_Object> lines_objects = new ArrayList<Line_Object>();
	List<Group_Object> groups = new ArrayList<Group_Object>();
	Area_Object selectarea = null;
	Line_Object drawingline = null;
	UML_Canvas thisCanvas = this;
	
	//constructor //
	UML_Canvas() {
		setLayout(null);
		setOpaque(true);
		setBackground(new Color(255,255,255));
		Override_Mouse_Adapter();		
	}
	
	// private //
	private void Override_Mouse_Adapter() {
		// override canvas mouse event, using MouseAdapter class
		MouseAdapter canvasmouseadapter = (new MouseAdapter() {
			//clicked
			public void mouseClicked(MouseEvent e) {
				if (curr_mouse_event != null)
					curr_mouse_event.Mouse_Clicked(thisCanvas, e.getX(), e.getY());
			}
			//release
			public void mouseReleased(MouseEvent e) {
				if (curr_mouse_event != null)
					curr_mouse_event.Mouse_Released(thisCanvas, e.getX(), e.getY());
			}
			//Dragged
			public void mouseDragged(MouseEvent e) {
				if (curr_mouse_event != null)
					curr_mouse_event.Mouse_Dragged(thisCanvas, e.getX(), e.getY());
			}
			//Pressed
			public void mousePressed(MouseEvent e) {
				if (curr_mouse_event != null)
					curr_mouse_event.Mouse_Pressed(thisCanvas, e.getX(), e.getY());
			}
		});
		addMouseListener(canvasmouseadapter);
        addMouseMotionListener(canvasmouseadapter);
	}
	
	// public //
	public void set_curr_mouse_event(Mouse_Event mouseevent) {
		curr_mouse_event = mouseevent;
	}
	
	//select object <add , clear , get>
	public void addselectObject(Selected_Object selectobject) {
		selectobjects.add(selectobject);
	}
	public void clearselectObject() {
		selectobjects.clear();
	}
	public List<Selected_Object> getselectObject() {
		return selectobjects;
	}
	
	//object <add , clear , get>
	public void addObject(Basic_Object object) {
		objects.add(object);
	}
	public void clearObject() {
		objects.clear();
	}
	public List<Basic_Object> getObject() {
		return objects;
	}
	
	//line <add , clear , get , update>
	public void addline(Line_Object line) {
		lines_objects.add(line);
	}
	public void clearline() {
		lines_objects.clear();
	}
	public List<Line_Object> getline(){
		return lines_objects;
	}
	public void updateline() {
		for(Line_Object target : lines_objects) {
			target.updatelineposition();
		}
	}
	
	//drawing line <add , clear>
	public void cleardrawinglinestatus() {
		drawingline = null;
	}
	public void setdrawinglinestatus(Line_Object line) {
		drawingline = line;
	}
	
	// group <get , add , clear> <setgroup , ungroup>
	public List<Group_Object> getgroup(){
		return groups;
	}
	public void addgroup(Group_Object group) {
		groups.add(group);
	}
	public void cleargroup() {
		groups.clear();
	}
	public void setgroup() {
		if(selectobjects.size() > 1) {
			addgroup(new Group_Object(selectobjects));
			addselectObject(new Group_Object(selectobjects));
		}
		repaint();
	}
	public void ungroup() {
		if(selectobjects.size() == 1 && selectobjects.get(0).getClass() == Group_Object.class) {
			groups.remove(selectobjects.get(0));
			selectobjects.remove(selectobjects.get(0));
		}
		repaint();
	}
	
	//select area
	public void addselectarea(Area_Object area) {
		selectarea = area;
	}
	public void clearselectarea() {
		selectarea = null;
	}
	
	// menu change name
	public boolean canobjectnamechange() {
		if(selectobjects.size() == 1 && objects.contains(selectobjects.get(0)))
			return true;
		return false;
	}
	public void objectnewnamechange(String newname) {
		Basic_Object changnameobj = (Basic_Object) selectobjects.get(0);
		changnameobj.setobjectname(newname);
		repaint();
	}
	
	public void paint(Graphics g) {
		Dimension dim = getSize();
		g.setColor(new Color(255,255,255));
		g.fillRect(0, 0, dim.width, dim.height);
		
		Color paintingColor = new Color(20,20,120);
		g.setColor(paintingColor);
		
		
		for (Basic_Object target : objects) {
			target.object_draw(g);
		}
		
		for(Line_Object target : lines_objects) {
			Graphics2D g2 = (Graphics2D)g;
			target.line_draw(g2);
		}
		
		if(selectobjects.size() > 0) {
			for(Selected_Object target : selectobjects) {
				target.drawSelectedObject(g);
			}
		}
		
		//show line
		if(drawingline != null) {
			Graphics2D g2 = (Graphics2D)g;
			drawingline.line_draw(g2);
		}
		
		//show select area
		if (selectarea != null) {
			selectarea.draw_area(g);
		}
	}
}
