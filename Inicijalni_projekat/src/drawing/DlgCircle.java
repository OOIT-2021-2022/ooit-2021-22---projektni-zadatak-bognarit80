package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgCircle extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldRadius;
	
	private Circle circle = null;
	
	private Color edgeColor = null;
	private Color fillColor = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		setModal(true);
		setTitle("Circle");
		setResizable(false);
		setBounds(100, 100, 436, 228);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCenterXCoordinates = new JLabel("Center X coordinates:");
			GridBagConstraints gbc_lblCenterXCoordinates = new GridBagConstraints();
			gbc_lblCenterXCoordinates.anchor = GridBagConstraints.EAST;
			gbc_lblCenterXCoordinates.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterXCoordinates.gridx = 0;
			gbc_lblCenterXCoordinates.gridy = 0;
			contentPanel.add(lblCenterXCoordinates, gbc_lblCenterXCoordinates);
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
			JLabel lblCenterYCoordinates = new JLabel("Center Y coordinates:");
			GridBagConstraints gbc_lblCenterYCoordinates = new GridBagConstraints();
			gbc_lblCenterYCoordinates.anchor = GridBagConstraints.EAST;
			gbc_lblCenterYCoordinates.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterYCoordinates.gridx = 0;
			gbc_lblCenterYCoordinates.gridy = 1;
			contentPanel.add(lblCenterYCoordinates, gbc_lblCenterYCoordinates);
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
			JLabel lblRadius = new JLabel("Radius:");
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.anchor = GridBagConstraints.EAST;
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 0;
			gbc_lblRadius.gridy = 2;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			textFieldRadius = new JTextField();
			GridBagConstraints gbc_textFieldRadius = new GridBagConstraints();
			gbc_textFieldRadius.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldRadius.gridx = 1;
			gbc_textFieldRadius.gridy = 2;
			contentPanel.add(textFieldRadius, gbc_textFieldRadius);
			textFieldRadius.setColumns(10);
		}
		{
			JButton btnChooseColor = new JButton("Choose Color");
			btnChooseColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					edgeColor = JColorChooser.showDialog(null, "Choose edge color", edgeColor);
					if (edgeColor == null) {
						edgeColor = Color.BLACK;
					}
					contentPanel.getComponent(7).setBackground(edgeColor);
				}
			});
			GridBagConstraints gbc_btnChooseColor = new GridBagConstraints();
			gbc_btnChooseColor.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnChooseColor.insets = new Insets(0, 0, 5, 5);
			gbc_btnChooseColor.gridx = 0;
			gbc_btnChooseColor.gridy = 3;
			contentPanel.add(btnChooseColor, gbc_btnChooseColor);
		}
		{
			JButton btnChooseFillColor = new JButton("Choose Fill Color");
			btnChooseFillColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					fillColor = JColorChooser.showDialog(null, "Choose fill color", fillColor);
					if (fillColor == null) {
						fillColor = Color.WHITE;
					}
					contentPanel.getComponent(9).setBackground(fillColor);
				}
			});
			{
				JPanel pnlEdge = new JPanel();
				GridBagConstraints gbc_pnlEdge = new GridBagConstraints();
				gbc_pnlEdge.insets = new Insets(0, 0, 5, 0);
				gbc_pnlEdge.fill = GridBagConstraints.BOTH;
				gbc_pnlEdge.gridx = 1;
				gbc_pnlEdge.gridy = 3;
				contentPanel.add(pnlEdge, gbc_pnlEdge);
			}
			GridBagConstraints gbc_btnChooseFillColor = new GridBagConstraints();
			gbc_btnChooseFillColor.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnChooseFillColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnChooseFillColor.gridx = 0;
			gbc_btnChooseFillColor.gridy = 4;
			contentPanel.add(btnChooseFillColor, gbc_btnChooseFillColor);
		}
		{
			JPanel pnlFill = new JPanel();
			GridBagConstraints gbc_pnlFill = new GridBagConstraints();
			gbc_pnlFill.fill = GridBagConstraints.BOTH;
			gbc_pnlFill.gridx = 1;
			gbc_pnlFill.gridy = 4;
			contentPanel.add(pnlFill, gbc_pnlFill);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							int x = Integer.parseInt(textFieldX.getText());
							int y = Integer.parseInt(textFieldY.getText());
							int radius = Integer.parseInt(textFieldRadius.getText());
							
							if (x <= 0 || y <= 0 || radius < 0) {
								JOptionPane.showMessageDialog(null, "Values must be greater than 0!", "Error", JOptionPane.ERROR_MESSAGE);
							}
							
							circle = new Circle(new Point(x, y), radius, edgeColor, fillColor);
							dispose();
							
						} catch (Exception exception) {
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
	
	public Circle getCircle() {
		return this.circle;
	}
	
	public void setPoint(Point p) {
		textFieldX.setText("" + p.getX());
		textFieldY.setText("" + p.getY());
	}
	
	public void setColors(Color edgeColor, Color fillColor) {
		this.edgeColor = edgeColor;
		this.fillColor = fillColor;
		contentPanel.getComponent(7).setBackground(edgeColor);
		contentPanel.getComponent(9).setBackground(fillColor);
	}
	
	public void setCircle(Circle c) {
		setPoint(c.getCenter());
		setColors(c.getColor(), c.getFillColor());
		textFieldRadius.setText("" + c.getRadius());
	}

	public JTextField getTextFieldRadius() {
		return this.textFieldRadius;
	}

}
