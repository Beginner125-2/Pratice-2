package person.liming.test.test50;

import javax.smartcardio.CardException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liuliming
 * @Description Java��ģ�⹺����վ�Ĺ��ﳵ
 * @Date: Created in 16:422019/11/8
 */
public class Test50 {

    static ShopMall shopMall;
    static Scanner scanner = new Scanner(System.in);

    static {
        ArrayList<Goods> goods;
        goods = new ArrayList<>();
        goods.add(new Goods(1, "�����ֱ�", 10, 100));
        goods.add(new Goods(2, "Ư��Χ��", 2, 200));
        goods.add(new Goods(3, "����Ь��", 80, 1000));
        goods.add(new Goods(4, "���Ӳ�Ʒ", 6, 100));
        goods.add(new Goods(5, "С���", 1, 10));
        goods.add(new Goods(6, "��ͯ��Ʒ", 0, 50));
        shopMall = new ShopMall(goods);
    }

    public static void main(String[] args) {
        while (true){
            System.out.println("��������Ӧ��Ž��в���");
            System.out.println("1.���빺�ﳵ");
            System.out.println("2.�޸Ĺ�������");
            System.out.println("3.ɾ��");
            System.out.println("4.�˳�");
            int i = scanner.nextInt();
            switch (i){
                case 1:
                    addCart();
                    break;
                case 2:
                    updateCart();
                    break;
                case 3:
                    delCart();
                    break;
                case 4:
                    System.exit(0);
                    default:
                        System.out.println("û�д�ѡ��");
                        break;
            }
        }
    }

    public static void addCart(){
        System.out.println(shopMall.getAllGoodsString());
        System.out.println("������Ҫ�������Ʒ��ź�����");
        int no = scanner.nextInt();
        int num = scanner.nextInt();
        try {
            shopMall.addCartContent(no, num);
        } catch (GoodsExecption goodsExecption) {
            System.out.println(goodsExecption.getMessage());
            System.out.println("�����²���\n");
            return;
        }
        System.out.println(shopMall.getCartString());
    }

    public static void updateCart(){
        System.out.println(shopMall.getCartString());
        System.out.println("������Ҫ�޸ĵĹ��ﳵ����Ʒ��ź�����");
        int no = scanner.nextInt();
        int num = scanner.nextInt();
        try {
            shopMall.addCartContent(no, num);
        } catch (GoodsExecption goodsExecption) {
            System.out.println(goodsExecption.getMessage());
            System.out.println("�����²���\n");
            return;
        }
        System.out.println(shopMall.getCartString());
    }

    public static void delCart(){
        System.out.println(shopMall.getCartString());
        System.out.println("������Ҫ�������Ʒ���");
        int no = scanner.nextInt();
        try {
            shopMall.delCartContent(no);
        } catch (CardException e) {
            System.out.println(e.getMessage());
            System.out.println("�����²���\n");
            return;
        }
        System.out.println(shopMall.getCartString());
    }
}
