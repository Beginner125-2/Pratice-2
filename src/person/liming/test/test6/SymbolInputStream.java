package person.liming.test.test6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SymbolInputStream {
	private BufferedReader reader;
	private int lineIndex = 0;

	public SymbolInputStream(String pathname) throws IOException {
		super();
		File file = new File(pathname);
		//�ж��ļ��Ƿ����
		if(!file.exists()){
			file.createNewFile();
		}
		
		//��ʼ��������
		reader = new BufferedReader(new FileReader(file));
		reader.mark(200);;
	}
	
	//��ȡһ��
	public String readLine() throws IOException{
		String str = reader.readLine();
		if(str == null){
			return null;
		}
		lineIndex++;
		return "��" + String.valueOf(lineIndex) + "��:" + str;
	}
	
	//��ȡ�ض��еĺ���
	public String readLine(int index) throws IOException{
		reader.reset();
		String str = reader.readLine();
		lineIndex++;
		//���Ϊ�գ�˵���ļ�Ϊ�շ��ؿ�ֵ
		if(str == null){
			return null;
		}
		if(index == 1){
			return "��" + String.valueOf(index) + "��:" + str;
		}
		
		int i = 1;
		
		//ȡ��ĳ�е��ı����ݷ���
		while(str != null){
			i++;
			this.lineIndex++;
			str = reader.readLine();
			if(i == index){
				return "��" + String.valueOf(index) + ":" + str;
			}
		}
		//index�����ļ����������ؿ�
		return null;
	}
	
	//��װreset����
	public void reset() throws IOException{
		reader.reset();
	}
	
	public void close() throws IOException{
		reader.close();
	}
}
