package smartpcb;

import Resources.MainFrameResources;
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import java.io.BufferedWriter;
import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import SaveObjects.Project;
import smartpcb.forms.MainFrame;

public class Main 
{
    private static MainFrame mainFrame;
    public static MainFrameResources mainFrameResources;
    
    public static void main(String[] args) 
    {
        PropertiesManager.initialize();
        mainFrameResources = new MainFrameResources();
        mainFrameResources.loadResources();
        try
        {
            UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
        }
        catch(ParseException | UnsupportedLookAndFeelException e)
        {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, e);
            Dialog.error("There was a problem loading the look and feel.",e);
        }
        mainFrame = new MainFrame();
        mainFrame.setVisible(true);   
    }
    
    
    public static void testMsg()
    {
        JOptionPane.showMessageDialog(mainFrame, "Test Message");
        //TODO:remove
    }
}
