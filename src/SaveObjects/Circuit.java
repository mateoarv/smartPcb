package SaveObjects;

import java.util.ArrayList;

public class Circuit extends SaveObject
{
    private Schematic schematic;
    private ArrayList<Board> boards;
    
    public Circuit(Project project,String name)
    {
        super(name,project);
        boards = new ArrayList<Board>();
        schematic = new Schematic(project,name + "_sch");
    }
    public void createBoard()
    {
        boards.add(new Board(project,schematic,name + "_brd" + boards.size()));
    }
    public Schematic getSchematic() 
    {
        return schematic;
    }

    public ArrayList<Board> getBoards() 
    {
        return boards;
    }
    
}
