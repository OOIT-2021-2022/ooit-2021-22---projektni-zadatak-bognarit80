package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape2D extends Shape {
	
	protected Color fillColor;
	
	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public abstract void fill(Graphics g);
}
