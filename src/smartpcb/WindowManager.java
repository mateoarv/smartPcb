package smartpcb;

import Components.ProjectTree;
import Components.Panels.SchematicPanel;
import Components.ProjectPopup;
import Components.Tab;
import Components.TabbedPane;
import SaveObjects.Project;
import SaveObjects.Schematic;
import smartpcb.forms.MainFrame;

public abstract class WindowManager 
{
    public static TabbedPane tabbedPane;
    public static ProjectTree projectTree;
    public static MainFrame mainFrame;
    public static ProjectPopup projectPopup;
    
    public static void setComponents(TabbedPane pane,ProjectTree tree,MainFrame frame)      
    {
        tabbedPane = pane;
        projectTree = tree;
        mainFrame = frame;
        projectPopup = new ProjectPopup();
    }
    public static void openProject(Project project)
    {
        projectTree.addProject(project);
    }
    public static void openSchematic(Schematic schematic)
    {
        tabbedPane.addTabPanel(new SchematicPanel(schematic));
    }
    public static void closeTab() 
    {
        ((Tab)tabbedPane.getTabComponentAt(tabbedPane.getSelectedIndex())).closing();
        tabbedPane.remove(tabbedPane.getSelectedIndex());
    }
    public static void closeProject(Project project)
    {
        
    }
}
