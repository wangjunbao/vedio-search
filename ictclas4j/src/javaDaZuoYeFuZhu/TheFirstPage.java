package javaDaZuoYeFuZhu;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
//��½�����һҳ

//���û�û��������Ϣ�����ˡ�ȷ����Ҳ�������ã�������ʾ���������� ����Ϣ����

public class TheFirstPage extends Frame  implements ActionListener{
	

	Label lab1=new Label("��������չ�����Ĳι�ϵͳ");
	Label lab2=new Label("������������Ϣ��");
	
	Label lab3=new Label("����(��ʹ��Ӣ������ƴ��)��");
	Label lab4=new Label("�Ա���A��ŮB����");
	Label lab5=new Label("���䣺");
	Label lab6=new Label("ְҵ����ʹ��Ӣ������ƴ������");
	Button but1=new Button("ȷ��");
	
	Button but2=new Button("�˳�");
	
	TextField tf3=new TextField();
	TextField tf4=new TextField();
	TextField tf5=new TextField();
	TextField tf6=new TextField();
	
	
	
	public TheFirstPage(){
		
		setSize(400,500);
		setLayout(null);
		add(lab1);
		add(lab2);
		add(lab3);
		add(lab4);
		add(lab5);
		add(lab6);
		
		add(but1);
		add(but2);
		
		add(tf3);
		add(tf4);
		add(tf5);
		add(tf6);
		
		lab1.setBounds(100,30,200,20);
		lab2.setBounds(120,80,200,20);
		lab3.setBounds(30,130,200,20);
		lab4.setBounds(30,180,200,20);
		lab5.setBounds(30,230,200,20);
		lab6.setBounds(30,280,200,20);
		
		tf3.setBounds(250,130,90,20);
		tf4.setBounds(250,180,90,20);
		tf5.setBounds(250,230,90,20);
		tf6.setBounds(250,280,90,20);
		
		but1.setBounds(100,330,100,20);
		but2.setBounds(100,380,100,20);
		
		
		but1.addActionListener(this);
		but2.addActionListener(this);
		
		tf3.addActionListener(this);
		show();
		
		addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                e.getWindow().dispose();}});
		
	}
		
		//������������÷�ʵ��ȷ�� "�����Ĺ���
		
		
	
	public static void main(String args[]) throws Exception{
		
		System.out.println();
		System.out.println("****************************************************************************************");
		System.out.println("****************************************************************************************");
		System.out.println("����Ա���鿴��̨���ݣ���鿴���±����F���ļ�TheInfomationOfTheVistors������������Ϣ�ļ���");
		System.out.println("****************************************************************************************");
		System.out.println("****************************************************************************************");
		new TheFirstPage();
		
		ReadFile.infor();
		ReadFile.sex();
		ReadFile.nation();
		
	
		
	
	}

	public void actionPerformed(ActionEvent e){
		BuildANewFileFolder.newFileFolder();
		new AddMoreInformationToFile();
		
		File f=new File("f:\\TheInfomationOfTheVistors\\login.txt");

	  BufferedWriter out=null;
	  try
	  {
	   if (!f.exists())
	   {
	    f.createNewFile();//���out.txt�����ڣ��򴴽�һ�����ļ�
	   }
	   out = new BufferedWriter(new FileWriter(f,true));//����true��ʾ�����׷�ӵ��ļ����ݵ�ĩβ��������ԭ��������
	   //out.newLine(); //����
	  
//***********************************************
//	   ���ı��������д���ļ��С�
	   //System.out.println(str);
//	   out.flush();
//	   out.write("����    �Ա�    ����   ְҵ");
	   out.newLine();
	   out.write(tf3.getText());
	   out.newLine();
	   out.write(tf4.getText());
	   out.newLine();
	   out.write(tf5.getText());
	   out.newLine();
	   out.write(tf6.getText());
	   
	   //out.newLine();
	   out.close();
//****************************************************************8
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
	  
	  try{
			RandomAccessFile myfile;
			String s1=tf3.getText();
			String s="\t\t";
			String s2=tf4.getText();
		
			String s3=tf5.getText();
		
			String s4=tf6.getText();
		
			  
			myfile=new RandomAccessFile("f:\\TheInfomationOfTheVistors\\totalInformation.txt","rw");
			
			myfile.seek(myfile.length());
			myfile.writeBytes(s1+s+s2+s+s3+s+s4+s);
			myfile.close();
			}catch(IOException er){
				System.out.println("Error!");
			}


		if(e.getSource()==but1){
			BuildNewWindows bNewWin=new  BuildNewWindows();
			bNewWin.setSize(400,400);
			pack();
		}
		
		if(e.getSource()==but2){
			this.dispose();
		}
	}


		
}
	

 
