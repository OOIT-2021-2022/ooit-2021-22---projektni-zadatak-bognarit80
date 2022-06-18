package drawing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;

public class DrawingWindow extends JFrame {
	
	private ButtonGroup btnAction = new ButtonGroup();
	private ButtonGroup btnShape = new ButtonGroup();

	private JPanel contentPane;

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
		setBounds(100, 100, 554, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		PnlDrawing pnlDrawing = new PnlDrawing();
		contentPane.add(pnlDrawing, BorderLayout.CENTER);
		pnlDrawing.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel leftPanel = new JPanel();
		contentPane.add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JToggleButton btnDraw = new JToggleButton("Draw");
		btnDraw.setSelected(true);
		leftPanel.add(btnDraw);
		btnAction.add(btnDraw);
		
		JToggleButton btnSelect = new JToggleButton("Select");
		leftPanel.add(btnSelect);
		btnAction.add(btnSelect);
		
		JSeparator separator = new JSeparator();
		leftPanel.add(separator);
		
		JButton btnEdit = new JButton("Edit");
		leftPanel.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		leftPanel.add(btnDelete);
		
		JButton btnClearAll = new JButton("Clear all");
		leftPanel.add(btnClearAll);
		
		JSeparator separator_1 = new JSeparator();
		leftPanel.add(separator_1);
		
		JToggleButton btnPoint = new JToggleButton("Point");
		btnPoint.setSelected(true);
		leftPanel.add(btnPoint);
		btnShape.add(btnPoint);
		
		JToggleButton btnLine = new JToggleButton("Line");
		leftPanel.add(btnLine);
		btnShape.add(btnLine);
		
		JToggleButton btnRectangle = new JToggleButton("Rectangle");
		leftPanel.add(btnRectangle);
		btnShape.add(btnRectangle);
		
		JToggleButton btnCircle = new JToggleButton("Circle");
		leftPanel.add(btnCircle);
		btnShape.add(btnCircle);
		
		JToggleButton btnDonut = new JToggleButton("Donut");
		leftPanel.add(btnDonut);
		btnShape.add(btnDonut);
		
		JPanel topPanel = new JPanel();
		contentPane.add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblPaint = new JLabel("Paint");
		topPanel.add(lblPaint);
		
		JLabel lblTotalObjects = new JLabel("Total objects:");
		topPanel.add(lblTotalObjects);
		
		JLabel lblXY = new JLabel("X: Y:");
		topPanel.add(lblXY);
	}

}
