package Main_Project;

import javax.swing.JFrame;
//**************************
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

//**************************

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;

import java.io.*;
//***************************************************
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
//***************************************************

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.Desktop;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class File_Frame extends JFrame {

	private JPanel contentPane;
	public JTextField location1;
	public JButton directory1;
	public JButton file_convert;
	public JComboBox from1;
	public JComboBox to1; 
	private JLabel lblNewLabel_2;
	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the frame.
	 */
	public File_Frame() {
		 try {
	            // Set the look and feel
	            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 820, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FILE CONVERTER");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblNewLabel.setBounds(251, 54, 325, 38);
		contentPane.add(lblNewLabel);
		
	    from1 = new JComboBox();
		from1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		from1.addItem("");
		from1.addItem("class");
		from1.addItem("txt");
		from1.addItem("doc");
		from1.addItem("docx");;
		
		from1.setBounds(258, 158, 87, 45);
		contentPane.add(from1);
		
		to1 = new JComboBox();
		to1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		to1.addItem("");
		to1.addItem("java");
		to1.addItem("txt");
		to1.addItem("doc");
		to1.addItem("pdf");
		to1.addItem("docx");
		to1.setBounds(418, 158, 90, 45);
		contentPane.add(to1);
		
		JLabel lblNewLabel_1 = new JLabel("     TO");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		lblNewLabel_1.setBounds(343, 165, 77, 45);
		contentPane.add(lblNewLabel_1);
		
		location1 = new JTextField();
		location1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		location1.setBounds(132, 257, 444, 38);
		contentPane.add(location1);
		location1.setColumns(10);
		
		directory1 = new JButton("Directory");
		directory1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//take the file from own window directory it;
				try {
				JFileChooser chooser = new JFileChooser();
        // Set a filter to only allow certain file types (optional)
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("TextFiles","class","java","txt","pdf","docx");
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
		            location1.setText(selectedFilePath);
		            
		            Desktop desktop = Desktop.getDesktop();
		            File directory = selectedFile.getParentFile();
		//desktop.open(directory);
		            
		        } else {
		        	JOptionPane.showMessageDialog(lblNewLabel_1,"File Not Selected");
		        }
				}
				
				catch (Exception c) {
					System.out.println("Directory***"+c);
					
				}
				
			}
		});
		directory1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		directory1.setBounds(597, 257, 129, 38);
		contentPane.add(directory1);
		
	    file_convert = new JButton("Convert");
	    file_convert.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String input=(String)location1.getText();
				
				File file=new File(input);		
	//separate the location and filename
				String parent1=file.getParent();
				String inputname=file.getName();
	// Find the last occurrence of the period (.)
	//separate the filename and file format
		        int dotIndex = inputname.lastIndexOf(".");
	// Extract the file name and format from the original file name
		        String Format = inputname.substring(dotIndex + 1);
		        String FileName = inputname.substring(0, dotIndex);
		        String valuefrom1 = from1.getSelectedItem().toString();
		        String valueto1=to1.getSelectedItem().toString();
		        String outputname=(FileName+"."+valueto1);
	    if(valuefrom1.equals(valueto1)||!Format.equals(valuefrom1)){
		        JOptionPane.showMessageDialog(lblNewLabel_1,"Not Applicable Format\nBecause Both File format is Same");
		     }
	    else if((valuefrom1.equals("class"))&&(valueto1.equals("java"))) {
try
{ 
	 
	 
	//write the Filename first to String datatype;
                 String className=FileName;
	//Classpool to Get Detaults create the  classpool object              
                 ClassPool classPool = ClassPool.getDefault();
    //add to fileopenpath in the classpath in classpool             
                 classPool.appendClassPath(parent1);
	//Get the class name to the ctclass creation:
                 CtClass ctClass = classPool.get(className);
     //read the methods by using ctMethod
                 CtMethod[] methods = ctClass.getDeclaredMethods();
     //create Stringbuilder because i want change value in mutable state 
                 StringBuilder javaCode = new StringBuilder();
                 javaCode.append("public class " + ctClass.getSimpleName() + " {\n");
     //Append the take from .class into java source code:
                 for (CtMethod method : methods) {
                 javaCode.append(method.getMethodInfo().toString());
                 javaCode.append("{\n");
                 javaCode.append(method.getMethodInfo().getCodeAttribute().toString());
                 javaCode.append("}\n\n");
     }
                 javaCode.append("}\n");
    
                 String javaCode1 = javaCode.toString();
     //java output name to user choice
                 String javaFileName = outputname;
     //give where the output can present by using Filepath
                 File javaFile = new File(parent1,javaFileName);
      
                 //javaFile.getParentFile().mkdirs();------its automatically get path by using filename
                 try (FileWriter writer = new FileWriter(javaFile)) {
     //Write to already created java file
                 writer.write(javaCode1);
                 JOptionPane.showMessageDialog(lblNewLabel_1, "Sucessfully javacode decoded");
     }
    
	
	 
	    		            }          
catch(Exception N) 
{System.out.println("class into java "+N);}
	    		}
	    		
	    		
	    		
