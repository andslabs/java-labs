package com.painter.abstractfactory;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

import javax.swing.JComponent;

import com.sun.javafx.geom.Ellipse2D;

import javafx.scene.shape.Ellipse;

public class DrawArea extends JComponent {
	
	// Image in which we're going to draw
	private Image image;
	
	// Graphics2D object ==> used to draw on
	private Graphics2D g2;
	
	// Mouse coordinates
	private int currentX, currentY, oldX, oldY;
	
	public DrawArea() {
		setDoubleBuffered(false);
		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				oldX = e.getX();
				oldY = e.getY();
			}
			
		});
		
		addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				currentX = e.getX();
				currentY = e.getY();
				
				if (g2 != null) {
					g2.drawLine(oldX, oldY, currentX, currentY);
					repaint();
					oldX = currentX;
					oldY = currentY;
				}
			}
			
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		if (image == null) {
			// image == null ==> create
			image = createImage(getSize().width, getSize().height);
			g2 = (Graphics2D) image.getGraphics();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setStroke(new BasicStroke(20f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0f));
			clear();
		}
		
		g.drawImage(image, 0, 0, null);
	}
	
	// creating exposed methods
	public void clear() {
		g2.setPaint(Color.white);
		g2.fillRect(0, 0, getSize().width, getSize().height);
		g2.setPaint(Color.black);
		repaint();
	}
	
	public void red() {
		g2.setPaint(Color.red);
	}
	
	public void black() {
		g2.setPaint(Color.black);
	}
	
	public void magenta() {
		g2.setPaint(Color.magenta);
	}
	
	public void green() {
		g2.setPaint(Color.green);
	}
	
	public void blue() {
		g2.setPaint(Color.blue);
	}
}
