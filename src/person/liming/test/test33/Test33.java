package person.liming.test.test33;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liuliming
 * @Description ���׽��ֻ�ȡhttpЭ���·��͵����ݣ�����ӡ�ڿ���̨�ϡ�
 * @Date: Created in 22:402019/8/4
 */
public class Test33 {
    static ServerSocket serverSocket;
    private final int PORT = 8089;

    public static void main(String[] args) {
        InputStream inputStream = null;
        Reader reader = null;
        StringBuffer result = new StringBuffer();

        while (true){
            try {
                serverSocket = new ServerSocket(8089);
                Socket socket = serverSocket.accept();

                System.out.println("----���ܵ�����----");

                inputStream = socket.getInputStream();
                reader = new InputStreamReader(inputStream);

                char []bufferMeg = new char[100];
                System.out.println("----��ʼ����Ϣ----");
                while (reader.read(bufferMeg) != -1){
                    result.append(bufferMeg);//���������ܲ�����Ϣ������
                }
                System.out.println("---��Ϣ��ȡ���---");
                System.out.println(result.toString());
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }

    }
}
