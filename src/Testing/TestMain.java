package Testing;

import Xml.XmlTag;
import Xml.XmlParser;
import java.io.File;
import smartpcb.Coordinate;
import smartpcb.CoordinateSystem;
import smartpcb.Counter;
import smartpcb.Dialog;
import smartpcb.Units;
import smartpcb.Utils;

public class TestMain 
{
    public static void main(String[] args) 
    {
        Utils.startTimer();
        test2();
        Utils.stopTimer();
    }
    private static void test1()
    {
        XmlTag tag1 = new XmlTag("g");
        XmlTag tag2 = new XmlTag("line");
        XmlTag tag3 = new XmlTag("circle");
        XmlTag tag4 = new XmlTag("g");
        tag1.setAttribute("id", "123234");
        tag2.setAttribute("stroke", "1mm");
        tag2.setAttribute("color", "black");
        tag3.setAttribute("radius", "1");
        tag1.addChild(tag2);
        tag1.addChild(tag4);
        tag4.addChild(tag3);
        System.out.println(tag1.toString());
        XmlTag tag = tag1.getByAttribute("color", "black");
        System.out.println(tag);
    }
    private static void test3()
    {
        XmlParser parser = new XmlParser(new XmlTag("root"));
        XmlTag tag = parser.parse(Utils.loadStringFile(new File("C:\\Users\\Mateo\\Documents\\Programación\\SmartPcb\\testing\\OpAmpInst.svg")));
        Utils.saveStringToFile(new File("C:\\Users\\Mateo\\Documents\\Programación\\SmartPcb\\testing\\result.svg"), tag.toString());
        Dialog.print(tag);
    }
    private static void test4()
    {
        Counter counter = new Counter();
        Dialog.print(counter.getIndex());
        Dialog.print(counter.getIndex());
        Dialog.print(counter.getIndex());
        Dialog.print(counter.getIndex());
        counter.removeIndex(4);
        Dialog.print(counter.getIndex());
        Dialog.print(counter.getIndex());
        Dialog.print(counter.getIndex());
    }
    private static void test2()
    {
        CoordinateSystem s1 = new CoordinateSystem(Units.units.MM);
        CoordinateSystem s2 = new CoordinateSystem(Units.units.PX);
        Coordinate point = new Coordinate(100, 100, s2);
        s1.transformed(2, 10, 10);
        Coordinate projection = s1.projectCoordinate(point);
        Dialog.print(point);
        Dialog.print(projection);
    }
}
