package person.liming.test.test51;

/**
 * @author liuliming
 * @Description ���ַ����Ե�Z�������
 * @Date: Created in 9:552019/11/10
 */
public class Test51 {

    public static void main(String[] args) {
        String s = "abcdefghijklmnopqrs";
        System.out.println(convert(s, 5));
    }


    public static String convert(String s, int numRows) {
        int len = s.length();
        int col = numRows;
        int row = (len/(2*numRows-2))*(numRows-1);
        if(len%(2*numRows-2) != 0){
            row += (len%(2*numRows-2)/numRows) % numRows+1;
        }

        char[][] str = new char[col][row];
        int k = row-1,l = col-1, m = 0;//�ֱ�ָ��str�ĺ����꣬str�������꣬ s������

        boolean flag = true;//��ʾ�����ƶ�,����б�������ƶ�
        for (int i = 0; i < len; i++) {
            str[l][k] = s.charAt(m++);
            if(flag){
                l--;
                if(l == 0){
                    flag = false;
                }
            }else {
                l++;
                k--;
                if(l == col-1){
                    flag = true;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[0].length; j++) {
                if(str[i][j] != 0) {
                    stringBuilder.append(str[i][j]);
                }else{
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
