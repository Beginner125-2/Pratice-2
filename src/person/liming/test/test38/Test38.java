package person.liming.test.test38;

import java.util.Observable;
import java.util.Observer;

/**
 * @author liuliming
 * @Description ʹ��jdk�����۲���ģʽ
 * @Date: Created in 22:122019/9/12
 */
public class Test38 {
    public static void main(String[] args) {
        Text text = new Text("��������������");
        Board board = new Board("��ʾ��");
        Board board1 = new Board("���ű�ֽ");

        text.addObserver(board);
        text.addObserver(board1);
        text.notifyObservers();

        text.setStr("�й����������");
        text.notifyObservers();
    }
}
