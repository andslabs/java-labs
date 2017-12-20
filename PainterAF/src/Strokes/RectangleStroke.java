package Strokes;

import java.awt.BasicStroke;
import java.awt.Stroke;

public class RectangleStroke extends AbstractStrokes{
	
	public RectangleStroke() {
		stroke = new BasicStroke(10f);
	}
	
	public RectangleStroke(int width) {
		stroke = new BasicStroke(width);
	}
	
	@Override
	public void setWidth(int width) {
		stroke = new BasicStroke(width);
	}

	@Override
	public Stroke getStroke() {
		return this.stroke;
	}

}
