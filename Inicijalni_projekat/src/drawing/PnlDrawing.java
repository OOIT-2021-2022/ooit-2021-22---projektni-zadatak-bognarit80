package drawing;

import javax.swing.JPanel;


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
}
