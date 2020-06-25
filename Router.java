package firecol;

//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Container;
//import java.awt.Font;
//import java.awt.Image;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.io.BufferedInputStream;
//import java.io.BufferedOutputStream;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.DataInputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.ServerSocket;
//import java.net.Socket;
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
//import javax.swing.border.TitledBorder;
//
//
//
//
//public class Router implements ActionListener
//{		
//	
//	String dd;
//	String txtstr=null;
//    
//    public JLabel T1a= new JLabel("Intrusion Detection System ");
//	public JLabel T1b= new JLabel("");
//	public Font f = new Font("Times new roman" , Font.BOLD , 22);	
//	public Font f1 = new Font("Times new roman", Font.BOLD , 15);
//	public Font f2 = new Font("Times new roman", Font.BOLD , 17);
//	public Font f3 = new Font("Times new roman", Font.BOLD , 18);
//	public JLabel T0= new JLabel("Router");
//	
//	public JLabel T2= new JLabel("Received File");
//	
//	public JLabel T4= new JLabel();
//	
//	public Font l3 = new Font("Times New roman" , Font.BOLD , 14);
//	public JLabel rip= new JLabel("Received File size(bits):");
//	public JTextField riptxt=new JTextField("");
//	public JButton btn = new JButton("Connect");
//	public JTextArea tf = new JTextArea();
//	public JScrollPane pane = new JScrollPane();
//	  
//	public JLabel proxip=new JLabel("ProxyServer IP Address:");
//	public JTextField txt=new JTextField();
//	public JLabel  leftButton;
//    
//	public JLabel line;
//    public JLabel line1;
//	public JFrame jf;
//	public Container c;
//	String event="null";
//	
//	Router()
//	{		
//		jf = new JFrame("Router");
//		c = jf.getContentPane();
//		c.setLayout(null);
//		jf.setSize(740, 750);
//		jf.setLocation(120, 0);
//		 jf.setResizable(false);  
//		c.setBackground(new Color(68,104,125));
//		T1a.setBounds(85, 5, 650,45);
//		T1a.setFont(f);
//		T1a.setForeground(Color.white);
//		T1b.setBounds(165, 40, 450,45);
//		T1b.setFont(f);
//		T1b.setForeground(Color.white);
//		
//		Border lineBorder = BorderFactory.createLineBorder(new Color(196,223,220));
//		line = new JLabel();
//		line.setBorder(lineBorder);
//		line.setBounds(70,140,590,100);
//		
//		
//		TitledBorder leftBorder = BorderFactory.createTitledBorder("Received File");
//	    leftBorder.setTitleJustification(TitledBorder.LEFT);
//	    leftButton = new JLabel();
//	    leftButton.setBorder(leftBorder);
//	   
//	    leftButton.setBounds(70,300,590,380);
//	    leftBorder.setTitleColor(Color.WHITE);
//	    leftButton.setForeground(Color.white);
//	    
//	    proxip.setBounds(140, 165, 250,45);
//	    proxip.setForeground(Color.white);
//	    txt.setBounds(310, 175, 180,26);
//	    txt.setForeground(Color.BLUE);
//	    txt.setFont(f1);
//	    
//	    rip.setBounds(160, 600, 250,45);
//	    rip.setForeground(Color.WHITE);
//	    riptxt.setBounds(320, 610, 120,25);
//	    riptxt.setFont(f2);
//	    riptxt.setForeground(new Color(0,0,120));
//		T0.setBounds(310,60,350,45);
//	    T0.setFont(f);
//	   
//	    T0.setForeground(Color.white);
//		T2.setBounds(290, 320, 250,45);
//		T2.setFont(f2);
//		T2.setForeground(Color.white);
//		 
//	  	
//		
//		
//		T4.setBounds(225, 540, 250,45);
//		T4.setFont(f2);
//		T4.setForeground(Color.RED);
//		
//		
//	  	 
//		btn.setBounds(520,177,105,28);
//		btn.setFont(f1);
//		btn.setForeground(Color.black);
//	
//		pane.setBounds(150, 380, 400, 200);
//		
//		tf.setColumns(20);
//		
//		tf.setForeground(new Color(120,0,0));
//		tf.setFont(f1);
//		tf.setRows(10);
//		tf.setName("tf");
//		pane.setName("pane");
//		pane.setViewportView(tf);
//	 
//		
//		btn.addActionListener(this);
//		    
//		jf.show();
//		c.add(btn);
//		c.add(txt);
//	    c.add(line);
//	 	c.add(rip);
//	 	c.add(riptxt);
//		c.add(T1a);
//		c.add(T1b);
//	    c.add(proxip);
//		c.add(T2);
//		
//		c.add(T4);
//		
//		c.add(pane, BorderLayout.CENTER);
//		
//		c.add(T0);
//	
//		c.add(leftButton);		
//		
//		jf.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent win) {
//				System.exit(0);
//			}
//		});
//		
//		int[] ports = new int[] { 1000 };
//
//		for (int i = 0; i < 1; i++) {
//			Thread t = new Thread(new PortListener(ports[i]));
//			t.setName("Listener-" + ports[i]);
//			t.start();
//
//		}
//		
//	}		
//	public void actionPerformed(ActionEvent e1)
//	 {
//		if(e1.getSource()==btn){
//			
//			event=txt.getText().trim();
//			 if(txt.getText().trim().equals("")){
//				 JOptionPane.showMessageDialog(null,"Please, Connect IPAddress!", "Message Box", 1);
//
//			 }else{
//				 JOptionPane.showMessageDialog(null,"Successfully connected IPAddress!!", "Message Box", 1);
//
//			 }
//		}
//		
//	 }
//	class PortListener implements Runnable {
//
//		ServerSocket server;
//		Socket connection;
//		BufferedReader br = null;
//		int port;
//
//		public PortListener(int port) {
//			this.port = port;
//		}
//
//		public void run() {
//			
//			
//			try {
//				
//				server = new ServerSocket(port);
//
//				while (true) {
//					connection = server.accept();
//					
//					br = new BufferedReader(
//							new InputStreamReader(new BufferedInputStream(
//									connection.getInputStream())));
//					
//					String strLine;
//					
//					StringBuffer  buffer = new StringBuffer();
//					
//					while ((strLine = br.readLine()) != null) {
//						
//					
//						buffer.append(strLine + "\n");
//						
//					}
//					 br.close();
//					 connection.close();
//					 riptxt.setText("");				
//					 String deip=buffer.substring(0,2);
//					 int desip=Integer.parseInt(deip);
//					 String desstr=buffer.substring(2,2+desip-10);
//					 String orifile=buffer.substring(2+desip-10,buffer.length());
//					 String filnam=orifile.substring(0,2);
//					 int filnamelen=Integer.parseInt(filnam);
//					 String filename=orifile.substring(2,2+filnamelen-10);
//					 String origifl=orifile.substring(2+filnamelen-10,orifile.trim().length());
//					 tf.setText(origifl.trim().toString());
//					 riptxt.setText(Integer.toString(origifl.trim().length()));
//					
//					
//					 byte[] byteArray;
//	                 Socket client = null;
//	             	 BufferedOutputStream bos = null;
//
//					
//					 try     { 
//	                    	/********************RouterB IP Address****************/
//	                    			    client = new Socket(event, 2000);
//	                    			    bos = new BufferedOutputStream(client.getOutputStream()); 
//	                    			      
//	                    			    
//	                    			    byteArray =buffer.toString().getBytes();
//	                    			    bos.write(byteArray, 0, byteArray.length);
//	                    			    bos.flush();
//	                    			    bos.close();
//	                    			    client.close();
//	                    			}
//
//	                    			catch (UnknownHostException e1) 
//	                    			{
//
//	                    			e1.printStackTrace();
//	                    			}
//	                    			catch (IOException e1) 
//	                    			{
//	                    			}
//
//	                    			finally 
//	                    			{}
//	                   
//					
//				}
//			} catch (IOException e) {
//			} finally {
//			}
//			
//
//		}
//
//	}
//
//	
//	
//	public static void main(String args[])
//	{
//		new Router();
//	}
//}
//	
//	
//	
//
//		
//
//
