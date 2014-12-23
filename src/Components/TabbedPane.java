package Components;

import Components.Panels.TabPanel;
import javax.swing.JTabbedPane;

/**
 * Componente de tipo JTabbedPane que contiene las ventanas del proyecto.
 * @author Mateo
 */
public class TabbedPane extends JTabbedPane
{
    public void addTabPanel(TabPanel tabPanel)
    {
        String title = tabPanel.getSaveObject().getName();
        this.addTab(title, tabPanel);
        this.setTabComponentAt(this.getTabCount()-1, new Tab(title,tabPanel));
        checkPadNumber();
    }

    @Override
    public void removeTabAt(int index) 
    {
        super.removeTabAt(index);
        checkPadNumber();
    }
    
    private void checkPadNumber()
    {
        if(this.getTabCount() == 0)
            this.setVisible(false);
        else
            this.setVisible(true);
    }
}
