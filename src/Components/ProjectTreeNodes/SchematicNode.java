package Components.ProjectTreeNodes;

import javax.swing.tree.DefaultMutableTreeNode;
import SaveObjects.Schematic;

public class SchematicNode extends ProjectTreeNode
{ 
    public SchematicNode(Schematic schematic)
    {
        super(schematic.getName(),schematic);
    }
    public Schematic getSchematic()
    {
        return (Schematic)saveObject;
    }
}
