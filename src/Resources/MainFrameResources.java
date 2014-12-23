package Resources;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import smartpcb.Dialog;
import smartpcb.Main;

public class MainFrameResources
{
    private HashMap hashMap;
    
    public MainFrameResources()
    {
        hashMap = new HashMap();
    }
    
    public void loadResources() 
    {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = null;
        try 
        {
            hashMap.put("back_image", ImageIO.read(new File(classLoader.getResource("graphics/circuit_pattern.png").toURI())));
            hashMap.put("delete_image",ImageIO.read(new File(classLoader.getResource("graphics/delete.png").toURI())));
            hashMap.put("delete_image_b",ImageIO.read(new File(classLoader.getResource("graphics/delete_b.png").toURI())));
        } 
        catch (IOException | URISyntaxException ex) 
        {
            Dialog.error("The image \"circuit_pattern.png\" could not be loaded.", ex);
        }
    }

    public void disposeResources() 
    {
        //TODO
    }

    public Object getResource(String key) 
    {
        return hashMap.get(key);
    }
    
}
