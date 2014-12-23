package smartpcb;

public class Coordinate extends Point2D
{
    private CoordinateSystem system;
    
    public Coordinate()
    {
        this(0,0,null);
    }
    public Coordinate(Coordinate point)
    {
        this(point.x,point.y,point.system);
    }
    public Coordinate(float x,float y)
    {
        this(x,y,null);
    }
    public Coordinate(float x,float y,CoordinateSystem system)
    {
        this.x = x;
        this.y = y;
        this.system = system;
    }
    public CoordinateSystem getSystem() 
    {
        return system;
    }
    public void setSystem(CoordinateSystem system) 
    {
        this.system = system;
    }
    public void set(Coordinate point)
    {
        x = point.x;
        y = point.y;
    }
}
