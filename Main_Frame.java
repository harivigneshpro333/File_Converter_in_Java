package Main_Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main_Frame extends JFrame {

	private JPanel contentPane;
	public JButton startbut;
	public static  Main_Frame frames;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				 frames = new Main_Frame();
					frames.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main_Frame() {
		 try {
	            // Set the look and feel
	            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X Changer");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("Viner Hand ITC", Font.BOLD, 32));
		lblNewLabel.setBounds(245, 89, 215, 50);
		contentPane.add(lblNewLabel);

		startbut = new JButton("LOGIN");
		startbut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Option_Frame frame = new Option_Frame();
					frame.setVisible(true);
					frames.setVisible(false);
				
				} catch (Exception l) {
					System.out.println("Option frame view"+e);
				}	
			}
		});
		startbut.setForeground(new Color(0, 255, 255));
		startbut.setBackground(new Color(0, 64, 128));
		startbut.setFont(new Font("Tempus Sans ITC", Font.BOLD, 19));
		startbut.setBounds(286, 262, 101, 40);
		contentPane.add(startbut);
		
		JLabel lblNewLabel_1 = new JLabel("Image And File Converter");
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(225, 138, 215, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\Java_Main_Project\\src\\Main_Project\\star black.jpg"));
		lblNewLabel_2.setBounds(-37, 0, 708, 364);
		contentPane.add(lblNewLabel_2);
		
	}
}
