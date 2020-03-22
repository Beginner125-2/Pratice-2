package person.liming.test.test35.generator;

import person.liming.test.test35.database.databaseJava.Table;

import java.io.IOException;

/**
 * @author liuliming
 * @Description
 * @Date: Created in 16:552019/8/5
 */
public interface BeanGenerator {

    /**
     * ͨ��table����Bean
     * */
    public void generateBean(Table table) throws IOException;

    //��������
    String generateBeanClassName(String tableName);

    //����get��set����
    String generateBeanGetSet(String fieldType, String filedName);

    //����toString����
    String generateBeanToString(String[] fieldNames);

    //�����ֶ�����
    String generateBeanField(String fieldType, String fieldName);
}
