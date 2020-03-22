package person.liming.test.test35.generator.generatorImpl;

import person.liming.test.test35.Config.Configurer;
import person.liming.test.test35.database.databaseJava.Table;
import person.liming.test.test35.generator.BeanGenerator;
import person.liming.test.test35.util.FieldTypeUtil;

import java.io.*;
import java.util.HashMap;

/**
 * @author liuliming
 * @Description
 * @Date: Created in 14:332019/8/5
 */
public class JavaBeanJointGenerator implements BeanGenerator {
    public String PATH = "file/";
    public String SUFFIX = ".java";
    BufferedWriter writer;

    public JavaBeanJointGenerator(){
        PATH = (String) Configurer.getInstance().getParam("PATH");
        SUFFIX = (String)Configurer.getInstance().getParam("SUFFIX");
    }

    public void generateBean(Table table) throws IOException {
        File file = new File(PATH + titleString(table.getTableName())+SUFFIX);

        //��ȡ�����
        if(!file.exists()){
            file.createNewFile();
        }
        writer = new BufferedWriter(new FileWriter(file));

        //������ͷ
        writer.write(generateBeanClassName(table.getTableName()));
        writer.write("\n");
        writer.newLine();

        String[] fields = new String[table.getColumns().size()];//���ڻ�ȡ�����ֶ�

        //�������л�id
        writer.write(generateBeanSerializeId());
        writer.write("\n");
        writer.newLine();

        //���������ֶ�
        int i = 0;
        for(HashMap<String ,String> column:table.getColumns()){
            writer.write(generateBeanField(column.get("fieldType"), column.get("field")));
            writer.write("\n");
            writer.newLine();
            fields[i] = column.get("field");
            i++;
        }

        //���������ֶη���
        for(HashMap<String ,String> column:table.getColumns()){
            writer.write(generateBeanGetSet(column.get("fieldType"), column.get("field")));
            writer.write("\n");
            writer.newLine();
        }

        //����toString����
        writer.write(generateBeanToString(fields));
        writer.write("\n");
        writer.newLine();

        //������β
        writer.write("\n");
        writer.write(generateBeanClassTail());

        //�ر��ļ������
        writer.close();
    }

    //�������л�id
    public String generateBeanSerializeId(){
        return "\tprivate static final long serialVersionUID = 1L;";
    }

    //������ͷ
    @Override
    public String generateBeanClassName(String tableName){
        StringBuffer re = new StringBuffer();
        re.append("public class ");
        re.append(titleString(tableName));
        re.append(" implements Serializable {");
        return re.toString();
    }

    //������β
    public String generateBeanClassTail(){
        return "}";
    }

    //����get��set����
    @Override
    public String generateBeanGetSet(String fieldType, String filedName) {
        StringBuffer re = new StringBuffer();
        //get����
        re.append("\tpublic "+ FieldTypeUtil.toJavaType(fieldType));
        re.append(" get"+titleString(filedName));
        re.append("(){\n");
        re.append("\t\treturn this."+filedName);
        re.append(";\n");
        re.append("\t}\n");
        //set����
        re.append("\tpublic void set");
        re.append(titleString(filedName));
        re.append("("+FieldTypeUtil.toJavaType(fieldType)+" "+filedName+"){\n");
        re.append("\t\tthis."+filedName+" = "+filedName+";");
        re.append("\n\t}");
        return re.toString();
    }

    //����toString����
    @Override
    public String generateBeanToString(String[] fieldNames){
        StringBuffer re = new StringBuffer();
        re.append("\tpublic String toString(){");
        re.append("\n");
        re.append("\t\treturn \"\"");
        for(String fileName:fieldNames){
            re.append("\n\t\t\t");
            re.append("+\""+fileName+"=\"+this."+fileName);
        }
        re.append(";");
        re.append("\n\t}");
        return re.toString();
    }

    //�����ֶ�����
    @Override
    public String generateBeanField(String fieldType, String fieldName){
        StringBuffer re = new StringBuffer();
        re.append("\tprivate " + FieldTypeUtil.toJavaType(fieldType));
        re.append(" "+fieldName);
        re.append(";");
        return re.toString();
    }

    /**
     * @param str
     * @return ����������ĸ��д
     */
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
