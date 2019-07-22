package person.liming.test.test21;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;


public class Client {
	//�ϴ��ֽڻ���
	private static final int BUFFER_SIZE = 10;
	//���ϴ����ļ�
	File file;
	//�����׽���
	Socket socket;
	//����˴�������Ϣ
	String news;
	
	
	public void getFile() {
		
		String str;
		Scanner scan = new Scanner(System.in);
		
		//ѡ���ļ�
		while(true){
			System.out.println("������·���鿴�ļ�");
			str = scan.next();
			file = new File(str);
			System.out.println(Arrays.toString(file.list()));
			
			System.out.println("�����뵱ǰ·���ļ���������next���²鿴·����ѡ��");
			str = scan.next();
			
			//next����
			if(!str.equals("next")){
				
				//��no����
				while(true){
					file = new File(str);
					System.out.println("���������"+file.getAbsolutePath());
					System.out.println("����no������ѡ��");
					
					str = scan.next();
					if(!str.equals("no")){
						break;
					}
				}
				
				break;
			}
		}
	}
	
	public void subFile() throws IOException{
		OutputStream out = socket.getOutputStream();
		InputStream in = new FileInputStream(file);
		byte[] bufferByte = new byte[BUFFER_SIZE];
		int flag;
		
		//�����ļ�
		System.out.println("�����ļ���ʼ");
		
		while((flag = in.read(bufferByte)) != -1){
			out.write(bufferByte);
		}
		
		System.out.println("�����ļ����");
		in.close();
		out.close();
	}
	
	public void getConnect(String host, int port) throws UnknownHostException, IOException{
		socket = new Socket(host, port);
	}
	
	public void disConnect() throws IOException{
		socket.close();
	}
	
}
