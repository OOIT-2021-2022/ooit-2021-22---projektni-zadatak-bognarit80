package geometry;

import java.awt.Graphics;

public abstract class Shape implements Moveable, Comparable {
	protected boolean selected;
	
	public Shape() {
		
	}
	
	public Shape(boolean selected) {
		this.selected = selected;
	}
	
	public boolean isSelected() {
		return this.selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public abstract void draw(Graphics g);
}
