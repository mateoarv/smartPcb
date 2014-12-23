package Components.LibraryTreeNodes;

import SaveObjects.SaveObject;
import javax.swing.tree.DefaultMutableTreeNode;

public class LibraryTreeNode extends DefaultMutableTreeNode
{
    protected SaveObject saveObject;
    
    public LibraryTreeNode(String name,SaveObject saveObject)
    {
        super(name);
        this.saveObject = saveObject;
    }

    public SaveObject getSaveObject() 
    {
        return saveObject;
    }
    
}
