package packageToDoList;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("TODO List");
		
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		JList<String> list = new JList<>(listModel);
		list.addMouseListener( new MouseAdapter () {
			public void mouseClicked(MouseEvent e){
			if (e.getClickCount() % 2 == 0 && !list.isSelectionEmpty()) 
				listModel.remove(list.getSelectedIndex());
			}
		});
		frame.add(new JScrollPane(list));
		JTextField textField = new JTextField();
		textField.addActionListener((e) -> {
			listModel.addElement(textField.getText());
			textField.setText("");
		});
		frame.add(textField ,BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		        try (FileOutputStream fileStream = new FileOutputStream("TODO"))
		        {
		        	
		        } catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});
		frame.setPreferredSize(new Dimension(1000, 600));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		
	}

}
