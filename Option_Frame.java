package Main_Project;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Option_Frame extends JFrame {

	private JPanel contentPane;
	public JButton imagebut;
	public JButton filebut;
	/**
	 * Launch the application.
	 *//*
		 * public static void main(String[] args) { EventQueue.invokeLater(new
		 * Runnable() { public void run() { try { Option_Frame frame = new
		 * Option_Frame(); frame.setVisible(true); } catch (Exception e) {
		 * e.printStackTrace(); } } }); }
		 */
	/**
	 * Create the frame.
	 */
	public Option_Frame() {
		 try {
	            // Set the look and feel
	            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Option ");
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		lblNewLabel.setBounds(194, 43, 89, 36);
		contentPane.add(lblNewLabel);
		
        imagebut = new JButton("Image Convert");
		imagebut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//here the imagechooser call jFrame:  
				try {
					Image_Frame Image = new Image_Frame();
					Image.setVisible(true);
					
				} catch (Exception z) {
					z.printStackTrace();
				}
				
				
				
			}
		});
		imagebut.setFont(new Font("Times New Roman", Font.BOLD, 17));
		imagebut.setBounds(204, 116, 149, 44);
		contentPane.add(imagebut);
		
	    filebut = new JButton("File Convert");
	    filebut.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
	    //call the class JFrame for File Converter; 
	    			File_Frame FILE= new File_Frame();
	    			FILE.setVisible(true);
	    		}
	    		catch (Exception g) {
	    		    System.out.println("File convert"+g);	
	    		}
	    	}
	    });
		filebut.setFont(new Font("Times New Roman", Font.BOLD, 18));
		filebut.setBounds(204, 210, 149, 44);
		contentPane.add(filebut);
		
		JLabel lblNewLabel_2 = new JLabel("Pane");
		lblNewLabel_2.setForeground(new Color(0, 255, 255));
		lblNewLabel_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 24));
		lblNewLabel_2.setBounds(293, 43, 69, 36);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\Java_Main_Project\\src\\Main_Project\\1244978.jpg"));
		lblNewLabel_1.setBounds(-682, -390, 1240, 718);
		contentPane.add(lblNewLabel_1);
	}
}
