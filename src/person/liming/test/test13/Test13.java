package person.liming.test.test13;

import java.io.IOException;

/**
 * @author liuliming
 * @Description ����ģʽ��ȡ����������Ϣ
 */
public class Test13 {
	
	public static void main(String[] args) {
		Configuration config;
		try {
			config = Configuration.getInstance();
			System.out.println(config.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
