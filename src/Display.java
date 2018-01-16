import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Thread.State;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Display extends JFrame
{
	static JLabel JL1 = new JLabel();
		static	JLabel JL2 = new JLabel();
		static JLabel JL3 = new JLabel();
		static	JLabel JL4 = new JLabel();
		static	JLabel JL5 = new JLabel();
	
	// table and fork label 
		static	JLabel JLtable = new JLabel();
		static	JLabel fork1 = new JLabel();
		static	JLabel fork2 = new JLabel();
		static	JLabel fork3 = new JLabel();
		static	JLabel fork4 = new JLabel();
		static	JLabel fork5 = new JLabel();
		
		static Button startButton;
		static Button stopButton ;
		static JPanel JP1;

		 static boolean onClick1 = true;
			
	 
	
	 
	public  Display()
	{
		
		
		//create a JFrame 
		JFrame window = new JFrame("Dinning");
		window.setVisible(true);
		window.setSize(500, 500);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// create panel to hold philosopher item.
		JP1 = new JPanel();
		JP1.setLayout(null);
		JP1.setBackground(Color.GREEN);
		
		
		// JPanel for Philosoper-1 

		JL1.setIcon(new ImageIcon("phil.png"));
		JL1.setBounds(220, 5, 70, 60);
		JL1.setBackground(Color.ORANGE);
		JP1.add(JL1);
		window.add(JP1);
		
		
		// JPanel for Philosoper-2
		JL2.setIcon(new ImageIcon("phil2.png"));
		JL2.setBounds(380, 80, 60, 60);
		JP1.add(JL2);
		
		
		// JPanel for Philosoper-3
		JL3.setIcon(new ImageIcon("phil2.png"));
		JL3.setBounds(350, 260, 60, 60);
		JP1.add(JL3);
		
		
		// JPanel for Philosoper-3
		JL4.setIcon(new ImageIcon("phil2.png"));
		JL4.setBounds(60, 260, 60, 60);
		JP1.add(JL4);
		
		
		// JPanel for Philosoper-5
		JL5.setIcon(new ImageIcon("phil.png"));
		JL5.setBounds(30, 80, 60, 60);
		JP1.add(JL5);
		
		
		
		// JLable for fork-1
		fork1.setIcon(new ImageIcon("fork1.png"));
		fork1.setBounds(280, 30, 60, 100);
		JP1.add(fork1);
		
		// JLable for fork-2
		fork2.setIcon(new ImageIcon("fork1.png"));
		fork2.setBounds(360, 130, 60, 100);
		JP1.add(fork2);
		
		// JLable for fork-3
		fork3.setIcon(new ImageIcon("fork1.png"));
		fork3.setBounds(210, 260, 60, 80);
		JP1.add(fork3);
				
		
		// JLable for fork-5
		fork5.setIcon(new ImageIcon("fork1.png"));
		fork5.setBounds(130, 20, 60, 80);
		JP1.add(fork5);
				
		// JLable for fork-4
		fork4.setIcon(new ImageIcon("fork1.png"));
		fork4.setBounds(60, 160, 60, 80);
		JP1.add(fork4);
		
		Button startButton = new Button("Start");
		Button stopButton = new Button("Stop");
		
		startButton.setBounds(50, 350, 160, 40);
		JP1.add(startButton);
		stopButton.setBounds(50, 390, 160, 40);
		JP1.add(stopButton);
		
		
		TextField id = new TextField("");
		id.setBounds(220, 360, 200, 50);
		JP1.add(id);
		
		System.out.println("This is inside Display");
		
		validate();
		
		
		
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				onClick1 = false;
				
			}
		});
		stopButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				
			}
		});
		
	    
	}
	
	

}


