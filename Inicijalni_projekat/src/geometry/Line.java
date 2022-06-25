package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
	private Point startPoint; 
	private Point endPoint;
	
	public Line() {

	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, Color color) {
		this(startPoint, endPoint);
		this.color = color;
	}
	
	public Line(Point startPoint, Point endPoint, Color color, boolean selected) {
		this(startPoint, endPoint, color);
		this.selected = selected;	
	}
	
	public double length() {
		return this.endPoint.distance(this.startPoint.getX(), this.startPoint.getY());
	}

	public Point getStartPoint() {
		return this.startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return this.endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
	@Override
	public String toString() {
		return this.startPoint + "-->" + this.endPoint;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Line) {
			Line l = (Line)obj;
			return this.getStartPoint().equals(l.getStartPoint()) && this.getEndPoint().equals(l.getEndPoint());
		} else {
			return false;
		}
	}
	
	public boolean contains(int x, int y) {
		double d = this.getStartPoint().distance(x, y) + this.getEndPoint().distance(x, y);
		return d - this.length() <= 2;
	}
	
	public boolean contains(Point point) {
		double d = this.getStartPoint().distance(point.getX(), point.getY()) + this.getEndPoint().distance(point.getX(), point.getY());
		return d - this.length() <= 2;
	}
	
	public void draw(Graphics g) {
		g.setColor(this.color);
		g.drawLine(this.startPoint.getX(), this.getStartPoint().getY(), this.endPoint.getX(), this.endPoint.getY());
		if(this.isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.startPoint.getX() - 2, this.startPoint.getY() - 2, 4, 4);
			g.drawRect(this.endPoint.getX() - 2, this.endPoint.getY() - 2, 4, 4);
			g.setColor(Color.black);
		}
	}
	
	public void moveBy(int x, int y) {
		this.startPoint.moveBy(x, y);
		this.endPoint.moveBy(x, y);
	}
	
	public void moveTo(int x, int y) {
		this.startPoint.moveTo(x, y);
		this.endPoint.moveTo(x, y);
	}
	
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Line) {
			return (int)(this.length() - ((Line)obj).length());
		}
		return 0;
	}
	
}
