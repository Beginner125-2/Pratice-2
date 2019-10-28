package person.liming.test.test45;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liuliming
 * @Description ��ȡ�嵰���ϵ�������Ϣ���������ݿ���
 * @Date: Created in 19:182019/10/21
 */
public class Test45 {
    public static StringBuilder getLine(InputStream inputStream) throws IOException {
        char c;
        StringBuilder stringBuilder = new StringBuilder();
        while ((c = (char) inputStream.read()) != -1){
            if(c == '\n'){
                break;
            }
            stringBuilder.append(c);
        }
        if (stringBuilder.length() == 0){
            return null;
        }
        return stringBuilder;
    }

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://jandan.net/treehole");
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder temp;

        //��ȡ���������������ݣ����е���ʽ��ȡ
        while((temp = getLine(inputStream)) != null){
            stringBuilder.append(temp.toString());
        }
        String strings = stringBuilder.toString();
        stringBuilder = null;

        //����ƥ������class Ϊtext�ı�ǩ
        List<String> textList = new ArrayList<String>();
        Pattern pattern = Pattern.compile("<div class=\"text\">(.|\n|\r)*?</div>");
        Matcher m = pattern.matcher(strings);
        while (m.find()){
            textList.add(m.group());
        }
        System.out.println(textList.size());

        //��ȡ���ӱ�ǩ����p������ַ�
        for (int i = 0; i < textList.size(); i++) {
            String subString  = textList.get(i).split("</?p>")[1];
            subString = subString.replaceAll("<br />", "\n");
            textList.set(i, new String(subString.getBytes("ISO-8859-1"), "utf-8"));
        }


        //�����л�ȡ�����ݴ������ݿ���
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false", "root", "root");
            String sql = "insert into jandan_treehole value(?, ?)";
            PreparedStatement statement = connection1.prepareStatement(sql);
            for (int i = 0; i < textList.size(); i++) {
                statement.setInt(1, i);
                statement.setString(2, textList.get(i));
                statement.execute();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
