package person.liming.test.test35.generator.generatorImpl;

import person.liming.test.test35.Config.Configurer;
import person.liming.test.test35.database.databaseJava.Table;
import person.liming.test.test35.generator.BeanGenerator;

import java.io.*;

/**
 * @author liuliming
 * @Description
 * @Date: Created in 10:582020/3/18
 */
public class JavaBeanTemplateGenerator implements BeanGenerator {

    public String PATH = "file/";
    public String SUFFIX = ".java";
    private String beanTemplate;
    private String getSetTemplate;
    private String result;
    BufferedWriter writer;

    public JavaBeanTemplateGenerator() {
        PATH = (String) Configurer.getInstance().getParam("PATH");
        SUFFIX = (String)Configurer.getInstance().getParam("SUFFIX");
    }

    @Override
    public void generateBean(Table table) throws IOException {
        File file = new File(PATH + titleString(table.getTableName())+SUFFIX);

        //��ȡ�����
        if(!file.exists()){
            file.createNewFile();
        }
        writer = new BufferedWriter(new FileWriter(file));

        //������ͷ

        String[] fields = new String[table.getColumns().size()];//���ڻ�ȡ�����ֶ�

        //�������л�id

        //���������ֶ�

        //���������ֶη���

        //����toString����

        //�ر��ļ������
        writer.close();
    }

    @Override
    public String generateBeanClassName(String tableName) {
        result = result.replaceAll("\\$\\{ClassName}", titleString(tableName));
        return result;
    }

    @Override
    public String generateBeanGetSet(String fieldType, String filedName) {
        return null;
    }

    @Override
    public String generateBeanToString(String[] fieldNames) {
        return null;
    }

    @Override
    public String generateBeanField(String fieldType, String fieldName) {
        return null;
    }


    public void loadTemplate(String path, String getSetPath) throws IOException {
        File file = new File(path);
        File file1 = new File(getSetPath);

        if(!file.exists() || !file1.exists()){
            throw new FileNotFoundException();
        }

        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        String a = "";
        StringBuilder stringBuilder = new StringBuilder();

        do {
            stringBuilder.append(a);
            a = randomAccessFile.readLine();
        }while (a != null);

        beanTemplate = stringBuilder.toString();
        result = beanTemplate;
    }

    private String titleString(String str){
        String[] strs = str.split("_");
        StringBuilder re = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            strs[i] = strs[i].substring(0, 1).toUpperCase() + strs[i].substring(1);
            re.append(strs[i]);
        }
        return re.toString();
    }
}
