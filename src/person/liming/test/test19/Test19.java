package person.liming.test.test19;

import java.util.Arrays;

/**
 * @author liuliming
 * @Description ��֪һ��int���飬��ð�����򷨶�������Ԫ�ؽ����������У�����Ҳ���Ź���
 */
public class Test19 {

	public static void main(String[] args) {
		int[] g = new int[]{0,4,6,2,24,8,-99};
		
		//���������ֵ��1��ѭ����ѭ��ð�����ֵ
		for(int len = g.length-1, i = len; i > 0; i--){
		
			for(int j = 0; j < i; j++){
				
				if(g[j] > g[j+1]){
					int temp = g[j];
					g[j] = g[j+1];
					g[j+1] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(g));
	}

}
