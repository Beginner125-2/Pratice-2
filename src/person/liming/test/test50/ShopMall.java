package person.liming.test.test50;

import javax.smartcardio.CardException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * @author liuliming
 * @Description
 * @Date: Created in 9:322019/11/10
 */
public class ShopMall {
    ArrayList<Goods> goods;
    HashMap<Integer, Integer> shopingCart;

    public ShopMall(ArrayList<Goods> goods) {
        this.goods = goods;
        shopingCart = new HashMap<>();
    }

    public String getAllGoodsString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("���\t����\t�������\t����\n").append("+++++++++++++++++++++++++++++\n");
        for (Goods good :
                goods) {
            stringBuilder.append(good.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public String getCartString(){
        StringBuilder stringBuilder = new StringBuilder();
        Set<Integer> keys = shopingCart.keySet();
        stringBuilder.append("���\t��Ʒ��\t����\n").append("+++++++++++++++++++++++++++++\n");
        for (Integer key :
                keys) {
            Goods goods = getGoods(key);
            stringBuilder.append(key).append("\t").append(goods.getName()).append("\t").append(shopingCart.get(key)).append("\n");
        }
        return stringBuilder.toString();
    }

    public void addCartContent(int no, int num) throws GoodsExecption {//TODO:��ӹ��ﳵ
        Goods goods = getGoods(no);
        if(goods == null){
            throw new GoodsExecption("�����ڸ���Ʒ");
        }
        if(goods.getStock() < num){
            throw new GoodsExecption("����Ʒ���п��"+goods.getStock());
        }
        for (int i = 0; i < num; i++) {
            shopingCart.put(no, num);
        }
    }

    public void updateCartContent(int no, int num) throws GoodsExecption {//TODO:���¹��ﳵ
        addCartContent(no, num);
    }

    public void delCartContent(int no) throws CardException {//TODO:ɾ�����ﳵ
        if(shopingCart.get(no) == null){
            throw new CardException("���ﳵ�в����ڸ���Ϣ");
        }
        shopingCart.remove(no);
    }

    public Goods getGoods(int no){
        for (Goods good:
             goods) {
            if(good.getNo() == no){
                return good;
            }
        }
        return null;
    }
}
