package person.liming.test.test21;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author liuliming
 * ��TCPЭ��дһ���ͻ��˺�һ������ˣ�ʵ���ϴ��ļ�
 */
public class ServerClient {
	//�ϴ��ֽڻ���
	private static final int BUFFER_SIZE = 10;
	//�׽���
	ServerSocket ss;
	//�������ļ��ŵ��ĵط�
	File file;
	//�ͻ��˵���Ϣ
	String news;
	
	public void listen(int port) throws IOException{
		//��������
		String str;
		Scanner scan = new Scanner(System.in);
		Socket socket = null;
		OutputStream out;

		//�����ļ�����Ŀ�ĵ�
		System.out.println("�����ļ�����Ŀ�ĵ�");
		str = scan.next();
		file = new File(str);

		if(!file.exists()){
			file.createNewFile();
		}
		out = new FileOutputStream(file);

		ss = new ServerSocket(port);
		socket = ss.accept();

		//�������
		System.out.println("�������, �ȴ������ļ�");
		InputStream in = socket.getInputStream();
		byte[] buffer = new byte[BUFFER_SIZE];
		int flag;

		System.out.println("��ʼ�����ļ�");
		while(true){
			while( (flag = in.read(buffer)) != -1 ){
				out.write(buffer);
			}
			try{
			      socket.sendUrgentData(0xFF);
			}catch(Exception ex){
			      break;
			}
		}
		
		System.out.println("�ļ�����ɹ�������Ŀ�ĵ�"+file.getAbsolutePath());
	}
	
}
