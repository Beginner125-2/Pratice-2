package person.liming.test.test5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author liuliming
 * @Description ����һ���ļ�������������read(byte[]b)�������ļ��е��������ݴ�ӡ����(byte����Ĵ�С����Ϊ5)
 * @Date: forget
 */
public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("src/file/stu.txt");
		byte[] data = new byte[5];
		FileInputStream input;
		
		try {
			
			//�ж��ļ��Ƿ���ڣ������ڴ���
			if(!file.exists()){
				file.createNewFile();
			}
			
			//��������ʼ��
			input = new FileInputStream(file);
			
			//���������ж�ȡ���ݲ���ӡ
			int flag = input.read(data);;
			while (flag != -1) {
				System.out.println(new String(data));
				flag = input.read(data);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
