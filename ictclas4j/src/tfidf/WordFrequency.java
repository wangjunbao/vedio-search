/**
 * TF-IDF�㷨ʵ�֣�����ȷ�����塢��Ϊ�����������岿λ������Ƶ����������
 */
package tfidf;

import java.io.FileNotFoundException;
import java.io.IOException;

import keywords.GetKeywords;

public class WordFrequency {

	private static final int ITEMNO = 65535;
	/*
	 * �����
	 */
	//
	// int allSpecificWord[] = new int[4];
	double tf[] = new double[4];
	double idf[] = new double[4];
	int frequency[] = new int[4];

	/*
	 * ������i�ľ�����
	 */
	int sentenceWithWord[] = new int[4];
	//	
	/*
	 * ��j
	 */

	/*
	 * ��������--�ĵ���������
	 */
	int allSentences = 0;

	/*
	 * 
	 */

	/*
	 * ��ʼ��
	 */
	public WordFrequency() {
		for (int i = 0; i < 4; i++) {

			sentenceWithWord[i] = 0;
		}
	}

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 * @throws FileNotFoundException 
	 */
	
	public void countWordFrequency() throws FileNotFoundException{
		GetKeywords keywords = new GetKeywords();
		/*
		 * ����keywords.GetKeywords�ṩ�ķִʺ͹ؼ�����ȡģ��
		 */
		Item item[]=keywords.getKeywordsMain4IFIDF();

//		System.out.print("item[0].getSubjectNo()"+item[0].getSubjectNo());
		for (int i = 0; i < item[0].allSentencesNo; i++) {
			if (item[i].getSubjectNo() != 0) {
				sentenceWithWord[0] ++;
			}
			
			if (item[i].getActionNo() != 0) {
				sentenceWithWord[1] ++;
			}
			if (item[i].getSceneNo() != 0) {
				sentenceWithWord[2] ++;
			}
			if (item[i].getBodyPartNo() != 0) {
				sentenceWithWord[3] ++;
			}
			
		}
		/*
		 * ����idf
		 */
		for (int j = 0; j < 4; j++) {
			idf[j] = Math.log((item[0].allSentencesNo) / sentenceWithWord[j]);
		}
	

	}
	
	
	/*
	 * ��������Ȩ��
	 * 
	 * keywordsNo
	 * 1--subject��Ȩ��
	 * 2--action��Ȩ��
	 * 3--
	 * 4--
	 * 
	 * ����˹��³������������
	 * 
	 * wordInSentence
	 * ��i�����ţ��ھ���j�г��ֵĴ���------------------1
	 * 
	 * allWordInSentence
	 * ����j�����дʵĸ���-----------------------------4
	 */
	public double countWordFrequency(int keywordsNo,int wordInSentence, int allWordInSentence) throws FileNotFoundException{
		GetKeywords keywords = new GetKeywords();
		/*
		 * ����keywords.GetKeywords�ṩ�ķִʺ͹ؼ�����ȡģ��
		 */
		Item item[]=keywords.getKeywordsMain4IFIDF();

//		System.out.print("item[0].getSubjectNo()"+item[0].getSubjectNo());
		for (int i = 0; i < item[0].allSentencesNo; i++) {
			if (item[i].getSubjectNo() != 0) {
				sentenceWithWord[0] ++;
			}
			
			if (item[i].getActionNo() != 0) {
				sentenceWithWord[1] ++;
			}
			if (item[i].getSceneNo() != 0) {
				sentenceWithWord[2] ++;
			}
			if (item[i].getBodyPartNo() != 0) {
				sentenceWithWord[3] ++;
			}
			
		}
		/*
		 * ����idf
		 */
		for (int j = 0; j < 4; j++) {
			idf[j] = Math.log((item[0].allSentencesNo) / sentenceWithWord[j]);
		}
		/*
		 * w=tf*idf;
		 */
		return (wordInSentence/allWordInSentence)*idf[keywordsNo];

	}

	public static void main(String args[]) throws IOException {
		WordFrequency wordFrequency = new WordFrequency();

		wordFrequency.countWordFrequency();
		

		for (int k = 0; k < 4; k++) {
			System.out.println("sentenceWithWord[]:"+wordFrequency.sentenceWithWord[k]);
			
			System.out.println("idf[]:"+wordFrequency.idf[k]);
		}

	}

}
