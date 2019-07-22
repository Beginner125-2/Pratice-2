package person.liming.test.test12;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author liuliming
 *  дһ��Properties��ʽ�������ļ�����������������ơ�дһ������
 *  ��ȡ���Properties�����ļ����������������Ʋ���������࣬�÷���ķ�ʽ����run����
 */
public class Test12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties pro = new Properties();
		File file = new File("src/file/class.properties");
		InputStream in;
		
		try {
			if(!file.exists()){
				file.createNewFile();
			}
			
			//��ʼ��
			in = new FileInputStream(file);
			pro.load(in);
			
			//��ȡ������Ϣ
			String className = pro.getProperty("class.name");
			String run = pro.getProperty("class.run");
			
			//����������Ϣ���������
			Class<?> c = Class.forName(className);
			Object h = c.newInstance();
			
			//���÷���
			Method m = c.getMethod(run);
			m.invoke(h);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
