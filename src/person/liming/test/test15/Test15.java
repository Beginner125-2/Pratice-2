package person.liming.test.test15;

/**
 * @author liuliming
 * @Description ����һ���������飬�������̣߳������̷ֱ߳��һ��ʱ��(����дһ�������)����������������ݣ�ÿһ���߳�Ϊ�������3�����ݼ���
 */
public class Test15 {

	public static void main(String[] args) {
		int[] data = new int[12];
		Group g = new Group(data);
		Thread thread1 = new Thread(new DataAdditor(g));
		Thread thread2 = new Thread(new DataAdditor(g));
		
		thread1.start();
		thread2.start();
		
	}

}
