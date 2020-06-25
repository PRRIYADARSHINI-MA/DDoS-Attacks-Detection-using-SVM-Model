package firecol;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;




public class Proxybasedsigfree implements ActionListener
{		
	static final int MY_MINIMUM = 0;

	static final int MY_MAXIMUM = 100;
	String dd;
	String txtstr=null,threatname,threatcount,filesend,realdata;
    String strLine;
	public JLabel T1a= new JLabel("Detection Of DDOS Attacks");
	public JLabel T1b= new JLabel("");
	public Font f = new Font("Times new roman" , Font.BOLD , 22);	
	public Font f1 = new Font("Times new roman", Font.BOLD , 15);
	public Font f2 = new Font("Times new roman", Font.BOLD , 17);
	public Font f3 = new Font("Times new roman", Font.BOLD , 18);
	public JLabel T0= new JLabel("");
	public JLabel T1= new JLabel("Destination IP:");
	public JLabel T2= new JLabel("Source Path of The File");
	
	public JLabel T4= new JLabel();
	
	
	public Font l3 = new Font("Times New roman" , Font.BOLD , 14);
	public JLabel rip= new JLabel("Router IP:");
	
	public JTextField riptxt=new JTextField();
	
	public JTextArea tf = new JTextArea();
	public JScrollPane pane = new JScrollPane();
	public JTextArea tf1 = new JTextArea();
	public JScrollPane pane1 = new JScrollPane();
	public JButton btn1 = new JButton("Open");
	public JButton btn2 = new JButton("Send");

