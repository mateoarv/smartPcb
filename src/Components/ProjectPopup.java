package Components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

/**
 * Componente de tipo JPopupMenu que se abre al hundir click derecho en un
 * proyecto. Tiene opciones para crear nuevos archivos y explorar propiedades
 * @author Mateo
 */
public class ProjectPopup extends JPopupMenu
{
    public ProjectPopup()
    {
        addItems();
    }
    private void addItems()
    {
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem circuitItem = new JMenuItem("Circuit");
        JMenuItem closeItem = new JMenuItem("Close");
        JMenuItem propertiesItem = new JMenuItem("Properties");
        closeItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                
            }
        });
        propertiesItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                
            }
        });
        //newItem.add(circuitItem);
        this.add(newItem);
        this.add(new JSeparator());
        this.add(closeItem);
        this.add(new JSeparator());
        this.add(propertiesItem);
        
    }
}
