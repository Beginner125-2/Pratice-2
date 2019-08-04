package person.liming.test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuliming
 * �ѵ�ǰ�ļ��е������ı�����������һ��txt�ļ���ͳ��ÿ���ַ����ֵĴ��������
 */
public class Test10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File(".");
		File aimFile = new File("file/currentDirInfo.txt");
		Map<Character, Integer> total = new HashMap<Character, Integer>();
		String[] fileInfo;
		RandomAccessFile inAndOut;
		
		try {
			//�ж�Ŀ���ļ��Ƿ����
			if(!aimFile.exists()){
				file.createNewFile();
			}
			
			//��ʼ��
			inAndOut = new RandomAccessFile(aimFile, "rw");
			fileInfo = file.list();
			
			//ͳ�Ƶ�ǰĿ¼ÿ���ַ����ֵĴ���
			for(String info:fileInfo){
				for(int i = 0, len = info.length(); i < len; i++){
					Character c = info.charAt(i);
					Integer t = total.get(c);
					if(t == null){
						total.put(c, 1);
					}else{
						total.put(c, ++t);
					}
				}
			}
			
			//�����������Ŀ���ļ���
			for(String info:fileInfo){
				inAndOut.writeBytes(info);
				inAndOut.writeChar('\n');
			}
			inAndOut.writeBytes(total.toString());
			inAndOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
