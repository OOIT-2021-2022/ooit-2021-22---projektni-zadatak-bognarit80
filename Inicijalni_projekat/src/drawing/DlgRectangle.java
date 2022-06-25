package drawing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DlgRectangle extends JDialog {

	public JTextField getTextFieldWidth() {
		return textFieldWidth;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldWidth;
	private JTextField textFieldHeight;
	
	private Rectangle rectangle = null;
	private Color fillColor = null;
	private Color edgeColor = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		setModal(true);
		setTitle("Rectangle");
		setResizable(false);
		setBounds(100, 100, 367, 266);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblXCoordinates = new JLabel("X coordinates:");
			GridBagConstraints gbc_lblXCoordinates = new GridBagConstraints();
			gbc_lblXCoordinates.anchor = GridBagConstraints.EAST;
			gbc_lblXCoordinates.insets = new Insets(0, 0, 5, 5);
			gbc_lblXCoordinates.gridx = 0;
			gbc_lblXCoordinates.gridy = 0;
			contentPanel.add(lblXCoordinates, gbc_lblXCoordinates);
		}
		{
			textFieldX = new JTextField();
			GridBagConstraints gbc_textFieldX = new GridBagConstraints();
			gbc_textFieldX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldX.gridx = 1;
			gbc_textFieldX.gridy = 0;
			contentPanel.add(textFieldX, gbc_textFieldX);
			textFieldX.setColumns(10);
		}
		{
			JLabel lblYCoordinates = new JLabel("Y coordinates:");
			GridBagConstraints gbc_lblYCoordinates = new GridBagConstraints();
			gbc_lblYCoordinates.anchor = GridBagConstraints.EAST;
			gbc_lblYCoordinates.insets = new Insets(0, 0, 5, 5);
			gbc_lblYCoordinates.gridx = 0;
			gbc_lblYCoordinates.gridy = 1;
			contentPanel.add(lblYCoordinates, gbc_lblYCoordinates);
		}
		{
			textFieldY = new JTextField();
			GridBagConstraints gbc_textFieldY = new GridBagConstraints();
			gbc_textFieldY.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldY.gridx = 1;
			gbc_textFieldY.gridy = 1;
			contentPanel.add(textFieldY, gbc_textFieldY);
			textFieldY.setColumns(10);
		}
		{
			JLabel lblWidth = new JLabel("Width:");
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.anchor = GridBagConstraints.EAST;
			gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblWidth.gridx = 0;
			gbc_lblWidth.gridy = 2;
			contentPanel.add(lblWidth, gbc_lblWidth);
		}
		{
			textFieldWidth = new JTextField();
			GridBagConstraints gbc_textFieldWidth = new GridBagConstraints();
			gbc_textFieldWidth.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldWidth.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldWidth.gridx = 1;
			gbc_textFieldWidth.gridy = 2;
			contentPanel.add(textFieldWidth, gbc_textFieldWidth);
			textFieldWidth.setColumns(10);
		}
		{
			JLabel lblHeight = new JLabel("Height:");
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.anchor = GridBagConstraints.EAST;
			gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
			gbc_lblHeight.gridx = 0;
			gbc_lblHeight.gridy = 3;
			contentPanel.add(lblHeight, gbc_lblHeight);
		}
		{
			textFieldHeight = new JTextField();
			GridBagConstraints gbc_textFieldHeight = new GridBagConstraints();
			gbc_textFieldHeight.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldHeight.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldHeight.gridx = 1;
			gbc_textFieldHeight.gridy = 3;
			contentPanel.add(textFieldHeight, gbc_textFieldHeight);
			textFieldHeight.setColumns(10);
		}
		{
			JButton btnChooseEdgeColor = new JButton("Edge Color");
			btnChooseEdgeColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					edgeColor = JColorChooser.showDialog(null, "Choose edge color", edgeColor);
					if (edgeColor == null) {
						edgeColor = Color.BLACK;
					}
					contentPanel.getComponent(9).setBackground(edgeColor);
				}
			});
			GridBagConstraints gbc_btnChooseEdgeColor = new GridBagConstraints();
			gbc_btnChooseEdgeColor.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnChooseEdgeColor.insets = new Insets(0, 0, 5, 5);
			gbc_btnChooseEdgeColor.gridx = 0;
			gbc_btnChooseEdgeColor.gridy = 4;
			contentPanel.add(btnChooseEdgeColor, gbc_btnChooseEdgeColor);
		}
		{
			JPanel pnlEdgeColor = new JPanel();
			pnlEdgeColor.setBackground(Color.BLACK);
			GridBagConstraints gbc_pnlEdgeColor = new GridBagConstraints();
			gbc_pnlEdgeColor.insets = new Insets(0, 0, 5, 0);
			gbc_pnlEdgeColor.fill = GridBagConstraints.BOTH;
			gbc_pnlEdgeColor.gridx = 1;
			gbc_pnlEdgeColor.gridy = 4;
			contentPanel.add(pnlEdgeColor, gbc_pnlEdgeColor);
		}
		{
			JButton btnChooseFillColor = new JButton("Fill Color");
			btnChooseFillColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fillColor = JColorChooser.showDialog(null, "Choose fill color", fillColor);
					if (fillColor == null) {
						fillColor = Color.WHITE;
					}
					contentPanel.getComponent(11).setBackground(fillColor);
				}
			});
			GridBagConstraints gbc_btnChooseFillColor = new GridBagConstraints();
			gbc_btnChooseFillColor.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnChooseFillColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnChooseFillColor.gridx = 0;
			gbc_btnChooseFillColor.gridy = 5;
			contentPanel.add(btnChooseFillColor, gbc_btnChooseFillColor);
		}
		{
			JPanel pnlFillColor = new JPanel();
			pnlFillColor.setBackground(Color.WHITE);
			GridBagConstraints gbc_pnlFillColor = new GridBagConstraints();
			gbc_pnlFillColor.fill = GridBagConstraints.BOTH;
			gbc_pnlFillColor.gridx = 1;
			gbc_pnlFillColor.gridy = 5;
			contentPanel.add(pnlFillColor, gbc_pnlFillColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							int x = Integer.parseInt(textFieldX.getText());
							int y = Integer.parseInt(textFieldY.getText());
							int width = Integer.parseInt(textFieldWidth.getText());
							int height = Integer.parseInt(textFieldHeight.getText());
							
							if (x < 0 || y < 0 || height < 0 || width < 0) {
								JOptionPane.showMessageDialog(null, "Values must be greater than 0!", "Error", JOptionPane.ERROR_MESSAGE);
								return;
							}
							
							rectangle = new Rectangle(new Point(x, y), height, width, edgeColor, fillColor);
							dispose();
							
						} catch (NumberFormatException exception) {
							JOptionPane.showMessageDialog(null, "Invalid data type!", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public Rectangle getRectangle() {
		return this.rectangle;
	}
	
	public void setRectangle(Rectangle rectangle) {
		setPoint(rectangle.getUpperLeftPoint());
		setColors(rectangle.getColor(), rectangle.getFillColor());
		textFieldHeight.setText("" + rectangle.getHeight());
		textFieldWidth.setText("" + rectangle.getWidth());
	}
	
	public void setColors(Color edgeColor, Color fillColor) {
		this.edgeColor = edgeColor;
		this.fillColor = fillColor;
		contentPanel.getComponent(9).setBackground(this.edgeColor);
		contentPanel.getComponent(11).setBackground(this.fillColor);		
	}
	
	public void setPoint(Point p) {
		textFieldX.setText("" + p.getX());
		textFieldY.setText("" + p.getY());
	}

}
