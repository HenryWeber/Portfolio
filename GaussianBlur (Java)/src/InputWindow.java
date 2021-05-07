import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InputWindow  extends JFrame implements ActionListener {	
	Dimension d;
	Container canvas;
	JTextField fileField = new JTextField(10);
	JTextField radiusField = new JTextField(3);
	JTextField varianceField = new JTextField(3);
    JButton button = new JButton("Compute");
    Sequencer s = new Sequencer();
    
	public InputWindow() {
		//set up defaults
		d = new Dimension(1500,800);
		this.setSize(d);
		this.setLocation(300, 100);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Input Window");
		
		//set layout and canvas
		canvas = this.getContentPane();
		this.setLayout(new FlowLayout());

		//add text field and button
		this.add(fileField, BorderLayout.NORTH);
		this.add(radiusField, BorderLayout.NORTH);
		this.add(varianceField, BorderLayout.NORTH);
        this.add(button);
        button.addActionListener((ActionListener) this);
	
	}

	 public void actionPerformed(ActionEvent event) {
	       
	        String text = fileField.getText();
	        String text2 = radiusField.getText();
	        String text3 = varianceField.getText();
	        
	        System.out.println(text + " " + text2 + " " + text3);
	        s.run(text, text2, text3);
	 }
	 
	 public void addImages() {
		 	this.add(new JLabel(new ImageIcon("original_image.png")));
			this.add(new JLabel(new ImageIcon("blurred_image.png")));
	 }

	
	
	
}