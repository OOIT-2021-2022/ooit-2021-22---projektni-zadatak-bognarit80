package stack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StackWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * The DefaultListModel for the JList to display.
	 */
	private DefaultListModel<Circle> dlm = new DefaultListModel<Circle>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StackWindow frame = new StackWindow();
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
	public StackWindow() {
		setTitle("Bognar Nemanja IT80/2021");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel btnPanel = new JPanel();
		contentPane.add(btnPanel, BorderLayout.SOUTH);
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				DlgCircleStack dlg = new DlgCircleStack();
				dlg.setVisible(true);
				
				if (dlg.getCircle() != null) {
					dlm.add(i, dlg.getCircle());
					i++;
				}
			}
		});
		btnPanel.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DlgCircleStack dlg = new DlgCircleStack();
					dlg.setCircle(dlm.get(0));
					dlg.setVisible(true);
					dlm.remove(0);
				} catch (ArrayIndexOutOfBoundsException exception) {
					JOptionPane.showMessageDialog(null, "Stack is empty!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnPanel.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JList<Circle> listStack = new JList<Circle>();
		scrollPane.setViewportView(listStack);
		
		JLabel lblCircleStack = new JLabel("Circle Stack");
		lblCircleStack.setHorizontalAlignment(SwingConstants.CENTER);
		lblCircleStack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblCircleStack, BorderLayout.NORTH);
		
		listStack.setModel(dlm);
	}

}
