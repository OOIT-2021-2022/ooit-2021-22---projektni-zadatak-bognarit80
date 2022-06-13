package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
	private Point upperLeftPoint;
	private int height;
	private int width;
	
	 public Rectangle () {
		 this.upperLeftPoint = new Point();
	 }
	 
	public Rectangle(Point upperLeftPoint, int height, int width)  {
		this.upperLeftPoint = upperLeftPoint;
		this.height = height;
		this.width = width;
	}
	
	public Rectangle(Point upperLeftPoint, int height, int width, boolean selected) {
		this(upperLeftPoint, height, width);
		this.selected = selected;
	}
	
	public double area() {
		return (this.height * this.width);
	}
	
	public double circumference() {
		return 2 * (this.height + this.width);
	}

	public Point getUpperLeftPoint() {
		return this.upperLeftPoint;
	}

	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	@Override
	public String toString() {
		return "Upper left point: " + this.upperLeftPoint + ", width = "+ this.width + ", height = "+ this.height;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle r = (Rectangle)obj;
			return r.getUpperLeftPoint().equals(this.upperLeftPoint) &&
					r.getHeight() == this.height && r.getWidth() == this.width;
		} else {
			return false;
		}
	}
	
	public boolean contains(int x, int y) {
		if(x > this.upperLeftPoint.getX() && x < this.upperLeftPoint.getX() + width
				&& y > this.upperLeftPoint.getY() && y < this.getUpperLeftPoint().getY() + height) {
			return true;
		}
		return false;
	}
	
	public boolean contains(Point point) {
		if(point.getX() > this.upperLeftPoint.getX() && point.getX() < this.upperLeftPoint.getX() + width
				&& point.getY()> this.upperLeftPoint.getY() && point.getY() < this.getUpperLeftPoint().getY() + height) {
			return true;
		}
		return false;
	}
	
	public void draw(Graphics g) {
		g.drawRect(this.upperLeftPoint.getX(), this.upperLeftPoint.getY(), this.width, this.height);
		if(this.isSelected()) {
			g.setColor(Color.blue);
			g.drawRect(this.upperLeftPoint.getX() - 2, this.upperLeftPoint.getY() - 2, 4, 4);
			g.drawRect(this.upperLeftPoint.getX() + this.width - 2, this.upperLeftPoint.getY() - 2, 4, 4);
			g.drawRect(this.upperLeftPoint.getX() - 2, this.upperLeftPoint.getY() + this.height - 2, 4, 4);
			g.drawRect(this.upperLeftPoint.getX() + this.width  - 2, this.upperLeftPoint.getY() + this.height - 2, 4, 4);
			g.setColor(Color.black);
		}

	}
	
	public void moveTo(int x, int y) {
		this.upperLeftPoint.moveTo(x, y);
	}
	
	public void moveBy(int x, int y) {
		this.upperLeftPoint.moveBy(x, y);
	}
	
	@Override
	public int compareTo(Object o) {
		if (o instanceof Rectangle) {
			return (int) (this.area() - ((Rectangle) o).area());
		}
		return 0;
	}
}
