package com.painter.abstractfactory;

import DrawArea.CircleDrawArea;
import DrawArea.RectangleDrawArea;
import Strokes.AbstractStrokes;
import Strokes.CircleStroke;
import Strokes.RectangleStroke;

public class AreaCreator {
	private AbstractStrokes stroke;
	private RectangleDrawArea rectanglePane;
	private CircleDrawArea circlePane;
	
	public AreaCreator(Object obj) {
		if (obj.getClass().equals(RectangleDrawArea.class)) {
			rectanglePane = (RectangleDrawArea) obj;
			rectanglePane.createStroke(new RectangleStroke());
		} else if (obj.getClass().equals(CircleDrawArea.class)) {
			circlePane = (CircleDrawArea) obj;
			circlePane.createStroke(new CircleStroke());
		} else {
			System.out.println("Error in parsing class name");
		}
	}
	
	public RectangleDrawArea getRectangle() {
		return this.rectanglePane;
	}
	
	public CircleDrawArea getCircle() {
		return this.circlePane;
	}
}
