package person.liming.test.test39.model;

import person.liming.test.test39.model.concrete.Cell;

/**
 * @author liuliming
 * @Description
 * @Date: Created in 12:582019/9/24
 */
public abstract class AbstractCellMatrix {
    protected int row;
    protected int col;
    protected AbstractCell[][] cells;

    public AbstractCellMatrix(int row, int col) {
        this.row = row;
        this.col = col;
        init();
    }

    /**
     * ��ʼ������cell��״̬����ϵ
     */
    public abstract void init();

    /**
     * һ���Ըı�����ϸ��״̬
     */
    public abstract void changeStateAll();

    public void changeCell(int x, int y, AbstractCell cell){
        if ( (x>0 && x<row) && (y>0 && y<col) ){
            return;
        }
        cells[x][y] = cell;
    }
    /**
     * �������ϸ����״̬
     */
    public abstract void clearAll();

    public AbstractCell[][] getCells() {
        return cells;
    }
}
