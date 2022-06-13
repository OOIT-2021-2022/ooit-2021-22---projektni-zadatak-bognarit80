package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {

	private int innerRadius;
	
	public Donut() {
		super();
	}
	
	public Donut(Point center, int innerRadius, int radius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center, innerRadius, radius);
		this.setSelected(selected);
	}
	
	public int getInnerRadius() {
		return this.innerRadius;
	}
	
	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public double area() {
		return super.area() - Math.PI * this.innerRadius * this.innerRadius;
	}
	
	public String toString() {
		return super.toString() + ", innerRadius = " + this.innerRadius;
	}
	
	@Override
	public boolean equals(Object obj) {			
		if(obj instanceof Donut) {
			Donut d = (Donut)obj;
			return super.equals(d) && this.innerRadius == d.innerRadius;
		} else {
			return false;
		}
	}
	
	public boolean contains(int x, int y) {
		double d = this.getCenter().distance(x, y);
		if (d > this.innerRadius && super.contains(x, y)) {
			return true;
		}
		return false;
	}
	
	public boolean contains(Point p) {
		return super.contains(p) && this.getCenter().distance(p.getX(), p.getY()) >= this.innerRadius;
	}
	
	public void draw(Graphics g) {
		super.draw(g);
		int xRect = this.getCenter().getX() - this.innerRadius;
		int yRect = this.getCenter().getY() - this.innerRadius;
		int a = this.innerRadius*2;
		g.drawOval(xRect, yRect, a, a);
		if (this.isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.getCenter().getX() - 2, this.getCenter().getY() - 2, 4, 4);
			g.drawRect(this.getCenter().getX() - this.innerRadius - 2, this.getCenter().getY() - 2, 4, 4);
			g.drawRect(this.getCenter().getX() + this.innerRadius - 2, this.getCenter().getY() - 2, 4, 4);
			g.drawRect(this.getCenter().getX() - 2, this.getCenter().getY() - this.innerRadius - 2, 4, 4);
			g.drawRect(this.getCenter().getX() - 2, this.getCenter().getY() + this.innerRadius - 2, 4, 4);
			g.setColor(Color.black);
		}
		
	}
	
	@Override
	public int compareTo(Object obj) {
		if (obj instanceof Donut) {
			return (int) (this.area() - ((Donut) obj).area());
		}
		return 0;
	}
}
