package person.liming.test.test17;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuliming
 * дһ��ArrayList��Ĵ���ʵ�ֺ�ArrayList������ȫ��ͬ�Ĺ��ܣ������Լ���ÿ���������е�ʱ��
 */
public class Test17 {
	
	public static void main(String[] args) {
		List<String> stringGroup = new ArrayList<String>();
		ArrayListAgent agent;
		
		//��list�������
		stringGroup.add("I");
		stringGroup.add("success");
		stringGroup.add("invoke");
		
		//��ʼ��agent����
		agent = new ArrayListAgent(stringGroup);
		
		try {
			
			//����ָ������(�޲�)
			agent.invoke("toString");
			
			//����ָ������(�в�)
			Integer s = (Integer)agent.invoke("size");
			System.out.println(s);
			
		} catch (NoSuchMethodError e) {
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
		}
	}
	
}
