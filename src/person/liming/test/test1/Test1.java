package person.liming.test.test1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuliming
 * @Description ȡ��һ���ַ�������ĸ���ֵĴ������磺�ַ�������abcdekka27qoq������������ַ��Ĵ���
 * @Date: forget
 */
public class Test1 {

	public static void main(String[] args) {
		String str = "qqqqqqqqqqqqqqqqq";
		Map<Character, Integer> total = new HashMap<Character, Integer>();
		
		//ͳ���ַ��е�����
		for(int i = 0, len = str.length(); i < len; i++){
			char c = str.charAt(i);
			Integer a = total.get(c);
			if(a == null){
				total.put(c, 1);
			}else{
				total.put(c, ++a);
			}
		}
		
		System.out.println(total.get(new Character('q')));
		System.out.println(total.toString());
	}
	
}
