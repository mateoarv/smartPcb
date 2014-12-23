package Components.ProjectTreeNodes;

import Components.ProjectTreeNodes.BoardNode;
import java.util.ArrayList;
import SaveObjects.Board;
import SaveObjects.Circuit;
import SaveObjects.SaveObject;
import SaveObjects.Schematic;

public class CircuitNode extends ProjectTreeNode
{
    public CircuitNode(Circuit circuit)
    {
        super(circuit.getName(),circuit);
        updateNodes();
    }
    public Circuit getCircuit()
    {
        return (Circuit)saveObject;
    }
    private void updateNodes()
    {
        Circuit circuit = (Circuit)saveObject;
        Schematic schematic = circuit.getSchematic();
        if(schematic != null)
        {
            this.add(new SchematicNode(schematic));
            ArrayList<Board> boards = circuit.getBoards();
            if(boards.size()>0)
            {
                for(int i = 0;i<boards.size();i++)
                {
                    this.add(new BoardNode(boards.get(i)));
                }
            }
        }
    }
}
