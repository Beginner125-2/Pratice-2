package person.liming.test.test48;

import person.liming.test.test48.execution.Imp.auxiliary.Imp.HistogramImagelocator;
import person.liming.test.test48.function.SuperRobot;
import person.liming.test.test48.interaction.Imp.CommandInteractor;
import person.liming.test.test48.utils.ArrayUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;

/**
 * @author liuliming
 * @Description ʹ��Robotдһ�������ĳ��򣬸ó�����������������п���������
 * @Date: Created in 15:212019/10/22
 */
public class Test48 {

    public static void main(String[] args) throws AWTException, IOException, InterruptedException {
        CommandInteractor interactor = new CommandInteractor();
        interactor.run();
//        File file = new File("f:\\tempraryfile\\param5.png");
//        System.out.println(file.exists());
//        SuperRobot robot = new SuperRobot();
//
//        int sourceImgWidth = 1366;
//        int sourceImgHeight = 760;
//        BufferedImage sourceImg = robot.createScreenCapture(new Rectangle(0,0,sourceImgWidth, sourceImgHeight));
//        BufferedImage paramImg = ImageIO.read(new File("F:\\TempraryFile\\tianmao\\catCode.png"));
//
//        HistogramImagelocator imagelocator = new HistogramImagelocator(sourceImg, paramImg);
//        Point point = imagelocator.locate();
//        System.out.println(point.toString());
//        robot.linerMoveMouse(point.x, point.y, 2);
//        ImageIO.write(sourceImg, "png", new File("F:\\TempraryFile\\scree.png"));
    }
}
