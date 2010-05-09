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

	/*
	 * ��������"����Ա/n"֮������壬���򵥵ش���Ϊ�����ʣ��������������ȡ����ˣ�������࣬��Ϊ
	 * �ʵ�Ĳ��䲿�֣��ڡ��ؼ��ʡ���ȡ����֮ǰ���Էִ�����һ���Ĵ���
	 * 
	 * �����Ż������Կ��ǽ��ⲿ������һ���ʵ�
	 */
	public void plusDictionary() {
		for (int i = 0; i < length; i++) {
			/*
			 * ����Ա /n
			 */
			if (deletedSymbolResult[i][0].equals("����Ա")||deletedSymbolResult[i][0].equals("�Ž�")) {
				deletedSymbolResult[i][1] = "nr";
			} else if (deletedSymbolResult[i][0].equals("��")) {
				deletedSymbolResult[i][1] = "v";
			} else if (deletedSymbolResult[i][0].equals("���ƾ���")) {
				deletedSymbolResult[i][1] = "v";
			}
			/*
			 * ��/v ��/j
			 */
			else if (deletedSymbolResult[i][1].equals("j")) {
				deletedSymbolResult[i][1] = "v";
			}
			/*
			 * Football�е����岿λ
			 * 
			 * ���Լ򻯳���deletedSymbolResult[i][0]����"��"��"ͷ"�ģ�����Ϊһ���ر�Ĵ���
			 */
			else if ((deletedSymbolResult[i][0].equals("���"))
					|| (deletedSymbolResult[i][0].equals("�ҽ�"))
					|| (deletedSymbolResult[i][0].equals("ͷ��"))
					/*
					 * 1������ n ����������岿λ��
					 */
					|| (deletedSymbolResult[i][1].equals("������"))) {
				/*
				 * bp--bodypart
				 */
				deletedSymbolResult[i][1] = "bp";
			}

			/*
			 * ��/u ��/v
			 */
			else if (deletedSymbolResult[i][1].equals("u")
					&& ((i + 1 < length) && (deletedSymbolResult[i + 1][1]
							.equals("v")))) {
				deletedSymbolResult[i][1] = "v";
			}
			/*
			 * pbei ��ʡ����� ictclas4jû�б��ֳ���
			 */
			else if (deletedSymbolResult[i][0].equals("��")) {
				deletedSymbolResult[i][1] = "pbei";
			}
			/*
			 * ��/p ��/n  �ã�pyong ��ֹ��ʶ��Ϊscene
			 */
			else if (deletedSymbolResult[i][0].equals("��")) {
				deletedSymbolResult[i][1] = "pyong";
			}
			/*
			 * ˫/m ȭ��/n ��/v 
			 * 
			 * ��Ȼ��"˫"����ֻ�п�����"��"�ˡ�
			 */
			else if (deletedSymbolResult[i][1].equals("m")&&(i+1<length)) {
				deletedSymbolResult[i+1][0] = deletedSymbolResult[i][0]+"��";
				deletedSymbolResult[i+1][1] = "bp";
			}
			/*
			 * ����/n ��Ե/n ��/f ��/n
			 * 
			 * ����Ե"��λ��"
			 */
			else if (deletedSymbolResult[i][0].equals("��Ե")) {
				deletedSymbolResult[i][1] = "f";
			}
			
		}

	}

	public String subject = "NO SUBJECT";
	/*
	 * ����ĸ���
	 */
	public int subjectNo = 0;

	/*
	 * public void getSubject() {
	 * 
	 * System.out.println("\n���壺");
	 * 
	 * for (int i = 0; i < length; i++) { // if
	 * (deletedSymbolResult[i][1].equals("n") // Ҧ��/nr ||
	 * deletedSymbolResult[i][1].equals("nr") // ��/r ||
	 * deletedSymbolResult[i][1].equals("r")) { deletedSymbolResult[i][2] =
	 * "SUBJECT";
	 * 
	 * subject = deletedSymbolResult[i][0]; if (subjectNo == 0) {
	 * keywords[subjectNo++][0] = subject; } else { keywords[subjectNo++][0] +=
	 * '-' + subject; } System.out.println(subject); break; }
	 * 
	 * }
	 * 
	 * }
	 */
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
					|| deletedSymbolResult[i][1].equals("r")
			/*
			 * ����Ա/n ������������е��鷳����ʱ���ǳ���һ����һ��
			 */
			) {

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
	 * 
	 * 
	 * 
	 * /* ĳ���������Ϊ����
	 */

	public int actionNo = 0;

	/*
	 * k������������α�
	 */
	public int k = -1;

	public void insertAction() {

		// System.out.println("\n��Ϊ��");
		/*
		 * �����Բ��Ҷ���
		 */

		// for (int i = 0; i < length; i++) {
		int i = 0;
		/*********************************************************************
		 * k ���ܶ�������ĸ���
		 * 
		 * ����������һ������ʱ��k++,��ʾ�л�����
		 * *******************************************************************
		 */
		while ((i < length) && (k < subjectNo)) {
			if (deletedSymbolResult[i][1].equals("nr")
					|| deletedSymbolResult[i][1].equals("r")) {
				k++;
			}
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
							/*
							 * ����/v ��/u ��/v -----------����/v ��/v ��/v
							 */
							&& ((deletedSymbolResult[i + 2][1].equals("n")) || (deletedSymbolResult[i + 2][1]
									.equals("v")))) {

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
			} else {
				i++;
			}

		}

	}

	/*
	 * ��ȡ������Ϊ�����ĳ�����
	 */

	/*
	 * ��������
	 */
	int sceneNo = 0;

	public void insertScene() {
		// System.out.println("\n������");

		for (int i = 0; i < length; i++) {
			/*
			 * Ҧ���������ݴ����� �� ������ n
			 */
			if ((i + 1 < length)
					/*
					 * ��/p �Ž�/n �õ�/v   
					 * 
					 * ��ʱ��������ʶ
					 */
					&& (deletedSymbolResult[i][1].equals("p")) &&(!(deletedSymbolResult[i][1].equals("pbei"))&& (deletedSymbolResult[i + 1][1]
							.equals("n")
					// ��/p �г�/s
					// s ������
					|| (deletedSymbolResult[i + 1][1].equals("s"))))) {
				// deletedSymbolResult[i + 1][2] = "SCENE";
				keyword[sceneNo].setScene(deletedSymbolResult[i + 1][0]);
				sceneNo++;
				// System.out.println(scene);
				// break;

			}
			/*
			 * 
			 * 
			 * С/a ����/n ��/f
			 */
			else if (deletedSymbolResult[i][1].equals("n")
					&& ((i + 1 < length) && (deletedSymbolResult[i + 1][1]
							.equals("f")
						
							
							))) {
				if ((i - 1 >= 0) && (deletedSymbolResult[i - 1][1].equals("a"))) {
					keyword[sceneNo].setScene(deletedSymbolResult[i - 1][0]
							+ deletedSymbolResult[i][0]
							+ deletedSymbolResult[i + 1][0]);
				}
				/*
				 * ����/n ��/f f ��λ��
				 */
				else {
					keyword[sceneNo].setScene(deletedSymbolResult[i][0]
							+ deletedSymbolResult[i + 1][0]);
				}

			}
			/*
			 * ��/f ��/q
			 */
			else if (deletedSymbolResult[i][1].equals("f")
					&& ((i + 1 < length) && deletedSymbolResult[i + 1][1]
							.equals("q"))) {
				keyword[sceneNo].setScene(deletedSymbolResult[i][0]
						+ deletedSymbolResult[i + 1][0]);

			}
			

		}
		// System.out.println(scene);

	}

	/*
	 * ��ȡ������Ϊ����ʱ���õ����岿λ��
	 */

	/*
	 * ��������
	 */
	int bodyPartNo = 0;

	/*
	 * ����������α�
	 */
	
	public void insertBodyPart() {
		k=-1;
		for (int i = 0; (i < length)&&(k<subjectNo); i++) {
			/*
			 * ����/n ��/f ���/n
			 */
			/*
			 * if (deletedSymbolResult[i][0].equals("���")) {
			 * keyword[bodyPartNo].setBodyPart(deletedSymbolResult[i][0]);
			 * 
			 * }
			 */
			if (deletedSymbolResult[i][1].equals("nr")
					|| deletedSymbolResult[i][1].equals("r")) {
				k++;
			}
			
			if (deletedSymbolResult[i][1].equals("bp")) {
				keyword[k].setBodyPart(deletedSymbolResult[i][0]);

			}
			/*
			 * ��/f ��/n
			 */
			else if (deletedSymbolResult[i][1].equals("f")
					&& ((i + 1 < length) && deletedSymbolResult[i + 1][1]
							.equals("n"))) {
				keyword[k].setBodyPart(deletedSymbolResult[i][0]
						+ deletedSymbolResult[i + 1][0]);

			}
			/*
			 * �г�/n ��/f ��/n
			 */
			else if (deletedSymbolResult[i][1].equals("pyong")) {
				keyword[k].setBodyPart(deletedSymbolResult[i+1][0]);

			}

		}
		// System.out.println(scene);

	}

	public static void main(String args[]) {
		System.out.println("�ı�����������");
		System.out.println("1.Ҧ���������ݴ�����");
		System.out.println("2.��������");
		System.out.println("3.�����г��������š�");
		System.out.println("4.����˹��³���������ҽ�����");
		System.out.println("5.���������ޡ��������滻������˹������");
		/*
		 * ��"�ؼ��ʵ�֪ʶ��Ｏ��ӳ��"ʱ�����Խ�"��ס"ӳ��Ϊ"����"
		 */
		System.out.println("5.����Ա����������ס");
		System.out.println("5.���������ޡ������޾���������������ϣ����ᡤī���������ɡ���ά˹���ŵ÷�");
		System.out.println("4.����˹��³��С�������ҽ�����");

		GetKeywords key = new GetKeywords();
		key.getWordSegResult();

		System.out.println("��ȡ�ִʵ����ս��:\n" + key.wordSegResult + "\n");

		key.deleteSymbols();

		key.plusDictionary();

		// key.getSubject();

		// key.getAction();

		// key.getScene();

		System.out
				.println("**********************************************************************\n**********************************************************************");
		key.insertSubject();
		key.insertAction();
		key.insertScene();
		key.insertBodyPart();
		/*
		 * ����Ӧ����ÿ������Զ�Ӧ���Լ�����Ϊ�����������岿λ�����ǲ�ǡ���ģ�
		 * 
		 * ����
		 * 
		 * ͻȻ���֣�����д��ǡǡ�����˶�����ʱ����
		 * 
		 * �� ����0:���������ޡ������� ��Ϊ0-0:���� ��Ϊ0-1:��� ��Ϊ0-2:null ��Ϊ0-3:null ����0:null
		 * ���岿λ0:null
		 * 
		 * ����1:���ᡤī�� ��Ϊ1-0:null ��Ϊ1-1:null ��Ϊ1-2:���� ��Ϊ1-3:null ����1:null
		 * ���岿λ1:null
		 * 
		 * ����2:���ɡ���ά˹ ��Ϊ2-0:null ��Ϊ2-1:null ��Ϊ2-2:null ��Ϊ2-3:���ŵ÷� ����2:null
		 * ���岿λ2:null
		 * 
		 * 0-0:���� 0-1:��� 1-2:���� 2-3:���ŵ÷�
		 */
		for (int i = 0; i < key.subjectNo; i++) {
			System.out.println("����" + i + ":" + key.keyword[i].getSubject());
			for (int j = 0; j < key.actionNo; j++) {
				System.out.println("��Ϊ" + i + "-" + j + ":"
						+ key.keyword[i].getAction(j));
			}
			System.out.println("����" + i + ":" + key.keyword[i].getScene());
			System.out.println("���岿λ" + i + ":" + key.keyword[i].getBodyPart());
			System.out.println();

		}

	}

}
