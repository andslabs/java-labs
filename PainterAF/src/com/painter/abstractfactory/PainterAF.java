package com.painter.abstractfactory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.org.apache.bcel.internal.generic.NEW;

import DrawArea.CircleDrawArea;
import DrawArea.RectangleDrawArea;

public class PainterAF extends Component {
	JButton colorChooserBtn, clearBtn;
	JComboBox<String> widthList;
	RectangleDrawArea rectangleDrawArea;
	CircleDrawArea circleDrawArea;
	String[] widths = {"1", "5", "10", "15", "20", "25", "30", "35", "40"};
	
	ActionListener actionListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == clearBtn) {
				rectangleDrawArea.clear();
				circleDrawArea.clear();
			} else if (e.getSource() == colorChooserBtn) {
				setNewColor();
			} else if (e.getSource() == widthList) {
				setNewWidth(widthList.getSelectedIndex());
			}
			
		}
	};

	public static void main(String[] args) {
		new PainterAF().show();
	}
	
	public void setNewColor() {
		Color color = JColorChooser.showDialog(this, "Choose Color", Color.gray);
		if (color != null) {
			rectangleDrawArea.setColor(color);
			circleDrawArea.setColor(color); 
		}
	};
	
	public void setNewWidth(int index) {
		int width = Integer.parseInt(widths[index]);
		this.rectangleDrawArea.setWidth(width);
		this.circleDrawArea.setWidth(width);
	}

	public void show() {
		// create main frame
		JFrame frame = new JFrame("PainterAF");
		Container content = frame.getContentPane();

		// set layout on content pane
		content.setLayout(new BorderLayout());

		// create draw area
		AreaCreator areaCreator = new AreaCreator(new RectangleDrawArea());
		rectangleDrawArea = areaCreator.getRectangle();
		
		areaCreator = new AreaCreator(new CircleDrawArea());
		circleDrawArea = areaCreator.getCircle();

		content.add(circleDrawArea, BorderLayout.LINE_START);
		content.add(rectangleDrawArea, BorderLayout.LINE_END);
		
		
		// create controls to apply colors and call clear feature
		JPanel controls = new JPanel();

		clearBtn = new JButton("Clear");
		clearBtn.addActionListener(actionListener);
		
		colorChooserBtn = new JButton("Choose color");
		colorChooserBtn.addActionListener(actionListener);
		
		widthList = new JComboBox<>(this.widths);
		widthList.addActionListener(actionListener);
		
		// add to controls panel
		controls.add(clearBtn);
		controls.add(colorChooserBtn);
		controls.add(widthList);
		
		// add to content pane
		content.add(controls, BorderLayout.NORTH);
		
		frame.setSize(800, 476);
		frame.setBackground(Color.gray);
		// can close frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// show the swing paint result
		frame.setVisible(true);
	}
}
