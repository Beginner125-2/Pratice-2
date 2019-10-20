package person.liming.test.test44;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * @author liuliming
 * @Description ��ȡ���а��е�����
 * @Date: Created in 13:072019/10/19
 */
public class Test44 {
    // ��ȡ���а��е�����
    public static String getClipboardText()
    {
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable clipT = clip.getContents(null);
        if (clipT != null)
        {
            // ��������Ƿ����ı�����
            if (clipT.isDataFlavorSupported(DataFlavor.stringFlavor))
            {
                try
                {
                    String text = (String) clipT
                            .getTransferData(DataFlavor.stringFlavor);
                    return text;
                }
                catch (UnsupportedFlavorException e)
                {
                    e.printStackTrace();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getClipboardText());
    }
}
