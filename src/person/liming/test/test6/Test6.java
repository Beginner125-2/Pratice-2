package person.liming.test.test6;

import java.io.IOException;

/**
 * @author liuliming
 * @Description �Զ����ַ��������İ�װ�࣬ͨ�������װ��Եײ��ַ����������а�װ��
 * @Description �ó���ͨ�������װ���ȡĳ���ı��ļ������磬һ��javaԴ�ļ���ʱ���ܹ��ڶ�ȡ��ÿ��ǰ�涼�������кź�ð��
 */
public class Test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			SymbolInputStream input = new SymbolInputStream("src/file/stu.txt");
			System.out.println(input.readLine());
			System.out.println(input.readLine(1));
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
