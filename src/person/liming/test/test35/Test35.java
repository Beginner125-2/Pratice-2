package person.liming.test.test35;

import person.liming.test.test35.Config.Configurer;
import person.liming.test.test35.database.DatabaseConnector;
import person.liming.test.test35.database.databaseJava.Table;
import person.liming.test.test35.generator.BeanGenerator;
import person.liming.test.test35.generator.generatorImpl.JavaBeanGenerator;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author liuliming
 * @Description �������ݿ�����bean�ļ�
 * @Date: Created in 13:322019/8/5
 */
public class Test35 {

    public static void main(String[] args) {
        try {
//            //��ȡ�����ļ�
//            Configurer.getInstance().getConfigureFile("file/beanGenerator.properties");
            //���������ļ�
            Configurer.getInstance().setConfigurerFile("file/beanGenerator.properties");
            //��ȡ���ݿ�������
            DatabaseConnector database = new DatabaseConnector();
            //���ݿ�����q_question��
            Table table = database.getTables("question");
            //����������
            BeanGenerator generator = new JavaBeanGenerator();
            //����bean�ļ�
            generator.generateBean(table);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
