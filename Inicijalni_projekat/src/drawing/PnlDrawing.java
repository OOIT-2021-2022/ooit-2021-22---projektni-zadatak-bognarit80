package drawing;

import javax.swing.JPanel;

import geometry.Point;
import geometry.Shape;
import geometry.Shape2D;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Color;
import java.awt.GridLayout;

public class PnlDrawing extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Shape> shapes = new ArrayList<>();
	
	public PnlDrawing() {
		setBackground(Color.WHITE);
		setLayout(new GridLayout(1, 0, 0, 0));
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Shape> it = shapes.iterator();
		
		//call the draw func of all shape objects in the list
		while(it.hasNext())
			it.next().draw(g);
	}
	
	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}
	
	public void addShape(Shape sh) {
		shapes.add(sh);
		repaint();
	}
	
	/**
	 * Boolean type for confirming if an object was selected or not.
	 * Early return ensures we can only select one object at a time.
	 * Decreasing the iterator instead of increasing it ensures we select the objects on top first.
	 * @param p - Click coordinates (geometry.Point)
	 * @return true if the click selected an object, otherwise false
	 */
	public boolean select(Point p) {
		for (int i = shapes.size() - 1; i >= 0; i--) {
			if (shapes.get(i).contains(p.getX(), p.getY())) {
				shapes.get(i).setSelected(true);
				repaint();
				return true;
			}
		}			
		repaint();
		return false;
	}
	
	/**
	 * Returns the index of the selected Shape in the array, newest to oldest.
	 * Returns -1 if no elements are selected.
	 * @return The index of the selected shape, or -1 if no elements are selected.
	 */
	public int getSelectedIndex() {
		for(int i = shapes.size() - 1; i >= 0; i--) {
			if (shapes.get(i).isSelected()) {
				return i;
			}
		}
		return -1; //no selected elements
	}
	
	/**
	 * Deselects all shapes in the list, then calls repaint() to clear the "selected" graphics.
	 */
	public void deselectAll() {
		for (int i = 0; i < shapes.size(); i++) {
			shapes.get(i).setSelected(false);
		}
		repaint();
	}
	
	public int getShapesCount() {
		return shapes.size();
	}
	
	public Shape getShapeAt(int index) {
		return shapes.get(index);
	}
	
	public void deleteShapeAt(int index) {
		shapes.remove(index);
		repaint();
	}
	
	public void deleteAt(Point p) {
		for (int i = shapes.size() - 1; i >= 0; i--) {
			if (shapes.get(i).contains(p.getX(), p.getY())) {
				this.deleteShapeAt(i);
				repaint();
			}
		}
	}
	
	 /**
	  * Deletes all selected shapes, unlike deleteShapeAt(int).
	  */
	public void deleteSelected() {
		for (int i = shapes.size() - 1; i >= 0; i--) {
			if (shapes.get(i).isSelected()) {
				shapes.remove(i);
			}
		}
		repaint();
	}
	
	public void moveSelected(int x, int y) {
		for (int i = shapes.size() - 1; i >= 0; i--) {
			if (shapes.get(i).isSelected()) {
				shapes.get(i).moveBy(x, y);
			}
		}
		repaint();
	}
	
	/**
	 * Sets the color to all selected shapes to default.
	 */
	public void clearColorOfSelected() {
		for (int i = shapes.size() - 1; i >= 0; i--) {
			Shape shape = shapes.get(i);
			if (shape.isSelected()) {
				if (shape instanceof Shape2D) {
					shape.setColor(Color.BLACK);
					((Shape2D)shape).setFillColor(Color.WHITE);
				}
			}
		}
		repaint();
	}
}
