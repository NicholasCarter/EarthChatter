import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class Client {
	
	  private JFrame frame;
	  private JTextField entryBar;
	  private JScrollPane scrollPane;
	  private guiPanel display;
	  private String name = "You";
		
	public Client(){
		frame = new JFrame("EarthChattering");
	    frame.setSize(500, 500);
	    entryBar = new JTextField("/username ");

	    display = new guiPanel();

	    Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	    screenSize.width /= 2;
	    screenSize.height /= 2;

	    display.setPreferredSize(screenSize);
	    scrollPane = new JScrollPane(display);

	    List<String> fresh = new ArrayList<String>();
	    fresh.add("Server: Never send anyone your password or private information.");
	    
	    display.setText(fresh);

	    frame.getContentPane().add(entryBar, BorderLayout.SOUTH);
	    frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();

	    // Respond to the user pressing <enter> in the address bar.
	    entryBar.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	        String textInBar = entryBar.getText();
	        if(textInBar.contains("/username ")){
	        	String[] temp = textInBar.split("/username ",2);
	        	name = temp[1];
	        }
	        else if(textInBar.contains("/color ")){
	        	String[] temp = textInBar.split("/color ",2);
	        	if(Color.getColor(temp[1]) != null){
	        		display.setColor(Color.getColor(temp[1]));
	        	}
	        }
	        else{
	        	display.addText(textInBar, name);
	        }
	        entryBar.setText(null);
	        frame.repaint();
	      }
	    });
	    
	}
	
	public static void main(String[] args) {
		Client starter = new Client();
	}

}
