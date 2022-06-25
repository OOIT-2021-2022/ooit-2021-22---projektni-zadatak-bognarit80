package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgPoint extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX;
	private JTextField textFieldY;
	
	private Point point = null;
	private Color color = null;
	
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.textFieldX.setText("" + point.getX());
		this.textFieldY.setText("" + point.getY());
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPoint dialog = new DlgPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPoint() {
		setResizable(false);
		setTitle("Point");
		setModal(true);
		setBounds(100, 100, 365, 162);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 136, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
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
			gbc_textFieldX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldX.insets = new Insets(0, 0, 5, 0);
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
			gbc_textFieldY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldY.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldY.gridx = 1;
			gbc_textFieldY.gridy = 1;
			contentPanel.add(textFieldY, gbc_textFieldY);
			textFieldY.setColumns(10);
		}
		{
			JPanel colorPanel = new JPanel();
			colorPanel.setBackground(Color.BLACK);
			GridBagConstraints gbc_colorPanel = new GridBagConstraints();
			gbc_colorPanel.fill = GridBagConstraints.BOTH;
			gbc_colorPanel.gridx = 1;
			gbc_colorPanel.gridy = 2;
			contentPanel.add(colorPanel, gbc_colorPanel);
		}
		{
			JButton btnChooseColor = new JButton("Choose Color");
			btnChooseColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color = JColorChooser.showDialog(null, "Choose a color", color);
					if (color == null) {
						color = Color.BLACK;
					}
					
					//set the background color of rectangle next to the color btn
					contentPanel.getComponent(4).setBackground(color);
				}
			});
			GridBagConstraints gbc_btnChooseColor = new GridBagConstraints();
			gbc_btnChooseColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnChooseColor.gridx = 0;
			gbc_btnChooseColor.gridy = 2;
			contentPanel.add(btnChooseColor, gbc_btnChooseColor);
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
							if (x < 0 || y < 0) {
								JOptionPane.showMessageDialog(null, "Values cannot be lower than 0.", "Error", JOptionPane.ERROR_MESSAGE);
								return;
							}
							point = new Point (x, y, color);
							setPoint(point);
							dispose();
						} catch (NumberFormatException exception) {
							JOptionPane.showMessageDialog(null, "Invalid data type.", "Error", JOptionPane.ERROR_MESSAGE);
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
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
