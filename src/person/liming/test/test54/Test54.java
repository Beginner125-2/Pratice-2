package person.liming.test.test54;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * @author liuliming
 * @Description дһ���������ʵĳ��򣬽����Ƶĵ����Զ����浽txt�ļ����С�
 * @Date: Created in 14:412020/1/31
 */
public class Test54 {

    public static void main(String[] args) {
        String path = args[0];
        System.out.println("����·����"+path);
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(path, "rwd");
            randomAccessFile.seek(randomAccessFile.length());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ClipboardGetter getter = new ClipboardGetter(randomAccessFile);
        getter.findNewTextEvent();
        while (true);
    }
}
