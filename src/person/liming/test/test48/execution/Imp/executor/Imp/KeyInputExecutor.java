package person.liming.test.test48.execution.Imp.executor.Imp;

import person.liming.test.test48.execution.ExecuteResult;
import person.liming.test.test48.execution.Imp.executor.AbstractRobotExecutor;
import person.liming.test.test48.execution.Imp.result.StringExecuteResult;
import person.liming.test.test48.execution.Imp.context.KeyInputContext;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liuliming
 * @Description
 * @Date: Created in 19:352019/10/23
 */
public class KeyInputExecutor extends AbstractRobotExecutor {

    @Override
    protected ExecuteResult specificExecute() {
        KeyInputContext keyInputContext = (KeyInputContext)context;
        Queue<Integer> keyCode = keyInputContext.getKeyCode();
        while(!keyCode.isEmpty()){
            superRobot.singleKeyClick(keyCode.poll());
            superRobot.delay(100);
        }
        return new StringExecuteResult("ִ�а�������ָ��ɹ�");
    }

    @Override
    public KeyInputContext parse(String param) {
        String string = param.split(" +")[1].toUpperCase();//������ַ���
        Queue<Integer> keyCode = new ConcurrentLinkedDeque<>();//���ɵ�������
        //���ⰴ��ӳ��
        Map<String, Integer> specialKey = new HashMap<>();
        specialKey.put("#{space}", 1);
        specialKey.put("#{enter}", 1);
        specialKey.put("#{backspace}", 1);
        specialKey.put("#{esc}", 1);
        specialKey.put("#{delete}", 1);
        specialKey.put("#{ctrl}", 1);
        specialKey.put("#{shift}", 1);
        specialKey.put("#{capslock}", 1);
        specialKey.put("#{tab}", 1);
        //�滻�����Ϊ��Ӧ��������
        Pattern pattern = Pattern.compile("#(.*)");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()){
            Integer integer = specialKey.get(matcher.group());
            if(integer == null){
                continue;
            }else {
                string = string.replaceAll(matcher.group(), String.valueOf((char)integer.intValue()));
            }
        }
        //����������
        for (int i = 0; i < string.length(); i++) {
            keyCode.add((int)string.charAt(i));
        }
        return new KeyInputContext(keyCode);
    }
}
