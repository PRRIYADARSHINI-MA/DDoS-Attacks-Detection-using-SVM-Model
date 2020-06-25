package firecol;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
//import java.net.UnknownHostException;
//
//import javax.swing.BorderFactory;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JCheckBox;
//import javax.swing.JComboBox;
//import javax.swing.JFileChooser;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.*;




public class server implements ActionListener
{		
	
	String dd;
	String txtstr=null;

	public JLabel T1a= new JLabel(" Intrusion Detection System Attack Blocker");
	public JLabel T1b= new JLabel("");
	public Font f = new Font("Times new roman" , Font.BOLD , 22);	
	public Font f1 = new Font("Times new roman", Font.BOLD , 15);
	public Font f2 = new Font("Times new roman", Font.BOLD , 17);
	public Font f3 = new Font("Times new roman", Font.BOLD , 18);
	public JLabel T0= new JLabel("Server");
	
	public JLabel T2= new JLabel("Received File");
	
	public JLabel T4= new JLabel();
	
	
	public Font l3 = new Font("Times New roman" , Font.BOLD , 14);
	public JLabel rip= new JLabel("Received File size(bits):");
	
	public JTextField riptxt=new JTextField();
	
	
	public JTextArea tf = new JTextArea();
	public JScrollPane pane = new JScrollPane();
	
	public JLabel  leftButton;
	
	
	
	public JFrame jf;
	public Container c;
	String event;String fname;String originalfile;
	public JLabel sys=new JLabel();
	public JLabel flocation=new JLabel("File Received Location:");
	public JLabel flocation1=new JLabel();
	
	
	
	server()
	{	
//		ImageIcon redsys=new ImageIcon(this.getClass().getResource("F:/ProjectsDemo/Error/IDS_sigfree/src/redsystem.png"));
//		sys.setIcon(redsys);
//		sys.setBounds(200,70,400,300);
		
		
		
		
		jf = new JFrame("Server");
		c = jf.getContentPane();
		c.setLayout(null);
		jf.setSize(740, 750);
		jf.setLocation(120, 0);
		jf.setResizable(false);  
		c.setBackground(new Color(98,130,130));
		T1a.setBounds(85, 5, 650,45);
		T1a.setFont(f);
		T1a.setForeground(Color.YELLOW);
		T1b.setBounds(165, 40, 450,45);
		T1b.setFont(f);
		T1b.setForeground(Color.RED);
		
		
		
		

		TitledBorder leftBorder = BorderFactory.createTitledBorder("Received File");
	    leftBorder.setTitleJustification(TitledBorder.LEFT);
	    leftButton = new JLabel();
	    leftButton.setBorder(leftBorder);
	  
	    leftButton.setBounds(70,325,590,350);
	    leftBorder.setTitleColor(Color.CYAN);
	    leftButton.setForeground(Color.white);
	     
	  
	    rip.setBounds(160, 590, 250,45);
	  
	    rip.setForeground(Color.CYAN);
	    riptxt.setBounds(300, 600, 120,25);
	    riptxt.setFont(f2);
	    riptxt.setForeground(new Color(0,0,120));
	    
	    flocation.setBounds(160, 630, 250,45);
		  
	    flocation.setForeground(Color.CYAN);
	    flocation1.setBounds(300, 640, 220,25);
	    flocation1.setFont(f1);
	    flocation1.setForeground(Color.GREEN);
	    
	    
		T0.setBounds(310,60,350,45);
	    T0.setFont(f);
	   
	    T0.setForeground(Color.RED);
		T2.setBounds(290, 340, 250,45);
		T2.setFont(f2);
		T2.setForeground(Color.CYAN);
		
		T4.setBounds(225, 540, 250,45);
		T4.setFont(f2);
		T4.setForeground(Color.RED);
		
		
		pane.setBounds(150, 380, 400, 200);
		
		tf.setColumns(20);
		
		tf.setForeground(new Color(120,0,0));
		tf.setFont(f1);
		tf.setRows(10);
		tf.setName("tf");
		pane.setName("pane");
		pane.setViewportView(tf);
	
		jf.show();
	
	 	c.add(rip);
	 	c.add(riptxt);
		c.add(T1a);
		c.add(T1b);
	 	
		c.add(T2);
		
		c.add(T4);
		c.add(flocation);
		c.add(flocation1);
		c.add(pane, BorderLayout.CENTER);
	
		c.add(T0);
		
		c.add(leftButton);		
		
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent win) {
				System.exit(0);
			}
		});
		
		int[] ports = new int[] { 3000 };

		for (int i = 0; i < 1; i++) {
			Thread t = new Thread(new PortListener(ports[i]));
			t.setName("Listener-" + ports[i]);
			t.start();

		}
		c.add(sys);
	}		
	
	class PortListener implements Runnable {

		ServerSocket server;
		Socket connection;
		BufferedReader br = null;
		int port;

		public PortListener(int port) {
			this.port = port;
		}

		public void run() {
			
			
			try {
				
				server = new ServerSocket(port);

				while (true) {
					connection = server.accept();
					
					br = new BufferedReader(
							new InputStreamReader(new BufferedInputStream(
									connection.getInputStream())));
					
					String strLine;
					
					StringBuffer  buffer = new StringBuffer();
					
					while ((strLine = br.readLine()) != null) {
						
						buffer.append(strLine + "\n");
						
					}
					br.close();
					connection.close();
					
				String fnl=buffer.substring(0,2);
				int fnlen=Integer.parseInt(fnl);
				 fname=buffer.substring(2,2+fnlen-10);
				 originalfile=buffer.substring(2+fnlen-10,buffer.length());
				String crpt   = originalfile.substring(originalfile.length()- 10 );
				//tf.setText(originalfile.toString());
                                
                               // System.out.println("crpt " +crpt);
                                String crpt1 =crpt.trim();
                                if(crpt1.equalsIgnoreCase("127.0.0.1")||crpt1.equalsIgnoreCase("127.0.0.2")||crpt1.equalsIgnoreCase("127.0.0.3")) {
                                    
                                    tf.setText("             ");
                                    
                                   }
                                
                                else {
                                    
                                  originalfile = originalfile.substring(0, originalfile.length()-10);
                                  //System.out.println("originalfile : "+originalfile);
                                  tf.setText(originalfile.toString());
                                
                                
                                
				riptxt.setText(Integer.toString(tf.getText().trim().length()));
				
				byte[] bb=originalfile.getBytes();
				try{
				    String strDirectoy ="C:/SigFree";
				  
				    boolean success = (new File(strDirectoy)).mkdir();
				    if (success) {
				      
				    } 
				    
				    FileOutputStream fos = new FileOutputStream("C:/SigFree/"+fname);
				    fos.write(bb);
				    fos.close();
				    flocation1.setText("C:/SigFree/"+fname);
				}catch (Exception e){
				      System.err.println("Error: " + e.getMessage());
			    }
                               
                            }
                        }    		
			
			} catch (IOException e) {
			} finally {
			}
			

		}

	}

		public void actionPerformed(ActionEvent e)
		 {}
				   
				
				 
	

	public static void main(String args[])
	{
//            try{
//        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
//
//    }
//    catch(Exception e){
//        System.out.println("Nimbus isn't available");
//    }
		new server();
	}
}
	
	
	

		


