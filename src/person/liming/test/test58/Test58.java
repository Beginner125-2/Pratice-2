package person.liming.test.test58;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuliming
 * @Description ʹ��redis�������ݣ������г־û�
 * @Date: Created in 9:062020/6/20
 */
public class Test58 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("���ӳɹ�");
        jedis.set("key", "redis");
        jedis.lpush("list", "baidu");
        jedis.lpush("list", "google");
        jedis.lpush("list", "bing");
        System.out.println("������������"+jedis.get("key"));
    }
}