else if(valuefrom1.equals("txt")&&valueto1.equals("doc")||valuefrom1.equals("doc")&&valueto1.equals("txt")) {
	    		try {
						File infile=new File(parent1,inputname);
	    				 // Create a FileInputStream for the source file
	    	            FileInputStream inStream = new FileInputStream(infile);
	    	            File outfile=new File(parent1,outputname);
	    	            if(outfile.exists()) {
	    	            	System.out.println("file already exists");
	    	            }
	    	            
	    	            else {
	    	            outfile.createNewFile();
	    	            }
	    	// Create a FileOutputStream for the destination file
	    	            FileOutputStream outStream = new FileOutputStream(outfile);

	    	// Create a buffer to hold the data being read from the source file
	    	            byte[] buffer = new byte[1024];

	    	// Read from the input stream and write to the output stream
	    	            int length;
	    	            while ((length = inStream.read(buffer)) > 0) {
	    	                outStream.write(buffer, 0, length);
	    	            }

	    	// Close the input and output streams
	    	            inStream.close();
	    	            outStream.close();
	    	            JOptionPane.showMessageDialog(lblNewLabel_1, "File Converted Successfully...");
	    	         
	    			}catch(Exception N) {
	    				System.out.println("txt into doc"+N);
	    			}
	    		}
	    	else if(valuefrom1.equals("docx")&&valueto1.equals("pdf")) {
	    		try 
				{
						  FileInputStream inputStream = new FileInputStream(new File((String)parent1,inputname));
			//From jar class to apply the inputStream 
						  XWPFDocument document = new XWPFDocument(inputStream);
			//Create the pdf Options for Create the new pdf file			  
						  PdfOptions options = PdfOptions.create();
			// Convert the Word document to PDF 
						  FileOutputStream outputStream = new FileOutputStream(new File((String)parent1,outputname));
			//Convert pdf from Pdf jar file			  
						  PdfConverter.getInstance().convert(document, outputStream, options);
			//Dialog box show the Message to Successfully	
						JOptionPane.showMessageDialog(lblNewLabel_1,"Word document converted to PDF successfully!");
				}
	    		catch(Exception M)
	    		{System.out.println("doc into pdf"+M);}
	    		}
	    	else {
	    		JOptionPane.showMessageDialog(lblNewLabel_1," Sorry...Those Format is n't Applicable for this Software ");
	    		
	    	}
	    	}
	    });
		file_convert.setFont(new Font("Times New Roman", Font.BOLD, 24));
		file_convert.setBounds(285, 352, 176, 38);
		contentPane.add(file_convert);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\Java_Main_Project\\src\\Main_Project\\1244978.jpg"));
		lblNewLabel_2.setBounds(0, 0, 804, 481);
		contentPane.add(lblNewLabel_2);
	}
}
