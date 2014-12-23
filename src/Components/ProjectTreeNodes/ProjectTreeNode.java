package Components.ProjectTreeNodes;

import SaveObjects.SaveObject;
import javax.swing.tree.DefaultMutableTreeNode;

public class ProjectTreeNode extends DefaultMutableTreeNode
{
    protected SaveObject saveObject;
    
    public ProjectTreeNode(String name,SaveObject saveObject)
    {
        super(name);
        this.saveObject = saveObject;
    }

    public SaveObject getSaveObject() 
    {
        return saveObject;
    }
    
}
