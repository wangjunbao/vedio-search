package graphicsInterface;

import org.ictclas4j.bean.SegResult;

public class TextAnalyse {
	
	SegResult seg_res = segTag.split(line);
	/*
	 * ��ȡ�ִʵ����ս����
	 */
	// key.wordSegResult=seg_res.getFinalResult();
	// System.out.println(seg_res.getFinalResult());
	wordSegResult = seg_res.getFinalResult();
	System.out.println("��ȡ�ִʵ����ս��:\n" +wordSegResult + "\n");

	deleteSymbols();

	plusDictionary();
	
	System.out
			.println("**********************************************************************\n**********************************************************************");
	insertSubject();
	insertAction();
	insertScene();
	insertBodyPart();
	for (int i = 0; i < subjectNo; i++) {
		System.out.println("����" + i + ":" + keyword[i].getSubject());
		for (int j = 0; j < actionNo; j++) {
			System.out.println("��Ϊ" + i + "-" + j + ":"
					+ keyword[i].getAction(j));
		}
		System.out.println("����" + i + ":" + keyword[i].getScene());
		System.out.println("���岿λ" + i + ":" + keyword[i].getBodyPart());
		System.out.println();

	}

}
