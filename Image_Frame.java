package Main_Project;


import java.io.*;
import java.awt.Desktop;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.itextpdf.io.image.ImageDataFactory;
//******************
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
//*******************
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;

public class Image_Frame extends JFrame {

	private JPanel contentPane;
	public JTextField locationtext;
	public JComboBox from;
	public JComboBox to;
	/**
	 * Launch the application
	 */

	/**
	 * Create the frame.
	 */
	public Image_Frame() {
		 try {
	            // Set the look and feel
	            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 851, 499);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel mainlabel = new JLabel("IMAGE CONVERTER");
		mainlabel.setForeground(new Color(255, 255, 255));
		mainlabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
		mainlabel.setBounds(249, 26, 342, 61);
		contentPane.add(mainlabel);
		
		from = new JComboBox();
		from.setFont(new Font("Times New Roman", Font.BOLD, 26));
		from.setBounds(290, 145, 85, 43);
		from.addItem("");
		from.addItem("png");
		from.addItem("jpg");
		from.addItem("jpeg");
		from.addItem("gif");
		contentPane.add(from);
		
		JLabel lblNewLabel_1 = new JLabel("     TO");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		lblNewLabel_1.setBounds(376, 145, 85, 43);
		
		contentPane.add(lblNewLabel_1);
		
		to = new JComboBox();
		to.setFont(new Font("Times New Roman", Font.BOLD, 26));
		to.setBounds(452, 143, 85, 43);
		to.addItem("");
		to.addItem("png");
		to.addItem("jpg");
		to.addItem("jpeg");
		to.addItem("gif");
		to.addItem("pdf");
		
		contentPane.add(to);
		
		locationtext = new JTextField();
		locationtext.setFont(new Font("Times New Roman", Font.BOLD, 26));
		locationtext.setBounds(160, 257, 431, 36);
		contentPane.add(locationtext);
		locationtext.setColumns(10);
		
		JButton directory = new JButton("Directory");
		directory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)   {
        //take the file from own window directory it;
				try {
				JFileChooser chooser = new JFileChooser();
        // Set a filter to only allow certain file types (optional)
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("Allfiles", "jpg", "jpeg", "png", "gif","avif");
        //FileNameExtensionFilter filter1 = new FileNameExtensionFilter("Text files","txt", "pdf", "xls", "doc");
		        
		        chooser.setFileFilter(filter); 
        // Show the dialog and wait for the user to select a file
		        int result = chooser.showOpenDialog(null);
        // Check if the user selected a file
		        if (result == JFileChooser.APPROVE_OPTION) {
		            
		// Get the selected file object
		            java.io.File selectedFile = chooser.getSelectedFile();
		            
		// Get the absolute path of the selected file
		            String selectedFilePath = selectedFile.getAbsolutePath();
		//Here set the location into the text field :
		            locationtext.setText(selectedFilePath);
		            
		            Desktop desktop = Desktop.getDesktop();
		            File directory = selectedFile.getParentFile();
		//desktop.open(directory);
		            
		        } else {
		        	JOptionPane.showMessageDialog(directory, "File Not Selected...");
		        }
				}
				
				catch (Exception c) {
					System.out.println("Directory***"+c);
					
				}
		    }
		
				
			
		});
		directory.setBackground(new Color(192, 192, 192));
		directory.setFont(new Font("Times New Roman", Font.BOLD, 20));
		directory.setBounds(609, 257, 130, 36);
		contentPane.add(directory);
		
		JButton convert = new JButton("Convert");
		convert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try {
		//action performing the Convert the format:
		//input location from directory:
					String input=(String)locationtext.getText();
					
					File file=new File(input);		
		//separate the location and filename
					String parent=file.getParent();
					String name=file.getName();
		// Find the last occurrence of the period (.)
		//separate the filename and file format
			        int dotIndex = name.lastIndexOf(".");
		// Extract the file name and format from the original file name
			        String Format = name.substring(dotIndex + 1);
			        String FileName = name.substring(0, dotIndex);
			        String valuefrom = from.getSelectedItem().toString();
			        String valueto=to.getSelectedItem().toString();
			        String outputname=(FileName+"."+valueto);
		// Rearrange the Separated filename and format and loction also:
			        
			        File file1 = new File(parent, outputname);
	    // Get the new file path from the File object
			        String newFilePath = file1.getPath();
			        String output=newFilePath;
			        String fileFormat=valueto.toUpperCase();
			        if(valuefrom.equals(valueto)||!Format.equals(valuefrom)){
			        	JOptionPane.showMessageDialog(convert,"Not Applicable Format\nBecause Both Image format is Same");
			        }
			        else if(valuefrom.equals("jpeg")&&valueto.equals("pdf")||valuefrom.equals("png")&&valueto.equals("pdf")||valuefrom.equals("gif")&&valueto.equals("pdf")||valuefrom.equals("jpg")&&valueto.equals("pdf")) {
			        	try {
	 //insert the location of input file and output file
			        		
			        		    String imagePath = input;		        		 
			        	        String pdfPath =output;
     // Create PDF writer and document
			        	        PdfWriter writer = new PdfWriter(pdfPath);
			        	        PdfDocument pdfDoc = new PdfDocument(writer);
			        	        Document doc = new Document(pdfDoc);
     // Add image to document
			        	        Image img = new Image(ImageDataFactory.create(imagePath));
			        	        doc.add(img);
     // Close document and writer
			        	        doc.close();
			        	        writer.close();
			        	        
			        	        JOptionPane.showMessageDialog(convert,"To pdf Converting Sucessfully...");
			    				
			    		}
			    		catch(Exception R) {System.out.println("jpeg to pdf"+R);}
			        	
			        }
			        else if(valuefrom.equals("jpg")&&valueto.equals("png")||valuefrom.equals("jpg")&&valueto.equals("jpeg")||valuefrom.equals("jpg")&&valueto.equals("gif")||valuefrom.equals("png")&&valueto.equals("jpg")||valuefrom.equals("png")&&valueto.equals("jpeg")||valuefrom.equals("png")&&valueto.equals("gif")||valuefrom.equals("jpeg")&&valueto.equals("png")||valuefrom.equals("jpeg")&&valueto.equals("jpg")||valuefrom.equals("jpeg")&&valueto.equals("gif")||valuefrom.equals("gif")&&valueto.equals("jpg")||valuefrom.equals("gif")&&valueto.equals("jpeg")||valuefrom.equals("gif")&&valueto.equals("png")) {
	  //format change here by using IO Stream:
			        	FileInputStream inputstream=new FileInputStream(input);
			        	FileOutputStream outputstream=new FileOutputStream(output);
			        	BufferedImage inputImage=ImageIO.read(inputstream);
	 //Write the Image into Required Format:
			        	Boolean result=ImageIO.write(inputImage, fileFormat, outputstream);
	 //messagedialog shown when the File Format Converted or not:		        	
			        	if(result) {
			        		JOptionPane.showMessageDialog(convert,"Image Converting Successfully...");
			        	}
			        	else {
			        		JOptionPane.showMessageDialog(convert, "Request Denied...");
			        	}
			        }
			
				}
				catch(Exception A) {
					JOptionPane.showMessageDialog(directory,"Something Wrong");
					System.out.println("Convert***"+A);
					
				}
				
			}
		});
		convert.setBackground(new Color(192, 192, 192));
		convert.setFont(new Font("Times New Roman", Font.BOLD, 24));
		convert.setBounds(311, 333, 207, 43);
		contentPane.add(convert);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\Java_Main_Project\\src\\Main_Project\\1244978.jpg"));
		lblNewLabel.setBounds(-610, -212, 1445, 672);
		contentPane.add(lblNewLabel);
		
				
	}
}
