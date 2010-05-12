package javaDaZuoYeFuZhu;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.*;

public class BuildNewWindows extends Frame implements ActionListener{
		Label lab1=new Label("��ӭ�ι۱�������չ������");
		Label lab2=new Label("��ѡ��ι۷�ʽ��");
		
		Button but1=new Button("�����ҷ���ι�");
		Button but2=new Button("����Ʒ����ι�");
		
		JFrame frame=new JFrame("��������չ������ȫ��");
		JPanel JPimage=new JPanel();
		ImageIcon gx1=new ImageIcon("gz2.jpg");
		ImageIcon gx2=new ImageIcon("gz1.jpg");
		JLabel JLgx1=new JLabel(gx1);
		JLabel JLgx2=new JLabel(gx2);
		
		
		
		
		
	
		public BuildNewWindows(){
			

			lab1.setBounds(50,100,300,20);
			lab2.setBounds(50,130,300,20);
			
			but1.setBounds(70,180,100,20);
			but2.setBounds(70,210,100,20);
			
//			JPimage.setBounds(10,10,100,100);
//			add(JPimage);
			
			JPimage.add(JLgx1);
			JPimage.add(JLgx2);
			frame.add(JPimage);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(300,300);
			frame.setVisible(true);
			frame.add(lab1);
			frame.add(lab2);
		
			frame.add(but1);
			frame.add(but2);
			
			
			
			but1.addActionListener(this);
			but2.addActionListener(this);
			
//			tf3.addActionListener(this);
			
			//load pictures
			
			
//			show();
			addWindowListener(new WindowAdapter(){
	            public void windowClosing(WindowEvent e){
	                e.getWindow().dispose();}});
		}

		
		
		public static void main(String args[]){
			new BuildNewWindows();
			
		}
		
		
		
		public void actionPerformed(ActionEvent e) 
		{

//*********************************************************
			BuildANewFileFolder t1=new BuildANewFileFolder();
			t1.newFileFolder();
			new AddMoreInformationToFile();
					
			File f=new File("f:\\TheInfomationOfTheVistors\\VisitStyle.txt");
			BufferedWriter out=null;
			try{
				   if (!f.exists())
				   {
				    f.createNewFile();//���out.txt�����ڣ��򴴽�һ�����ļ�
				   }
				   out = new BufferedWriter(new FileWriter(f,true));//����true��ʾ�����׷�ӵ��ļ����ݵ�ĩβ��������ԭ��������
				   //out.newLine(); //����
				  
			//***********************************************
//				   ���ı��������д���ļ��С�
//				   out.newLine();
				
				  
					if(e.getSource()==but1){
						WindowsNations nation=new  WindowsNations();
						nation.setSize(400,400);
						pack();
						out.write("Nations");
						out.newLine();
						//   out.write(tf6.getText());
					}
					
					if(e.getSource()==but2){
						WindowsThings thing=new WindowsThings();
						thing.setSize(400,400);
						pack();
						out.write("Things");
						out.newLine();
					//	this.dispose();
					}
					 out.close();
			  }
			  catch (IOException ef)
			  {
			   ef.printStackTrace();
			  }
			  finally {
			   try
			   {
			    if (out!=null)
			    {
			     out.close();
			    }
			   }
			   catch (IOException ef)
			   {
			    ef.printStackTrace();
			   }
			  }
				
		
//***************************************************************************8
		try{
			RandomAccessFile myfile;
			myfile=new RandomAccessFile("f:\\TheInfomationOfTheVistors\\totalInformation.txt","rw");
			
			myfile.seek(myfile.length());
			if(e.getSource()==but1){
				myfile.writeBytes("Nations		");
				System.out.print("Nations  ����ι۷�ʽ�ǰ����ҷ���ι�");
				
			}
			
			if(e.getSource()==but2){
				myfile.writeBytes("Things		");
				System.out.print("Things  ����ι۷�ʽ�ǰ���Ʒ����ι�");
			}
			myfile.close();
			}catch(IOException er){
				System.out.println("Error!");
			}
		
				
			
//			if(e.getSource()==but2){
//				WindowsThings NWN2=new  WindowsThings();
//				NWN2.setSize(400,400);
//				pack();
//			}
		
}

}		
				
			
		
		
		

