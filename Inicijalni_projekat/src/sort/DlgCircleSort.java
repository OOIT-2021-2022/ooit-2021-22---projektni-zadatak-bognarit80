package sort;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
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
import java.awt.Font;

public class DlgCircleSort extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldRadius;
	
	private Circle circle = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircleSort dialog = new DlgCircleSort();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircleSort() {
		setModal(true);
		setTitle("Circle");
		setResizable(false);
		setBounds(100, 100, 501, 211);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{40, 39, 40, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCenterXCoordinates = new JLabel("Center X coordinates:");
			lblCenterXCoordinates.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
			lblCenterYCoordinates.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
			lblRadius.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.anchor = GridBagConstraints.EAST;
			gbc_lblRadius.insets = new Insets(0, 0, 0, 5);
			gbc_lblRadius.gridx = 0;
			gbc_lblRadius.gridy = 2;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			textFieldRadius = new JTextField();
			GridBagConstraints gbc_textFieldRadius = new GridBagConstraints();
			gbc_textFieldRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldRadius.gridx = 1;
			gbc_textFieldRadius.gridy = 2;
			contentPanel.add(textFieldRadius, gbc_textFieldRadius);
			textFieldRadius.setColumns(10);
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
								return;
							}
							
							circle = new Circle(new Point(x, y), radius);
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
	
	public void setCircle(Circle c) {
		setPoint(c.getCenter());
		textFieldRadius.setText("" + c.getRadius());
	}

}
