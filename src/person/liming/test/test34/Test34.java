package person.liming.test.test34;

import redis.clients.jedis.Jedis;

/**
 * @author liuliming
 * @Description ʹ��redis���л��壬ÿ��ʮ�����һ�������ݿ��ͬ��
 * @Date: Created in 11:122019/8/5
 */
public class Test34 {

    public static void main(String[] args) {
        //���ӱ��ص� Redis ����
        Jedis jedis = new Jedis("localhost");
        System.out.println("���ӳɹ�");
        //�鿴�����Ƿ�����
        System.out.println("������������: "+jedis.ping());
        //δ�����
    }
}
