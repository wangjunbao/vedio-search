package javaDaZuoYeFuZhu;

//����ַ�����һ���ļ���������ԭ�ļ������ݣ�׷�ӣ�
import java.io.*;
class AddMoreInformationToFile 
{
//	AddMoreInformationToFile amitf=new AddMoreInformationToFile();
 public static void main(String[] args) 
 {
	 AddMoreInformationToFile.dataToFile();
 }
 
 static void dataToFile(){
	 File f=new File("f:\\TheInfomationOfTheVistors\\login.txt");
	  BufferedWriter out=null;
	  try
	  {
	   if (!f.exists())
	   {
	    f.createNewFile();//���out.txt�����ڣ��򴴽�һ�����ļ�
	   }
	   out = new BufferedWriter(new FileWriter(f,true));//����true��ʾ�����׷�ӵ��ļ����ݵ�ĩβ��������ԭ��������
	   out.newLine(); //����
	   out.write("���ǵ�һ��");
	   out.newLine(); //����
	   out.write("���ǵڶ���");
	   out.newLine();
	  }
	  catch (IOException e)
	  {
	   e.printStackTrace();
	  }
	  finally {
	   try
	   {
	    if (out!=null)
	    {
	     out.close();
	    }
	   }
	   catch (IOException e)
	   {
	    e.printStackTrace();
	   }
	  }
 }
}

