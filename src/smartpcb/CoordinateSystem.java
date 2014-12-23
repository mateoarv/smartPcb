package smartpcb;

import Interfaces.TransformListener;

public class CoordinateSystem implements TransformListener
{
    private float zoom,transX,transY;
    private final Units.units baseUnit;
    
    public CoordinateSystem(Units.units baseUnit)
    {
        this.baseUnit = baseUnit;
        zoom = 1;
    }
    @Override
    public void transformed(float zoom, float transX, float transY) 
    {
        this.zoom = zoom;
        this.transX = Units.changeUnit(transX, Units.units.PX, baseUnit);
        this.transY = Units.changeUnit(transY, Units.units.PX, baseUnit);
 
    }
    public Coordinate projectCoordinate(Coordinate point)
    {
        Coordinate projection = new Coordinate(point);
        projection.setSystem(this);
        projection.x = (Units.changeUnit(projection.x, point.getSystem().baseUnit, baseUnit)+transX)/zoom;
        projection.y = (Units.changeUnit(projection.y, point.getSystem().baseUnit, baseUnit)+transY)/zoom;
        return projection;
    }
    public Point2D projectPoint(Point2D point,Units.units pointUnit)
    {
        Point2D projection = new Point2D(point);        
        projection.x = Units.changeUnit(projection.x, pointUnit, baseUnit)*zoom+transX;
        projection.y = Units.changeUnit(projection.y, pointUnit, baseUnit)*zoom+transY;
        Dialog.print(projection);
        return projection;
    }
    public float getZoom() 
    {
        return zoom;
    }
    public float getTransX() 
    {
        return transX;
    }
    public float getTransY() 
    {
        return transY;
    }
}
