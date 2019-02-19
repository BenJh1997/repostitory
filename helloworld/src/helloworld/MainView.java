package helloworld;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class MainView {
	
	// Declaring main view components
	private JFrame mainWindow;
	
	private JButton openFileBtn;
	private JTextField fileNameTxt;
	private JLabel fileNameLbl;

	
	private JButton grayScaleBtn;
	private JButton rgbButton;
	private JButton edgeButton;
	private JButton drawCanvasBtn;
	private JButton randombutton;
	
	private JPanel displayPanel;
	private JLabel imageLabel;
	
	private JFileChooser fileChooser;
	
	
	
	
	MainController controller;
	ImageModel imgModel;
	
	// Default constructor
	public MainView() {
        
		//controller = new MainController();
		//controller = new MainController(this);
		imgModel = new ImageModel();
		controller = new MainController(this, imgModel);
		
		// Create and set up the window.
		mainWindow = new JFrame("Main window title");
		// set the layout
		mainWindow.setLayout(new BorderLayout());
		
	
		// Creating file selection panel
        JPanel fileSelectPanel = new JPanel();
        
        fileNameLbl = new JLabel ("File name: ");
        fileNameTxt = new JTextField(50);
        fileNameTxt.setEnabled(false);        
        openFileBtn = new JButton("Open File");
		
        // Add components to the JPanel
        fileSelectPanel.add(fileNameLbl);
        fileSelectPanel.add(fileNameTxt);
        fileSelectPanel.add(openFileBtn);
		
        // Add JPanel to the JFrame's north position
        // mainWindow.add(fileSelectPanel, BorderLayout.PAGE_START);
		
        // Creating main operation button panel
        JPanel opButtonPanel = new JPanel();
        
        rgbButton = new JButton("RGB Image");
        grayScaleBtn = new JButton("Grayscale Image");
        edgeButton = new JButton("Edge Image");
        drawCanvasBtn = new JButton("Draw Image");
		randombutton = new JButton("Press Me");
        
        opButtonPanel.add(rgbButton);
        opButtonPanel.add(grayScaleBtn);
        opButtonPanel.add(edgeButton);
        opButtonPanel.add(drawCanvasBtn);
        opButtonPanel.add(randombutton);
        
        // A JPanel with box layout
        JPanel southLayout = new JPanel();
        southLayout.setLayout(new BoxLayout(southLayout,
        		BoxLayout.Y_AXIS));
        
        // add both flow layouts to southLayout
        southLayout.add(fileSelectPanel);
        southLayout.add(opButtonPanel);
        
        // add southLayout to mainWindow's south
        mainWindow.add(southLayout, BorderLayout.SOUTH);
        
        // instantiate a new JPanel to hold image labels
        displayPanel = new JPanel();
        displayPanel.setPreferredSize(new Dimension(150, 150));
        displayPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        imageLabel = new JLabel();
        displayPanel.add(imageLabel);
        
        // add image panel to the north of the main window
        mainWindow.add(displayPanel, BorderLayout.NORTH);
        
		// Make the program quit, as the window is closed
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Set the width and height of mainWindow
		// mainWindow.setSize(new Dimension(200, 100));;
		mainWindow.pack();
        // Display the window.
		mainWindow.setVisible(true);
		
		
		// Event handling
		// Register action listener with openFileBtn
		//openFileBtn.addActionListener(controller);
				
		// Using annonymous inner class
		openFileBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				File selectedFile = showFileChooserDialog();
				
				if(selectedFile != null) {
					fileNameTxt.setText(selectedFile.getAbsolutePath());
					try {
						imgModel.LoadImage(selectedFile);
					} catch (IOException e1) {
						
						System.out.println("IO Exception in "
								+ "imageLoad(); " + e.toString());
						
						JOptionPane.showMessageDialog(null, 
								"Error, No image file found", 
								"Image Error", 
								JOptionPane.ERROR_MESSAGE);
						fileNameTxt.setText("");
					}
					

				}
				else
					fileNameTxt.setText("No file selected");	
			}
		});		
		
		rgbButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BufferedImage img = imgModel.getRGBImage();
				if(img != null) {
					displayImage(img);
				}
				else {
					JOptionPane.showMessageDialog(null, 
							"No image file is choosen", 
							"Image error", 
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		grayScaleBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BufferedImage img = imgModel.getGrayscaleImage();
				if (img != null)
					displayImage(img);
				else {
					JOptionPane.showMessageDialog(null, 
							"Error in loading the grayscale image", 
							"Image error", 
							JOptionPane.ERROR_MESSAGE);
				}			
			}
		});
		
		edgeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BufferedImage img = imgModel.getEdgeImage();
				if (img != null)
					displayImage(img);
				else {
					JOptionPane.showMessageDialog(null, 
							"Error in loading the edge image", 
							"Image error", 
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	private void displayImage(BufferedImage img) {
		imageLabel.setIcon(new ImageIcon(img));
	}
	
	
	
	private File showFileChooserDialog() {
		fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new 
				File(System.getProperty("user.home")));
	    int status = fileChooser.showOpenDialog(this.mainWindow);
	    File selected_file = null;
	    if (status == JFileChooser.APPROVE_OPTION) {
	        selected_file = fileChooser.getSelectedFile();
	    }
	    return selected_file;
	}

}
