package smartpcb;

import java.awt.Component;
import java.io.BufferedWriter;
import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public abstract class Dialog 
{
    public static boolean showQuestion(Component component,String text,String title)
    {
        return JOptionPane.showConfirmDialog(component,text, title,JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }
    public static boolean showQuestion(String text,String title)
    {
        return showQuestion(WindowManager.mainFrame,text,title);
    }
    public static void showMessage(Component component,String text,String title)
    {
        JOptionPane.showMessageDialog(component, text, title, JOptionPane.INFORMATION_MESSAGE);
    }
    public static void showMessage(String text,String title)
    {
        showMessage(WindowManager.mainFrame,text,title);
    }
    public static void error(String message,Exception ex)
    {
        String trace = Utils.getDate();
        trace += System.getProperty("line.separator");
        CharArrayWriter cw = new CharArrayWriter();
        PrintWriter w = new PrintWriter(cw);
        ex.printStackTrace(w);
        w.close();
        trace += cw.toString();
        try 
        {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("error_log.txt", true)));
            out.println(trace + "\n");
            out.flush();
            out.close();
        } 
        catch (IOException ex1) 
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex1);
        }
        JOptionPane.showMessageDialog(WindowManager.mainFrame, message + "\n" + ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    public static void error(String message)
    {
        JOptionPane.showMessageDialog(WindowManager.mainFrame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    public static void print(Object text)
    {
        System.out.println(text);
    }
}
