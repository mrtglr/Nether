import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Driver extends JFrame{
	
	static String folder_path;
	static String project_name;
	static String project_type;
	
	Driver() {
		
		final JLabel panel = new JLabel();
		this.setTitle(".Net Project Creator");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setSize(620, 280);
		
		JFileChooser chooser;
		String choosertitle = null;
		chooser = new JFileChooser(); 
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle(choosertitle);
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);
	    
		JLabel title = new JLabel();
		title.setText("create new dotnet project");
		title.setFont(new java.awt.Font("Arial Black", Font.BOLD, 15));
		title.setBounds(50, 20, 450, 20);
		panel.add(title);
		
		String[] project_types = new String[] { "console", "classlib", "wpf", "wpflib", "wpfcustomcontrollib",
												"wpfusercontrollib", "winforms", "winformslib", "worker",
												"mstest", "nunit", "xunit", "page", "viewimports",
												"blazorserver", "blazorwasm", "web", "mvc", "webapp",
												"angular", "react", "reactredux", "razorclasslib", "webapi",
												"grpc", "globaljson", "proto"};

		final JComboBox<String> project_types_comboBox = new JComboBox<>(project_types);
		project_types_comboBox.setBounds(470, 17, 100, 30);
		panel.add(project_types_comboBox);

		JLabel name_label = new JLabel();
		name_label.setText("Project Name");
		name_label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 12));
		name_label.setBounds(50, 50, 80, 28);
		panel.add(name_label);
		
		final JTextField name = new JTextField(20);
		name.setBounds(50, 80, 250, 25);
		panel.add(name);
				
		final JLabel directory_label = new JLabel();
		directory_label.setText("Project Path: " +  chooser.getCurrentDirectory());
		directory_label.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 12));;
		directory_label.setBounds(80, 120, 600, 28);
		panel.add(directory_label);
		
		JButton path = new JButton("<html><font color=black size=3><b>...</b></html>");
		path.setBounds(50, 120, 25, 25);
		panel.setLayout(null);
		panel.add(path);
				
		JButton create_button = new JButton("<html><font color=black size=4><b>Create</b></html>");
		create_button.setBounds(275, 180, 90, 30);
		panel.setLayout(null);
		panel.add(create_button);
	
		this.setVisible(true);
		this.add(panel);

		project_types_comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				String selectedColor = (String) project_types_comboBox.getSelectedItem();

				if (selectedColor.equals("console")) {
					title.setText("create new dotnet console project");
					project_type = "console";
				}
				if (selectedColor.equals("classlib")) {
					title.setText("create new dotnet classlib project");
					project_type = "classlib";
				}
				if (selectedColor.equals("wpf")) {
					title.setText("create new dotnet wpf project");
					project_type = "wpf";
				}
				if (selectedColor.equals("wpflib")) {
					title.setText("create new dotnet wpflib project");
					project_type = "wpflib";
				}
				if (selectedColor.equals("wpfcustomcontrollib")) {
					title.setText("create new dotnet wpfcustomcontrollib project");
					project_type = "wpfcustomcontrollib";
				}
				if (selectedColor.equals("wpfusercontrollib")) {
					title.setText("create new dotnet wpfusercontrollib project");
					project_type = "wpfusercontrollib";
				}
				if (selectedColor.equals("winforms")) {
					title.setText("create new dotnet winforms project");
					project_type = "winforms";
				}
				if (selectedColor.equals("winformslib")) {
					title.setText("create new dotnet winformslib project");
					project_type = "winformslib";
				}
				if (selectedColor.equals("worker")) {
					title.setText("create new dotnet worker project");
					project_type = "worker";
				}
				if (selectedColor.equals("mstest")) {
					title.setText("create new dotnet mstest project");
					project_type = "mstest";
				}
				if (selectedColor.equals("nunit")) {
					title.setText("create new dotnet nunit project");
					project_type = "nunit";
				}
				if (selectedColor.equals("xunit")) {
					title.setText("create new dotnet xunit project");
					project_type = "xunit";
				}
				if (selectedColor.equals("page")) {
					title.setText("create new dotnet page project");
					project_type = "page";
				}
				if (selectedColor.equals("viewimports")) {
					title.setText("create new dotnet viewimports project");
					project_type = "viewimports";
				}
				if (selectedColor.equals("blazorserver")) {
					title.setText("create new dotnet blazorserver project");
					project_type = "blazorserver";
				}
				if (selectedColor.equals("blazorwasm")) {
					title.setText("create new dotnet blazorwasm project");
					project_type = "blazorwasm";
				}
				if (selectedColor.equals("web")) {
					title.setText("create new dotnet web project");
					project_type = "web";
				}
				if (selectedColor.equals("mvc")) {
					title.setText("create new dotnet mvc project");
					project_type = "mvc";
				}
				if (selectedColor.equals("webapp")) {
					title.setText("create new dotnet webapp project");
					project_type = "webapp";
				}
				if (selectedColor.equals("angular")) {
					title.setText("create new dotnet angular project");
					project_type = "angular";
				}
				if (selectedColor.equals("react")) {
					title.setText("create new dotnet react project");
					project_type = "react";
				}
				if (selectedColor.equals("reactredux")) {
					title.setText("create new dotnet reactredux project");
					project_type = "reactredux";
				}
				if (selectedColor.equals("razorclasslib")) {
					title.setText("create new dotnet razorclasslib project");
					project_type = "razorclasslib";
				}
				if (selectedColor.equals("webapi")) {
					title.setText("create new dotnet webapi project");
					project_type = "webapi";
				}
				if (selectedColor.equals("grpc")) {
					title.setText("create new dotnet grpc project");
					project_type = "grpc";
				}
				if (selectedColor.equals("globaljson")) {
					title.setText("create new dotnet globaljson project");
					project_type = "globaljson";
				}
				if (selectedColor.equals("proto")) {
					title.setText("create new dotnet proto project");
					project_type = "proto";
				}
			}
		});
		
		create_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {	
				
				project_name = name.getText();
				
				if(project_type != null) {
					if(!project_name.equals("")) {	
						if(chooser.getSelectedFile() != null) {
							
							folder_path = chooser.getSelectedFile().toString();						
							String [] command = {"cmd",};					
							Process p;
							
							try {
									p = Runtime.getRuntime().exec(command);
							        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
					                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
					                PrintWriter stdin = new PrintWriter(p.getOutputStream());
					                stdin.println("cd " + folder_path);
					                stdin.println("dotnet new " + project_type +" -n " + project_name);
					                stdin.close();
					                p.waitFor();
					                
					                JOptionPane.showConfirmDialog(null, "Project created!", "Finished", JOptionPane.CLOSED_OPTION);
						    	} catch (Exception e) {
						    		JOptionPane.showConfirmDialog(null, "An error ocuured!", "Error", JOptionPane.CLOSED_OPTION);
						    		e.printStackTrace();
							}
						}
						else {
							JOptionPane.showConfirmDialog(null, "Please select a folder path!", "Error", JOptionPane.CLOSED_OPTION);
						}
					}
					else {
						JOptionPane.showConfirmDialog(null, "Please enter a project name!", "Error", JOptionPane.CLOSED_OPTION);
					}
				}
				else {
					JOptionPane.showConfirmDialog(null, "Please select a project type!", "Error", JOptionPane.CLOSED_OPTION);
				}			
			}
		});
		
		path.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 
			    if (chooser.showOpenDialog(panel) == JFileChooser.APPROVE_OPTION) { 
			      directory_label.setText("Project Path: " +  chooser.getSelectedFile());
			    }
			    else {
			      System.out.println("No Selection ");
			    }
			 }
		});	
	}	
		
	public static void main(String[] args) {
		
		new Driver();
	}
}
