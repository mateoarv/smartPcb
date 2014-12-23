package SaveObjects;

public class Board extends SaveObject
{
    private Schematic schematic;
    
    public Board(Project project,Schematic schematic,String name)
    {
        super(name,project);
        this.schematic = schematic;
    }

    public Schematic getSchematic() 
    {
        return schematic;
    }
}
