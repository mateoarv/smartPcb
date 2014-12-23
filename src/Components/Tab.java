package Components;

import Components.Panels.TabPanel;
import Components.Panels.TabPanel;
import SaveObjects.SaveObject;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import smartpcb.Dialog;
import smartpcb.Main;
import smartpcb.WindowManager;

/**
 * Componente de tipo JPanel que representa una pestaña del TabbedPane. Está
 * compuesta por un botón para cerrar y un título.
 * @author Mateo
 */
public class Tab extends JPanel
{
    private JLabel lblTitle,lblClose;
    private ImageIcon closeIcon,closeIcon_b;
    private TabPanel tabPanel;
    
    public Tab(String title,TabPanel tabPanel)
    {
        this.setLayout(new GridBagLayout());
        this.tabPanel = tabPanel;
        GridBagConstraints c = new GridBagConstraints();
        closeIcon = new ImageIcon((Image) Main.mainFrameResources.getResource("delete_image"));
        closeIcon_b = new ImageIcon((Image) Main.mainFrameResources.getResource("delete_image_b"));
        lblTitle = new JLabel(title);
        lblClose = new JLabel(closeIcon);
        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 4;
        c.anchor = GridBagConstraints.CENTER;
        this.add(lblTitle,c);
        c.gridx = 1;
        c.gridy = 0;
        c.ipadx = 0;
        c.ipady = 5;
        c.anchor = GridBagConstraints.CENTER;
        this.add(lblClose,c);
        this.setSize(this.getPreferredSize().width +20,this.getPreferredSize().height);
        this.setOpaque(false);
        addListeners();
    }
    private void addListeners()
    {
        lblClose.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) 
            {
                WindowManager.closeTab();
            }

            @Override
            public void mouseEntered(MouseEvent e) 
            {
                lblClose.setIcon(closeIcon_b);
            }
            @Override
            public void mouseExited(MouseEvent e) 
            {
                lblClose.setIcon(closeIcon);
            }
        });
    }

    public void closing() 
    {
        if(Dialog.showQuestion("Do you want to save changes?", "Save Changes"))
        {
            
        }
    }
    public SaveObject getSaveObject()
    {
        return tabPanel.getSaveObject();
    }
}
