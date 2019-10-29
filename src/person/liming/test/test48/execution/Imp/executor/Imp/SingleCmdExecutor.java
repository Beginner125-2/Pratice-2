package person.liming.test.test48.execution.Imp.executor.Imp;

import person.liming.test.test48.execution.ExecuteResult;
import person.liming.test.test48.execution.Imp.context.GlobalContext;
import person.liming.test.test48.execution.Imp.executor.AbstractRobotExecutor;
import person.liming.test.test48.execution.Imp.result.StringExecuteResult;
import person.liming.test.test48.execution.Imp.context.StringContext;

import java.util.Queue;

/**
 * @author liuliming
 * @Description
 * @Date: Created in 19:482019/10/23
 */
public class SingleCmdExecutor extends AbstractRobotExecutor {

    @Override
    protected ExecuteResult specificExecute() {
        StringContext stringContext = (StringContext)context;
        String string = stringContext.getString();
        StringBuilder stringBuilder;
        switch (string){
            case "sclick":
                superRobot.singleClick();
                break;
            case "dclick":
                superRobot.doubleClick();
                break;
            case "exit":
                System.exit(0);
                break;
            case "history":
                Queue<String> queue = GlobalContext.cmdHistory;
                stringBuilder = new StringBuilder();
                int i = 0;
                for (String s :
                        queue) {
                    stringBuilder.append(i).append(": ").append(s).append("\n");
                    i++;
                }
                return new StringExecuteResult(stringBuilder.toString());
            case "help":
                return new StringExecuteResult("���������е�����\n" +
                        "�ƶ����ʾ�� mousemove 100,100\n" +
                        "���������� sclick\n" +
                        "˫�������� dclick\n" +
                        "���밴��ʾ�� keyinput abcdefg\n" +
                        "\n" +
                        "��ʾ��ʷ���� history\n" +
                        "����ִ������ mousemove 100,100;sclick\n" +
                        "\n" +
                        "ʹ�ýű�ʾ�� usescript F:\\TempraryFile\\supermove.txt\n" +
                        "����3��ʾ��  sleep 3000\n" +
                        "ִ��cmd����ʾ�� !ping 127.0.0.1\n" +
                        "�˳����� exit\n" +
                        "\n" +
                        "������ʾ�� addfunc move (mousemove 100,100;sclick)\n" +
                        "ʹ�ú���ʾ�� usefunc move\n" +
                        "ɾ������ʾ�� delfunc move\n" +
                        "�޸ĺ���ʾ�� modfunc btn (mousemove 100,100;dclick)\n" +
                        "\n" +
                        "����ͼƬʾ�� addimg btn (F:\\TempraryFile\\btn.jpg)\n" +
                        "ʹ��ͼƬʾ�� mousemove useimg btn\n" +
                        "ɾ��ͼƬʾ�� delimg btn\n" +
                        "�޸�ͼƬʾ�� modimg btn (F:\\TempraryFile\\btn.jpg)\n");
        }
        return new StringExecuteResult("ִ��"+string+"����ɹ�");
    }

    @Override
    public StringContext parse(String param) {
        return new StringContext(param.trim());
    }
}
