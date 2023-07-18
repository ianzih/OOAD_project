package UML_interface;

//import
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class UMLUsers extends JFrame{
	// default
	UML_Canvas canvas;
	UML_Tool tool;
	UML_Menu menu;
	
	
	//constructor
	public UMLUsers() {
		setUserInterface();
		buildCanvas();
		buildTool();
		buildMenu();
	}
	
	//set user interface
	private void setUserInterface() {
		setTitle("UML");
		setMinimumSize(new Dimension(1200,1000));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	// build canvas
	private void buildCanvas() {
		canvas = new UML_Canvas();
		add(canvas , BorderLayout.CENTER);
	}
	// build toll
	private void buildTool() {
		tool = new UML_Tool(canvas);
		add(tool , BorderLayout.WEST);
	}
	//build menu
	private void buildMenu() {
		menu = new UML_Menu(canvas);
		setJMenuBar(menu);
	}
	
	public static void main(String[] args) {
		new UMLUsers();
	}
}
