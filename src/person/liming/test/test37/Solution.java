package person.liming.test.test37;



import person.liming.test.test37.state.StateManager;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuliming
 * @Description ����д�����ϵĴ������
 * @Date: Created in 11:322019/8/25
 */
public class Solution {
    public static void main(String[] args) {
        People people = new People(StateManager.happyState);
        people.say();
        people.say();
        people.say();
        people.say();
        people.say();
    }
}
