package person.liming.test.test43;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

/**
 * @author liuliming
 * @Description ���ļ������������������Ϊ�༶��Ա������
 * @Date: Created in 14:35 2019/10/16
 */
public class RenameTask {

    public static void changeName(String fileName, String[] names) {
        File path = new File(fileName);
        if(!path.exists()){
            info("·��������");
            System.exit(0);
        }
        String[] lastName = path.list();
        File[] subPath = path.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if(pathname.isFile()){
                    return true;
                }
                return false;
            }
        });
        info(Arrays.toString(subPath));

        int len = names.length<subPath.length ? names.length : subPath.length;
        for (int i = 0; i < len; i++) {
            String[] temp = subPath[i].getName().split("\\.");
            String tail = temp[temp.length-1];
            subPath[i].renameTo(new File(fileName+"\\"+names[i]+"."+tail));
        }

        info("�������ɹ�");
        info("��������"+Arrays.toString(lastName));
        info("����������"+Arrays.toString(path.list()));
    }


    public static void info(String info) {
        System.out.println(info);
    }

    public static void main(String[] args) {
//        String[] name = {"�ֿ�","�η�","������","�ſ�","Ҧ����","����ҫ","�����_","����","����Ƚ","����",
//                "�����","÷ܰ��","��־��","����","�ؿ�Ң","��Х��","����","������","����"};
        if(args.length != 2){
            info("����ʾ��(ʹ�þ���·���޸��ļ������� C:\\pic 1,2,3,4,5,6,7");
            info("����ʾ��(ʹ�����·���޸��ļ������� \\pic 1,2,3,4,5,6,7");
            System.exit(0);
        }
        changeName(args[0], args[1].split(","));
    }
}
