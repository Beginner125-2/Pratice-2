package person.liming.test.test35.generator;

import person.liming.test.test35.database.databaseJava.Table;

import java.io.IOException;

/**
 * @author liuliming
 * @Description
 * @Date: Created in 16:552019/8/5
 */
public interface BeanGenerator {

    //ͨ��table����Bean
    public void generateBean(Table table) throws IOException;

    //�������л�id
    String generateBeanSerializeId();

    //������ͷ
    String generateBeanClassHead(String tableName);

    //������β
    String generateBeanClassTail();

    //����get��set����
    String generateBeanGetSet(String fieldType, String filedName);

    //����toString����
    String generateBeanToString(String[] fieldNames);

    //�����ֶ�����
    String generateBeanField(String fieldType, String fieldName);
}
