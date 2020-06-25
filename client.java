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
//import java.io.FileNotFoundException;
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
//public class client implements ActionListener
//{		
//	
//	String dd,conn="",path=null,filesend;
//	String txtstr=null;
//
//	public JLabel T1a= new JLabel(" Intrusion Detection System Attack Blocker");
//	public JLabel T1b= new JLabel("");
//	public Font f = new Font("Times new roman" , Font.BOLD , 22);	
//	public Font f1 = new Font("Times new roman", Font.BOLD , 15);
//	public Font f2 = new Font("Times new roman", Font.BOLD , 17);
//	public Font f3 = new Font("Times new roman", Font.BOLD , 18);
//	public JLabel T0= new JLabel("Client");
//	public JLabel T1= new JLabel("Destination IP:");
//	public JLabel T2= new JLabel("Source Path of The File");
//	
//	public JLabel T4= new JLabel();
//	
//	public Font l3 = new Font("Times New roman" , Font.BOLD , 14);
//	public JLabel rip= new JLabel("Router IP:");
//	public JLabel worm= new JLabel("Select The Worm:");
//	public JTextField riptxt=new JTextField("");
//	public String[] jcmb={"No Virus","setup.exe","love.exe","malv.exe"};
//	public JCheckBox chk1=new JCheckBox("");
//	public JComboBox TAreu = new JComboBox();	
//	public JButton btn = new JButton("Connect");
//	public JTextArea tf = new JTextArea();
//	public JScrollPane pane = new JScrollPane();
//	public JButton btn1 = new JButton("Open");
//	public JButton btn2 = new JButton("Send");
//
//	public JTextField txt=new JTextField("");
//	public JTextField txt1=new JTextField("");
//	public JTextField txt2=new JTextField("txt2");
//	
//	public  JLabel tfld=new JLabel();
//	JPanel jp=new JPanel();
//	JPanel jp1=new JPanel();
//	public JLabel  leftButton;
//	public JLabel  proxyques;
//	public JComboBox jcombo1;
//	public JLabel line;
//	public JLabel line1;
//	public JFrame jf;
//	public Container c;
//	String event;
//	public  JLabel orifilelen=new JLabel("Original File Length(bits):");
//	public JTextField orifle=new JTextField("");String vrf;
//	client()
//	{	
//		
//		
//		
//		
//		jf = new JFrame("Client");
//		c = jf.getContentPane();
//		c.setLayout(null);
//		jf.setSize(740, 750);
//		jf.setLocation(120, -3);
//		 jf.setResizable(false);  
//		c.setBackground(new Color(92,188,104));
//		T1a.setBounds(85, 5, 650,45);
//		T1a.setFont(f);
//		T1a.setForeground(Color.black);
//		T1b.setBounds(165, 40, 450,45);
//		T1b.setFont(f);
//		T1b.setForeground(Color.black);
//		Border lineBorder = BorderFactory.createLineBorder(new Color(196,223,220));
//		line = new JLabel();
//		line.setBorder(lineBorder);
//		line.setBounds(70,140,590,100);
//		TitledBorder leftBorder = BorderFactory.createTitledBorder("File Transmit");
//	    leftBorder.setTitleJustification(TitledBorder.LEFT);
//	    leftButton = new JLabel();
//	    leftButton.setBorder(leftBorder);
//	   
//	    leftButton.setBounds(70,270,590,380);
//	    leftBorder.setTitleColor(Color.black);
//	    leftButton.setForeground(Color.black);
//	      
//	   
//	    rip.setBounds(125, 180, 250,45);
//	  
//	    rip.setForeground(Color.black);
//	    riptxt.setBounds(260, 190, 180,25);
//	    riptxt.setFont(f2);
//	    riptxt.setForeground(Color.BLUE);
//		T0.setBounds(310,60,350,45);
//	    T0.setFont(f);
//	   
//	    T0.setForeground(Color.black);
//		T2.setBounds(185, 290, 250,45);
//		T2.setFont(f2);
//		T2.setForeground(Color.black);
//		jcombo1=new JComboBox(jcmb);
//		jcombo1.setBounds(260, 590, 130,28);
//		jcombo1.setFont(l3);
//		jcombo1.setForeground(Color.black);
//		worm.setBounds(100, 590, 130,28);
//		
//		worm.setForeground(Color.black);
//		
//		orifilelen.setBounds(100, 555, 180,28);
//		
//		orifilelen.setForeground(Color.black);
//		
//		
//		orifle.setBounds(260, 555, 130,28);
//		orifle.setFont(l3);
//		orifle.setForeground(Color.black);
//		
//		txt1.setBounds(105, 340, 330,25);
//	    txt1.setFont(f1);
//	  
//		
//	
//		T4.setBounds(225, 540, 250,45);
//		T4.setFont(f2);
//		T4.setForeground(Color.RED);
//		
//	
//		txt2.setBounds(220, 575, 250,30);
//		txt2.setForeground(Color.BLUE);
//	    txt2.setFont(f1);
//	
//		btn.setBounds(480,180,120,30);
//		btn.setFont(f1);
//		btn.setForeground(Color.black);
//		btn1.setBounds(480,340,120,30);
//		btn1.setFont(f1);
//		btn1.setForeground(Color.black);
//		btn2.setBounds(480,570,120,30);
//		btn2.setFont(f1);
//		btn2.setForeground(Color.black);
//		
//		jp.setBounds(85,110,850,550);
//		jp.setBackground(new Color(211,217,184));
//		
//		jp1.setBounds(80,105,860,560);
//		
//		T1.setForeground(Color.black);
//		T1.setBounds(120,140,250,45);
//		txt.setBounds(260,150,180,25);
//		txt.setForeground(Color.BLUE);
//		txt.setFont(f1);
//		TAreu.setBounds(650,550,360,35);
//		
//		TAreu.addItem("Mesh Route");
//		TAreu.addItem(" Node ");
//		TAreu.setFont(f3);
//	
//		TAreu.setForeground(Color.BLUE);
//		TAreu.setFont(f);
//		pane.setBounds(105, 390, 330, 150);
//		
//		tf.setColumns(20);
//		
//		tf.setForeground(Color.MAGENTA);
//		tf.setFont(f1);
//		tf.setRows(10);
//		tf.setName("tf");
//		pane.setName("pane");
//		pane.setViewportView(tf);
//		tfld.setBounds(410,160,200,30);
//		tfld.setFont(f2);
//		tfld.setForeground(new Color(120,0,0));
//		btn1.addActionListener(this);
//		btn.addActionListener(this);
//		btn2.addActionListener(this);
//		txt2.setEnabled(false);
//		
//		jf.show();
//		c.add(orifilelen);
//		c.add(orifle);
//		c.add(worm);
//		c.add(jcombo1);
//	 	c.add(rip);
//	 	c.add(riptxt);
//		c.add(T1a);
//		c.add(T1b);
//	 	c.add(T1);
//	 	c.add(line);
//	 	c.add(txt);
//	 	c.add(txt1);
//	
//		c.add(btn);
//		c.add(btn2);
//		c.add(T2);
//	
//		c.add(T4);
//	
//		c.add(pane, BorderLayout.CENTER);
//		c.add(btn1);
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
//		int[] ports = new int[] { 8000 };
//
//		for (int i = 0; i < 1; i++) {
//			Thread t = new Thread(new PortListener(ports[i]));
//			t.setName("Listener-" + ports[i]);
//			t.start();
//
//		}
//		
//	}		
//	
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
//		public void run() {}
//
//	}
//
//		public void actionPerformed(ActionEvent e)
//		 {		
//		    
//		    	StringBuffer buffer = new StringBuffer();
//		    			    			 
//			    String strLine = null;
//			 
//			    if(e.getSource()== btn)
//				 {
//					conn="Connect";
//					 if(txt.getText().equals("")||riptxt.getText().equals(""))
//					 {
//						 JOptionPane.showMessageDialog(null,
//									"please, Give valid IPAddress!", "Message Box", 1);
//					 }
//					 	 else
//					 {
//					 		 JOptionPane.showMessageDialog(null,"Successfully connected IPAddress!!", "Message Box", 1);
//	 
//					 }
//				}
//			    
//			    
//			    if (e.getSource()== btn1)
//			    {
//			    	 if(conn.trim().equals("")){
//						 JOptionPane.showMessageDialog(null,
//									"please, Connect IPAddress!", "Message Box", 1);
//
//					 }else{
//					 JFileChooser chooser = new JFileChooser();
//			    			    
//			    try {
//			        
//			        File f = new File(new File("").getCanonicalPath());
//			      
//			        chooser.setSelectedFile(f);
//			        }      catch (IOException e1) {
//			        }
//			    		  
//			      chooser.showOpenDialog(btn1);
//			      int retval = chooser.showOpenDialog(btn1);
//                  if (retval == JFileChooser.APPROVE_OPTION){
//                  File field = chooser.getSelectedFile();
//                  txt1.setText(field.getAbsolutePath());
//                 }		    
//			    
//			            File curFile = chooser.getSelectedFile();
//			            
//			            String fname=curFile.getName();
//					    int len=fname.length()+10;
//					    String strlen=Integer.toString(len);
//					    dd=strlen+fname;
//					     
//			        try{
//				    
//				        FileInputStream fstream = new FileInputStream(curFile);
//				   
//				        DataInputStream ins = new DataInputStream(fstream);
//				        BufferedReader br = new BufferedReader(new InputStreamReader(ins));
//				 
//			    		
//				        
//				    while ((strLine = br.readLine()) != null)   {
//				     
//				        System.out.println (strLine);
//				        buffer.append(strLine+ "\n");
//				          
//				      
//				    }tf.setText("");
//				       tf.setText(buffer.toString());
//				       filesend=tf.getText().trim();
//				     
//				       orifle.setText(Integer.toString(Integer.parseInt(Integer.toString(tf.getText().trim().length()))));
//				      
//				    
//				    }catch (Exception e1){
//				      System.err.println("Error: " + e1.getMessage());
//				    }
//			    }
//			    }
//		
//			 if(e.getSource()== btn2)
//			 
//			 {
//				   orifle.setText(Integer.toString(Integer.parseInt(Integer.toString(tf.getText().trim().length()))));
//				    
//				 if(tf.getText().equals(""))
//				 {
//					 JOptionPane.showMessageDialog(null,
//								"please, Select the file and then send!", "Message Box", 1);
//
//				 }else{
//					        
//						String cmbType = (String) jcombo1.getSelectedItem();
////						String cmbType= JFileChooser.get();
//						
//						 if(cmbType.equals("setup.exe"))
//						 {
//							 
//						       path="F:/DS_sigfree/Virus Files/Virus Files/setup.exe";	 
//							 
//						 }
//						 else if(cmbType.equals("love.exe")){
//							 
//								path="F:/ProjectsDemo/Error/IDS_sigfree/Virus Files/Virus Files/love.exe";
//								
//						 }else if(cmbType.equals("malv.exe")){
//							 
//								path="F:/ProjectsDemo/Error/IDS_sigfree/Virus Files/Virus Files/malv.exe";
//															
//						 }else if(cmbType.equals("No Virus"))
//						 {
//							 path=null;
//							 
//						 }
//						 
//							if(path==null){
//								
//								 String desip=txt.getText().trim();
//								 String ripad=riptxt.getText().trim();
//								 int despadlen=desip.length()+10;
//								 String desipstr=Integer.toString(despadlen);
//								 String totip=desipstr+desip;
//								 String totfile=totip+dd+filesend;
//								 filesend(ripad,totfile);
//								
//								 
//							}else{
//						 try {
//							
//					        FileInputStream fstream = new FileInputStream(path);
//					   
//					        DataInputStream ins = new DataInputStream(fstream);
//					        BufferedReader br = new BufferedReader(new InputStreamReader(ins));
//					        StringBuffer buffer1 = new StringBuffer();
//					       
//					         try {
//						         	while ((strLine = br.readLine()) != null)   {
//							         buffer1.append(strLine+ "\n");
//		
//							      }
//						           } catch (IOException e1) {
//							
//							         e1.printStackTrace();
//						          }
//						           int fv=buffer1.length();
//						           filesend=tf.getText().trim();	
//						           vrf=dd+buffer1.toString().trim();
//								
//						    } catch (FileNotFoundException e1) {
//							
//							           e1.printStackTrace();
//						          }
//						 String desip=txt.getText().trim();
//						 String ripad=riptxt.getText().trim();
//						 int despadlen=desip.length()+10;
//						 String desipstr=Integer.toString(despadlen);
//						 String totip=desipstr+desip;
//						 String totfile=totip+vrf+filesend;
//						 
//						filesend(ripad,totfile);
//					
//					 
//				 }
//				 }
//				 
//				 
//			 }	
//	}
//				   
//			void filesend(String ip,String file){
//			  
//                 byte[] byteArray;
//                 Socket client = null;
//             	 BufferedOutputStream bos = null;
//                 
//				 try     { 
//                    	/********************RouterB IP Address****************/
//                    			    client = new Socket(ip, 1000);
//                    			    bos = new BufferedOutputStream(client.getOutputStream()); 
//                    			    byteArray =file.toString().getBytes();
//                    			    bos.write(byteArray, 0, byteArray.length);
//                    			    bos.flush();
//                    			    bos.close();
//                    			    client.close();
//                    			}
//
//                    			catch (UnknownHostException e1) 
//                    			{
//
//                    			e1.printStackTrace();
//                    			}
//                    			catch (IOException e1) 
//                    			{
//                    			}
//
//                    			finally 
//                    			{}
//                   
//				
//				
//				
//			}
//				 
//	
//
//	public static void main(String args[])
//	{
//		new client();
//	}
//}
//	
//	
//	
//
//		
//
//
