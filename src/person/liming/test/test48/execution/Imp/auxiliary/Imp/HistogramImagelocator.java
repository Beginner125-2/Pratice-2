package person.liming.test.test48.execution.Imp.auxiliary.Imp;

import person.liming.test.test48.execution.Imp.auxiliary.ImageLocate;
import person.liming.test.test48.utils.ArrayUtil;
import person.liming.test.test48.utils.PointValue;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

/**
 * @author liuliming
 * @Description
 * @Date: Created in 8:562019/10/27
 */
public class HistogramImagelocator implements ImageLocate {

    BufferedImage sourceImg = null;
    BufferedImage paramImg = null;

    double[][] posValue;//����������ȡ�����ƶȵ�ֵ
    int similarLevel=0;//���Ƽ���
    ArrayList<PointValue<Double>> posValueSort;//posValue�Դ�С˳���ֵ������
    boolean ischange = false;//�Ƿ��޸���ͼƬ

    public HistogramImagelocator(BufferedImage sourceImg, BufferedImage paramImg) {
        this.sourceImg = sourceImg;
        this.paramImg = paramImg;
        this.ischange = true;
        posValueSort = new ArrayList<>();
    }

    @Override
    public Point locate() {
        //�����ͼƬ�䶯�����¼���
        if(posValue == null || ischange == true){
            CalPosValue();
            ischange = false;
        }
        //��ѯ��N���Ƶ�ͼƬ
        while (similarLevel+1>posValueSort.size()){
            Point point = ArrayUtil.minArryPos(posValue, new ArrayUtil.Constraint() {
                @Override
                public boolean equal(Object value) {
                    Point param = (Point)value;
                    for (PointValue d:
                         posValueSort) {
                        if(d.isInclude(new Rectangle(param, new Dimension(paramImg.getWidth(), paramImg.getHeight())))){
                            return true;
                        }
                    }
                    return false;
                }
            });
            posValueSort.add(new PointValue(point, posValue[point.x][point.y]));
        }
        System.out.println(posValueSort);
        return posValueSort.get(similarLevel).getLocation();
    }

    //�������������ͼƬ�����ƶ�
    protected void CalPosValue(){
        long first = System.currentTimeMillis();
        System.out.println("��ʼƥ�䡣����");
        int sourceImgWidth = sourceImg.getWidth();
        int sourceImgHeight = sourceImg.getHeight();
        int paramImgWidth = paramImg.getWidth();
        int paramImgHeight = paramImg.getHeight();
        int[][] sourceImgPix;//ԭͼ���rgbֵ����
        int[][] paramImgPix;//��ƥ���ͼ���rgbֵ����
        int[] paramImgPixOne;
        int[] sourceImgPixOne;

        //��ʼ���������������
        System.out.println("��ʼ���������������...");
        posValue = new double[sourceImgWidth-paramImgWidth+1][sourceImgHeight-paramImgHeight+1];
        sourceImgPixOne = sourceImg.getRGB(0, 0, sourceImgWidth, sourceImgHeight, null, 0, sourceImgWidth);
        paramImgPixOne = paramImg.getRGB(0, 0, paramImgWidth, paramImgHeight, null, 0, paramImgWidth);
        sourceImgPix = ArrayUtil.TwoArry(sourceImgWidth, sourceImgHeight, sourceImgPixOne);
        paramImgPix = ArrayUtil.TwoArry(paramImgWidth, paramImgHeight, paramImgPixOne);

        //��ʼ��������������ֵ
        System.out.println("��ʼ��������������ֵ...");
        double[][] paramImgHistogram = GetHistogram1(paramImgPixOne, paramImgWidth,paramImgHeight);
        for (int i = 0; i <= sourceImgWidth-paramImgWidth; i++) {
            for (int j = 0; j <= sourceImgHeight-paramImgHeight; j++) {
                posValue[i][j] = GetSimilarity2(GetHistogram1(ArrayUtil.OneArry(ArrayUtil.subArry(i, j, paramImgWidth, paramImgHeight, sourceImgPix)), paramImgWidth, paramImgHeight), paramImgHistogram);
            }
        }
        System.out.println("�������������ʱ��Ϊ��"+(System.currentTimeMillis()-first));
    }

    //��ֱ��ͼÿ������ֵ���ܸ�����������
    protected static double[][] GetHistogram1(int[] pix, int width, int height)
    {
        double[][] histgram=new double[3][256];
        int r,g,b;//��¼R��G��B��ֵ
        for(int i=0; i<width*height; i++)
        {
            r = pix[i]>>16 & 0xff; //��ȡR
            g = pix[i]>>8 & 0xff;
            b = pix[i] & 0xff;
            histgram[0][r] ++;
            histgram[1][g] ++;
            histgram[2][b] ++;
        }
        double red =0,green=0,blue=0;
        for(int j=0;j<256;j++){
            red+=histgram[0][j];
            green+=histgram[1][j];
            blue+=histgram[2][j];
        }
        for(int j=0;j<256;j++)//��ֱ��ͼÿ������ֵ���ܸ�����������
        {
            histgram[0][j]/=red;
            histgram[1][j]/=green;
            histgram[2][j]/=blue;
        }
        return histgram;
    }

    //ŷʽ������ͼƬ�����ƶ�
    protected static double GetSimilarity2(double[][] Rhistgram, double[][] Dhistgram)
    {
        double similar=0.0;//���ƶ�
        for(int i=0;i<Rhistgram.length;i++)
        {
            for(int j=0;j<Rhistgram[i].length;j++)
            {
                similar+=(Rhistgram[i][j]-Dhistgram[i][j])*(Rhistgram[i][j]-Dhistgram[i][j]);
            }
        }
        similar=similar/6;
        similar=Math.sqrt(similar);
        //similar=similar/3;
        return similar;
    }

    public void setSourceImg(BufferedImage sourceImg) {
        this.sourceImg = sourceImg;
        this.ischange = true;
    }

    public void setParamImg(BufferedImage paramImg) {
        this.paramImg = paramImg;
        this.ischange = true;
    }

    public void setSimilarLevel(int similarLevel) {
        this.similarLevel = similarLevel;
    }
}
