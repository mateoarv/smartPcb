package Components;

import Components.ProjectTreeNodes.BoardNode;
import Components.ProjectTreeNodes.ProjectNode;
import Components.ProjectTreeNodes.SchematicNode;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import SaveObjects.Project;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.tree.TreePath;
import smartpcb.WindowManager;

/**
 * Componente de tipo JTree utilizado para manejar los archivos de los proyectos.
 * @author Mateo
 */
public class ProjectTree extends JTree
{
    private ArrayList<Project> openedProjects;
    public ProjectTree()
    { 
        this.setRootVisible(false);
        ((DefaultMutableTreeNode)((DefaultTreeModel)this.getModel()).getRoot()).removeAllChildren();
        ((DefaultTreeModel)this.getModel()).reload();
        openedProjects = new ArrayList<Project>();
        
        this.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) 
            {
                pressed(e);
            }
            
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }
    private void pressed(MouseEvent e)
    {
        TreePath path = this.getPathForLocation(e.getX(), e.getY());
        if(path != null)
        {
            if(e.getButton() == MouseEvent.BUTTON1 && e.getClickCount()==2)
            {
                if(path.getLastPathComponent() instanceof SchematicNode)
                {
                    WindowManager.openSchematic(((SchematicNode)path.getLastPathComponent()).getSchematic());
                }
                else if(path.getLastPathComponent() instanceof BoardNode)
                {
                    
                }
            }
            if(e.getButton() == MouseEvent.BUTTON3)
            {
                if(path.getLastPathComponent() instanceof ProjectNode)
                {
                    WindowManager.projectPopup.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        }
    }
    public void addProject(Project project)
    {
        if(!isOpened(project))
        {
            openedProjects.add(project);
            ((DefaultMutableTreeNode)((DefaultTreeModel)this.getModel()).getRoot()).add(new ProjectNode(project));
            ((DefaultTreeModel)this.getModel()).reload();
        }
    }
    private boolean isOpened(Project project)
    {
        UUID id = project.getId();
        int size = openedProjects.size();
        int i = 0;
        boolean found = false;
        while(i<size && !found)
        {
            found = id.compareTo(openedProjects.get(i).getId()) == 0;
            i++;
        }
        return found;
    }
}