	public JTextField txt=new JTextField();
	public JTextField txt1=new JTextField();
	public JTextField txt2=new JTextField();
	
	
	public JLabel  leftButton;
	public JLabel  rightButton;
	public JLabel  proxyques;
	public JComboBox jcombo1;
	public JLabel line;
	public JLabel line1;
	public JFrame jf;
	public Container c;
	String event;
	public JLabel sys=new JLabel();
	public JLabel scan = new JLabel("Detecting Attack:");
	JLabel scn= new JLabel();char[] temp;
	public JProgressBar jpb;StringBuffer  buffer;int desip; int filnamelen;String filename;String st="";String t,nw;
	Proxybasedsigfree()
	{	
		ImageIcon redsys=new ImageIcon(this.getClass().getResource("green.jpg"));
		sys.setIcon(redsys);
		sys.setBounds(-5,-80,900,870);
				
		
		jf = new JFrame("Honeypot Based Sigfree");
		c = jf.getContentPane();
		c.setLayout(null);
		jf.setSize(800, 750);
		jf.setLocation(120, -3);
		 jf.setResizable(false);  
		c.setBackground(new Color(0,0,196));
		T1a.setBounds(70, 5, 650,45);
		T1a.setFont(f);
		T1a.setForeground(Color.WHITE);
		T1b.setBounds(125, 40, 450,45);
		T1b.setFont(f); 
		T1b.setForeground(Color.black);
		
		
		
		Border lineBorder = BorderFactory.createLineBorder(new Color(196,223,220));
		line = new JLabel();
		line.setBorder(lineBorder);
		line.setBounds(70,140,630,100);
		

		TitledBorder leftBorder = BorderFactory.createTitledBorder("Original File Details");
	    leftBorder.setTitleJustification(TitledBorder.LEFT);
	    leftButton = new JLabel();
	    leftButton.setBorder(leftBorder);
	    leftButton.setBounds(70,300,300,250);
	    leftBorder.setTitleColor(Color.white);
	    leftButton.setForeground(Color.black);
	   
	    
	    TitledBorder rightBorder = BorderFactory.createTitledBorder("DDoS Attack File Details");
	    rightBorder.setTitleJustification(TitledBorder.LEFT);
	    rightButton = new JLabel();
	    rightButton.setBorder(rightBorder);
	    rightButton.setBounds(400,300,300,250);
	    rightBorder.setTitleColor(Color.white);
	    rightButton.setForeground(Color.white);
	    
	    
		jpb = new JProgressBar(0, 2000);
		jpb.setBounds(290, 160, 300,28);
		jpb.setValue(0);
		jpb.setFont(l3);
		jpb.setStringPainted(true);
		jpb.setForeground(new Color(120,0,0));
	    
		jpb.setMinimum(MY_MINIMUM);
		jpb.setMaximum(MY_MAXIMUM);
		    
		    
	    TitledBorder leftBorder1 = BorderFactory.createTitledBorder("Proxy Question");
	    leftBorder.setTitleJustification(TitledBorder.LEFT);
	    proxyques = new JLabel();
	    proxyques.setBorder(leftBorder1);
	  
	    proxyques.setBounds(70,520,500,180);
	    
	    
	    leftBorder1.setTitleColor(Color.black);
	   
	    rip.setBounds(125, 180, 250,45);
	    rip.setForeground(Color.black);
	    riptxt.setBounds(260, 190, 180,25);
	    riptxt.setFont(f2);
	    riptxt.setForeground(Color.BLUE);
		T0.setBounds(250,60,350,45);
	    T0.setFont(f);
	   
	    T0.setForeground(Color.white);
		T2.setBounds(185, 290, 250,45);
		T2.setFont(f2);
		T2.setForeground(Color.black);
		
		
		txt1.setBounds(105, 340, 330,25);
	    txt1.setFont(f1);
	  
		T4.setBounds(225, 540, 250,45);
		T4.setFont(f2);
		T4.setForeground(Color.RED);
		
	
		txt2.setBounds(220, 575, 250,30);
		txt2.setForeground(Color.BLUE);
	    txt2.setFont(f1);
	
		
		btn1.setBounds(480,340,120,30);
		btn1.setFont(f1);
		btn1.setForeground(Color.black);
		btn2.setBounds(480,570,120,30);
		btn2.setFont(f1);
		btn2.setForeground(Color.black);
		
		
		scan.setBounds(120,150,300,50);
		scan.setFont(l3);
		scan.setForeground(Color.white);
		
		scn.setBounds(300,180,300,50);
		scn.setFont(l3);
		scn.setForeground(Color.GREEN);
		
		T1.setForeground(Color.black);
		T1.setBounds(120,140,250,45);
		txt.setBounds(260,150,180,25);
		txt.setForeground(Color.BLUE);
		txt.setFont(f1);
		
		
		tf.setColumns(20);
		tf.setForeground(new Color(0,101,68));
		tf.setFont(f1);
		tf.setRows(10);
		tf.setName("tf");
		pane.setName("pane");
		pane.setViewportView(tf);
		pane.setBounds(100, 355, 240, 150);
		
		
		tf1.setColumns(20);
		tf1.setForeground(new Color(0,101,68));
		tf1.setFont(f1);
		tf1.setRows(10);
		tf1.setName("tf");
		pane1.setName("pane");
		pane1.setViewportView(tf1);
		pane1.setBounds(430, 355, 240, 150);
		
		
		btn1.addActionListener(this);
		
		btn2.addActionListener(this);
		btn1.setMnemonic(KeyEvent.VK_B);
		
		 txt2.setEnabled(false);
		
		    
		jf.show();
	
		c.add(T1a);
		c.add(T1b);
	 
	 	c.add(line);
		c.add(scn);
	 	c.add(scan);
	 	c.add(jpb);
		c.add(T4);
		
		c.add(pane, BorderLayout.CENTER);
		c.add(pane1, BorderLayout.CENTER);
		
		c.add(T0);
		c.add(leftButton);		
		c.add(rightButton);
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent win) {
				System.exit(0);
			}
		});
		
		int[] ports = new int[] { 2000 };

		for (int i = 0; i < 1; i++) {
			Thread t = new Thread(new PortListener(ports[i]));
			t.setName("Listener-" + ports[i]);
			t.start();

		}
		
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
					
					String strLine1;
				
				  buffer = new StringBuffer();
					
					while ((strLine1 = br.readLine()) != null) {
						
						buffer.append(strLine1 + "\n");
						
					}
					br.close();
					connection.close();
					
					  threatname="";
					  threatcount="";filesend="";
					  tf.setText(" ");tf1.setText(" ");
					  strLine="";st="";
					  String deip=buffer.substring(0,2);
					  desip=Integer.parseInt(deip);
					  String desstr=buffer.substring(2,2+desip-10);
					  String orifile=buffer.substring(2+desip-10,buffer.length());
					  String filnam=orifile.substring(0,2);
					  filnamelen=Integer.parseInt(filnam);
					  filename=orifile.substring(2,2+filnamelen-10);
					  String origifl=orifile.substring(2+filnamelen-10,orifile.trim().length());
					 
					scanprogress(origifl,desstr,filename);
					
				}
			} catch (IOException e) {
			} finally {
			}
			

		}

	}
	void scanprogress(String file,String deip,String fname){
		
        scn.setForeground(Color.GREEN);
		scn.setText("Worm Detecting....................................");
		
		scanobject(file);
	    for (int i = MY_MINIMUM; i <= MY_MAXIMUM; i++) {
	      final int percent = i;
	      try {
	        SwingUtilities.invokeLater(new Runnable() {
	          public void run() {
	        	  jpb.setValue(percent);
	          }
	        });
	        java.lang.Thread.sleep(100);
	      } catch (InterruptedException e) {
	        ;
	      }
	    }
	    scn.setForeground(Color.RED);
                if(!threatname.equals("No Threat"))
                {
                   scn.setText("Malicious Attack Detected.");
                   tf1.setText("File Scanning Completed."+"\n"+threatcount+"\n"+"Threat name="+threatname+".");
		tf.setText("File Scanning Completed."+"\n File Name="+filename+"."+"\n File Length="+Integer.toString(filesend.trim().length())+".");
                int flen=fname.length()+10;
		String ftotlen=Integer.toString(flen);
		String tot=ftotlen+fname+filesend;
		realdatesend(tot,deip);
                }
		
                else

                {
                    scn.setText("Worm not Detected.");
		tf1.setText("File Scanning Completed."+"\n"+threatcount+"\n"+"Threat name="+threatname+".");
		tf.setText("File Scanning Completed."+"\n File Name="+filename+"."+"\n File Length="+Integer.toString(filesend.trim().length())+".");
		int flen=fname.length()+10;
		String ftotlen=Integer.toString(flen);
		String tot=ftotlen+fname+filesend;
		realdatesend(tot,deip);
                
            }
            if(threatname.equals("setup.exe"))
                {try{
                                   Thread.sleep(2000);
                             }
                                   catch(Exception le){}
                   Threadsetup object1= new  Threadsetup();
                         object1.getTime(object1);
                }
 else if(threatname.equals("love.exe"))
            {
     try{
                                   Thread.sleep(2000);
                             }
                                   catch(Exception le){}
     Threadlove obj1=new Threadlove();
                        obj1.getTime(obj1);
 }
 else if(threatname.equals("malv.exe"))
            {
     try{
                                   Thread.sleep(2000);
                             }
                                   catch(Exception me){}
			Threadmalv obj2 =new Threadmalv();
                        obj2.getTime(obj2);
 }
	}
	
	void scanobject(String bufferfile){
		if(bufferfile!=null){
					
		 temp=bufferfile.toString().toCharArray();
		
		for(int i=0;i<=temp.length-1;i++){
		
		if(temp[i]=='1'){
			if(strLine==null)
			{
				strLine =Integer.toString(temp[i]);
			}else
			{
			strLine+=temp[i];
			int hash=strLine.hashCode();
			
			if(hash==366063909||hash==1395661191||hash==913746725){
				
				break;
			}
			
			}
		}else if(temp[i]=='0')
		{
			if(strLine==null)
			{
				strLine =Integer.toString(temp[i]);
			}else
			{
			strLine+=temp[i];
			int hash=strLine.hashCode();
         if(hash==366063909||hash==1395661191||hash==913746725){
        	
        	 break;
			}
			}
		}
		else{
			
			break;
			
		}
			
		}
		
		
		if(strLine.isEmpty())
                {
			
				threatname="No Threat";
				threatcount="No Threat found.";
				filesend=buffer.substring((2+filnamelen-10)+(2+desip-10),buffer.length());
			
		}else{
		
		 st=strLine.trim();
		 
			
		 
		if(st.trim().equals("1011000111110010010101010101"))
		{
			threatname="setup.exe";
			threatcount="One Threat found.";
			filesend=buffer.substring((2+filnamelen-10)+(2+desip-10)+st.trim().length(),buffer.length());
//                        try{
//                                   Thread.sleep(5000);
//                             }
//                                   catch(Exception se){}
//                         Threadsetup object1= new  Threadsetup();
//                        object1.getTime(object1);
//                         object1.setVisible(true);
			
		}else if(st.trim().equals("01001011000111110010010101010101010000011111100000"))
		{
			
			threatname="love.exe";
			threatcount="One Threat found.";
                        
			filesend=buffer.substring((2+filnamelen-10)+(2+desip-10)+st.trim().length(),buffer.length());
//                        Threadlove obj1=new Threadlove();
//                        obj1.getTime(obj1);
//                        obj1.setVisible(true);
			
		}else if(st.trim().equals("001011000111110010010101010101"))
		{
			threatname="malv.exe";
			threatcount="One Threat found.";
			filesend=buffer.substring((2+filnamelen-10)+(2+desip-10)+st.trim().length(),buffer.length());
//                        try{
//                                   Thread.sleep(5000);
//                             }
//                                   catch(Exception me){}
//			Threadmalv obj2 =new Threadmalv();
//                        obj2.getTime(obj2);
//                        obj2.setVisible(true);
		}
		else
		{
			threatname="No Threat";
			threatcount="No Threat found.";
			filesend=buffer.substring((2+filnamelen-10)+(2+desip-10),buffer.length());
		}
		
		
		}
		
			}
	}
void realdatesend(String file,String deip){
	

	  
    byte[] byteArray;
    Socket client = null;
	 BufferedOutputStream bos = null;

	
	 try     { 
       	/********************RouterB IP Address****************/
       			    client = new Socket(deip, 3000);
       			    bos = new BufferedOutputStream(client.getOutputStream()); 
       			      
       			    
       			    byteArray =file.toString().getBytes();
       			    bos.write(byteArray, 0, byteArray.length);
       			    bos.flush();
       			    bos.close();
       			    client.close();
       			}

       			catch (UnknownHostException e1) 
       			{

       			e1.printStackTrace();
       			}
       			catch (IOException e1) 
       			{
       			}

       			finally 
       			{}
      
	
	
	

	
}
		public void actionPerformed(ActionEvent e)
		 {
			
		 }
				   
	
	public static void main(String args[])
	{
		new Proxybasedsigfree();
	}
}
	
	
	

		


