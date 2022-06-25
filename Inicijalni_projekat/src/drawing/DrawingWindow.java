package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Insets;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DrawingWindow extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ButtonGroup that contains the Draw and Select togglebuttons.
	 */
	private ButtonGroup btnAction = new ButtonGroup();
	/**
	 * ButtonGroup that contains the Edit, Delete and Clear Color buttons.
	 */
	private ButtonGroup btnModify = new ButtonGroup();
	/**
	 * ButtonGroup that contains the shape togglebuttons.
	 */
	private ButtonGroup btnShape = new ButtonGroup();

	private JPanel contentPane;
	
	//used for Line drawing
	private Point startingPoint = null;
	//default colors	
	private Color edgeColor = Color.BLACK;
	private Color fillColor = Color.WHITE;
	
	//used for moving functionality
	private int lastX = 0;
	private int lastY = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingWindow frame = new DrawingWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the frame.
	 */
	public DrawingWindow() {
		setTitle("Bognar Nemanja IT80/2021");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		PnlDrawing pnlDrawing = new PnlDrawing();
		
		
		pnlDrawing.setBorder(new EmptyBorder(0, 0, 5, 5));
		contentPane.add(pnlDrawing, BorderLayout.CENTER);
		pnlDrawing.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(new EmptyBorder(10, 5, 10, 10));
		contentPane.add(leftPanel, BorderLayout.WEST);
		GridBagLayout gbl_leftPanel = new GridBagLayout();
		gbl_leftPanel.columnWidths = new int[]{89, 0};
		gbl_leftPanel.rowHeights = new int[]{26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 0};
		gbl_leftPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_leftPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		leftPanel.setLayout(gbl_leftPanel);
		
		JToggleButton btnDraw = new JToggleButton("Draw");
		btnDraw.setToolTipText("Select the shape and click on the canvas to start drawing.");
		btnDraw.setSelected(true);
		GridBagConstraints gbc_btnDraw = new GridBagConstraints();
		gbc_btnDraw.fill = GridBagConstraints.BOTH;
		gbc_btnDraw.insets = new Insets(0, 0, 5, 0);
		gbc_btnDraw.gridx = 0;
		gbc_btnDraw.gridy = 0;
		leftPanel.add(btnDraw, gbc_btnDraw);
		btnAction.add(btnDraw);
		
		JToggleButton btnSelect = new JToggleButton("Select");
		btnSelect.setToolTipText("Select the shapes on the canvas to modify or delete them.");
		GridBagConstraints gbc_btnSelect = new GridBagConstraints();
		gbc_btnSelect.fill = GridBagConstraints.BOTH;
		gbc_btnSelect.insets = new Insets(0, 0, 5, 0);
		gbc_btnSelect.gridx = 0;
		gbc_btnSelect.gridy = 1;
		leftPanel.add(btnSelect, gbc_btnSelect);
		btnAction.add(btnSelect);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = pnlDrawing.getSelectedIndex();
				if (i == -1) {
					JOptionPane.showMessageDialog(null, "No shapes selected!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				Shape shape = pnlDrawing.getShapeAt(i);
				
				//big elseif block; just check what type our selected shape is
				//and then instantiate its dialog,
				//by passing the shape downcasted to the appropriate shape
				//then modify that shape by changing its values to be equal to the new shape from dlg
				
				if (shape instanceof Point) {
					DlgPoint dlgPoint = new DlgPoint();
					dlgPoint.setPoint((Point)shape);
					dlgPoint.setVisible(true);
					Point point = dlgPoint.getPoint();
					
					if (dlgPoint.getPoint() != null) {
						((Point) shape).setX(point.getX());
						((Point) shape).setY(point.getY());
						shape.setColor(dlgPoint.getPoint().getColor());
					}
				}
				
				else if (shape instanceof Line) {
					DlgLine dlgLine = new DlgLine();
					dlgLine.setLine(((Line)shape).getStartPoint(), ((Line)shape).getEndPoint());
					dlgLine.setVisible(true);
					Line line = dlgLine.getLine();
					
					if (line != null) {
						((Line) shape).setStartPoint(line.getStartPoint());
						((Line) shape).setEndPoint(line.getEndPoint());
						shape.setColor(line.getColor());
					}
				}
				
				else if (shape instanceof Rectangle) {
					DlgRectangle dlgRectangle = new DlgRectangle();
					dlgRectangle.setRectangle((Rectangle)shape);
					dlgRectangle.setVisible(true);
					Rectangle rect = dlgRectangle.getRectangle();
					
					if (rect != null) {
						((Rectangle) shape).setUpperLeftPoint(rect.getUpperLeftPoint());
						((Rectangle) shape).setWidth(rect.getWidth());
						((Rectangle) shape).setHeight(rect.getHeight());
						shape.setColor(rect.getColor());
						((Rectangle) shape).setFillColor(rect.getFillColor());
					}
				}
				
				//since donut is also a circle, we check for donut first
				else if (shape instanceof Donut) {
					DlgDonut dlgDonut = new DlgDonut();
					dlgDonut.setDonut((Donut)shape);
					dlgDonut.setVisible(true);
					Donut donut = dlgDonut.getDonut();
					
					if (donut != null) {
						((Donut) shape).setCenter(donut.getCenter());
						((Donut) shape).setRadius(donut.getRadius());
						((Donut) shape).setInnerRadius(donut.getInnerRadius());
						shape.setColor(donut.getColor());
						((Donut) shape).setFillColor(donut.getFillColor());
					}
				}
				
				else if (shape instanceof Circle) {
					DlgCircle dlgCircle = new DlgCircle();
					dlgCircle.setCircle((Circle)shape);
					dlgCircle.setVisible(true);
					Circle circle = dlgCircle.getCircle();
					
					if (circle != null) {
						((Circle) shape).setCenter(circle.getCenter());
						((Circle) shape).setRadius(circle.getRadius());
						shape.setColor(circle.getColor());
						((Circle) shape).setFillColor(circle.getFillColor());
					}
				}
				
				pnlDrawing.repaint();
			}
		});
		btnEdit.setEnabled(false);
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.fill = GridBagConstraints.BOTH;
		gbc_btnEdit.insets = new Insets(0, 0, 5, 0);
		gbc_btnEdit.gridx = 0;
		gbc_btnEdit.gridy = 3;
		leftPanel.add(btnEdit, gbc_btnEdit);
		btnModify.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		
		btnDelete.setEnabled(false);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.fill = GridBagConstraints.BOTH;
		gbc_btnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_btnDelete.gridx = 0;
		gbc_btnDelete.gridy = 4;
		leftPanel.add(btnDelete, gbc_btnDelete);
		btnModify.add(btnDelete);
		
		JButton btnClearColor = new JButton("Clear Color");
		btnClearColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to reset colors of selected object(s)?", "Confirm delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
					pnlDrawing.clearColorOfSelected();
				}	
			}
		});
		btnClearColor.setEnabled(false);
		GridBagConstraints gbc_btnClearColor = new GridBagConstraints();
		gbc_btnClearColor.fill = GridBagConstraints.BOTH;
		gbc_btnClearColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnClearColor.gridx = 0;
		gbc_btnClearColor.gridy = 5;
		leftPanel.add(btnClearColor, gbc_btnClearColor);
		btnModify.add(btnClearColor);
		
		JToggleButton btnPoint = new JToggleButton("Point");
		btnPoint.setSelected(true);
		GridBagConstraints gbc_btnPoint = new GridBagConstraints();
		gbc_btnPoint.fill = GridBagConstraints.BOTH;
		gbc_btnPoint.insets = new Insets(0, 0, 5, 0);
		gbc_btnPoint.gridx = 0;
		gbc_btnPoint.gridy = 7;
		leftPanel.add(btnPoint, gbc_btnPoint);
		btnShape.add(btnPoint);
		
		JToggleButton btnLine = new JToggleButton("Line");
		GridBagConstraints gbc_btnLine = new GridBagConstraints();
		gbc_btnLine.fill = GridBagConstraints.BOTH;
		gbc_btnLine.insets = new Insets(0, 0, 5, 0);
		gbc_btnLine.gridx = 0;
		gbc_btnLine.gridy = 8;
		leftPanel.add(btnLine, gbc_btnLine);
		btnShape.add(btnLine);
		
		JToggleButton btnRectangle = new JToggleButton("Rectangle");
		GridBagConstraints gbc_btnRectangle = new GridBagConstraints();
		gbc_btnRectangle.fill = GridBagConstraints.BOTH;
		gbc_btnRectangle.insets = new Insets(0, 0, 5, 0);
		gbc_btnRectangle.gridx = 0;
		gbc_btnRectangle.gridy = 9;
		leftPanel.add(btnRectangle, gbc_btnRectangle);
		btnShape.add(btnRectangle);
		
		JToggleButton btnCircle = new JToggleButton("Circle");
		GridBagConstraints gbc_btnCircle = new GridBagConstraints();
		gbc_btnCircle.fill = GridBagConstraints.BOTH;
		gbc_btnCircle.insets = new Insets(0, 0, 5, 0);
		gbc_btnCircle.gridx = 0;
		gbc_btnCircle.gridy = 10;
		leftPanel.add(btnCircle, gbc_btnCircle);
		btnShape.add(btnCircle);
		
		JToggleButton btnDonut = new JToggleButton("Donut");
		GridBagConstraints gbc_btnDonut = new GridBagConstraints();
		gbc_btnDonut.fill = GridBagConstraints.BOTH;
		gbc_btnDonut.gridx = 0;
		gbc_btnDonut.gridy = 11;
		leftPanel.add(btnDonut, gbc_btnDonut);
		btnShape.add(btnDonut);
		
		JPanel topPanel = new JPanel();
		contentPane.add(topPanel, BorderLayout.NORTH);
		GridBagLayout gbl_topPanel = new GridBagLayout();
		gbl_topPanel.columnWidths = new int[]{-16, 422, 0};
		gbl_topPanel.rowHeights = new int[]{31, 31, 31, 0};
		gbl_topPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_topPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		topPanel.setLayout(gbl_topPanel);
		
		JLabel lblPaint = new JLabel("Paint");
		lblPaint.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaint.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblPaint = new GridBagConstraints();
		gbc_lblPaint.gridwidth = 2;
		gbc_lblPaint.fill = GridBagConstraints.BOTH;
		gbc_lblPaint.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaint.gridx = 0;
		gbc_lblPaint.gridy = 0;
		topPanel.add(lblPaint, gbc_lblPaint);
		
		JLabel lblTotalShapes = new JLabel("Total shapes: 0");
		lblTotalShapes.setBorder(new EmptyBorder(0, 10, 0, 0));
		GridBagConstraints gbc_lblTotalShapes = new GridBagConstraints();
		gbc_lblTotalShapes.fill = GridBagConstraints.BOTH;
		gbc_lblTotalShapes.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalShapes.gridx = 0;
		gbc_lblTotalShapes.gridy = 1;
		topPanel.add(lblTotalShapes, gbc_lblTotalShapes);
		
		JLabel lblXY = new JLabel("X: Y:");
		lblXY.setToolTipText("Current coordinates of the mouse.");
		lblXY.setBorder(new EmptyBorder(0, 10, 0, 0));
		GridBagConstraints gbc_lblXY = new GridBagConstraints();
		gbc_lblXY.insets = new Insets(0, 0, 0, 5);
		gbc_lblXY.fill = GridBagConstraints.BOTH;
		gbc_lblXY.gridx = 0;
		gbc_lblXY.gridy = 2;
		topPanel.add(lblXY, gbc_lblXY);
		
		JLabel lblProTip = new JLabel("Pro tip: Use the CTRL button to select multiple shapes at once.");
		GridBagConstraints gbc_lblProTip = new GridBagConstraints();
		gbc_lblProTip.anchor = GridBagConstraints.WEST;
		gbc_lblProTip.gridx = 1;
		gbc_lblProTip.gridy = 2;
		topPanel.add(lblProTip, gbc_lblProTip);
		//randomize the pro tip every time the window is loaded
		int dlgIndex = (int)(Math.random() * ((3 - 1) + 1)) + 1;
		String text = "";
		switch (dlgIndex) {
		case 1:
			text = "Pro tip: Use the CTRL button to select multiple shapes at once.";
			break;
		case 2:
			text = "Pro tip: Use the ALT button to skip dialogs when drawing.";
			break;
		case 3:
			text = "Pro tip: While holding the SHIFT button, you can move selected shapes by dragging.";
			break;
		default:
			text = "";
			break;
		}
		lblProTip.setText(text);
		
		//performed when clicking on the canvas
		pnlDrawing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//store the coords of our click in clickPos
				Point clickPos = new Point(e.getX(), e.getY());				
				
				//ctrl selects objects regardless of select btn state (by design)
				//also allows multiple objects selection
				if (e.isControlDown()) {
					if (pnlDrawing.select(clickPos)) {
						setEditButtons(true);
					}
					return;
				}
					
				pnlDrawing.deselectAll();
				setEditButtons(false);
				
				if (btnSelect.isSelected()) {
					//select(Point p) returns true if an object was selected
					setEditButtons(pnlDrawing.select(clickPos));
					return;
				}
				
				//firstly check which of the togglebuttons from btnShape is selected
				//then instantiate the appropriate dialogue, if alt isn't held
				//set the coordinates to our click coords, and show the dialogue
				//in the dialogue, a new Shape is created, pass it here onto the pnlDrawing
				if (btnPoint.isSelected()) {
					if(e.isAltDown()) {
						pnlDrawing.addShape(new Point(e.getX(), e.getY(), edgeColor));
					} else {
						DlgPoint dlgPoint = new DlgPoint();
						dlgPoint.setPoint(clickPos);
						dlgPoint.setVisible(true);
						if (dlgPoint.getPoint() != null) {
							pnlDrawing.addShape(dlgPoint.getPoint());
						}
						startingPoint = null;
					}
					
				}
				
				else if (btnLine.isSelected()) {
					if (startingPoint != null) {
						if (e.isAltDown()) {
							pnlDrawing.addShape(new Line(startingPoint, clickPos, edgeColor));
							startingPoint = null;
						} else {
							DlgLine dlgLine = new DlgLine();
							dlgLine.setLine(startingPoint, clickPos);
							dlgLine.setColor(edgeColor);
							dlgLine.setVisible(true);
							if (dlgLine.getLine() != null) {
								pnlDrawing.addShape(dlgLine.getLine());
							}
							startingPoint = null;
						}
					} else {
						startingPoint = clickPos;
					}					
				}
				
				else if (btnRectangle.isSelected()) {
					if (e.isAltDown()) {
						if (startingPoint != null) {
							pnlDrawing.addShape(new Rectangle(startingPoint, clickPos, edgeColor, fillColor));
							startingPoint = null;
						} else {
							startingPoint = clickPos;
						}
					} else {
						DlgRectangle dlgRectangle = new DlgRectangle();
						dlgRectangle.setPoint(clickPos);
						dlgRectangle.setColors(edgeColor, fillColor);
						//set focus to textFieldWidth, by invoking after it becomes visible
						EventQueue.invokeLater( () -> dlgRectangle.getTextFieldWidth().requestFocusInWindow() );
						dlgRectangle.setVisible(true);
						if (dlgRectangle.getRectangle() != null) {
							pnlDrawing.addShape(dlgRectangle.getRectangle());
						}
						startingPoint = null;
					}
					
				}
				
				else if (btnCircle.isSelected()) {
					if (e.isAltDown()) {
						if (startingPoint != null) {
							pnlDrawing.addShape(new Circle(startingPoint, clickPos, edgeColor, fillColor));
							startingPoint = null;
						} else {
							startingPoint = clickPos;
						}
					} else {
						DlgCircle dlgCircle = new DlgCircle();
						dlgCircle.setPoint(clickPos);
						dlgCircle.setColors(edgeColor, fillColor);
						EventQueue.invokeLater( () -> dlgCircle.getTextFieldRadius().requestFocusInWindow() );
						dlgCircle.setVisible(true);
						if (dlgCircle.getCircle() != null) {
							pnlDrawing.addShape(dlgCircle.getCircle());
						}
						startingPoint = null;
					}					
				}
				
				else if (btnDonut.isSelected()) {
					//won't allow drawing a donut with alt key, it's just too ugly
					DlgDonut dlgDonut = new DlgDonut();
					dlgDonut.setPoint(clickPos);
					dlgDonut.setColors(edgeColor, fillColor);
					EventQueue.invokeLater( () -> dlgDonut.getTextFieldInner().requestFocusInWindow() );
					dlgDonut.setVisible(true);
					if (dlgDonut.getDonut() != null) {
						pnlDrawing.addShape(dlgDonut.getDonut());
					}
					startingPoint = null;
				}
				
				//pass the drawing panel object and the label to edit to include new elements
				updateTotalElements(pnlDrawing, lblTotalShapes);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				//before we start moving, we store the click coords to compare the distance to
				lastX = e.getX();
				lastY = e.getY();
			}
		});
		
		pnlDrawing.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				//update the coords text every time the mouse moves inside the canvas
				lblXY.setText("X: " + Integer.toString(e.getX()) + " , Y: " + Integer.toString(e.getY()));				
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				//move the selected objects only if shift is held
				if (e.isShiftDown()) {
					if(lastX != 0 && lastY != 0) {
						pnlDrawing.moveSelected(e.getX() - lastX, e.getY() - lastY);
					}
					lastX = e.getX();
					lastY = e.getY();
				}
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete selected object(s)?", "Confirm delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
					pnlDrawing.deleteSelected();
					setEditButtons(false);
					updateTotalElements(pnlDrawing, lblTotalShapes);
				}		
			}
		});
	}
	
	/**
	 * Enables or disables the buttons in the btnModify ButtonGroup
	 * (Modify, Delete, Clear Color)
	 * @param b = true to enable, or false to disable the buttons.
	 */
	public void setEditButtons(boolean b) {
		//Enumeration is just an old Iterator type
		//AbstractButton is the parent class of the buttons
		for (Enumeration<AbstractButton> e = btnModify.getElements(); e.hasMoreElements();) {
			e.nextElement().setEnabled(b);
		}		
	}
	
	/**
	 * Updates the JLabel's text to accurately display total number of shapes.
	 * @param pnlDrawing - the drawing panel
	 * @param label - the label to change the text of
	 */
	public void updateTotalElements(PnlDrawing pnlDrawing, JLabel label) {
		label.setText("Total shapes: " + pnlDrawing.getShapesCount());
	}

}
