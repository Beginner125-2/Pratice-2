package person.liming.test.test23;

/**
 * @author liuliming
 * @Description �ô���֤������try��д��return��������д��finally������ִ��return������ִ��fianlly
 */
public class Test23 {
	public static void main(String[] args) {
		try {
			System.out.println("hello");
			return;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			System.out.println("world");
		}
	}
}
