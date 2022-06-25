package sort;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SortWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private ArrayList<Circle> list = new ArrayList<>();
	private DefaultListModel<Circle> dlm = new DefaultListModel<Circle>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortWindow frame = new SortWindow();
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
	public SortWindow() {
		setTitle("Bognar Nemanja IT80/2021");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Add");
		
		panel.add(btnAdd);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btnExit);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JList<Circle> circleJList = new JList<Circle>();
		scrollPane.setViewportView(circleJList);
		
		JLabel lblCircleSort = new JLabel("Circle Sort (lowest on top)");
		contentPane.add(lblCircleSort, BorderLayout.NORTH);
		lblCircleSort.setHorizontalAlignment(SwingConstants.CENTER);
		lblCircleSort.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgCircleSort dlg = new DlgCircleSort();
				dlg.setVisible(true);
				
				if (dlg.getCircle() != null) {
					list.add(dlg.getCircle());
				}
				
				list.sort(null);
				circleJList.setModel(getSortedModel());
			}
		});
		
	}
	
	public DefaultListModel<Circle> getSortedModel() {
		Iterator<Circle> it = list.iterator();
		dlm.clear();
		
		while(it.hasNext()) {
			dlm.addElement(it.next());
		}
		
		return dlm;
	}

}
