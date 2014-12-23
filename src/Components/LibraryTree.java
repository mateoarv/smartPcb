package Components;

import Components.ProjectTreeNodes.BoardNode;
import Components.ProjectTreeNodes.ProjectNode;
import Components.ProjectTreeNodes.SchematicNode;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 * Componente de tipo JTree para manejar las librerias
 * @author Mateo
 */
public class LibraryTree extends JTree
{
    public LibraryTree()
    {
        this.setRootVisible(false);
        ((DefaultMutableTreeNode)((DefaultTreeModel)this.getModel()).getRoot()).removeAllChildren();
        ((DefaultTreeModel)this.getModel()).reload();
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
                    
                }
                else if(path.getLastPathComponent() instanceof BoardNode)
                {
                    
                }
            }
            if(e.getButton() == MouseEvent.BUTTON3)
            {
                if(path.getLastPathComponent() instanceof ProjectNode)
                {
                    
                }
            }
        }
    }
}
