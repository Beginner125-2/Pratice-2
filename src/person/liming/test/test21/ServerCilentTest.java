package person.liming.test.test21;

import java.io.IOException;

/**
 * @author liuliming
 * ��TCPЭ��дһ���ͻ��˺�һ������ˣ�ʵ���ϴ��ļ�
 */
public class ServerCilentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerClient sc = new ServerClient();
		try {
			sc.listen(8888);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
