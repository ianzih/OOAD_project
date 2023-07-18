package UML_interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import Event.*;
 

@SuppressWarnings("serial")
public class UML_Tool extends JToolBar{
	int tool_num = 6 ;
	Tool_Button selectbutton = null;
	UML_Canvas tool_canvas;
	
	// constructor
	UML_Tool(UML_Canvas canvas){
		setLayout(new GridLayout(tool_num,1,2,2));
		tool_canvas = canvas;
		Build_tool(); 
	}
	
	// private
	private void Build_tool() {
		// select
		ImageIcon selectIcon = new ImageIcon("src/image/select.png");
		ImageIcon select_final = new ImageIcon(selectIcon.getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT));
		Tool_Button selectbutton = new Tool_Button(select_final , "select" , new Select_Event());
		add(selectbutton);
		
		//asso_line
		ImageIcon asso_lineIcon = new ImageIcon("src/image/asso_line.png");
		ImageIcon asso_line_final = new ImageIcon(asso_lineIcon.getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT));
		Tool_Button asso_linebutton = new Tool_Button(asso_line_final , "asso. line" , new Assoline_Event());
		add(asso_linebutton);
		
		//gen_line
		ImageIcon gen_lineIcon = new ImageIcon("src/image/gen_line.png");
		ImageIcon gen_line_final = new ImageIcon(gen_lineIcon.getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT));
		Tool_Button gen_linebutton = new Tool_Button(gen_line_final , "gen. line" , new Genline_Event());
		add(gen_linebutton);
		
		//composition_line
		ImageIcon composition_lineIcon = new ImageIcon("src/image/composition_line.png");
		ImageIcon composition_line_final = new ImageIcon(composition_lineIcon.getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT));
		Tool_Button composition_linebutton = new Tool_Button(composition_line_final , "com. line" , new Comline_Event());
		add(composition_linebutton);
		
		//Class
		ImageIcon ClassIcon = new ImageIcon("src/image/Class.png");
		ImageIcon ClassIcon_final = new ImageIcon(ClassIcon.getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT));
		Tool_Button Classbutton = new Tool_Button(ClassIcon_final , "class" , new Class_Event());
		add(Classbutton);
		
		//use_case
		ImageIcon use_caseIcon = new ImageIcon("src/image/use_case.png");
		ImageIcon use_caseIcon_final = new ImageIcon(use_caseIcon.getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT));
		Tool_Button use_casebutton = new Tool_Button(use_caseIcon_final , "usecase" , new Usecase_Event());
		add(use_casebutton); 
	}
	
	// private nested class
	private class Tool_Button extends JButton{
		private Mouse_Event  mode;
		Tool_Button(ImageIcon imgicon, String name, Mouse_Event mouse_mode) {
			setIcon(imgicon);
			setText(name);
			setPreferredSize(new Dimension(200,150));
			setBackground(new Color(255, 255, 255));
			setRolloverEnabled(true);
			setFocusable(false);
			setFloatable(false);
			setVisible(true);
			
			mode = mouse_mode;
			addActionListener(new toolaction());
		}
		// button display action 
		class toolaction implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(selectbutton != null)
					selectbutton.setBackground(new Color(255,255,255));
				selectbutton = (Tool_Button) e.getSource(); 
				selectbutton.setBackground(new Color(150,150,100));
				tool_canvas.clearselectObject();
				tool_canvas.repaint();
				tool_canvas.set_curr_mouse_event(mode);
			}
		}
	}
}
