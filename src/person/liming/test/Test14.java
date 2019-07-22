package person.liming.test;

import java.util.Random;

/**
 * @author liuliming
 * ��дһ�����򣬻�ȡ10��1��20���������Ҫ������������ظ�
 */
public class Test14 {

	public static void main(String[] args) {
		int[] randNum = new int[10];
		Random rand = new Random(System.currentTimeMillis());
		
		//��ȡʮ������ͬ�������
		for(int i = 0; i < 10; i++){
			int v;
			
			//����ȡ�������ֱ��ȡ�����ظ���ֵ
			//ע�⣬�������ΧС��Ҫ��õ����������ʱ��������ѭ��
			do {
				v = rand.nextInt(20)+1;
			} while (repeat(randNum, v));
			
			randNum[i] = v;
		}
		
		//���
		for(int i:randNum){
			System.out.print(i);
			System.out.print(' ');
		}
	}
	
	
	public static boolean repeat(int[] group, int value){
		
		for(int i : group){
			if(value == i){
				return true;
			}
		}
		
		return false;
	}
}
