package smartpcb;

import java.awt.Point;

public class Point2D 
{
    public float x,y;
    public Point2D()
    {
        this(0,0);
    }
    public Point2D(Point point)
    {
        set(point);
    }
    public Point2D(Point2D point)
    {
        set(point);
    }
    public Point2D(float x,float y)
    {
        set(x,y);
    }
    public void round()
    {
        this.x = Math.round(x);
        this.y = Math.round(y);
    }
    public final void set(float x,float y)
    {
        this.x = x;
        this.y = y;
    }
    public final void set(Point2D point)
    {
        set(point.x,point.y);
    }
    public final void set(Point point)
    {
        set((float)point.getX(),(float)point.getY());
    }
    public int getRoundX()
    {
        return Math.round(x);
    }
    public int getRoundY()
    {
        return Math.round(y);
    }
    public void multiply(float factor)
    {
        x*=factor;
        y*=factor;
    }
    @Override
    public String toString() 
    {
        return "[" + x + "," + y + "]";
    }
    
}
