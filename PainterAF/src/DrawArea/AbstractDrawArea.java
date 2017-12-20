package DrawArea;

import java.awt.Color;
import Strokes.AbstractStrokes;

public interface AbstractDrawArea {
	public void createStroke(AbstractStrokes stroke);
	public void setColor(Color color);
	//public void setWidth(int width);
	public void clear();
}
