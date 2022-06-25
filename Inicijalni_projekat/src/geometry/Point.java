package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {
	
	private int x;
	private int y;
	
	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, int y, boolean selected) {
		this(x,y);
		this.selected = selected;
	}
	
	public Point(int x, int y, Color color) {
		this(x, y);
		this.color = color;
	}
	
	public Point(int x, int y, Color color, boolean selected) {
		this(x, y, color);
		this.selected = selected;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public double distance(int x2, int y2) {
		double dx = x2 - this.x;
		double dy = y2 - this.y;
		double d = Math.sqrt(dx*dx + dy*dy);
		return d;
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point p = (Point)obj;
			return this.x == p.x && this.y == p.y;
		} else {
			return false;
		}
	}
	
	public boolean contains(int x, int y) {
		return this.distance(x, y) <= 2;
	}
	
	public boolean contains(Point p) {
		return this.distance(p.getX(), p.getY()) <= 2;
	}
	
	@Override
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}
	
	public void draw(Graphics g) {
		g.setColor(this.getColor());
		g.drawLine(this.x - 2, this.y, this.x + 2, this.y);
		g.drawLine(this.x, this.y - 2, this.x, this.y + 2);
		if (this.selected) {
			g.setColor(Color.BLUE);
			g.drawRect(x - 2, y - 2, 4, 4);
			g.setColor(Color.BLACK);
		}
	}
	
	public void moveBy(int x, int y) {
		this.x += x;
		this.y += y;
	}
	
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Point) {
			double d1 = this.distance(0, 0);
			double d2 = ((Point)obj).distance(0, 0);
			return (int)(d1 - d2);
		} else {
			return 0;
		}
	}
}
