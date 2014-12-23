package Components.Panels;

import SaveObjects.SaveObject;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JPanel;

public abstract class TabPanel extends JPanel
{
    protected SaveObject saveObject;
    
    public TabPanel(SaveObject saveObject)
    {
        this.saveObject = saveObject;
        this.addComponentListener(new ComponentListener()
        {
            @Override
            public void componentResized(ComponentEvent e)
            {
                Dimension size = getSize();
            }
            @Override
            public void componentMoved(ComponentEvent e) {}
            @Override
            public void componentShown(ComponentEvent e) {}
            @Override
            public void componentHidden(ComponentEvent e) {}
        });
    }
    public SaveObject getSaveObject() 
    {
        return saveObject;
    }  
}
