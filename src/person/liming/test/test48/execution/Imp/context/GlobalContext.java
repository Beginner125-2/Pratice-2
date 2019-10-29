package person.liming.test.test48.execution.Imp.context;

import person.liming.test.test48.execution.Executor;
import person.liming.test.test48.execution.Imp.executor.Imp.*;
import person.liming.test.test48.function.SuperRobot;

import java.awt.*;
import java.util.*;

/**
 * @author liuliming
 * @Description
 * @Date: Created in 19:432019/10/23
 */
public class GlobalContext extends Context {

    public static Map<String, Executor> parseRule = new HashMap();
    public static SuperRobot superRobot = null;
    public static Map<String, String> functions = new HashMap<>();
    public static Map<String, String> images = new HashMap<>();
    public static Queue<String> cmdHistory = new ArrayDeque<>();
    static {
        try {
            superRobot = new SuperRobot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        parseRule.put("mousemove +(\\d+,\\d+)", new MouseMoveExecutor());//����ƶ�
        parseRule.put("mousemove +(useimg +\\w+)", new MouseMoveExecutor());//��굽ָ��ͼ��
        parseRule.put("automap", null);//������ģʽ
        parseRule.put("usescript +.+\\.txt", new ScriptExecutor());//ʹ�ýű�
        parseRule.put("(\\w|,| )+;(\\w|,| )+", new ComplieBatExecutor());//����ִ�й���
        parseRule.put("keyinput +\\w+", new KeyInputExecutor());//������̰���
        parseRule.put("sclick *", new SingleCmdExecutor());//��굥��
        parseRule.put("dclick *", new SingleCmdExecutor());//���˫��
        parseRule.put("history *", new SingleCmdExecutor());//���˫��
        parseRule.put("(addfunc +\\w+ +\\(.+\\))|(usefunc +\\w+)|(findfunc +\\w+)|(delfunc +\\w+)|(modfunc +\\w+ +\\(.+\\))|(listfunc)", new FuncCurdExecutor());//���溯��
        parseRule.put("(addimg +\\w+ +\\(.+\\))|(useimg +\\w+)|(findimg +\\w+)|(delimg +\\w+)|(modimg +\\w+ +\\(.+\\))|(listimg)", new ImgCurdExecutor());//���溯��
        parseRule.put("exit *", new SingleCmdExecutor());//�뿪����
        parseRule.put("help *", new SingleCmdExecutor());//�����ĵ�
        parseRule.put("sleep \\d+", new SleepExecutor());//ֹͣn��
        parseRule.put("!.+", new SysCmdExecutor());
    }
}
