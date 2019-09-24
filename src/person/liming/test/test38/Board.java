package person.liming.test.test38;

import java.util.Observable;
import java.util.Observer;

/**
 * @author liuliming
 * @Description
 * @Date: Created in 22:082019/9/12
 */
public class Board implements Observer {

    private String boardName;

    public Board(String boardName) {
        this.boardName = boardName;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("����"+boardName+",����չʾ��"+((Text)o).getStr());
    }
}