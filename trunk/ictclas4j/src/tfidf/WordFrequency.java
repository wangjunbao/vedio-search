/**
 * TF-IDF�㷨ʵ�֣�����ȷ�����塢��Ϊ�����������岿λ������Ƶ����������
 */
package tfidf;

/**
 * @author Administrator
 *
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import keywords.KeywordStruct;
import keywords.GetKeywords;
import org.ictclas4j.bean.SegResult;
import org.ictclas4j.segment.SegTag; 
public class WordFrequency {
	private static final int ITEMNO = 65535; 

	Item item[]=new Item[ITEMNO];
	/*
	 * ��j
	 */
	
	/*
	 * ��������--�ĵ���������
	 */
	int allSentences=0;
	
	/*
	 * 
	 */
	
	/*
	 * ��ʼ��
	 */
	public WordFrequency() {
		for (int i = 0; i < ITEMNO; i++) {
			item[i] = new Item();
		}

	}

	/**
	 * @param args
	 */
	
	
	public static void main(String args[]) throws IOException {
		WordFrequency frequency=new WordFrequency();
		GetKeywords keywords=new GetKeywords();
		/*
		 * ����keywords.GetKeywords�ṩ�ķִʺ͹ؼ�����ȡģ��
		 */
		keywords.getKeywordsMain();
	}

}





	

