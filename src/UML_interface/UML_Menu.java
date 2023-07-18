package UML_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
 

@SuppressWarnings("serial")
public class UML_Menu extends JMenuBar{
	public UML_Canvas  canvas;
	public UML_Menu(UML_Canvas icanvas) {
		canvas = icanvas; 
		//file
		JMenu filemenu = new JMenu("File");
		add(filemenu);
		
		// edit
		JMenu editmenu = new JMenu("Edit");
		add(editmenu);
		
		JMenuItem objectnamechange = new JMenuItem("change object name");
		objectnamechange.addActionListener(new objectnamechangeevent()); 
		editmenu.add(objectnamechange);
		
		JMenuItem groupitem = new JMenuItem("setgroup");
		groupitem.addActionListener(new setgroupevent());
		editmenu.add(groupitem);
		
		JMenuItem ungroupitem = new JMenuItem("ungroup");
		ungroupitem.addActionListener(new ungroupevent());
		editmenu.add(ungroupitem);
		
		add(editmenu);
	}
	
	// implement action listener
	class objectnamechangeevent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(canvas.canobjectnamechange() == true) {
				canobjectnamechange();
			}
		}
	}
	class setgroupevent implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			canvas.setgroup();
		}
	}
	class ungroupevent implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			canvas.ungroup();
		}
	}
	
	// private
	private void canobjectnamechange() {
		JFrame inputFrame = new JFrame();
		inputFrame.setSize(400, 150);
        String getnewname = JOptionPane.showInputDialog(inputFrame, "Enter your message");
//		System.out.println(getnewname);
        if(getnewname != null)
        	canvas.objectnewnamechange(getnewname);
	}

}
