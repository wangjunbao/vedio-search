import org.ictclas4j.bean.SegResult;
import org.ictclas4j.segment.SegTag;

public class OneMain{

	public static void main(String[] args) {

		System.out.println("This is OneMain");

		SegTag st = new SegTag(1);

		SegResult sr = st.split("����һ����������Ͳ��ԣ�����������˿���������");

		System.out.println(sr.getFinalResult());

	}

}

