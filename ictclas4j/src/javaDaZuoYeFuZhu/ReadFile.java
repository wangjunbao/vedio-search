package javaDaZuoYeFuZhu;
import java.io.*; 
public class ReadFile {
	public static void main(String args[])throws Exception{
		ReadFile.sex();
		ReadFile.infor();
		ReadFile.nation();
		
	}

public static void sex() throws Exception{
		BufferedReader readStream=new BufferedReader(new  FileReader("F:\\TheInfomationOfTheVistors\\login.txt"));
		int  nMan=0;
		int  nWoman=0;
		String age1;
		while((age1=readStream.readLine())!=null){
			if(age1.equals("A")){
				nMan++;
			}
			if(age1.equals("B")){
				nWoman++;
			}	
		}
		System.out.println("�ι���������ռ��������Ϊ��"+nMan*100/(nMan+nWoman)+"%");
		System.out.println("�ι�����Ů��ռ��������Ϊ��"+nWoman*100/(nMan+nWoman)+"%");
		
		if(nMan/nWoman>=3){
			System.out.println("�˴�չƷ�Ƚ���Ů��ϲ�����ɽ���Ʒ����Ҫ�����߶�ΪŮ��");
			
		}
		else if(nWoman/nMan>=3){
			System.out.println("�˴�չƷ�Ƚ�������ϲ�����ɽ���Ʒ����Ҫ�����߶�Ϊ����");
		}
		System.out.println("*************************************************************************************");
		
}	
	
public static void infor() throws Exception{
		BufferedReader readStream=new BufferedReader(new  FileReader("F:\\TheInfomationOfTheVistors\\VisitStyle.txt"));
		int  NumNations=0;
		int  NumThings=0;
		String inVisitStyle;
		while((inVisitStyle=readStream.readLine())!=null){
			if(inVisitStyle.equals("Nations")){
				NumNations++;
			}
			if(inVisitStyle.equals("Things")){
				NumThings++;
			}	
		}
		System.out.println("ѡ�񰴹��ҷ��෽ʽ�ι۵�����ռ��������Ϊ��"+NumNations*100/(NumNations+NumThings)+"%");
		System.out.println("ѡ����Ʒ����ι۵�����ռ��������Ϊ��"+NumThings*100/(NumNations+NumThings)+"%");
		
		if(NumNations/NumThings>=3){
			System.out.println("��������չ������Ӧ��ѡ���Թ��ҷ��෽ʽ����չƷ�Ϻã�\t��Ϊ�����ϴ�����˵���Ը");
			
		}
		else if(NumThings/NumNations>=3){
			System.out.println("��������չ������Ӧ��ѡ������Ʒ���෽ʽ����չƷ�Ϻã�\t��Ϊ�����ϴ�����˵���Ը");
		}
		System.out.println("*************************************************************************************");

	}
	
	






public static void nation() throws Exception{
	BufferedReader readStream=new BufferedReader(new  FileReader("F:\\TheInfomationOfTheVistors\\Nations.txt"));
	int nc=0;
	int nu=0;
	int ng=0;
	int nf=0;
	int na=0;
	int nh=0;
	int nca=0;
	int ni=0;
	int nb=0;
	int nj=0;
	
	String inVisitStyle;
	while((inVisitStyle=readStream.readLine())!=null){
		if(inVisitStyle.equals("China")){
			na++;
		}
		if(inVisitStyle.equals("USA")){
			nu++;
		}
		
		if(inVisitStyle.equals("Japan")){
			nj++;
		}
		if(inVisitStyle.equals("France")){
			nf++;
		}
		if(inVisitStyle.equals("Australia")){
			na++;
		}
		if(inVisitStyle.equals("German")){
			ng++;
		}
		if(inVisitStyle.equals("Candan")){
			nca++;
		}
		if(inVisitStyle.equals("Holand")){
			nh++;
		}
		if(inVisitStyle.equals("Belgium")){
			nb++;
		}
		if(inVisitStyle.equals("Italy")){
			ni++;
		}
		
		
	}
	System.out.println("�ι����е��й���ռ�ι۵�����ռ��������Ϊ��"+nc*100/(nc+na+nu+ni+nf+ng+nj+nca+nh+nb)+"%");
	System.out.println("�ι����е�������ռ�ι۵�����ռ��������Ϊ��"+nu*100/(nc+na+nu+ni+nf+ng+nj+nca+nh+nb)+"%");
	System.out.println("�ι����е��ձ�����ռ�ι۵�����ռ��������Ϊ��"+nj*100/(nc+na+nu+ni+nf+ng+nj+nca+nh+nb)+"%");
	System.out.println("�ι����еķ�����ռ�ι۵�����ռ��������Ϊ��"+nf*100/(nc+na+nu+ni+nf+ng+nj+nca+nh+nb)+"%");
	System.out.println("�ι����еĵ¹���ռ�ι۵�����ռ��������Ϊ��"+ng*100/(nc+na+nu+ni+nf+ng+nj+nca+nh+nb)+"%");
	System.out.println("�ι����еĺ�������ռ�ι۵�����ռ��������Ϊ��"+nh*100/(nc+na+nu+ni+nf+ng+nj+nca+nh+nb)+"%");
	System.out.println("�ι����еİĴ����ǹ���ռ�ι۵�����ռ��������Ϊ��"+na*100/(nc+na+nu+ni+nf+ng+nj+nca+nh+nb)+"%");
	System.out.println("�ι����е��������ռ�ι۵�����ռ��������Ϊ��"+ni*100/(nc+na+nu+ni+nf+ng+nj+nca+nh+nb)+"%");
	System.out.println("�ι����еļ��ô���ռ�ι۵�����ռ��������Ϊ��"+nca*100/(nc+na+nu+ni+nf+ng+nj+nca+nh+nb)+"%");
	System.out.println("�ι����еı���ʱ��ռ�ι۵�����ռ��������Ϊ��"+nb*100/(nc+na+nu+ni+nf+ng+nj+nca+nh+nb)+"%");

		

	System.out.println("*************************************************************************************");

}



}
