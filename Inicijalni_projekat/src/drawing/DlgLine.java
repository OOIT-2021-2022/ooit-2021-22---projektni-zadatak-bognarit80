package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Line;
import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgLine extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldStartX;
	private JTextField textFieldStartY;
	private JTextField textFieldEndX;
	private JTextField textFieldEndY;
	
	private Line line = null;
	private Color color = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLine() {
		setModal(true);
		setTitle("Line");
		setResizable(false);
		setBounds(100, 100, 450, 287);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblStartingPoint = new JLabel("Starting point");
			lblStartingPoint.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_lblStartingPoint = new GridBagConstraints();
			gbc_lblStartingPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartingPoint.gridx = 0;
			gbc_lblStartingPoint.gridy = 0;
			contentPanel.add(lblStartingPoint, gbc_lblStartingPoint);
		}
		{
			JLabel lblXCoordinates = new JLabel("X coordinates:");
			GridBagConstraints gbc_lblXCoordinates = new GridBagConstraints();
			gbc_lblXCoordinates.insets = new Insets(0, 0, 5, 5);
			gbc_lblXCoordinates.anchor = GridBagConstraints.EAST;
			gbc_lblXCoordinates.gridx = 0;
			gbc_lblXCoordinates.gridy = 1;
			contentPanel.add(lblXCoordinates, gbc_lblXCoordinates);
		}
		{
			textFieldStartX = new JTextField();
			GridBagConstraints gbc_textFieldStartX = new GridBagConstraints();
			gbc_textFieldStartX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldStartX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldStartX.gridx = 1;
			gbc_textFieldStartX.gridy = 1;
			contentPanel.add(textFieldStartX, gbc_textFieldStartX);
			textFieldStartX.setColumns(10);
		}
		{
			JLabel lblYCoordinates = new JLabel("Y coordinates:");
			GridBagConstraints gbc_lblYCoordinates = new GridBagConstraints();
			gbc_lblYCoordinates.anchor = GridBagConstraints.EAST;
			gbc_lblYCoordinates.insets = new Insets(0, 0, 5, 5);
			gbc_lblYCoordinates.gridx = 0;
			gbc_lblYCoordinates.gridy = 2;
			contentPanel.add(lblYCoordinates, gbc_lblYCoordinates);
		}
		{
			textFieldStartY = new JTextField();
			GridBagConstraints gbc_textFieldStartY = new GridBagConstraints();
			gbc_textFieldStartY.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldStartY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldStartY.gridx = 1;
			gbc_textFieldStartY.gridy = 2;
			contentPanel.add(textFieldStartY, gbc_textFieldStartY);
			textFieldStartY.setColumns(10);
		}
		{
			JSeparator separator = new JSeparator();
			GridBagConstraints gbc_separator = new GridBagConstraints();
			gbc_separator.gridwidth = 2;
			gbc_separator.insets = new Insets(0, 0, 5, 0);
			gbc_separator.gridx = 0;
			gbc_separator.gridy = 3;
			contentPanel.add(separator, gbc_separator);
		}
		{
			JLabel lblEndingPoint = new JLabel("Ending point:");
			lblEndingPoint.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_lblEndingPoint = new GridBagConstraints();
			gbc_lblEndingPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndingPoint.gridx = 0;
			gbc_lblEndingPoint.gridy = 4;
			contentPanel.add(lblEndingPoint, gbc_lblEndingPoint);
		}
		{
			JLabel lblXCoordinates_1 = new JLabel("X coordinates:");
			GridBagConstraints gbc_lblXCoordinates_1 = new GridBagConstraints();
			gbc_lblXCoordinates_1.anchor = GridBagConstraints.EAST;
			gbc_lblXCoordinates_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblXCoordinates_1.gridx = 0;
			gbc_lblXCoordinates_1.gridy = 5;
			contentPanel.add(lblXCoordinates_1, gbc_lblXCoordinates_1);
		}
		{
			textFieldEndX = new JTextField();
			GridBagConstraints gbc_textFieldEndX = new GridBagConstraints();
			gbc_textFieldEndX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldEndX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldEndX.gridx = 1;
			gbc_textFieldEndX.gridy = 5;
			contentPanel.add(textFieldEndX, gbc_textFieldEndX);
			textFieldEndX.setColumns(10);
		}
		{
			JLabel lblYCoordinates_1 = new JLabel("Y coordinates:");
			GridBagConstraints gbc_lblYCoordinates_1 = new GridBagConstraints();
			gbc_lblYCoordinates_1.anchor = GridBagConstraints.EAST;
			gbc_lblYCoordinates_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblYCoordinates_1.gridx = 0;
			gbc_lblYCoordinates_1.gridy = 6;
			contentPanel.add(lblYCoordinates_1, gbc_lblYCoordinates_1);
		}
		{
			textFieldEndY = new JTextField();
			GridBagConstraints gbc_textFieldEndY = new GridBagConstraints();
			gbc_textFieldEndY.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldEndY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldEndY.gridx = 1;
			gbc_textFieldEndY.gridy = 6;
			contentPanel.add(textFieldEndY, gbc_textFieldEndY);
			textFieldEndY.setColumns(10);
		}
		{
			JButton btnChooseColor = new JButton("Choose Color");
			btnChooseColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color = JColorChooser.showDialog(null, "Choose color", color);
					if (color == null) {
						color = Color.BLACK;
					}
					contentPanel.getComponent(12).setBackground(color);
				}
			});
			GridBagConstraints gbc_btnChooseColor = new GridBagConstraints();
			gbc_btnChooseColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnChooseColor.gridx = 0;
			gbc_btnChooseColor.gridy = 7;
			contentPanel.add(btnChooseColor, gbc_btnChooseColor);
		}
		{
			JPanel pnlColor = new JPanel();
			GridBagConstraints gbc_pnlColor = new GridBagConstraints();
			gbc_pnlColor.fill = GridBagConstraints.BOTH;
			gbc_pnlColor.gridx = 1;
			gbc_pnlColor.gridy = 7;
			contentPanel.add(pnlColor, gbc_pnlColor);
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
							int x1 = Integer.parseInt(textFieldStartX.getText());
							int y1 = Integer.parseInt(textFieldStartY.getText());
							int x2 = Integer.parseInt(textFieldEndX.getText());
							int y2 = Integer.parseInt(textFieldEndY.getText());
							
							if(x1 <= 0 || x2 <= 0 || y1 <= 0 || y2 <= 0) {
								JOptionPane.showMessageDialog(null, "Values must be positive!", "Error", JOptionPane.ERROR_MESSAGE);
								return;
							}
							
							line = new Line(new Point(x1, y1), new Point(x2, y2), color);
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
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	

	public void setColor(Color color) {
		this.color = color;
		contentPanel.getComponent(12).setBackground(color);
	}
	
	public Line getLine() {
		return this.line;
	}
	
	public void setLine(Point sp, Point ep) {
		textFieldStartX.setText("" + sp.getX());
		textFieldStartY.setText("" + sp.getY());
	
		textFieldEndX.setText("" + ep.getX());
		textFieldEndY.setText("" + ep.getY());
	}
	
	public void setLine(Point sp, Point ep, Color color) {
		setLine(sp, ep);
		setColor(color);
	}
	

}
