package person.liming.test.test39.model.concrete;

import person.liming.test.test39.model.AbstractCell;

/**
 * @author liuliming
 * @Description
 * @Date: Created in 13:022019/9/24
 */
public class Cell extends AbstractCell {

    @Override
    public CellState preChangeState() {
        CellState cellState = state;
        //��ȡ��Χϸ����������
        int envSurvival = 0;
        AbstractCell[] cells = new AbstractCell[]{north, south, east, west, eastNorth, eastSouth, westNorth, westSouth};
        for(AbstractCell cell:cells){
            if (cell != null && cell.getState() == CellState.survival){
                envSurvival++;
            }
        }
        //�����Ǵ��̬
        if(state == CellState.survival){
            if(envSurvival < 2){
                cellState = CellState.dead;
            }else if (envSurvival > 3){
                cellState = CellState.dead;
            }
        }
        //����������̬
        if(state == CellState.dead){
            if (envSurvival == 3){
                cellState = CellState.survival;
            }
        }
        return cellState;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "state=" + state.name() +
                '}';
    }
}
