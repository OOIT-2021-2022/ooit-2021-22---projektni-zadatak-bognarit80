package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape2D {
	
	private int radius;
	private Point center;
	
	public Circle() {
		this.center = new Point();
	}
	
	public Circle(Point center, int radius) {
		this.radius = radius;
		this.center = center;
	}
	
	public Circle(Point center, int radius, Color edgeColor, Color fillColor) {
		this(center, radius);
		this.color = edgeColor;
		this.fillColor = fillColor;
	}
	
	public Circle(Point center, int radius, Color edgeColor, Color fillColor, boolean selected) {
		this(center, radius, edgeColor, fillColor);
		this.selected = selected;
	}
	
	public double area() {
		return this.radius * this.radius * Math.PI;
	}
	
	public double circumference() {
		return 2 * this.radius * Math.PI;
	}

	public int getRadius() {
		return this.radius;
	}

	public void setRadius(int radius) throws Exception {
		if(radius < 0) {
			throw new Exception("Radius cannot be negative!");
		}
		this.radius = radius;
	}

	public Point getCenter() {
		return this.center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public String toString() {
		return "Center = " + this.getCenter().toString() + ", Radius = " + this.radius;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Circle) {
			Circle c = (Circle) obj;
			return this.getCenter().equals(c.getCenter()) && this.getRadius() == c.getRadius();
		} else {
			return false;
		}
	}
	
	public boolean contains(int x, int y) {
		return this.getCenter().distance(x, y) <= this.radius;
	}
	
	public boolean contains(Point point) {
		return this.getCenter().distance(point.getX(), point.getY()) <= this.radius;
	}
	
	public void fill(Graphics g) {
		g.setColor(this.fillColor);
		g.fillOval(this.center.getX() - this.radius + 1, this.center.getY() - this.radius + 1,
				this.radius * 2 - 2, this.radius * 2 - 2);
	}
	
	public void draw(Graphics g) {
		int xRect = this.center.getX() - this.radius;
		int yRect = this.center.getY() - this.radius;
		int a = 2 * this.radius;
		g.setColor(this.color);
		g.drawOval(xRect, yRect, a, a);
		this.fill(g);
		if (this.isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.center.getX() - 2, this.center.getY() - 2, 4, 4);
			g.drawRect(this.center.getX() - this.radius - 2, this.center.getY() - 2, 4, 4);
			g.drawRect(this.center.getX() + this.radius - 2, this.center.getY() - 2, 4, 4);
			g.drawRect(this.center.getX() - 2, this.center.getY() - this.radius - 2, 4, 4);
			g.drawRect(this.center.getX() - 2, this.center.getY() + this.radius - 2, 4, 4);
			g.setColor(Color.black);
		}
	}
	
	public void moveTo(int x, int y) {
		this.center.moveTo(x, y);
	}
	
	public void moveBy(int x, int y) {
		this.center.moveBy(x, y);
	}
	
	@Override
	public int compareTo(Object obj) {
		if (obj instanceof Circle) {
			return (int)(this.area() - ((Circle)obj).area());
		}
		return 0;
	}
}
