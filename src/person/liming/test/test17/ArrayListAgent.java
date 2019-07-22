package person.liming.test.test17;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListAgent {
	List list;
	Method[] methods;

	public ArrayListAgent(List stringGroup) {
		super();
		this.list = stringGroup;
		methods = this.list.getClass().getMethods();
		
		//��ʾ����
//		for(Method method:methods){
//			System.out.println(method.getName());
//		}
	}
	
	public Object invoke(String methodName, Object...args) throws NoSuchMethodError, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		//����ָ������
		for(Method method : methods){
			
			//����ָ�����������㲢�������ʱ��
			if(method.getName().equals(methodName)){
				long preTime = System.nanoTime();
				Object re = (Object)method.invoke(list, args);
				long rap = System.nanoTime() - preTime;
				printRapTime(methodName, rap);
				return re;
			}
			
		}
		
		//�׳��Ҳ����������쳣
		throw new NoSuchMethodError("�Ҳ�������"+methodName);
	}
	
	//��ָ����ʽ�����������ʱ����
	protected void printRapTime(String methodName, long rap){
		System.out.println("����"+methodName+"ʱ����Ϊ��"+rap+"����");
	}
}
