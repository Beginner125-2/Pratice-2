package person.liming.test.test41;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Logger;

/**
 * @author liuliming
 * @Description
 * @Date: Created in 9:232019/10/3
 */
public class FileIO {
    RandomAccessFile randomAccessFile;
    File file;
    int lineIndex;

    static Logger log = Logger.getLogger(FileIO.class.getName());

    public FileIO(String fileName) throws IOException {
        file = new File("./"+fileName);
        if(!file.exists()){
            file.createNewFile();
        }
        randomAccessFile = new RandomAccessFile(file, "rw");
    }

    public String readLine(int line) throws Exception {
        seekLine(line);
        String str = randomAccessFile.readLine();
        return str;
    }

    public synchronized boolean saveLine(String text) throws Exception {
        saveLine(text, getLineEnd());
        return true;
    }

    public synchronized boolean saveLine(String text, int line) throws Exception {
        log.info("��ʼ����"+text);
        synchronized (this){
//            seekLine(line);
            randomAccessFile.writeBytes(text);
        }
        log.info("�������"+text);
        return false;
    }

    public synchronized int getLineEnd() throws IOException {
        synchronized (this){
            randomAccessFile.seek(0);
            lineIndex = 0;
            String str;
            while ((str = randomAccessFile.readLine()) != null ){
                lineIndex++;
            }
            return lineIndex;
        }
    }

    public synchronized void seekLine(int index) throws Exception {
        if(index < 0){
            throw new Exception("�����������0");
        }
        //��ȡ�ض��еĺ���
        synchronized (this){
            randomAccessFile.seek(0);
            if(index < lineIndex){
                lineIndex = 0;
                String str;
                while ((--index) > 0){
                    str = randomAccessFile.readLine();
                    if(str == null){
                        throw new Exception("�����ı���������");
                    }
                    lineIndex++;
                }
            }else {
                index = lineIndex - index;
                String str;
                while ((--index) > 0){
                    str = randomAccessFile.readLine();
                    if(str == null){
                        throw new Exception("�����ı���������");
                    }
                    lineIndex++;
                }
            }
        }
    }
}
