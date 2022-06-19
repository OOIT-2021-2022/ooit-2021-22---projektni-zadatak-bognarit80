package drawing;

import javax.swing.JPanel;

import geometry.Point;
import geometry.Shape;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Color;
import java.awt.GridLayout;

public class PnlDrawing extends JPanel {

	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public PnlDrawing() {
		setBackground(Color.WHITE);
		setLayout(new GridLayout(1, 0, 0, 0));

	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Shape> it = shapes.iterator();
		
		//call the draw func of all shape objects in the list
		while(it.hasNext())
			it.next().draw(g);
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}
	
	public void addShape(Shape sh) {
		shapes.add(sh);
	}
	
	//boolean type for confirming if an object was selected or not
	//early return ensures we can only select one object at a time
	//decreasing the iterator instead of increasing it ensures we select the objects on top first
	public boolean select(Point p) {
		for (int i = shapes.size() - 1; i >= 0; i--) {
			if (shapes.get(i).contains(p.getX(), p.getY())) {
				shapes.get(i).setSelected(true);
				return true;
			}
		}			
		return false;
	}
	
	public void deselectAll() {
		for (int i = 0; i < shapes.size(); i++) {
			shapes.get(i).setSelected(false);
		}
	}
}
