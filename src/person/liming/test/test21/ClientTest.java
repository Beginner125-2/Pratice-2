package person.liming.test.test21;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 * @author liuliming
 * ��TCPЭ��дһ���ͻ��˺�һ������ˣ�ʵ���ϴ��ļ�
 */
public class ClientTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = new Client();
		
		try {
			client.getConnect("127.0.0.1", 8888);
			client.getFile();
			client.subFile();
			client.disConnect();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
