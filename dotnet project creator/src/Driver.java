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
	static JLabel title;
	
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
	    
		title = new JLabel();
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
				String selectedType = (String) project_types_comboBox.getSelectedItem();
				projectTypeSelector(selectedType);
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

	public static void projectTypeSelector(String selectedType) {

		title.setText("create new dotnet " + selectedType + " project");
		project_type = selectedType;
	}
		
	public static void main(String[] args) {
		
		new Driver();
	}
}
