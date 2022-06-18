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
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import java.awt.Color;

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
		leftPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(leftPanel, BorderLayout.WEST);
		GridBagLayout gbl_leftPanel = new GridBagLayout();
		gbl_leftPanel.columnWidths = new int[]{89, 0};
		gbl_leftPanel.rowHeights = new int[]{26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 0};
		gbl_leftPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_leftPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		leftPanel.setLayout(gbl_leftPanel);
		
		JToggleButton btnDraw = new JToggleButton("Draw");
		btnDraw.setSelected(true);
		GridBagConstraints gbc_btnDraw = new GridBagConstraints();
		gbc_btnDraw.fill = GridBagConstraints.BOTH;
		gbc_btnDraw.insets = new Insets(0, 0, 5, 0);
		gbc_btnDraw.gridx = 0;
		gbc_btnDraw.gridy = 0;
		leftPanel.add(btnDraw, gbc_btnDraw);
		btnAction.add(btnDraw);
		
		JToggleButton btnSelect = new JToggleButton("Select");
		GridBagConstraints gbc_btnSelect = new GridBagConstraints();
		gbc_btnSelect.fill = GridBagConstraints.BOTH;
		gbc_btnSelect.insets = new Insets(0, 0, 5, 0);
		gbc_btnSelect.gridx = 0;
		gbc_btnSelect.gridy = 1;
		leftPanel.add(btnSelect, gbc_btnSelect);
		btnAction.add(btnSelect);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setEnabled(false);
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.fill = GridBagConstraints.BOTH;
		gbc_btnEdit.insets = new Insets(0, 0, 5, 0);
		gbc_btnEdit.gridx = 0;
		gbc_btnEdit.gridy = 3;
		leftPanel.add(btnEdit, gbc_btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.fill = GridBagConstraints.BOTH;
		gbc_btnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_btnDelete.gridx = 0;
		gbc_btnDelete.gridy = 4;
		leftPanel.add(btnDelete, gbc_btnDelete);
		
		JButton btnClearAll = new JButton("Clear all");
		btnClearAll.setEnabled(false);
		GridBagConstraints gbc_btnClearAll = new GridBagConstraints();
		gbc_btnClearAll.fill = GridBagConstraints.BOTH;
		gbc_btnClearAll.insets = new Insets(0, 0, 5, 0);
		gbc_btnClearAll.gridx = 0;
		gbc_btnClearAll.gridy = 5;
		leftPanel.add(btnClearAll, gbc_btnClearAll);
		
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
		topPanel.setLayout(new GridLayout(3, 3, 0, 0));
		
		JLabel lblPaint = new JLabel("Paint");
		lblPaint.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaint.setFont(new Font("Tahoma", Font.PLAIN, 25));
		topPanel.add(lblPaint);
		
		JLabel lblTotalObjects = new JLabel("Total objects:");
		topPanel.add(lblTotalObjects);
		
		JLabel lblXY = new JLabel("X: Y:");
		topPanel.add(lblXY);
	}

}
