package smartpcb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class PropertiesManager
{
    private static Properties properties;
    private static File location;
    private static String filename = "props.xml";
    
    public static void initialize()
    {
        properties = new Properties();
        location = new File("C:\\Users\\Mateo\\Documents\\" + filename);
        if(loadProperties())
        {
            createStaticProperties();     
        }
        else
        {
            createDefaultProperties();
            createStaticProperties();
            saveProperties();
        }
        System.out.println(properties.toString());
    }
    public static String get(String key)
    {
        return properties.getProperty(key);
    }
    public static void set(String key,String value)
    {
        properties.setProperty(key, value);
        createStaticProperties();
        saveProperties();
    }
    private static void createStaticProperties()
    {
        properties.setProperty("project_ext", "sppj");
    }
    private static boolean loadProperties()
    {
        if(location.exists())
        {
            try
            {
                InputStream in = new FileInputStream(location);
                properties.loadFromXML(in);
                in.close();
                return true;
            }
            catch (FileNotFoundException ex)
            {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (IOException ex)
            {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    private static void createDefaultProperties()
    {
        properties.setProperty("separator", File.separator);
        properties.setProperty("project_path", "C:\\Users\\Mateo\\Documents\\Programación\\SmartPcb\\testing");
        properties.setProperty("libraries_path", "C:\\Users\\Mateo\\Documents\\Programación\\SmartPcb\\testing\\libraries");
    }
    public static void saveProperties()
    {
        try
        {
            OutputStream out = new FileOutputStream(location);
            properties.storeToXML(out, "SmartPcb properties");
            out.flush();
            out.close();
        }
        catch (FileNotFoundException  ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
