package person.liming.test.test9;

/**
 * @author liuliming
 * ��дһ���࣬����һ��ʵ���������ڴ�ӡһ���ַ�������ʹ�÷����ֶδ�������Ķ��󣬲����øö����еķ���
 */
public class Test9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class<?> c;
		try {
			c = Class.forName("person.liming.test.test9.PrintHello");
			PrintHello hello = (PrintHello) c.newInstance();
			hello.print();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
