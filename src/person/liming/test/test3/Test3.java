package person.liming.test.test3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuliming
 * @Description ����һ����ArrayList�д��һ��String���͵Ķ���һ��Inegter���Ͷ���
 * @Date: forget
 */
public class Test3 {
	
	public static void main(String[] args) {
		List<Object> list = new ArrayList<Object>();
		String strMsg = new String("text");
		int intMsg = 1;
		
		list.add((Object)strMsg);
		list.add((Object)intMsg);
		System.out.println((String)list.get(0));
		System.out.println((Integer)list.get(1));
	}
	
}
