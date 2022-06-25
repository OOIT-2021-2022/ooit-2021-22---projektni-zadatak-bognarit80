package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Donut;
import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgDonut extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldInner;
	private JTextField textFieldOuter;
	
	private Donut donut = null;
	private Color edgeColor = null;
	private Color fillColor = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonut() {
		setResizable(false);
		setModal(true);
		setTitle("Donut");
		setBounds(100, 100, 450, 282);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
			gbc_textFieldX.gridwidth = 2;
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
			gbc_textFieldY.gridwidth = 2;
			gbc_textFieldY.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldY.gridx = 1;
			gbc_textFieldY.gridy = 1;
			contentPanel.add(textFieldY, gbc_textFieldY);
			textFieldY.setColumns(10);
		}
		{
			JLabel lblInnerRadius = new JLabel("Inner radius:");
			GridBagConstraints gbc_lblInnerRadius = new GridBagConstraints();
			gbc_lblInnerRadius.anchor = GridBagConstraints.EAST;
			gbc_lblInnerRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblInnerRadius.gridx = 0;
			gbc_lblInnerRadius.gridy = 2;
			contentPanel.add(lblInnerRadius, gbc_lblInnerRadius);
		}
		{
			textFieldInner = new JTextField();
			GridBagConstraints gbc_textFieldInner = new GridBagConstraints();
			gbc_textFieldInner.gridwidth = 2;
			gbc_textFieldInner.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldInner.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldInner.gridx = 1;
			gbc_textFieldInner.gridy = 2;
			contentPanel.add(textFieldInner, gbc_textFieldInner);
			textFieldInner.setColumns(10);
		}
		{
			JLabel lblOuterRadius = new JLabel("Outer radius:");
			GridBagConstraints gbc_lblOuterRadius = new GridBagConstraints();
			gbc_lblOuterRadius.anchor = GridBagConstraints.EAST;
			gbc_lblOuterRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblOuterRadius.gridx = 0;
			gbc_lblOuterRadius.gridy = 3;
			contentPanel.add(lblOuterRadius, gbc_lblOuterRadius);
		}
		{
			textFieldOuter = new JTextField();
			GridBagConstraints gbc_textFieldOuter = new GridBagConstraints();
			gbc_textFieldOuter.gridwidth = 2;
			gbc_textFieldOuter.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldOuter.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldOuter.gridx = 1;
			gbc_textFieldOuter.gridy = 3;
			contentPanel.add(textFieldOuter, gbc_textFieldOuter);
			textFieldOuter.setColumns(10);
		}
		{
			JButton btnChooseEdgeColor = new JButton("Choose Edge Color");
			btnChooseEdgeColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					edgeColor = JColorChooser.showDialog(null, "Choose edge color", edgeColor);
					if (edgeColor == null) {
						edgeColor = Color.BLACK;
					}
					contentPanel.getComponent(9).setBackground(edgeColor);
				}
			});
			GridBagConstraints gbc_btnChooseEdgeColor = new GridBagConstraints();
			gbc_btnChooseEdgeColor.anchor = GridBagConstraints.EAST;
			gbc_btnChooseEdgeColor.insets = new Insets(0, 0, 5, 5);
			gbc_btnChooseEdgeColor.gridx = 0;
			gbc_btnChooseEdgeColor.gridy = 4;
			contentPanel.add(btnChooseEdgeColor, gbc_btnChooseEdgeColor);
		}
		{
			JPanel pnlEdge = new JPanel();
			GridBagConstraints gbc_pnlEdge = new GridBagConstraints();
			gbc_pnlEdge.insets = new Insets(0, 0, 5, 5);
			gbc_pnlEdge.fill = GridBagConstraints.BOTH;
			gbc_pnlEdge.gridx = 1;
			gbc_pnlEdge.gridy = 4;
			contentPanel.add(pnlEdge, gbc_pnlEdge);
		}
		{
			JButton btnChooseFillColor = new JButton("Choose Fill Color");
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
			gbc_btnChooseFillColor.fill = GridBagConstraints.BOTH;
			gbc_btnChooseFillColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnChooseFillColor.gridx = 0;
			gbc_btnChooseFillColor.gridy = 5;
			contentPanel.add(btnChooseFillColor, gbc_btnChooseFillColor);
		}
		{
			JPanel pnlFill = new JPanel();
			GridBagConstraints gbc_pnlFill = new GridBagConstraints();
			gbc_pnlFill.insets = new Insets(0, 0, 0, 5);
			gbc_pnlFill.fill = GridBagConstraints.BOTH;
			gbc_pnlFill.gridx = 1;
			gbc_pnlFill.gridy = 5;
			contentPanel.add(pnlFill, gbc_pnlFill);
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
							int innerRadius = Integer.parseInt(textFieldInner.getText());
							int outerRadius = Integer.parseInt(textFieldOuter.getText());
							
							if (x < 0 || y < 0 || innerRadius < 0 || outerRadius < 0) {
								JOptionPane.showMessageDialog(null, "Values must be greater than 0!", "Error", JOptionPane.ERROR_MESSAGE);
								return;
							}
							
							if (innerRadius >= outerRadius) {
								JOptionPane.showMessageDialog(null, "Outer radius must be greater than inner radius!", "Error", JOptionPane.ERROR_MESSAGE);
								return;
							}
							
							donut = new Donut(new Point(x, y), outerRadius, innerRadius, edgeColor, fillColor);
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
	
	public Donut getDonut() {
		return this.donut;
	}
	
	public void setDonut(Donut donut) {
		setPoint(donut.getCenter());
		setColors(donut.getColor(), donut.getFillColor());
		textFieldInner.setText("" + donut.getInnerRadius());
		textFieldOuter.setText("" + donut.getRadius());
	}
	
	public void setColors(Color edgeColor, Color fillColor) {
		this.edgeColor = edgeColor;
		this.fillColor = fillColor;
		contentPanel.getComponent(9).setBackground(edgeColor);
		contentPanel.getComponent(11).setBackground(fillColor);
	}
	
	public void setPoint(Point center) {
		textFieldX.setText("" + center.getX());
		textFieldY.setText("" + center.getY());
	}

	public JTextField getTextFieldInner() {		
		return this.textFieldInner;
	}

}
