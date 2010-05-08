package keywords;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.ictclas4j.bean.SegResult;
import org.ictclas4j.segment.*;

public class GetKeywords {
	/*
	 * ���ڴ������塢��Ϊ�����������ݽṹ��
	 */
	KeywordStruct keyword[] = new KeywordStruct[3];

	/*
	 * ��ʼ��keyword
	 */
	public GetKeywords() {
		for (int i = 0; i < 3; i++) {
			keyword[i] = new KeywordStruct();
		}

	}

	/*
	 * �ִʵ����ս��,ֻ����ͬһ������á�
	 */
	private String wordSegResult = null;
	/*
	 * ɾ���˱����ź���ַ����顣 ���ң��Զ�ά����洢�ˡ� �� [][0]�� [][1]���� [][2]��ע�Ƿ�Ϊ���塢��Ϊ��������
	 */

	/*
	 * �˴���д�ɣ� new String[65535][] �ձ��� Exception in thread "main"
	 * java.lang.NullPointerException at
	 * keywords.GetKeywords.deleteSymbols(GetKeywords.java:117) at
	 * keywords.GetKeywords.main(GetKeywords.java:136)
	 * 
	 * 
	 * 117�� deletedSymbolResult[k][0]=temp[k].substring(0,temp[k].length()-1);
	 */
	private String deletedSymbolResult[][] = new String[65535][3];

	/*
	 * �ı��ĳ��ȡ�
	 */
	int length = 0;

	/*
	 * ���ڴ�����塢��Ϊ������ keywords[0][0]:�� keywords[0][1]:����-д���� keywords[0][2]:����
	 * 
	 * keywords[0][0]:�� keywords[0][1]:������-���� keywords[0][2]:
	 */

	public String keywords[][] = new String[3][128];

	// private String
	/*
	 * �õ��ִʵ����ս����
	 */

