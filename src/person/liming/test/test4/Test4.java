package person.liming.test.test4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author liuliming
 * @Description �����ѧ����ÿ��ѧ����3�ſΣ����ġ���ѧ��Ӣ��ĳɼ���дһ��������մӼ�������ѧ������Ϣ��
 * @Description �����ʽΪ��name,30,30,30�����������ſγɼ�����
 * @Description �������ѧ����Ϣ���ִܷӸߵ��͵�˳��д�뵽һ�����ơ�stu.txt���ļ��С�
 * @Description Ҫ��stu.txt�ļ��ĸ�ʽҪ�Ƚ�ֱ�ۣ�������ļ����Ϳ��Ժ�����Ŀ���ѧ������Ϣ��
 * @Date: forget
 */
public class Test4 {
	
	public static void main(String[] args) {
		Student[] stu = new Student[5];
		Scanner scan = new Scanner(System.in);
		File file = new File("src/file/stu.txt");
		BufferedWriter writer;
		
		// TODO Auto-generated catch block
		try {
			//�ж��ļ��Ƿ����
			if(!file.exists()){
				file.createNewFile();
			}
			
			//writer��ʼ��
			writer = new BufferedWriter(new FileWriter(file));
			
			//��������
			for(int i = 0; i < 5; i++){
				String str = scan.next();
				String[] inputData = str.split("#");
				int score1 = Integer.valueOf(inputData[1]);
				int score2 = Integer.valueOf(inputData[2]);
				int score3 = Integer.valueOf(inputData[3]);
				stu[i] = new Student(inputData[0], score1, score2, score3);
			}
			
			//����ѧ���ĳɼ��ܺ�����
			Arrays.sort(stu, new Comparator<Student>() {

				@Override
				public int compare(Student o1, Student o2) {
					// TODO Auto-generated method stub
					if(o1.scoreAll()>o2.scoreAll()){
						return 1;
					}else{
						return -1;
					}
				}
				
			});
			
			//�����ݴ����ļ�
			for(int i = 0; i < 5; i++){
				writer.write(stu[i].toString());
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
