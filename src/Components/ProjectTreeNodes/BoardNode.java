package Components.ProjectTreeNodes;

import SaveObjects.Board;

public class BoardNode extends ProjectTreeNode
{ 
    public BoardNode(Board board)
    {
        super(board.getName(),board);
    }
    public Board getBoard()
    {
        return (Board)saveObject;
    }
}