	public String getWordSegResult() {

		SegTag segTag = new SegTag(1);

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				try {
					SegResult seg_res = segTag.split(line);
					/*
					 * ��ȡ�ִʵ����ս����
					 */
					// key.wordSegResult=seg_res.getFinalResult();
					// System.out.println(seg_res.getFinalResult());
					wordSegResult = seg_res.getFinalResult();
					return wordSegResult;

				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return line;
	}

	/*
	 * ���˵������š� ���ң��ö�ά����洢 �ʺʹ��ԡ�
	 */
	public void deleteSymbols() {
		/*
		 * �Կո��з�
		 */
		String temp[] = new String[65535];
		/*
		 * ��б���з�
		 */
		// String slashSeg[]=new String[2];
		int j = 0;

		// GetKeywords key1=new GetKeywords();

		// Seperator type
		/*
		 * public static final String SEPERATOR_C_SENTENCE = "������������";
		 * 
		 * public static final String SEPERATOR_C_SUB_SENTENCE = "����������������";
		 * 
		 * public static final String SEPERATOR_E_SENTENCE = "!?:;";
		 * 
		 * public static final String SEPERATOR_E_SUB_SENTENCE = ",()\"'";
		 * 
		 * public static final String SEPERATOR_LINK = "\n\r ��";
		 */

		// System.out.println(wordSegResult);
		// String str1=getWordSegResult();
		// System.out.println(wordSegResult);
		String str1Array[] = wordSegResult.split("\\s");

		System.out.println("�Կո�Ϊ��׼��ȥ�������зֵĽ����");

		for (int i = 0; i < str1Array.length; i++) {
			// System.out.println(str1Array[i]);
			// System.out.println(str1Array[i].charAt(0));

			if (str1Array[i].charAt(0) != '��') {
				temp[j] = str1Array[i];
				System.out.println(temp[j]);
				j++;

			}
			length = j;

		}
		System.out.println("\n��'/'Ϊ��׼�зֵĽ����");
		for (int k = 0; k < length; k++) {
			// System.out.println(temp[k]);

			// System.out.println(temp[k].length());
			// String tempStr="��/r";
			// System.out.println(tempStr.subSequence(0, tempStr.length()-2));
			// System.out.println(tempStr.substring(tempStr.length()-1));
			// System.out.println(tempStr.substring(0,tempStr.length()-2));
			// System.out.println("temp[k].substring(0,temp[k].length()-2)"+temp[k].substring(0,temp[k].length()-2));
			// String a=temp[k].substring(0,temp[k].length()-2);
			// System.out.println("a"+a);
			// deletedSymbolResult[k][0]=a;
			// System.out.println("deletedSymbolResult[k][0]"+deletedSymbolResult[k][0]);

			String slashSeg[] = temp[k].split("/");
			deletedSymbolResult[k][0] = slashSeg[0];
			deletedSymbolResult[k][1] = slashSeg[1];
			// deletedSymbolResult2[k]=temp[k].split("\\");
			/*
			 * ȡ��/��
			 */
			System.out.print(k + deletedSymbolResult[k][0] + "	");
			/*
			 * ȡ�ֵĴ���
			 */
			System.out.println(deletedSymbolResult[k][1]);

			// deletedSymbolResult[k][0]=temp[k].substring(0,temp[k].length()-2);

			// deletedSymbolResult[k][1]=temp[k].charAt(temp[k].length()-1)+"";
			// deletedSymbolResult[k][1]=temp[k].substring(beginIndex)charAt(length-1)+"";
			// System.out.print(k+"0:"+deletedSymbolResult[k][0]+"		");
			// System.out.println(k+"1:"+deletedSymbolResult[k][1]);
		}

	}

	public String subject = "NO SUBJECT";
	/*
	 * ����ĸ���
	 */
	public int subjectNo = 0;

	public void getSubject() {
		System.out.println("\n���壺");

		for (int i = 0; i < length; i++) {
			//
			if (deletedSymbolResult[i][1].equals("n")
			// Ҧ��/nr
					|| deletedSymbolResult[i][1].equals("nr")
					// ��/r
					|| deletedSymbolResult[i][1].equals("r")) {
				deletedSymbolResult[i][2] = "SUBJECT";

				subject = deletedSymbolResult[i][0];
				if (subjectNo == 0) {
					keywords[subjectNo++][0] = subject;
				} else {
					keywords[subjectNo++][0] += '-' + subject;
				}
				System.out.println(subject);
				break;
			}

		}

	}

	/*
	 * ����ȡ��������뵽���ݽṹ��
	 */
	public void insertSubject() {
		// System.out.println("\n���壺");

		for (int i = 0; i < length; i++) {
			//
			if (// deletedSymbolResult[i][1].equals("n")
			// Ҧ��/nr
			//
			deletedSymbolResult[i][1].equals("nr")
			// ��/r
					|| deletedSymbolResult[i][1].equals("r")) {

				/*
				 * ��ȡ����
				 */
				keyword[subjectNo].setSubject(deletedSymbolResult[i][0]);

				subjectNo++;
				// deletedSymbolResult[i][2] = "SUBJECT";

				// subject = deletedSymbolResult[i][0];

				/*
				 * if(subjectNo==0){
				 * 
				 * keywords[subjectNo++][0]=subject; } else{
				 * keywords[subjectNo++][0]+='-'+subject; }
				 */
				// System.out.println(subject);
				// break;
			}

		}

	}

	/*
	 * ��ȡ��ʾ��Ϊ�Ĵ�
	 */

	public String action = "NO ACTION";

	public void getAction() {

		System.out.println("\n��Ϊ��");
		/*
		 * �����Բ��Ҷ���
		 */

		for (int i = 0; i < length; i++) {
			/*
			 * �Է�/v
			 */
			// if(deletedSymbolResult[i][1].equals("vi")){
			/*
			 * ACTION��ʾ[][3]�Ǳ�ʾ��Ϊ�Ĵ��
			 */
			// deletedSymbolResult[i][2]="ACTION";
			// action=deletedSymbolResult[i][0];
			// System.out.println(action);
			// break;
			// }
			/*
			 * �����Ͷ��������ñ��
			 * 
			 * ���岻ֹһ��������Ҫ�����������������Ϊ
			 */
			if (deletedSymbolResult[i][1].equals("v"))
				/*
				 * ��/v ƻ��/n
				 */
				// else
				if (deletedSymbolResult[i][1].equals("v")
				/*
				 * ��/vg ��/n
				 */
				|| deletedSymbolResult[i][1].equals("vg")
				/*
				 * ����/vn
				 */
				|| deletedSymbolResult[i][1].equals("vn")
				/*
				 * ��/vd ��/v ������/n
				 */
				|| deletedSymbolResult[i][1].equals("vd")) {
					deletedSymbolResult[i][2] = "ACTION";
					/*
					 * ********************************************
					 * ********************************************** ����ط����������⡣
					 * ��Ϊ���ʲ�һ��ֻ��n *******************************************
					 * ******************************************
					 */
					/*
					 * ��i=1ʱ��Ϊʲô����ִ��&&�������䣿
					 * ��Ϊ��deletedSymbolResult.length=65535��
					 */
					if (((i + 1) < length)
							&& (deletedSymbolResult[i + 1][1].equals("n")
							/*
							 * ��/vd ��/v ������/n
							 */
							|| deletedSymbolResult[i + 1][1].equals("v"))) {
						if (((i + 2) < length)
								&& (deletedSymbolResult[i + 2][1].equals("n"))) {
							action = deletedSymbolResult[i][0]
									+ deletedSymbolResult[i + 1][0]
									+ deletedSymbolResult[i + 2][0];
							i = i + 3;
						} else {
							deletedSymbolResult[i + 1][2] = "ACTION";
							action = deletedSymbolResult[i][0]
									+ deletedSymbolResult[i + 1][0];
							i = i + 2;
						}
						System.out.println(action);
						// break;
						// i=i+2;

					} else {
						action = deletedSymbolResult[i][0];
						System.out.println(action);
						// break;

						/*
						 * ��ôд��
						 */
					}
				}
		}

	}

	/*
	 * ĳ���������Ϊ����
	 */

	public int actionNo = 0;

	/*
	 * k����Ϊ�������α�
	 */
	public int k = 0;

	public void insertAction() {

		// System.out.println("\n��Ϊ��");
		/*
		 * �����Բ��Ҷ���
		 */

//		for (int i = 0; i < length; i++) {
		int i=0;
		while(i<length){
			/*
			 * �Է�/v
			 */
			// if(deletedSymbolResult[i][1].equals("vi")){
			/*
			 * ACTION��ʾ[][3]�Ǳ�ʾ��Ϊ�Ĵ��
			 */
			// deletedSymbolResult[i][2]="ACTION";
			// action=deletedSymbolResult[i][0];
			// System.out.println(action);
			// break;
			// }
			/*
			 * �����Ͷ��������ñ��
			 * 
			 * ���岻ֹһ��������Ҫ�����������������Ϊ
			 */

			/*
			 * ��/v ƻ��/n
			 */
			// else
			if (deletedSymbolResult[i][1].equals("v")
			/*
			 * ��/vg ��/n
			 */
			|| deletedSymbolResult[i][1].equals("vg")
			/*
			 * ����/vn
			 */
			|| deletedSymbolResult[i][1].equals("vn")
			/*
			 * ��/vd ��/v ������/n
			 */
			|| deletedSymbolResult[i][1].equals("vd")) {

				// deletedSymbolResult[i][2] = "ACTION";
				/*
				 * ********************************************
				 * ********************************************** ����ط����������⡣
				 * ��Ϊ���ʲ�һ��ֻ��n *******************************************
				 * ******************************************
				 */
				/*
				 * ��i=1ʱ��Ϊʲô����ִ��&&�������䣿 ��Ϊ��deletedSymbolResult.length=65535��
				 */
				if (((i + 1) < length)
						&& ((deletedSymbolResult[i + 1][1].equals("n")
						/*
						 * ��/vd ��/v ������/n
						 */
						|| deletedSymbolResult[i + 1][1].equals("v")))) {
					if (((i + 2) < length)
							&& (deletedSymbolResult[i + 2][1].equals("n"))) {

						keyword[k].setAction(actionNo,
								deletedSymbolResult[i][0]
										+ deletedSymbolResult[i + 1][0]
										+ deletedSymbolResult[i + 2][0]);

						i = i + 3;
						actionNo++;
					} else {
						// deletedSymbolResult[i + 1][2] = "ACTION";
						keyword[k].setAction(actionNo,
								deletedSymbolResult[i][0]
										+ deletedSymbolResult[i + 1][0]);
						i = i + 2;
						actionNo++;
					}
					// System.out.println(action);
					// break;
					// i=i+2;

				} else {
					keyword[k].setAction(actionNo, deletedSymbolResult[i][0]);
					// System.out.println(action);
					// break;

					/*
					 * ��ôд��
					 */
					i++;
					actionNo++;
				}
			}
			else{
				i++;
			}

		}

	}

	/*
	 * ��ȡ������Ϊ�����ĳ�����
	 */
	public String scene = "NO SECNE";

	public void getScene() {
		System.out.println("\n������");

		for (int i = 0; i < length; i++) {
			/*
			 * ��/r ��/p �г�/s ����/vn ����/vn ��/w 
			 */
			if ((i + 1 < length) && deletedSymbolResult[i][1].equals("p")
					&& (deletedSymbolResult[i + 1][1].equals("n")
							//��/p �г�/s
							//s ������
							||(deletedSymbolResult[i + 1][1].equals("s")))){
				deletedSymbolResult[i + 1][2] = "SCENE";
				scene = deletedSymbolResult[i + 1][0];
				System.out.println(scene);
				// break;

			}

		}
		System.out.println(scene);

	}
	
	
	/*
	 * ��ȡ������Ϊ�����ĳ�����
	 */

	/*
	 * ��������
	 */
	int sceneNo=0;
	public void insertScene() {
//		System.out.println("\n������");

		for (int i = 0; i < length; i++) {
			/*
			 * Ҧ���������ݴ����� �� ������ n
			 */
			if ((i + 1 < length) && deletedSymbolResult[i][1].equals("p")
					&& (deletedSymbolResult[i + 1][1].equals("n")
							//��/p �г�/s
							//s ������
							||(deletedSymbolResult[i + 1][1].equals("s")))){
//				deletedSymbolResult[i + 1][2] = "SCENE";
				keyword[sceneNo].setScene(deletedSymbolResult[i + 1][0]);
				sceneNo++;
//				System.out.println(scene);
				// break;

			}

		}
//		System.out.println(scene);

	}
	
	

	public static void main(String args[]) {
		System.out.println("�ı�����������");
		System.out.println("1.Ҧ���������ݴ�����");
		System.out.println("2.��������");
		System.out.println("3.���ڲٳ��ܲ�");
		System.out.println("4.�������������");
		System.out.println("5.�����г���������");

		GetKeywords key = new GetKeywords();
		key.getWordSegResult();

		System.out.println("��ȡ�ִʵ����ս��:\n" + key.wordSegResult + "\n");

		key.deleteSymbols();

		// key.getSubject();

		// key.getAction();

		// key.getScene();

		System.out
				.println("**********************************************************************\n**********************************************************************");
		key.insertSubject();
		key.insertAction();
		key.insertScene();
		for (int i = 0; i < key.subjectNo; i++) {
			System.out.println("����" + i + ":" + key.keyword[i].getSubject());
			for (int j = 0; j < key.actionNo; j++) {
				System.out.println("��Ϊ" + i + "-" + j + ":"
						+ key.keyword[i].getAction(j));
			}
			System.out.println("����" + i + ":" + key.keyword[i].getScene());
		}

	}

}
