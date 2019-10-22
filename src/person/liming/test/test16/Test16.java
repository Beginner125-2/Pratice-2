package person.liming.test.test16;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

/**
 * @author liuliming
 * @Description ����ʵ��c��ĳ���ļ��и��Ƶ�D���У����ϴ��룬����ע�ͣ�����˼·
 */
public class Test16 {
	
	public static void main(String[] args) {
		String sourcePath;
		String aimPath;
		File sourceFile;
		File aimFile;
		Scanner scan = new Scanner(System.in);
		
		//��ʼ�����Ƶ�Դ·��
		System.out.println("���븴�Ƶ�Դ��ַ");
		sourcePath = scan.next();
		sourceFile = new File(sourcePath);
		System.out.println(sourceFile.getAbsolutePath());
		
		//ѡ���Ƶ�Դ·��
		System.out.println("��ok����,�����Ҫ����Դ�ļ��������µ�·��");
		while (true) {
			sourcePath = scan.next();
			if(sourcePath.equals("ok")){
				break;
			}
			sourceFile = new File(sourcePath);
			System.out.println(sourceFile.getAbsolutePath());
		}
		
		//��ø��Ƶ�Ŀ��·��
		System.out.println("������Ŀ���ļ�");
		aimPath = scan.next();
		aimFile = new File(aimPath);
		System.out.println(aimFile.getAbsolutePath());
		if(aimFile.exists()){
			System.out.println("Ŀ�ĵ��Ѵ����ļ�");
			System.exit(0);
		}
		
		//ִ�и��Ʋ���
		try {
			Files.copy(sourceFile.toPath(), new FileOutputStream(aimFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
