import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Gui extends javax.swing.JFrame{

	
	fileStream f = new fileStream();
	
	public Gui(){
		start();
	}
	
	private void start(){
		JFrame frame = new JFrame("LZW compressor");
		frame.setSize(400,150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(panel);
		frame.setVisible(true);
		
	}
	
	private void placeComponents(JPanel panel ){
		panel.setLayout(null);
		
		JLabel file = new JLabel("File name :");
		file.setBounds(10, 10, 80, 25);
		panel.add(file);
		
		final JTextField text = new JTextField(20);
		text.setBounds(100, 10, 160, 25);
		panel.add(text);
		
		
		JButton comp = new JButton("Comp");
		comp.setBounds(25, 80, 80, 50);
		panel.add(comp);
		
		JButton decomp = new JButton("De-co");
		decomp.setBounds(180, 80, 80, 50);
		panel.add(decomp);
		
		
		
		comp.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String path = text.getText().trim();
				f.comp(path);
				JOptionPane.showMessageDialog(null, "Compressed successfully !");

			}
		});
		
		decomp.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String path = text.getText().trim();
				f.decomp(path);
				JOptionPane.showMessageDialog(null, "Decompressed successfully !");
			}
		});
		
		
			
	
		
	
}
	
}
