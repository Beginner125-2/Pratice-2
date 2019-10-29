package person.liming.test.test48.utils;

import java.awt.*;

/**
 * @author liuliming
 * @Description
 * @Date: Created in 9:022019/10/27
 */
public class ArrayUtil {
    //һά����ת��Ϊ��ά����
    public static int[][] TwoArry(int width, int height, int[] one){
        int[][] arr=new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                arr[i][j] = one[i+j*width];
            }
        }
        return arr;
    }
    //��ά����ת��Ϊһά����
    public static int[] OneArry(int[][] two){
        int width = two.length;
        int height = two[0].length;
        int[] arr=new int[width*height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                arr[i+j*width] = two[i][j];
            }
        }
        return arr;
    }
    //��ȡ��ά������Ӷ�ά����
    public static double[][] subArry(int x, int y, int width, int height, double[][] arr){
        double[][] subarr = new double[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                subarr[i][j] = arr[x+i][y+j];
            }
        }
        return subarr;
    }
    //��ȡ��ά������Ӷ�ά����
    public static int[][] subArry(int x, int y, int width, int height, int[][] arr){
        int[][] subarr = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                subarr[i][j] = arr[x+i][y+j];
            }
        }
        return subarr;
    }
    //��ȡ��ά�����е���Сֵ����
    public static Point minArryPos(double[][] arr){
        int w = arr.length;
        int h = arr[0].length;
        int x = 0;
        int y = 0;
        double min = 0;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if(arr[i][j]<=min){
                    min = arr[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        return new Point(x, y);
    }
    //��ȡ��ά�����е���Сֵ����
    public static Point minArryPos(double[][] arr, Constraint constraint){
        int w = arr.length;
        int h = arr[0].length;
        int x = 0;
        int y = 0;
        double min = 20;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if(arr[i][j]<=min && !constraint.equal(new Point(i, j))){
                    min = arr[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        return new Point(x, y);
    }
    //��ȡ��ά�����е����ֵ����
    public static Point maxArryPos(double[][] arr){
        int w = arr.length;
        int h = arr[0].length;
        int x = 0;
        int y = 0;
        double max = 0;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if(arr[i][j]>=max){
                    max = arr[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        return new Point(x, y);
    }
    //��ȡ��ά�����е����ֵ����
    public static Point maxArryPos(double[][] arr, Constraint constraint){
        int w = arr.length;
        int h = arr[0].length;
        int x = 0;
        int y = 0;
        double max = 0;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if(arr[i][j]>=max && !constraint.equal(new Point(i, j))){
                    max = arr[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        return new Point(x, y);
    }
    public interface Constraint<T>{
        public boolean equal(T value);
    }
}
