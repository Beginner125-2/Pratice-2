package person.liming.test.test18;

import java.util.Scanner;

/**
 * @author liuliming
 * @Description ��дһ���������Ƚ������������һ���ַ���ת����ʮ����������Ȼ���ӡ�����ʮ����������Ӧ�Ķ�������ʽ��
 * @Description �������Ҫ����������ַ�������ת����һ��ʮ�������������������ת��ʧ�ܵ�ԭ��Ҫ���ֳ�������̫�󣬻������а����з������ַ��������
 */
public class Test18 {
	
	public static void main(String[] args) {
		String inputStr;
		int decimal;
		StringBuffer outputBinary = new StringBuffer();
		Scanner scan = new Scanner(System.in);
		
		//��������
		inputStr = scan.next();
		
		//�ж����������Ƿ���ȷ
		for(int i = 0, len = inputStr.length(); i < len; i++){
			char c = inputStr.charAt(i);
			if(c < '0' || c > '9'){
				System.out.println("���ڷǷ��ַ�");
			}
		}
		
		//������ת��Ϊint����
		decimal = Integer.valueOf(inputStr);
		
		int bin = 2; //ת���Ľ���
		
		//����ʮ����ת��Ϊ�������ַ�
		while (decimal != 0){
			int s = (int)(decimal%bin);
			decimal = decimal/bin;
			char c = (char)(s + 48);
			outputBinary.append(c);
		}
		outputBinary.reverse();
		
		//���
		outputBinary.append('B');
		System.out.println(outputBinary.toString());
	}
	
}
