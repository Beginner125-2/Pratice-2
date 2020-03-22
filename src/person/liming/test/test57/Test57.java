package person.liming.test.test57;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuliming
 * @Description װ��XML�����ݸ�XML�ļ������ļ��а������ݿ�����Ϣ������������mysql���ݿ������
 * @Description
 * @Date: Created in 10:432020/3/14
 */
public class Test57 {
    public static void main(String[] args) {
        //���ݿ������ض���
        DatabaseDAO databaseDAO = new DatabaseDAO();
        int re = 0;

        //XML������ض���
        File inputFile = new File("file/������Դ����ϵͳ���ݿ�����.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser;

        //���н�������xmlתΪ�ڴ�ṹ����
        ArrayList<DataTable> dataTables = new ArrayList<>();
        try {
            saxParser = factory.newSAXParser();
            DataTableHandler handler = new DataTableHandler();
            saxParser.parse(inputFile, handler);
            for (Object o :
                    handler.getTableHashMap().values()) {
                dataTables.add((DataTable) o);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //��ʼ�������ݿⴴ����
        try {
            databaseDAO.getConnection();
            for (DataTable table :
                    dataTables) {
                System.out.println(table.toString());
                databaseDAO.queryupdate(table.toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
