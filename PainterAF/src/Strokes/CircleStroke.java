package Strokes;

import java.awt.BasicStroke;
import java.awt.Stroke;

public class CircleStroke extends AbstractStrokes {

	public CircleStroke() {
		stroke = new BasicStroke(10f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0f);
	}
	
	public CircleStroke(int width) {
		stroke = new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0f);
	}
	
	@Override
	public void setWidth(int width) {
		
	}

	@Override
	public Stroke getStroke() {
		return this.stroke;
	}

}
