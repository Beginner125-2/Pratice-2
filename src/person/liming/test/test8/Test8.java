package person.liming.test.test8;

/**
 * @author liuliming
 * @Description ����һ����ͨ��ö�٣�������ơ��̵ơ��Ƶƣ���Ҫ�л����һ���Ƶķ��������磺��ƻ�ȡ��һ�������̵ƣ��̵ƻ�ȡ��һ�����ǻƵ�
 */
public class Test8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrafficLight light = TrafficLight.RED;
		System.out.println(light.toString());
		TrafficLight nextlight = light.nextLight();
		System.out.println(nextlight.nextLight());
	}

}
